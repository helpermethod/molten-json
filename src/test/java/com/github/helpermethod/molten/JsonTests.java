package com.github.helpermethod.molten;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class JsonTests {
    @Test
    @DisplayName("Create an empty JSON object")
    public void createObject() throws JSONException {
        assertEquals(Json.object().toJson(), new JSONObject(), true);
    }

    @Test
    @DisplayName("Create an empty JSON array")
    public void createArray() throws JSONException {
        assertEquals(Json.array().toJson(), new JSONArray(), true);
    }
}