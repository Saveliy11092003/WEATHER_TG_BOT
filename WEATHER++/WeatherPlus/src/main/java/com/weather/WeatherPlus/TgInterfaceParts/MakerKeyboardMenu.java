package com.weather.WeatherPlus.TgInterfaceParts;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *Class creates Main Menu
 *
 */

@Slf4j
public class MakerKeyboardMenu implements MakerKeyboard{
    public ReplyKeyboardMarkup makeKeyboard(){
        log.info("Went into the method makeKeyboard in MakerKeyboardMenu");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        row1.add("Help");
        row1.add("Weather");
        row2.add("Settings");
        row2.add("Cloth recommendations");

        keyboardRows.add(row1);
        keyboardRows.add(row2);

        keyboardMarkup.setKeyboard(keyboardRows);
        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makerKeyboard in MakerKeyboardMenu");
        return keyboardMarkup;
    }
}
