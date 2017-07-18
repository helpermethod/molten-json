package com.github.helpermethod.molten.type;

import org.json.JSONObject;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.Objects.requireNonNull;

public class JsonObject {
    private final JSONObject jsonObject;

    public JsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject string(String key, String value) {
        suppress(() -> jsonObject.put(key, value));

        return this;
    }

    public JsonObject number(String key, double value) {
        requireNonNull(key, "JSON keys must not be null");

        suppress(() -> jsonObject.put(key, value));

        return this;
    }

    public JsonObject bool(String key, boolean value) {
        suppress(() -> jsonObject.put(key, value));

        return this;
    }

    public JsonObject nil(String key) {
        suppress(() -> jsonObject.put(key, JSONObject.NULL));

        return this;
    }

    public JsonObject array(String key, Consumer<JsonArray> value) {
        JsonArray jsonArray = new JsonArray();
        value.accept(jsonArray);

        suppress(() -> jsonObject.put(key, jsonArray.toJson()));

        return this;
    }

    public JSONObject toJson() {
        return jsonObject;
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }

    public String toPrettyString() {
        return suppress(() -> jsonObject.toString(4));
    }
}