package com.github.helpermethod.molten.examples;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static com.github.helpermethod.molten.Json.object;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

public class MenuTests {
	@Test
	public void testGlossary() throws JSONException {
		JSONObject actual = new JSONObject()
			.put("menu", new JSONObject()
				.put("id", "file")
				.put("value", "File")
				.put("popup", new JSONObject()
					.put("menuitems", new JSONArray()
						.put(new JSONObject()
							.put("value", "New")
							.put("onclick", "CreateNewDoc()"))
						.put(new JSONObject()
							.put("value", "Open")
							.put("onclick", "OpenDoc()"))
						.put(new JSONObject()
							.put("value", "Close")
							.put("onclick", "CloseDoc()")))));

		JSONObject expected = object(o -> o
			.object("menu", menu -> menu
				.string("id", "file")
				.string("value", "File")
				.object("popup", popup -> popup
					.array("menuitems", menuitems -> menuitems
						.object(menuitem -> menuitem
							.string("value", "New")
							.string("onclick", "CreateNewDoc()"))
						.object(menuitem -> menuitem
							.string("value", "Open")
							.string("onclick", "OpenDoc()"))
						.object(menuitem -> menuitem
							.string("value", "Close")
							.string("onclick", "CloseDoc()")))))).toJson();

		assertEquals(actual, expected, STRICT);
	}
}