package com.github.helpermethod.molten.types;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonProperty {
    private final String key;
    private final JSONObject jsonObject;

    JsonProperty(String key, JSONObject jsonObject) {
        this.key = key;
        this.jsonObject = jsonObject;
    }

    public void str(String value) {
        try {
            jsonObject.put(key, value);
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }
}
