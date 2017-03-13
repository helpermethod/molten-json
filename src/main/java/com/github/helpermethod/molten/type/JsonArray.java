package com.github.helpermethod.molten.type;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.github.helpermethod.molten.function.Functions.wrap;

public class JsonArray {
    private final JSONArray jsonArray;

    public JsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonArray str(String value, String... rest) {
        return putAll(value, rest);
    }

    public JsonArray num(Double value, Double... rest) {
        return putAll(value, rest);
    }

    public JsonArray bool(Boolean value, Boolean... rest) {
        return putAll(value, rest);
    }

    // .nil()
    // .nil(null)
    // .nil(null, null)
    public JsonArray nil(Void... values) {
        if (isEmpty(values)) {
            jsonArray.put(JSONObject.NULL);

            return this;
        }

        Arrays.stream(values).forEach(v -> jsonArray.put(JSONObject.NULL));

        return this;
    }

    private boolean isEmpty(Void[] values) {
        return values != null && values.length == 0;
    }

    private <T> JsonArray putAll(T value, T... rest) {
        jsonArray.put(value);
        Arrays.stream(rest).forEach(jsonArray::put);

        return this;
    }

    public String toString() {
        return jsonArray.toString();
    }

    public String toPrettyString() {
        return wrap(() -> jsonArray.toString(4));
    }
}