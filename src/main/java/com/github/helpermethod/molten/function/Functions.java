package com.github.helpermethod.molten.function;

import org.json.JSONException;

public class Functions {
    private Functions() {
    }

    public static <T> T wrap(ThrowingSupplier<T> s) {
        try {
            return s.get();
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }
}