package com.tygern.seagull.birdfoodapi

import spock.lang.Specification

class BirdfoodControllerTest extends Specification {
    def "let's try this!"() {
        given:
        def number = 2

        when:
        number += 1

        then:
        number == 3
    }
}
