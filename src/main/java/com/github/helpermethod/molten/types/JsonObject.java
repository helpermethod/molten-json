package com.github.helpermethod.molten.types;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.function.Consumer;

public class JsonObject {
    private final JSONObject jsonObject;

    public JsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject prop(String key, Consumer<JsonProperty> consumer) {
        JsonProperty fluentProperty = new JsonProperty(key, jsonObject);
        consumer.accept(fluentProperty);

        return this;
    }

    public String toString() {
        return jsonObject.toString();
    }

    public String toPrettyString() {
        try {
            return jsonObject.toString(4);
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }
}
