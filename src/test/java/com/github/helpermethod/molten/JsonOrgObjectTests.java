package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonObject;
import com.github.helpermethod.molten.type.JsonOrgObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.helpermethod.molten.NullHandlingStrategy.ALLOW_NULL;
import static org.json.JSONObject.NULL;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

@DisplayName("A JsonOrgObject")
class JsonOrgObjectTests {
	private final JsonObject<JSONObject> jsonObject = new JsonOrgObject(ALLOW_NULL);

	@Test
	@DisplayName("should add a string property")
	void addStringProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", "value"), jsonObject.string("key", "value").toJson(), STRICT);
	}

	@Test
	@DisplayName("should add a numbers property")
	void addNumberProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", 1), jsonObject.number("key", 1).toJson(), STRICT);
	}

	@Test
	@DisplayName("should add an object property")
	void addObjectProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", new JSONObject()), jsonObject.object("key", o -> {}).toJson(), STRICT);
	}

	@Test
	@DisplayName("should add an array property")
	void addArrayProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", new JSONArray()), jsonObject.array("key", a -> {}).toJson(), STRICT);
	}

	@Test
	@DisplayName("should add a boolean property")
	void addBooleanProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", true), jsonObject.bool("key", true).toJson(), STRICT);
	}

	@Test
	@DisplayName("should add a null property")
	void addNullProperty() throws JSONException {
		assertEquals(new JSONObject().put("key", NULL), jsonObject.nil("key").toJson(), STRICT);
	}
}