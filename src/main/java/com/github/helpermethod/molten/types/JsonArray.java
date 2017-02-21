package com.github.helpermethod.molten.types;

import org.json.JSONArray;

import java.util.stream.Stream;

public class JsonArray {
    private final JSONArray jsonArray;

    public JsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonArray str(String... values) {
        Stream.of(values).forEach(jsonArray::put);

        return this;
    }
}
