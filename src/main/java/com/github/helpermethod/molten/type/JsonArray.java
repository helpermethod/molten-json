package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.stream.Streams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.stream.IntStream.range;

public class JsonArray {
    private final JSONArray jsonArray;

    public JsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonArray string(String... values) {
        Arrays.stream(values).forEach(jsonArray::put);

        return this;
    }

    public JsonArray number(double... values) {
        Streams.ofAll(values).forEach(jsonArray::put);

        return this;
    }

    public JsonArray bool(boolean... values) {
        Streams.ofAll(values).forEach(jsonArray::put);

        return this;
    }

    public JsonArray nil(int number) {
        range(0, number).forEach(i -> jsonArray.put(JSONObject.NULL));

        return this;
    }

    public JsonArray object(Consumer<JsonObject> value) {
        JsonObject moltenObject = new JsonObject(new JSONObject());
        value.accept(moltenObject);

        jsonArray.put(moltenObject.toJson());

        return this;
    }

    public JsonArray array(Consumer<JsonArray> value) {
        JsonArray moltenArray = new JsonArray(new JSONArray());
        value.accept(moltenArray);

        jsonArray.put(moltenArray.toJson());

        return this;
    }

    private boolean isEmpty(Void[] values) {
        return values != null && values.length == 0;
    }

    public JSONArray toJson() {
        return jsonArray;
    }

    @Override
    public String toString() {
        return jsonArray.toString();
    }

    public String toPrettyString() {
        return suppress(() -> jsonArray.toString(4));
    }
}