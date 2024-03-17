package com.weather.WeatherPlus.TgInterfaceParts;

import com.weather.WeatherPlus.language.Translator;
import com.weather.WeatherPlus.language.TranslatorEn;
import com.weather.WeatherPlus.language.TranslatorRu;
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


    private Translator translator;

    public MakerKeyboardMenu(Translator translator) {
        this.translator = translator;
    }


    public ReplyKeyboardMarkup makeKeyboard(){
        log.info("Went into the method makeKeyboard in MakerKeyboardMenu");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();


        row1.add(translator.translate("Help"));
        row1.add(translator.translate("Weather"));
        row2.add(translator.translate("Settings"));
        row2.add(translator.translate("Cloth recommendations"));

        keyboardRows.add(row1);
        keyboardRows.add(row2);

        keyboardMarkup.setKeyboard(keyboardRows);
        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makerKeyboard in MakerKeyboardMenu");
        return keyboardMarkup;
    }
}
