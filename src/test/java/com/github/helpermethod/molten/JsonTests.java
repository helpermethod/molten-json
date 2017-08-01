package com.github.helpermethod.molten;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A Json")
class JsonTests {
	@Test
	@DisplayName("should create a builder with default configuration")
	void createObject() throws JSONException {
		Json json = new Json();

		// TODO assertJ
	}

	@Test
	@DisplayName("should create a builder with a custom configuration")
	void createArray() throws JSONException {
		new Json(c -> c
			.jsonProvider(new JsonOrgProvider())
			.nullHandling(NullHandlingStrategy.IGNORE_NULL)
			.nullTransformer(() -> ""));

		// TODO assertJ
	}
}