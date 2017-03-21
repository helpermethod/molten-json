package com.github.helpermethod.molten

import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

class JsonSpecification extends Specification {
    @Shared
    private JsonSlurper slurper = new JsonSlurper()

    def 'create an empty JSON object'() {
        expect:
        slurper.parseText(Json.obj().toString()) == slurper.parseText('{}')
    }

    def 'create an empty JSON array'() {
        expect:
        slurper.parseText(Json.arr().toString()) == slurper.parseText('[]')
    }
}