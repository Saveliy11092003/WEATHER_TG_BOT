package com.weather.WeatherPlus.service;

import com.weather.WeatherPlus.Command.*;
import com.weather.WeatherPlus.Creaters.CreaterMessage;
import com.weather.WeatherPlus.TgInterfaceParts.*;
import com.weather.WeatherPlus.checkers.CityNameChecker;
import com.weather.WeatherPlus.checkers.StartCommand;
import com.weather.WeatherPlus.config.BotConfig;
import com.weather.WeatherPlus.getters.GetterAdvancedWeather;
import com.weather.WeatherPlus.getters.GetterBaseWeather;
import com.weather.WeatherPlus.getters.GetterRecommendationWeather;
import com.weather.WeatherPlus.model.UserRepository;
import com.weather.WeatherPlus.units.PRESSURE;
import com.weather.WeatherPlus.units.StoreUnits;
import com.weather.WeatherPlus.units.TEMPERATURE;
import com.weather.WeatherPlus.units.WIND_SPEED;
import lombok.extern.slf4j.Slf4j;

import static com.weather.WeatherPlus.Constants.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private UserRepository userRepository;
    private boolean waitCity;
    final BotConfig config;
    StoreUnits storeUnits;

    CreaterMessage createrMessage;

    public TelegramBot(BotConfig config) {

        this.config = config;

        this.storeUnits = new StoreUnits(TEMPERATURE.C, PRESSURE.HPA, WIND_SPEED.MS);

        MakerMenu makerMenu = new MakerMenu();
        List<BotCommand> listOfCommands = makerMenu.makeMenu();
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error setting bot's command list: " + e.getMessage());
        }

        createrMessage = new CreaterMessage();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Went into the method onUpdateReceived");
        if (update.hasMessage() && update.getMessage().hasText() && !waitCity) {
            log.info("if !waitCity");
            log.info("Received text (update.getMessage().getText())");
            String messageText = update.getMessage().getText();
            log.info("Received chatId (update.getMessage().getChatId())");
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start": {

                    log.info("messageText equals /start");
                    RegisterUser registerUser = new RegisterUser();
                    registerUser.registerUser(update.getMessage(), userRepository);
                    startCommandReceive(chatId, update.getMessage().getChat().getFirstName());
                    SendMessage message = createrMessage.createMessage(chatId, "Enter the city: ");
                    doExecute(message);

                    waitCity = true;
                    break;
                }

                case "Help":
                case "/help": {
                    log.info("messageText equals /help");
                    sendMessage(chatId, HELP_TEXT);
                    break;
                }

                case "Base weather":
                case "/weather_base": {
                    log.info("messageText equals /weather_base");
                    try {
                        weatherBaseCommandReceive(chatId, storeUnits, userRepository);
                    } catch (IOException e) {
                        log.error("Error in case /weather_base:" + e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "Advanced weather":
                case "/weather_advanced": {
                    log.info("messageText equals /weather_advanced");
                    try {
                        weatherAdvancedCommandReceive(chatId, storeUnits, userRepository);
                    } catch (IOException e) {
                        log.error("Error in case /weather_advanced:" + e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "Change city":
                case "/change_city": {
                    log.info("messageText equals /change_city");
                    SendMessage message = createrMessage.createMessage(chatId, "Enter the city: ");
                    doExecute(message);
                    waitCity = true;
                    break;
                }

                case "Change units":
                case "/change_utils": {
                    log.info("messageText equals /change_utils");
                    try {
                        changeTempCommandReceive(chatId);
                    } catch (IOException e) {
                        log.error("Error in case /change_utils:" + e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "Cloth recommendations":
                case "/recommendation_of_clothes": {
                    log.info("messageText equals /recommendation_of_clothes");
                    try {
                        recommendationCommandReceive(userRepository, chatId, storeUnits);
                    } catch (IOException e) {
                        log.error("Error in case /weather_base:" + e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                default: {
                    log.info("messageText is not any command");
                    sendMessage(chatId, "Sorry, command was not recognized");
                }

            }
        } else if (update.hasMessage() && update.getMessage().hasText() && waitCity) {
            log.info("if (waitCity)");
            log.info("Received chatId (update.getMessage().getChatId())");
            var chatId = update.getMessage().getChatId();
            log.info("Received chat (update.getMessage().getChat())");
            var chat = update.getMessage().getChat();
            SendMessage message = createrMessage.createMessage(chatId,
                    "You enter: " + update.getMessage().getText());
            doExecute(message);
            String city = update.getMessage().getText();
            CityNameChecker cityNameChecker = new CityNameChecker();

            try {
                if (!cityNameChecker.isCity(city)) {

                } else {
                    ChangerUserData changerUserData = new ChangerUserData();
                    changerUserData.changeUserData(chatId, chat, city, userRepository);
                }
            } catch (RuntimeException e) {
                waitCity = false;
                log.info("waitCity = false in catch");
                SendMessage message1 = createrMessage.createMessage(chatId, "There is no such city");
                doExecute(message1);
                log.error("Error in check city: " + e.getMessage());
                throw new RuntimeException(e);
            }
            waitCity = false;
            log.info("waitCity = false is not catch");
        } else if (update.hasCallbackQuery()) {
            log.info("if (update.hasCallbackQuery)");
            String callBackData = update.getCallbackQuery().getData();
            log.info("Getting String callBackData");
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            log.info("Received messageId (update.getCallbackQuery().getMessage().getMessageId()");
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            log.info("Received chatId (update.getCallbackQuery().getMessage().getChatId();");

            if (callBackData.equals("BUTTON_C")) {

                EditMessageText message = createrMessage.createMessage(chatId, "You pressed C", messageId);
                doExecute(message);
                log.info("Set temperature - C");
                storeUnits.setTemperature(TEMPERATURE.C);

                try {
                    changeWindCommandReceive(chatId);
                } catch (IOException e) {
                    log.error("Error in changeWindCommandReceive: " + e.getMessage());
                    throw new RuntimeException(e);
                }

            } else if (callBackData.equals("BUTTON_K")) {

                EditMessageText message = createrMessage.createMessage(chatId, "You pressed K", messageId);
                doExecute(message);
                log.info("Set temperature - K");
                storeUnits.setTemperature(TEMPERATURE.K);

                try {
                    changeWindCommandReceive(chatId);
                } catch (IOException e) {
                    log.error("Error in changeWindCommandReceive: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            } else if (callBackData.equals("KM_H_BUTTON")) {

                EditMessageText message = createrMessage.createMessage(chatId, "You pressed km/h", messageId);
                doExecute(message);
                log.info("Set wind speed - KH");
                storeUnits.setWindSpeed(WIND_SPEED.KMH);

                try {
                    changePressureCommandReceive(chatId);
                } catch (IOException e) {
                    log.error("Error in changePressureCommandReceive: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            } else if (callBackData.equals("MS_BUTTON")) {
                EditMessageText message = createrMessage.createMessage(chatId, "You pressed m/s", messageId);
                doExecute(message);
                log.info("Set wind speed - MS");
                storeUnits.setWindSpeed(WIND_SPEED.MS);

                try {
                    changePressureCommandReceive(chatId);
                } catch (IOException e) {
                    log.error("Error in changePressureCommandReceive: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            } else if (callBackData.equals("MM_HG_BUTTON")) {
                EditMessageText message = createrMessage.createMessage(chatId, "You pressed mmHG", messageId);
                doExecute(message);
                log.info("Set pressure - MMHG");
                storeUnits.setPressure(PRESSURE.MMHG);

            } else if (callBackData.equals("H_PA_BUTTON")) {
                EditMessageText message = createrMessage.createMessage(chatId, "You pressed mmHG", messageId);
                doExecute(message);
                log.info("Set pressure - HPA");
                storeUnits.setPressure(PRESSURE.HPA);
            }
        }
        log.info("Exited the method onUpdateReceived");
    }

    private void recommendationCommandReceive(UserRepository userRepository, Long chatId, StoreUnits storeUnits) throws IOException {
        log.info("Went into the method recommendationCommandReceive");
        GetterRecommendationWeather getterRecommendation = new GetterRecommendationWeather(userRepository, chatId, storeUnits);
        String answer = getterRecommendation.getRecommendation();
        sendMessage(chatId, answer);
        log.info("Exited the method recommendationCommandReceive");
    }

    private void startCommandReceive(long chatId, String firstName) {
        log.info("Went into the method startCommandReceive");
        StartCommand startCommand = new StartCommand();
        String answer = startCommand.getStartCommandReceive(firstName);
        sendMessage(chatId, answer);
        log.info("Exited the method startCommandReceive");
    }

    private void weatherBaseCommandReceive(long chatId, StoreUnits storeUnits, UserRepository userRepository) throws IOException {
        log.info("Went into the method weatherBaseCommandReceive");
        GetterBaseWeather getterWeather = new GetterBaseWeather(storeUnits, userRepository, chatId);
        String answer = getterWeather.getWeather();
        sendMessage(chatId, answer);
        log.info("Exited the method weatherBaseCommandReceive");
    }

    private void weatherAdvancedCommandReceive(long chatId, StoreUnits storeUnits, UserRepository userRepository) throws IOException {
        log.info("Went into the method weatherAdvancedCommandReceive");
        GetterAdvancedWeather getterWeather = new GetterAdvancedWeather(storeUnits, userRepository, chatId);
        String answer = getterWeather.getWeather();
        sendMessage(chatId, answer);
        log.info("Exited the method weatherAdvancedCommandReceive");
    }

    private void changeTempCommandReceive(long chatId) throws IOException {
        log.info("Went into the method changeTempCommandReceive");
        CreaterTempBottom changerTemp = new CreaterTempBottom();
        SendMessage message = changerTemp.createTemp(chatId);
        doExecute(message);
        log.info("Exited the method changeTempCommandReceive");
    }

    private void changeWindCommandReceive(long chatId) throws IOException {
        log.info("Went into the method changeWindCommandReceive");
        CreaterWindBottom changerWind = new CreaterWindBottom();
        SendMessage message = changerWind.createWind(chatId);
        doExecute(message);
        log.info("Exited the method changeWindCommandReceive");
    }

    private void changePressureCommandReceive(long chatId) throws IOException {
        log.info("Went into the method changePressureCommandReceive");
        CreaterPresBottom changerPres = new CreaterPresBottom();
        SendMessage message = changerPres.createPres(chatId);
        doExecute(message);
        log.info("Exited the method changePressureCommandReceive");
    }

    public void sendMessage(long chatId, String textToSend) {
        log.info("Went into the method sendMessage");
        SendMessage message = createrMessage.createMessage(chatId, textToSend);
        MakerKeybord makerKeybord = new MakerKeybord();
        ReplyKeyboardMarkup keyboardMarkup = makerKeybord.makeKeybord();
        message.setReplyMarkup(keyboardMarkup);
        doExecute(message);
        log.info("Exited the method sendMessage");
    }

    public void doExecute(SendMessage message) {
        log.info("Went into the method doExecute(SendMessage message)");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
        log.info("Exited the method doExecute(SendMessage message)");
    }

    public void doExecute(EditMessageText message) {
        log.info("Went into the method doExecute(EditMessageText message)");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
        log.info("Exited the method doExecute(EditMessageText message)");
    }

}

