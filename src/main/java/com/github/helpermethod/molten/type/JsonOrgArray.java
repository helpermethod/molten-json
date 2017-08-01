package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandlingStrategy;
import org.json.JSONArray;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static com.github.helpermethod.molten.stream.Streams.ofAll;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.json.JSONObject.NULL;

public class JsonOrgArray implements JsonArray<JSONArray> {
	private final JSONArray jsonArray;
	private final NullHandlingStrategy nullHandlingStrategy;

	public JsonOrgArray(NullHandlingStrategy nullHandlingStrategy) {
		this.jsonArray = new JSONArray();
		this.nullHandlingStrategy = nullHandlingStrategy;
	}

	@Override
	public JsonOrgArray string(String... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonArray::put);

		return this;
	}

	@Override
	public JsonOrgArray number(Number... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonArray::put);

		return this;
	}

	@Override
	public JsonOrgArray array(Consumer<JsonOrgArray> value) {
		JsonOrgArray moltenArray = new JsonOrgArray(nullHandlingStrategy);
		value.accept(moltenArray);

		jsonArray.put(moltenArray.toJson());

		return this;
	}

	@Override
	public JsonOrgArray object(Consumer<JsonOrgObject> value) {
		JsonOrgObject moltenObject = new JsonOrgObject(nullHandlingStrategy);
		value.accept(moltenObject);

		jsonArray.put(moltenObject.toJson());

		return this;
	}

	@Override
	public JsonOrgArray bool(Boolean... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonArray::put);

		return this;
	}

	@Override
	public JsonOrgArray nil(int number) {
		range(0, number).forEach(i -> jsonArray.put(NULL));

		return this;
	}

	@Override
	public JSONArray toJson() {
		return jsonArray;
	}

	@Override
	public String toString() {
		return jsonArray.toString();
	}

	@Override
	public String toPrettyString() {
		return suppress(() -> jsonArray.toString(4));
	}
}