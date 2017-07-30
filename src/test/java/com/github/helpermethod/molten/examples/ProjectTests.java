package com.github.helpermethod.molten.examples;

import com.github.helpermethod.molten.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

class ProjectTests {
	@Test
	void testPackage() throws JSONException {
		JSONObject actual = new JSONObject()
			.put("name", "molten-json")
			.put("version", "0.1.0")
			.put("description", "A fluent Java 8 DSL for working with JSON.")
			.put("repository", new JSONObject()
				.put("type", "git")
				.put("url", "https://github.com/helpermethod/molten-json"))
			.put("keywords", new JSONArray()
				.put("json")
				.put("java-8")
				.put("fluent")
				.put("dsl"))
			.put("author", "helpermethod")
			.put("license", "Apache 2")
			.put("bugs", new JSONObject()
				.put("url", "https://github.com/helpermethod/molten-json/issues"));

		JSONObject expected = new Json()
			.object(o -> o
				.string("name", "molten-json")
				.string("version", "0.1.0")
				.string("description", "A fluent Java 8 DSL for working with JSON.")
				.object("repository", r -> r
					.string("type", "git")
					.string("url", "https://github.com/helpermethod/molten-json"))
				.array("keywords", k -> k
					.string("json", "java-8", "fluent", "dsl"))
				.string("author", "helpermethod")
				.string("license", "Apache 2")
				.object("bugs", b -> b
					.string("url", "https://github.com/helpermethod/molten-json/issues"))).toJson();

		assertEquals(actual, expected, STRICT);
	}
}