package com.weather.WeatherPlus.TgInterfaceParts;

import com.weather.WeatherPlus.Creaters.CreaterMessage;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Slf4j
public class CreaterPresBottom {
    public SendMessage createPres(Long chatId, boolean isRus){
        log.info("Went into the method createPres");
        CreaterMessage createrMessge = new CreaterMessage();
        log.info("Created SendMessage");

        String answer;

        if (isRus) {
            answer = "Выберите единицы измерения давления";
        } else {
            answer = "Select speed pressure:";
        }


        SendMessage message = createrMessge.createMessage(chatId, answer);

        MakeInlineKeyboardMarkup maker = new MakeInlineKeyboardMarkup();
        log.info("Created InlineKeyboardMarkup");
        InlineKeyboardMarkup markup = maker.makeInlineKeyboardMarkup("mmHg", "MM_HG_BUTTON", "hPa", "H_PA_BUTTON");
        log.info("message.setReplyMarkup(markup)");
        message.setReplyMarkup(markup);

        log.info("Exited the method createPres");
        return message;
    }
}
