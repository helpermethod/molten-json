package com.github.helpermethod.molten

import org.json.JSONObject
import spock.lang.Specification

class JsonSpecification extends Specification {
    def 'create an empty JSON object'() {
        expect:
        Json.obj() == new JSONObject()
    }

    def 'create an empty JSON array'() {
        expect:
        Json.arr() == "[]"
    }
}