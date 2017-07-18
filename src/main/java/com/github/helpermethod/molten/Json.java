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
        return new JsonObject();
    }

    public static JsonObject object(Consumer<JsonObject> c) {
        JsonObject moltenObject = new JsonObject();
        c.accept(moltenObject);

        return moltenObject;
    }

    public static JsonArray array() {
        return new JsonArray();
    }

    public static JsonArray array(Consumer<JsonArray> c) {
        JsonArray moltenArray = new JsonArray();
        c.accept(moltenArray);

        return moltenArray;
    }
}