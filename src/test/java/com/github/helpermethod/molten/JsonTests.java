package com.github.helpermethod.molten;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.helpermethod.molten.NullHandlingStrategy.ALLOW_NULL;
import static com.github.helpermethod.molten.NullHandlingStrategy.IGNORE_NULL;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Json")
class JsonTests {
	@Test
	@DisplayName("should create a builder with default configuration")
	void createObject() throws JSONException {
		Json json = new Json();

		assertThat(json).hasFieldOrPropertyWithValue("nullHandlingStrategy", ALLOW_NULL);
	}

	@Test
	@DisplayName("should create a builder with custom configuration")
	void createArray() throws JSONException {
		Json json = new Json(IGNORE_NULL);

		assertThat(json).hasFieldOrPropertyWithValue("nullHandlingStrategy", IGNORE_NULL);
	}
}