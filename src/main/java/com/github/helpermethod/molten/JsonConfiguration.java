package com.github.helpermethod.molten;

import java.util.function.Supplier;

public class JsonConfiguration {
	private NullHandlingStrategy nullHandlingStrategyStrategy = NullHandlingStrategy.ALLOW_NULL;
	private Supplier<?> nullTransformer = () -> null;

	Supplier<?> nullTransformer() {
		return nullTransformer;
	}

	public <T> JsonConfiguration nullTransformer(Supplier<T> nullTransformer) {
		this.nullTransformer = nullTransformer;

		return this;
	}

	NullHandlingStrategy nullHandlingStrategy() {
		return nullHandlingStrategyStrategy;
	}

	public JsonConfiguration nullHandlingStrategy(NullHandlingStrategy nullHandlingStrategyStrategy) {
		this.nullHandlingStrategyStrategy = nullHandlingStrategyStrategy;

		return this;
	}
}