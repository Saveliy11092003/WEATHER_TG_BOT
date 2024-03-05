package com.weather.WeatherPlus.TgInterfaceParts;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MakerKeybord {
    public ReplyKeyboardMarkup makeKeybord(){
        log.info("Went into the method makeKeybord");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        row1.add("Help");
        row1.add("Base weather");
        row1.add("Advanced weather");
        row2.add("Cloth recommendations");
        row2.add("Change units");
        row2.add("Change city");


        keyboardRows.add(row1);
        keyboardRows.add(row2);


        keyboardMarkup.setKeyboard(keyboardRows);
        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makeKeybord");
        return keyboardMarkup;
    }
}
