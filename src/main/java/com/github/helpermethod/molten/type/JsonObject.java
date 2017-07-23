package com.github.helpermethod.molten.type;

import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.Objects.requireNonNull;
import static org.json.JSONObject.NULL;

public class JsonObject {
	private final JSONObject jsonObject;

	public JsonObject() {
		this.jsonObject = new JSONObject();
	}

	public JsonObject string(String key, String value) {
		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	public JsonObject number(String key, double value) {
		requireNonNull(key, "JSON keys must not be null");

		suppress(() -> jsonObject.put(key, value));

		return this;
	}


	public JsonObject array(String key, Consumer<JsonArray> value) {
		JsonArray moltenArray = new JsonArray();
		value.accept(moltenArray);

		suppress(() -> jsonObject.put(key, moltenArray.toJson()));

		return this;
	}

	public JsonObject object(String key, Consumer<JsonObject> value) {
		JsonObject moltenObject = new JsonObject();
		value.accept(moltenObject);

		suppress(() -> jsonObject.put(key, moltenObject.toJson()));

		return this;
	}


	public JsonObject bool(String key, boolean value) {
		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	public JsonObject nil(String key) {
		suppress(() -> jsonObject.put(key, NULL));

		return this;
	}

	public JSONObject toJson() {
		return jsonObject;
	}

	@Override
	public String toString() {
		return jsonObject.toString();
	}

	public String toPrettyString() {
		return suppress(() -> jsonObject.toString(4));
	}
}