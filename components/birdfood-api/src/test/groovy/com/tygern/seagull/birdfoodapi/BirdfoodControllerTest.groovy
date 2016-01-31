package com.tygern.seagull.birdfoodapi

import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.HttpStatus.OK
import spock.lang.Specification

class BirdfoodControllerTest extends Specification {
    BirdfoodController birdfoodController
    MockMvc mockMvc

    def setup() {
        birdfoodController = new BirdfoodController()
        mockMvc = standaloneSetup(birdfoodController).build()
    }

    def "birdfood returns seed"() {
        when:
        def response = mockMvc.perform(get('/birdfood')).andReturn().response

        then:
        response.status == OK.value()
        response.contentAsString == 'seed'
    }
}
