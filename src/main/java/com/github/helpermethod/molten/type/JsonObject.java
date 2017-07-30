package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandling;
import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.Objects.requireNonNull;
import static org.json.JSONObject.NULL;

public class JsonObject {
	private final JSONObject jsonObject;
	private final NullHandling nullHandling;

	public JsonObject(NullHandling nullHandling) {
		this.jsonObject = new JSONObject();
		this.nullHandling = nullHandling;
	}

	public JsonObject string(String key, String value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandling.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	public JsonObject number(String key, Number value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandling.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	public JsonObject array(String key, Consumer<JsonArray> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JsonArray moltenArray = new JsonArray(nullHandling);
		value.accept(moltenArray);

		suppress(() -> jsonObject.put(key, moltenArray.toJson()));

		return this;
	}

	public JsonObject object(String key, Consumer<JsonObject> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JsonObject moltenObject = new JsonObject(nullHandling);
		value.accept(moltenObject);

		suppress(() -> jsonObject.put(key, moltenObject.toJson()));

		return this;
	}

	public JsonObject bool(String key, Boolean value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandling.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	public JsonObject nil(String key) {
		requireNonNull(key, "JSON keys must not be null.");

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