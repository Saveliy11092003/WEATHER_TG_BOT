package com.weather.WeatherPlus.getters;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.weather.WeatherPlus.Coordinates.Coordinates;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.weather.WeatherPlus.Constants.Constants.API_KEY1;
import static com.weather.WeatherPlus.Constants.Constants.HITS;

@Slf4j
public class GetterCoordinates {
    public void getCoordinates(Coordinates coordinates, String city){
        log.info("Went into the method getCoordinates");

        log.info("Created OKHttpClient");
        OkHttpClient client = new OkHttpClient();

        log.info("Created Request");
        Request request = new Request.Builder()
                .url("https://graphhopper.com/api/1/geocode?q=" + city + "&key=" + API_KEY1 )
                .get()
                .build();

        JsonArray hits;
        try {
            log.info("Client sent response to get coordinates");
            Response response = client.newCall(request).execute();
            JsonObject jobj1 = new Gson().fromJson(response.body().string(), JsonObject.class);
            hits = jobj1.getAsJsonArray(HITS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonElement element = hits.get(0);
        JsonObject object = (JsonObject)element;

        coordinates.setLat(Double.parseDouble(String.valueOf(object.getAsJsonObject("point").get("lat")).replaceAll("\"","")));
        coordinates.setLng(Double.parseDouble(String.valueOf(object.getAsJsonObject("point").get("lng")).replaceAll("\"","")));
        coordinates.setCityName(String.valueOf(object.get("name")).replaceAll("\"",""));
        log.info("lat " + String.valueOf(object.getAsJsonObject("point").get("lat")).replaceAll("\"",""));
        log.info("lng " + String.valueOf(object.getAsJsonObject("point").get("lng")).replaceAll("\"",""));
        log.info("Exited the method getCoordinates");
    }
}
