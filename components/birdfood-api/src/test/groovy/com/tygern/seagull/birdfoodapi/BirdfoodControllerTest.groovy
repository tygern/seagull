package com.tygern.seagull.birdfoodapi

import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.HttpStatus.OK
import groovy.json.JsonSlurper
import spock.lang.Specification

class BirdfoodControllerTest extends Specification {
    BirdfoodController birdfoodController
    SeedProvider seedProvider
    MockMvc mockMvc
    JsonSlurper slurper

    def setup() {
        slurper = new JsonSlurper()

        seedProvider = Mock(SeedProvider.class)
        birdfoodController = new BirdfoodController(seedProvider)

        mockMvc = standaloneSetup(birdfoodController).build()
    }

    def "birdfood returns seed"() {
        when:
        def response = mockMvc.perform(get('/birdfood')).andReturn().response
        def result = slurper.parseText(response.contentAsString)

        then:
        1 * seedProvider.getList() >> [new Seed(type: 'sunflower', quantity: 8L)]

        response.status == OK.value()

        result.size() == 1
        result[0].quantity == 8
        result[0].type == "sunflower"
    }
}
