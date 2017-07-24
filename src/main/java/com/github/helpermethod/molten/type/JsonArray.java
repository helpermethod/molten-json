package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.stream.Streams;
import org.json.JSONArray;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.github.helpermethod.molten.function.Errors.suppress;
import static java.util.stream.IntStream.range;
import static org.json.JSONObject.NULL;

public class JsonArray {
	private final JSONArray jsonArray;

	public JsonArray() {
		this.jsonArray = new JSONArray();
	}

	public JsonArray strings(String... values) {
		Arrays.stream(values).forEach(jsonArray::put);

		return this;
	}

	public JsonArray numbers(double... values) {
		Streams.ofAll(values).forEach(jsonArray::put);

		return this;
	}

	public JsonArray array(Consumer<JsonArray> value) {
		JsonArray moltenArray = new JsonArray();
		value.accept(moltenArray);

		jsonArray.put(moltenArray.toJson());

		return this;
	}

	public JsonArray object(Consumer<JsonObject> value) {
		JsonObject moltenObject = new JsonObject();
		value.accept(moltenObject);

		jsonArray.put(moltenObject.toJson());

		return this;
	}

	public JsonArray bools(boolean... values) {
		Streams.ofAll(values).forEach(jsonArray::put);

		return this;
	}

	public JsonArray nils(int number) {
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