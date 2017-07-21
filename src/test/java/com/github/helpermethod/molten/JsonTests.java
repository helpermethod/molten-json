package com.github.helpermethod.molten;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static com.github.helpermethod.molten.Json.array;
import static com.github.helpermethod.molten.Json.object;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@DisplayName("Json")
public class JsonTests {
	@Test
	@DisplayName("should create an empty JSON object")
	public void createObject() throws JSONException {
		assertEquals(object().toJson(), new JSONObject(), true);
	}

	@Test
	@DisplayName("should create an empty JSON array")
	public void createArray() throws JSONException {
		assertEquals(array().toJson(), new JSONArray(), true);
	}
}