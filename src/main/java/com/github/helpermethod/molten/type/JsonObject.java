package com.github.helpermethod.molten.type;

import java.util.function.Consumer;

public interface JsonObject<T> {
	JsonObject string(String key, String value);
	JsonObject number(String key, Number value);
	JsonObject array(String key, Consumer<JsonOrgArray> value);
	JsonObject object(String key, Consumer<JsonOrgObject> value);
	JsonObject bool(String key, Boolean value);
	JsonObject nil(String key);
	T toJson();
	String toString();
	String toPrettyString();
}