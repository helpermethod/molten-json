package com.github.helpermethod.molten.function;

import org.json.JSONException;

@FunctionalInterface
public interface ThrowingJsonSupplier<T> {
    T get() throws JSONException;
}
