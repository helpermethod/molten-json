package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonArray;
import com.github.helpermethod.molten.type.JsonObject;

import java.util.function.Consumer;

public class Json {
    private final NullHandling nullHandling;

    public Json() {
        this(c -> {});
    }

    public Json(Consumer<JsonConfiguration> c) {
        JsonConfiguration jsonConfiguration = new JsonConfiguration();
        c.accept(jsonConfiguration);

        nullHandling = jsonConfiguration.nullHandling();
    }

    public JsonObject object() {
        return new JsonObject(nullHandling);
    }

    public JsonObject object(Consumer<JsonObject> c) {
        JsonObject moltenObject = new JsonObject(nullHandling);
        c.accept(moltenObject);

        return moltenObject;
    }

    public JsonArray array() {
        return new JsonArray(nullHandling);
    }

    public JsonArray array(Consumer<JsonArray> c) {
        JsonArray moltenArray = new JsonArray(nullHandling);
        c.accept(moltenArray);

        return moltenArray;
    }
}