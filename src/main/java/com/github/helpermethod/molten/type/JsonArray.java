package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.stream.Streams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

import static com.github.helpermethod.molten.function.Errors.suppress;

public class JsonArray {
    private final JSONArray jsonArray;

    public JsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonArray str(String... values) {
        Arrays.stream(values).forEach(jsonArray::put);

        return this;
    }

    public JsonArray num(double... values) {
        Streams.ofAll(values).forEach(jsonArray::put);

        return this;
    }

    public JsonArray bool(boolean... values) {
        Streams.ofAll(values).forEach(jsonArray::put);

        return this;
    }

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

    public String toString() {
        return jsonArray.toString();
    }

    public String toPrettyString() {
        return suppress(() -> jsonArray.toString(4));
    }
}