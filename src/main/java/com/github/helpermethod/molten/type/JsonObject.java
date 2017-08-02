package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandlingStrategy;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.JsonErrors.suppress;
import static java.util.Objects.requireNonNull;
import static org.json.JSONObject.NULL;

public class JsonObject {
	private final JSONObject jsonOrgObject;
	private final NullHandlingStrategy nullHandlingStrategy;

	public JsonObject(JSONObject jsonOrgObject, NullHandlingStrategy nullHandlingStrategy) {
		this.jsonOrgObject = jsonOrgObject;
		this.nullHandlingStrategy = nullHandlingStrategy;
	}

	public JsonObject string(String key, String c) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(c)) {
			return this;
		}

		suppress(() -> jsonOrgObject.put(key, c));

		return this;
	}

	public JsonObject number(String key, Number value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(value)) {
			return this;
		}

		suppress(() -> jsonOrgObject.put(key, value));

		return this;
	}

	public JsonObject array(String key, Consumer<JsonArray> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JSONArray jsonOrgArray = new JSONArray();
		JsonArray jsonArray = new JsonArray(jsonOrgArray, nullHandlingStrategy);
		value.accept(jsonArray);

		suppress(() -> jsonOrgObject.put(key, jsonOrgArray));

		return this;
	}

	public JsonObject object(String key, Consumer<JsonObject> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JSONObject jsonOrgObject = new JSONObject();
		JsonObject jsonObject = new JsonObject(jsonOrgObject, nullHandlingStrategy);
		value.accept(jsonObject);

		suppress(() -> this.jsonOrgObject.put(key, jsonOrgObject));

		return this;
	}

	public JsonObject bool(String key, Boolean value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(value)) {
			return this;
		}

		suppress(() -> jsonOrgObject.put(key, value));

		return this;
	}

	public JsonObject nil(String key) {
		requireNonNull(key, "JSON keys must not be null.");

		suppress(() -> jsonOrgObject.put(key, NULL));

		return this;
	}
}