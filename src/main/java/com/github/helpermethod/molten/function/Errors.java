package com.github.helpermethod.molten.function;

import org.json.JSONException;

public class Errors {
    private Errors() {
    }

    public static <T> T suppress(ThrowingJsonSupplier<T> s) {
        try {
            return s.get();
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }
}