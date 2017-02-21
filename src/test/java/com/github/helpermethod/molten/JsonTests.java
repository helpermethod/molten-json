package com.github.helpermethod.molten;

import org.junit.Test;

import static com.github.helpermethod.molten.Json.arr;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonTests {
    @Test
    public void shouldCreateAnEmptyObject() {
        assertThat(Json.obj().toString()).isEqualTo("{}");
    }

    @Test
    public void shouldCreateAnObjectWithASingleProperty() {
        String json = Json.obj(o -> o.prop("name", p -> p.str("ID"))).toString();

        assertThat(json).isEqualTo("{\"name\":\"ID\"}");
    }

    @Test
    public void shouldCreateAnObjectWithMultipleProperties() {
        String json = Json.obj(o ->
            o.prop("name", p -> p.str("ID"))
             .prop("type", p -> p.str("INTEGER"))).toString();

        arr(a -> a.str("a", "b", "c"));

        assertThat(json).isEqualTo("{\"name\":\"ID\",\"type\":\"INTEGER\"}");
    }
}
