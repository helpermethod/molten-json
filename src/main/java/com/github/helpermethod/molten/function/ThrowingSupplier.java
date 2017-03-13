package com.github.helpermethod.molten.function;

import org.json.JSONException;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws JSONException;
}
