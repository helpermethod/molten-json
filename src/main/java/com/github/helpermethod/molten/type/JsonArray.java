package com.github.helpermethod.molten.type;

import com.github.helpermethod.molten.NullHandlingStrategy;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Consumer;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static org.json.JSONObject.NULL;

public class JsonArray {
	private final JSONArray jsonOrgArray;
	private final NullHandlingStrategy nullHandlingStrategy;

	public JsonArray(JSONArray jsonOrgArray, NullHandlingStrategy nullHandlingStrategy) {
		this.jsonOrgArray = jsonOrgArray;
		this.nullHandlingStrategy = nullHandlingStrategy;
	}

	public JsonArray strings(String... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonOrgArray::put);

		return this;
	}

	public JsonArray numbers(Number... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonOrgArray::put);

		return this;
	}

	public JsonArray array(Consumer<JsonArray> c) {
		JSONArray jsonOrgArray = new JSONArray();
		JsonArray jsonArray = new JsonArray(jsonOrgArray, nullHandlingStrategy);
		c.accept(jsonArray);

		this.jsonOrgArray.put(jsonOrgArray);

		return this;
	}

	public JsonArray object(Consumer<JsonObject> c) {
		JSONObject jsonOrgObject = new JSONObject();
		JsonObject jsonObject = new JsonObject(jsonOrgObject, nullHandlingStrategy);
		c.accept(jsonObject);

		jsonOrgArray.put(jsonOrgObject);

		return this;
	}

	public JsonArray bools(Boolean... values) {
		stream(values).filter(nullHandlingStrategy)
		              .forEach(jsonOrgArray::put);

		return this;
	}

	public JsonArray nils(int number) {
		range(0, number).forEach(i -> jsonOrgArray.put(NULL));

		return this;
	}
}