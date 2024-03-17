package com.weather.WeatherPlus.TgInterfaceParts;


import com.weather.WeatherPlus.Creaters.CreaterMessage;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Slf4j
public class CreaterWindBottom {
    public SendMessage createWind(Long chatId, boolean isRus){
        log.info("Went into the method createWind");
        CreaterMessage createrMessge = new CreaterMessage();
        log.info("Created SendMessage");

        String answer;

        if (isRus) {
            answer = "Выберите единицы измерения ветра";
        } else {
            answer = "Select speed wind:";
        }

        SendMessage message = createrMessge.createMessage(chatId, answer);

        MakeInlineKeyboardMarkup maker = new MakeInlineKeyboardMarkup();
        log.info("Created InlineKeyboardMarkup");
        InlineKeyboardMarkup markup = maker.makeInlineKeyboardMarkup("m/s", "MS_BUTTON", "km/h", "KM_H_BUTTON");
        log.info("message.setReplyMarkup(markup)");
        message.setReplyMarkup(markup);

        log.info("Exited the method createWind");
        return message;
    }
}
