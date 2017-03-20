package com.github.helpermethod.molten.function;

import org.json.JSONException;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws JSONException;
}
