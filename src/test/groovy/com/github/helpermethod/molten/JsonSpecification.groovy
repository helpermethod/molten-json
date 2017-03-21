package com.github.helpermethod.molten

import groovy.json.JsonSlurper
import org.json.JSONObject
import spock.lang.Shared
import spock.lang.Specification

class JsonSpecification extends Specification {
    @Shared
    private JsonSlurper slurper = new JsonSlurper()

    def 'create an empty JSON object'() {
        expect:
        slurper.parseText Json.obj() == slurper.parseText '{}'
    }

    def 'create an empty JSON array'() {
        expect:
        slurper.parseText Json.arr() == slurper.parseText '[]'
    }
}