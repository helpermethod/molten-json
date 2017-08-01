package com.github.helpermethod.molten.type;

import java.util.function.Consumer;

public interface JsonArray<T> {
	JsonArray<T> string(String... values);
	JsonArray<T> number(Number... values);
	JsonArray<T> array(Consumer<JsonOrgArray> value);
	JsonArray<T> object(Consumer<JsonOrgObject> value);
	JsonArray<T> bool(Boolean... values);
	JsonArray<T> nil(int number);
	T toJson();
	String toString();
	String toPrettyString();
}