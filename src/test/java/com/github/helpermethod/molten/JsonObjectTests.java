package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.json.JSONObject.NULL;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

// TODO parametrize tests
@DisplayName("A JsonObject")
public class JsonObjectTests {
	private final JsonObject jsonObject = new JsonObject();

	@Test
	@DisplayName("should be able to add a string property")
	public void addStringProperty() throws JSONException {
		assertEquals(jsonObject.string("key", "value").toJson(), new JSONObject().put("key", "value"), true);
	}

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
}