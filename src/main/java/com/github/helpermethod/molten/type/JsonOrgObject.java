package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandlingStrategy;
import org.json.JSONObject;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.Objects.requireNonNull;
import static org.json.JSONObject.NULL;

public class JsonOrgObject implements JsonObject<JSONObject> {
	private final JSONObject jsonObject;
	private final NullHandlingStrategy nullHandlingStrategy;

	public JsonOrgObject(NullHandlingStrategy nullHandlingStrategy) {
		this.jsonObject = new JSONObject();
		this.nullHandlingStrategy = nullHandlingStrategy;
	}

	@Override
	public JsonOrgObject string(String key, String value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	@Override
	public JsonOrgObject number(String key, Number value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	@Override
	public JsonOrgObject array(String key, Consumer<JsonOrgArray> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JsonOrgArray moltenArray = new JsonOrgArray(nullHandlingStrategy);
		value.accept(moltenArray);

		suppress(() -> jsonObject.put(key, moltenArray.toJson()));

		return this;
	}

	@Override
	public JsonOrgObject object(String key, Consumer<JsonOrgObject> value) {
		requireNonNull(key, "JSON keys must not be null.");

		JsonOrgObject moltenObject = new JsonOrgObject(nullHandlingStrategy);
		value.accept(moltenObject);

		suppress(() -> jsonObject.put(key, moltenObject.toJson()));

		return this;
	}

	@Override
	public JsonOrgObject bool(String key, Boolean value) {
		requireNonNull(key, "JSON keys must not be null.");

		if (!nullHandlingStrategy.test(value)) {
			return this;
		}

		suppress(() -> jsonObject.put(key, value));

		return this;
	}

	@Override
	public JsonOrgObject nil(String key) {
		requireNonNull(key, "JSON keys must not be null.");

		suppress(() -> jsonObject.put(key, NULL));

		return this;
	}

	@Override
	public JSONObject toJson() {
		return jsonObject;
	}

	@Override
	public String toString() {
		return jsonObject.toString();
	}

	@Override
	public String toPrettyString() {
		return suppress(() -> jsonObject.toString(4));
	}
}