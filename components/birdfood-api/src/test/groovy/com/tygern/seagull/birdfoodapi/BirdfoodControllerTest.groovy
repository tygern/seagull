package com.tygern.seagull.birdfoodapi

import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.HttpStatus.OK
import spock.lang.Specification

class BirdfoodControllerTest extends Specification {
    BirdfoodController birdfoodController
    SeedProvider seedProvider
    MockMvc mockMvc

    def setup() {
        seedProvider = Mock(SeedProvider.class)
        birdfoodController = new BirdfoodController(seedProvider)
        mockMvc = standaloneSetup(birdfoodController).build()
    }

    def "birdfood returns seed"() {
        when:
        def response = mockMvc.perform(get('/birdfood')).andReturn().response

        then:
        1 * seedProvider.getList() >> [new Seed(type: 'sunflower', quantity: 8L)]

        response.status == OK.value()
        response.contentAsString == '[{"quantity":8,"type":"sunflower"}]'
    }
}
