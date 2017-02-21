package com.github.helpermethod.molten;

import com.github.helpermethod.molten.types.JsonArray;
import com.github.helpermethod.molten.types.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.function.Consumer;

public class Json {
    private Json() {
    }

    public static JsonObject obj() {
        return new JsonObject(new JSONObject());
    }

    public static JsonArray arr(Consumer<JsonArray> consumer) {
        JsonArray moltenArray = new JsonArray(new JSONArray());
        consumer.accept(moltenArray);

        return moltenArray;
    }

    public static JsonObject obj(Consumer<JsonObject> consumer) {
        JsonObject moltenObject = new JsonObject(new JSONObject());
        consumer.accept(moltenObject);

        return moltenObject;
    }

    public static JsonObject from(JSONObject jsonObject) {
        try {
            return new JsonObject(new JSONObject(jsonObject.toString()));
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }

    public static JsonArray from(JSONArray jsonArray) {
        try {
            return new JsonArray(new JSONArray(jsonArray.toString()));
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }
}