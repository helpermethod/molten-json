package com.github.helpermethod.molten.type;

import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;

public class JsonObject {
    private final JSONObject jsonObject;

    public JsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject str(String key, String value) {
        suppress(() -> jsonObject.put(key, value));

        return this;
    }

    public JSONObject toJson() {
        return jsonObject;
    }

    public String toString() {
        return jsonObject.toString();
    }

    public String toPrettyString() {
        return suppress(() -> jsonObject.toString(4));
    }
}