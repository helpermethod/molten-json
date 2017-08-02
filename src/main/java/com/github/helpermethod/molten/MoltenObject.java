package com.github.helpermethod.molten;

import org.json.JSONObject;

import static com.github.helpermethod.molten.function.JsonErrors.suppress;

public class MoltenObject {
	private JSONObject jsonObject;

	MoltenObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public JSONObject toJson() {
		return jsonObject;
	}

	public String toString() {
		return jsonObject.toString();
	}

	public String toPrettyString() {
		return suppress(() -> jsonObject.toString(4));
	}
}