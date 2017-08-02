package com.github.helpermethod.molten;

import org.json.JSONArray;

import static com.github.helpermethod.molten.function.JsonErrors.suppress;

public class MoltenArray {
	private final JSONArray jsonOrgArray;

	MoltenArray(JSONArray jsonOrgArray) {
		this.jsonOrgArray = jsonOrgArray;
	}

	public JSONArray toJson() {
		return jsonOrgArray;
	}

	public String toString() {
		return jsonOrgArray.toString();
	}

	public String toPrettyString() {
		return suppress(() -> jsonOrgArray.toString(4));
	}
}