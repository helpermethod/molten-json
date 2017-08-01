package com.github.helpermethod.molten;

import com.github.helpermethod.molten.type.JsonArray;
import com.github.helpermethod.molten.type.JsonObject;
import com.github.helpermethod.molten.type.JsonOrgArray;
import com.github.helpermethod.molten.type.JsonOrgObject;

import java.util.function.Consumer;

public interface JsonProvider {
	JsonObject object();
	JsonObject object(Consumer<JsonOrgObject> c);
	JsonArray array();
	JsonArray array(Consumer<JsonOrgArray> c);
}