package com.weather.WeatherPlus.TgInterfaceParts;

import com.weather.WeatherPlus.language.Translator;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


/*
 *
 *Class creates Weather Menu
 *
 */

@Slf4j
public class MakerKeyboardWeather implements MakerKeyboard{

    private Translator translator;

    public MakerKeyboardWeather(Translator translator) {
        this.translator = translator;
    }

    @Override
    public ReplyKeyboardMarkup makeKeyboard() {
        log.info("Went into the method makeKeyboard in MakerKeyboardWeather");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();


        row1.add(translator.translate("Base weather"));
        row1.add(translator.translate("Advanced weather"));
        row1.add(translator.translate("Back"));


        keyboardRows.add(row1);


        keyboardMarkup.setKeyboard(keyboardRows);

        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makerKeyboard in MakerKeyboardWeather");
        return keyboardMarkup;
    }
}
