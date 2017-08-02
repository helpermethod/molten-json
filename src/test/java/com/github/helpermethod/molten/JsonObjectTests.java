package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.helpermethod.molten.NullHandlingStrategy.ALLOW_NULL;
import static org.json.JSONObject.NULL;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

@DisplayName("JsonObject")
class JsonObjectTests {
	private final JSONObject jsonOrgObject = new JSONObject();
	private final JsonObject jsonObject = new JsonObject(jsonOrgObject, ALLOW_NULL);

	@Test
	@DisplayName("should add a string property")
	void addStringProperty() throws JSONException {
		jsonObject.string("key", "value");

		assertEquals(new JSONObject().put("key", "value"), jsonOrgObject, STRICT);
	}

	@Test
	@DisplayName("should add a numbers property")
	void addNumberProperty() throws JSONException {
		jsonObject.number("key", 1);

		assertEquals(new JSONObject().put("key", 1), jsonOrgObject, STRICT);
	}

	@Test
	@DisplayName("should add an object property")
	void addObjectProperty() throws JSONException {
		jsonObject.object("key", o -> {
		});

		assertEquals(new JSONObject().put("key", new JSONObject()), jsonOrgObject, STRICT);
	}

	@Test
	@DisplayName("should add an array property")
	void addArrayProperty() throws JSONException {
		jsonObject.array("key", a -> {
		});

		assertEquals(new JSONObject().put("key", new JSONArray()), jsonOrgObject, STRICT);
	}

	@Test
	@DisplayName("should add a boolean property")
	void addBooleanProperty() throws JSONException {
		jsonObject.bool("key", true);

		assertEquals(new JSONObject().put("key", true), jsonOrgObject, STRICT);
	}

	@Test
	@DisplayName("should add a null property")
	void addNullProperty() throws JSONException {
		jsonObject.nil("key");

		assertEquals(new JSONObject().put("key", NULL), jsonOrgObject, STRICT);
	}
}