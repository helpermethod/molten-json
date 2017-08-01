package com.github.helpermethod.molten;

import java.util.Objects;
import java.util.function.Predicate;

public enum NullHandlingStrategy implements Predicate<Object> {
	IGNORE_NULL(Objects::nonNull),
	ALLOW_NULL(e -> true);

	private final Predicate<Object> c;

	NullHandlingStrategy(Predicate<Object> c) {
		this.c = c;
	}

	@Override
	public boolean test(Object o) {
		return c.test(o);
	}
}