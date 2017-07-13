package com.github.kotvertolet.tvprogrammetesting.utils.json;

import com.github.kotvertolet.tvprogrammetesting.utils.DateTimeFormats;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonUtils {

    public static <T> T mapJsonOnObject(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                (JsonDeserializer<LocalDateTime>) (jsonElement, type, jsonDeserializationContext) -> {
                    LocalDateTime initial = LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormats.INITIAL_FORMAT);
                    String formatted = initial.format(DateTimeFormats.GENERIC_FORMAT);
                    return LocalDateTime.parse(formatted, DateTimeFormats.GENERIC_FORMAT);
                }).create();

        return gson.fromJson(json, clazz);
    }

}
