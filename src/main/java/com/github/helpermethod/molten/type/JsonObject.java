package com.github.helpermethod.molten.type;

import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Functions.wrap;

public class JsonObject {
    private final JSONObject jsonObject;

    public JsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject prop(String key, Consumer<JsonProperty> consumer) {
        consumer.accept(new JsonProperty(key, jsonObject));

        return this;
    }

    public JSONObject toJson() {
        return wrap(() -> new JSONObject(jsonObject.toString()));
    }

    public String toString() {
        return jsonObject.toString();
    }

    public String toPrettyString() {
        return wrap(() -> jsonObject.toString(4));
    }
}