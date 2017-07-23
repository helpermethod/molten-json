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
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

@DisplayName("Json")
class JsonTests {
	@Test
	@DisplayName("should create an empty JSON object")
	void createObject() throws JSONException {
		assertEquals(new JSONObject(), object().toJson(), STRICT);
	}

	@Test
	@DisplayName("should create an empty JSON array")
	void createArray() throws JSONException {
		assertEquals(new JSONArray(), array().toJson(), STRICT);
	}
}