package com.github.helpermethod.molten.type;

import java.util.function.Consumer;

public interface JsonArray<T> {
	JsonArray string(String... values);
	JsonArray number(Number... values);
	JsonArray array(Consumer<JsonOrgArray> value);
	JsonArray object(Consumer<JsonOrgObject> value);
	JsonArray bool(Boolean... values);
	JsonArray nil(int number);
	T toJson();
	String toString();
	String toPrettyString();
}