package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonArray;
import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;

public class Json {
    private Json() {
    }

    public static JsonObject object() {
        return new JsonObject(new JSONObject());
    }

    public static JsonObject object(Consumer<JsonObject> c) {
        JsonObject moltenObject = new JsonObject(new JSONObject());
        c.accept(moltenObject);

        return moltenObject;
    }

    public static JsonArray array() {
        return new JsonArray(new JSONArray());
    }

    public static JsonArray array(Consumer<JsonArray> c) {
        JsonArray moltenArray = new JsonArray(new JSONArray());
        c.accept(moltenArray);

        return moltenArray;
    }
}