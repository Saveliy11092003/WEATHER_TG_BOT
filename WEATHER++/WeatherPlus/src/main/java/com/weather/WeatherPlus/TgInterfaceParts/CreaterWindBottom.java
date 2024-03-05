package com.weather.WeatherPlus.TgInterfaceParts;


import com.weather.WeatherPlus.Creaters.CreaterMessage;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Slf4j
public class CreaterWindBottom {
    public SendMessage createWind(Long chatId){
        log.info("Went into the method createWind");
        CreaterMessage createrMessge = new CreaterMessage();
        log.info("Created SendMessage");
        SendMessage message = createrMessge.createMessage(chatId, "Select speed wind");

        MakeInlineKeyboardMarkup maker = new MakeInlineKeyboardMarkup();
        log.info("Created InlineKeyboardMarkup");
        InlineKeyboardMarkup markup = maker.makeInlineKeyboardMarkup("m/s", "MS_BUTTON", "km/h", "KM_H_BUTTON");
        log.info("message.setReplyMarkup(markup)");
        message.setReplyMarkup(markup);

        log.info("Exited the method createWind");
        return message;
    }
}
