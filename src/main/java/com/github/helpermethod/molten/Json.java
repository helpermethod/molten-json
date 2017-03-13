package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonArray;
import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;

public class Json {
    private Json() {
    }

    public static JsonObject obj() {
        return new JsonObject(new JSONObject());
    }

    public static JsonObject obj(Consumer<JsonObject> consumer) {
        JsonObject moltenObject = new JsonObject(new JSONObject());
        consumer.accept(moltenObject);

        return moltenObject;
    }

    public static JsonArray arr() {
        return new JsonArray(new JSONArray());
    }

    public static JsonArray arr(Consumer<JsonArray> consumer) {
        JsonArray moltenArray = new JsonArray(new JSONArray());
        consumer.accept(moltenArray);

        return moltenArray;
    }
}