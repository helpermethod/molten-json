package com.github.helpermethod.molten;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.helpermethod.molten.NullHandlingStrategy.*;

@DisplayName("A Json")
class JsonTests {
	@Test
	@DisplayName("should create a builder with default configuration")
	void createObject() throws JSONException {
		Json json = new Json(new JsonOrgProvider());

		// TODO assertJ
	}

	@Test
	@DisplayName("should create a builder with a custom configuration")
	void createArray() throws JSONException {
		new Json(new JsonOrgProvider(c -> c
			.nullHandlingStrategy(IGNORE_NULL)));

		// TODO assertJ
	}
}