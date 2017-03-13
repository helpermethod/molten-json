package com.github.helpermethod.molten

import com.github.helpermethod.molten.type.JsonArray
import org.json.JSONArray
import org.json.JSONObject
import spock.lang.Specification

class JsonArraySpecification extends Specification {
    def 'adds null values'() {
        def jsonArray = new JSONArray()
        given:
        def moltenArray = new JsonArray(jsonArray)
        when:
        moltenArray.nil()
        then:
        jsonArray.get(0) == JSONObject.NULL
    }
}
