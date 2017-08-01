package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonOrgArray;
import com.github.helpermethod.molten.type.JsonOrgObject;

import java.util.function.Consumer;

public class Json {
	private final JsonProvider jsonProvider;

	public Json(JsonProvider jsonProvider) {
		this.jsonProvider = jsonProvider;
	}

	public JsonOrgObject object(Consumer<JsonOrgObject> c) {
		JsonOrgObject moltenObject = jsonProvider.object();
		c.accept(moltenObject);

		return moltenObject;
	}

	public JsonOrgArray array() {
		return jsonProvider.array();
	}

	public JsonOrgArray array(Consumer<JsonOrgArray> c) {
		JsonOrgArray moltenArray = jsonProvider.array(c);
		c.accept(moltenArray);

		return moltenArray;
	}
}