package com.github.helpermethod.molten.type;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;

public class JsonProperty {
    private final String key;
    private final JSONObject jsonObject;

    JsonProperty(String key, JSONObject jsonObject) {
        this.key = key;
        this.jsonObject = jsonObject;
    }

    public void str(String value) {
        put(value);
    }

    public void num(double value) {
        put(value);
    }

    public void bool(boolean value) {
        put(value);
    }

    public void arr() {
        put(new JSONArray());
    }

    public void arr(Consumer<JsonArray> c) {
        JSONArray jsonArray = new JSONArray();
        c.accept(new JsonArray(jsonArray));

        put(jsonArray);
    }

    public void obj() {
        put(new JSONObject());
    }

    public void nil() {
        put(JSONObject.NULL);
    }

    private <T> void put(T value) {
        suppress(() -> jsonObject.put(key, value));
    }
}