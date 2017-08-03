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
	@DisplayName("should create a builder with nullHandlingStrategy set to ALLOW_NULL")
	void createObject() throws JSONException {
		assertThat(new Json()).hasFieldOrPropertyWithValue("nullHandlingStrategy", ALLOW_NULL);
	}

	@Test
	@DisplayName("should create a builder with nullHandlingStrategy set to IGNORE_NULL")
	void createArray() throws JSONException {
		assertThat(new Json(IGNORE_NULL)).hasFieldOrPropertyWithValue("nullHandlingStrategy", IGNORE_NULL);
	}
}