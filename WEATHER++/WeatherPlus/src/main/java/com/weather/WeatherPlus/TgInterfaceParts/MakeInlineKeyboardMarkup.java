package com.weather.WeatherPlus.TgInterfaceParts;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MakeInlineKeyboardMarkup {
    public InlineKeyboardMarkup makeInlineKeyboardMarkup(String s1, String s2, String s3, String s4){
        log.info("Went into the method makeInlineKeyboardMarkup");

        log.info("Created InlineKeyboardMarkup");
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        log.info("Created List<List<InlineKeyboardButton>>");
        List<InlineKeyboardButton> row1 = new ArrayList<>();

        var button1 = new InlineKeyboardButton();
        button1.setText(s1);
        button1.setCallbackData(s2);

        var button2 = new InlineKeyboardButton();
        button2.setText(s3);
        button2.setCallbackData(s4);

        row1.add(button1);
        row1.add(button2);

        rows.add(row1);

        markup.setKeyboard(rows);
        log.info("markup.setKeyboard");
        log.info("Exited the method makeInlineKeyboardMarkup");
        return markup;
    }
}
