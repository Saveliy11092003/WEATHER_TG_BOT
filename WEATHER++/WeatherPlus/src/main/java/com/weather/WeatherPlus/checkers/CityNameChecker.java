package com.weather.WeatherPlus.checkers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.weather.WeatherPlus.Constants.Constants.*;


@Slf4j
@Component
public class CityNameChecker {

    public boolean isCity(String cityName) throws RuntimeException{
        log.info("Went into the method isCity");
        log.info("is City");
        boolean aswer = true;

        log.info("Create OkHttpClient");
        OkHttpClient client = new OkHttpClient();
        log.info("Create Request");
        Request request = new Request.Builder()
                .url("https://graphhopper.com/api/1/geocode?q=" + cityName + "&key=" + API_KEY1 )
                .get()
                .build();

        JsonArray hits;

        Response response = null;
        try {
            log.info("Client sent a request");
            response = client.newCall(request).execute();
            JsonObject jobj1 = new Gson().fromJson(response.body().string(), JsonObject.class);
            hits = jobj1.getAsJsonArray(HITS);
        } catch (IOException e) {
            aswer = false;
            log.info("City not found");
            throw new RuntimeException(e);
        }


        JsonElement element = hits.get(0);
        JsonObject object = (JsonObject)element;

        log.info("City found ");
        log.info("Exited the method isCity");
        return aswer;

    }




}
