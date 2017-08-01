package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonOrgArray;
import com.github.helpermethod.molten.type.JsonOrgObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class JsonOrgProvider implements JsonProvider {
	private final Supplier<?> nullTransformer;

	public JsonOrgProvider() {
		this(j -> {});
	}

	public JsonOrgProvider(Consumer<JsonConfiguration> c) {
		JsonConfiguration jsonConfiguration = new JsonConfiguration();
		c.accept(jsonConfiguration);

		nullTransformer = jsonConfiguration.nullTransformer();
	}

	@Override
	public JsonOrgObject object() {
		return null;
	}

	@Override
	public JsonOrgObject object(Consumer<JsonOrgObject> c) {
		return null;
	}

	@Override
	public JsonOrgArray array() {
		return null;
	}

	@Override
	public JsonOrgArray array(Consumer<JsonOrgArray> c) {
		return null;
	}
}