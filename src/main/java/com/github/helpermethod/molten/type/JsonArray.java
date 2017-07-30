package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandling;
import org.json.JSONArray;

import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static com.github.helpermethod.molten.stream.Streams.ofAll;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.json.JSONObject.NULL;

public class JsonArray {
	private final JSONArray jsonArray;
	private final NullHandling nullHandling;

	public JsonArray(NullHandling nullHandling) {
		this.jsonArray = new JSONArray();
		this.nullHandling = nullHandling;
	}

	public JsonArray string(String... values) {
		stream(values).filter(nullHandling)
		              .forEach(jsonArray::put);

		return this;
	}

	public JsonArray number(Number... values) {
		stream(values).filter(nullHandling)
		              .forEach(jsonArray::put);

		return this;
	}

	public JsonArray array(Consumer<JsonArray> value) {
		JsonArray moltenArray = new JsonArray(nullHandling);
		value.accept(moltenArray);

		jsonArray.put(moltenArray.toJson());

		return this;
	}

	public JsonArray object(Consumer<JsonObject> value) {
		JsonObject moltenObject = new JsonObject(nullHandling);
		value.accept(moltenObject);

		jsonArray.put(moltenObject.toJson());

		return this;
	}

	public JsonArray bool(Boolean... values) {
		stream(values).filter(nullHandling)
		              .forEach(jsonArray::put);

		return this;
	}

	public JsonArray nil(int number) {
		range(0, number).forEach(i -> jsonArray.put(NULL));

		return this;
	}

	public JSONArray toJson() {
		return jsonArray;
	}

	@Override
	public String toString() {
		return jsonArray.toString();
	}

	public String toPrettyString() {
		return suppress(() -> jsonArray.toString(4));
	}
}