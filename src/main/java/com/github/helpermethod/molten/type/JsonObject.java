package com.github.helpermethod.molten.type;

import java.util.function.Consumer;

public interface JsonObject<T> {
	JsonObject<T> string(String key, String value);
	JsonObject<T> number(String key, Number value);
	JsonObject<T> array(String key, Consumer<JsonOrgArray> value);
	JsonObject<T> object(String key, Consumer<JsonOrgObject> value);
	JsonObject<T> bool(String key, Boolean value);
	JsonObject<T> nil(String key);
	T toJson();
	String toString();
	String toPrettyString();
}