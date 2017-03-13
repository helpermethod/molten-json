package com.github.helpermethod.molten.type;

import org.json.JSONObject;

import static com.github.helpermethod.molten.function.Functions.wrap;

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

    public void nil() {
        put(null);
    }

    public void num(double value) {
        put(value);
    }

    public void bool(boolean value) {
        put(value);
    }

    private <T> void put(T value) {
        wrap(() -> jsonObject.put(key, value));
    }
}