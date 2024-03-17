package com.weather.WeatherPlus.TgInterfaceParts;


import com.weather.WeatherPlus.Creaters.CreaterMessage;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Slf4j
public class CreaterTempBottom {
    public SendMessage createTemp(Long chatId, boolean isRus){
        log.info("Went into the method createTemp");
        CreaterMessage createrMessge = new CreaterMessage();
        log.info("Created SendMessage");

        String answer;

        if (isRus) {
            answer = "Выберите единицы измерения температуры";
        } else {
            answer = "Select util of temperature:";
        }

        SendMessage message = createrMessge.createMessage(chatId, answer);

        MakeInlineKeyboardMarkup maker = new MakeInlineKeyboardMarkup();
        log.info("Created InlineKeyboardMarkup");
        InlineKeyboardMarkup markup = maker.makeInlineKeyboardMarkup("C", "BUTTON_C", "K", "BUTTON_K");
        log.info("message.setReplyMarkup(markup)");
        message.setReplyMarkup(markup);

        log.info("Exited the method createTemp");
        return message;
    }
}
