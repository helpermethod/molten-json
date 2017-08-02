package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonArray;
import com.github.helpermethod.molten.type.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.github.helpermethod.molten.NullHandlingStrategy.ALLOW_NULL;

public class Json {
	private final NullHandlingStrategy nullHandlingStrategy;

	public Json() {
		this(ALLOW_NULL);
	}

	public Json(NullHandlingStrategy nullHandlingStrategy) {
		this.nullHandlingStrategy = nullHandlingStrategy;
	}

	public MoltenObject object() {
		return new MoltenObject(new JSONObject());
	}

	public MoltenObject object(Consumer<JsonObject> c) {
		JSONObject jsonOrgObject = new JSONObject();
		JsonObject jsonObject = new JsonObject(jsonOrgObject, nullHandlingStrategy);
		c.accept(jsonObject);

		return new MoltenObject(jsonOrgObject);
	}

	public MoltenArray array() {
		return new MoltenArray(new JSONArray());
	}

	public MoltenArray array(Consumer<JsonArray> c) {
		JSONArray jsonOrgArray = new JSONArray();
		JsonArray jsonArray = new JsonArray(jsonOrgArray, nullHandlingStrategy);
		c.accept(jsonArray);

		return new MoltenArray(jsonOrgArray);
	}
}