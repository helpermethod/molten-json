package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.json.JSONObject.NULL;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class JsonObjectTests {
	@ParameterizedTest
	@MethodSource("jsonProvider")
	public void addStringProperty(JsonObject expected, JSONObject actual, String type) throws JSONException {
		assertEquals(expected.toJson(), actual, true);
	}

	private static Stream<Arguments> jsonProvider() throws JSONException {
		return Stream.of(
			Arguments.of(new JsonObject().string("key", "value"), new JSONObject().put("key", "value"), "string"),
			Arguments.of(new JsonObject().number("key", 1), new JSONObject().put("key", 1), "number"),
			Arguments.of(new JsonObject().bool("key", true), new JSONObject().put("key", true), "boolean"),
			Arguments.of(new JsonObject().nil("key"), new JSONObject().put("key", NULL), "null")
		);
	}
}