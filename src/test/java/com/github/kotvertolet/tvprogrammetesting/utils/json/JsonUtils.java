package com.github.kotvertolet.tvprogrammetesting.utils.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kotvertolet on 7/12/2017.
 */
public class JsonUtils {

    private final static DateTimeFormatter INITIAL_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a");
    private final static DateTimeFormatter GENERIC_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static <T> T mapJsonOnObject(String json, Class<T> clazz) {
//        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss").create();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                LocalDateTime initial = LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), INITIAL_FORMAT);
                String formatted = initial.format(GENERIC_FORMAT);
                return LocalDateTime.parse(formatted, GENERIC_FORMAT);
            }
        }).create();

        return gson.fromJson(json, clazz);
    }

}
