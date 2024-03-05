package com.weather.WeatherPlus.Creaters;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

@Slf4j
public class CreaterMessage {
    public SendMessage createMessage(long chatId, String textToSend){
        log.info("Went into the method createMessage(chat, textToSend)");
        log.info("Create SendMessage");
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        log.info("Exited the method createMessage(chat, textToSend)");
        return message;
    }

    public EditMessageText createMessage(Long chatId, String textToSend, long messageId){
        log.info("Went into the method createMessage(chatId, textToSend, messageId)");
        log.info("Create EditMessage");
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        message.setMessageId((int) messageId);
        log.info("Exited the method createMessage(chatId, textToSend, messageId)");
        return message;
    }


}
