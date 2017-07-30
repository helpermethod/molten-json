package com.github.helpermethod.molten;

public class JsonConfiguration {
	private NullHandling nullHandling = NullHandling.ALLOW_NULL;

	public JsonConfiguration nullHandling(NullHandling nullHandling) {
		this.nullHandling = nullHandling;

		return this;
	}

	public NullHandling nullHandling() {
		return nullHandling;
	}
}