package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@DisplayName("A JsonObject")
public class JsonObjectTests {
	private final JsonObject jsonObject = new JsonObject();

	@ParameterizedTest
	@MethodSource("jsonProvider")
	@DisplayName("should be able to add a string property")
	public void addStringProperty(JsonObject expected, JSONObject actual) throws JSONException {
		assertEquals(expected.toJson(), actual, true);
	}

	private static Stream<Arguments> jsonProvider() throws JSONException {
		return Stream.of(
			Arguments.of(new JsonObject().string("key", "value"), new JSONObject().put("key", "value")));
	}
/*
	@Test
	@DisplayName("should be able to add a number property")
	public void addNumberProperty() throws JSONException {
		assertEquals(jsonObject.number("key", 1).toJson(), new JSONObject().put("key", 1), true);
	}

	@Test
	@DisplayName("should be able to add a boolean property")
	public void addBooleanProperty() throws JSONException {
		assertEquals(jsonObject.bool("key", true).toJson(), new JSONObject().put("key", true), true);
	}

	@Test
	@DisplayName("should be able to add a null property")
	public void addNullProperty() throws JSONException {
		assertEquals(jsonObject.nil("key").toJson(), new JSONObject().put("key", NULL), true);
	}
	*/
}