package com.tygern.seagull.httpseedstore

import groovy.json.JsonOutput
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

class HttpSeedProviderTest extends Specification {

    RestTemplate restTemplate
    MockRestServiceServer mockServer
    HttpSeedProvider httpSeedProvider

    def setup() {
        restTemplate = new RestTemplate()
        mockServer = MockRestServiceServer.createServer(restTemplate);

        httpSeedProvider = new HttpSeedProvider(restTemplate, "http://www.example.com")
    }

    def testGetList() {
        given:

        def response = JsonOutput.toJson([
                seed: [
                        [id: 2, amount: 50, type: "flax", tasty: true],
                        [id: 3, amount: 600, type: "squash", tasty: false],
                ]
        ])


        mockServer.expect(requestTo("http://www.example.com/seed"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        when:
        def seedList = httpSeedProvider.getList();

        then:
        seedList.size() == 2

        def flax = seedList.get(0)
        flax.quantity == 50
        flax.type == "flax"

        def squash = seedList.get(1)
        squash.quantity == 600
        squash.type == "squash"

        mockServer.verify()
    }
}