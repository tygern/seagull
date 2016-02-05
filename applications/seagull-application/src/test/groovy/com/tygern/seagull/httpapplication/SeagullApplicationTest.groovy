package com.tygern.seagull.httpapplication

import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.tomjankes.wiremock.WireMockGroovy
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.junit.Rule
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification


@SpringApplicationConfiguration(classes = SeagullApplication.class)
@WebIntegrationTest(randomPort = true)
@TestPropertySource(locations = "classpath:test.properties")
class SeagullApplicationTest extends Specification {

    @Value('${local.server.port}')
    int port;

    @Rule
    WireMockRule wireMockRule = new WireMockRule(8888)

    WireMockGroovy wireMockStub

    JsonSlurper slurper;

    def setup() {
        slurper = new JsonSlurper()
        wireMockStub = new WireMockGroovy('localhost', 8888)
    }

    def "birdfood returns seed"() {
        given:
        def responseBody = JsonOutput.toJson([
                seed: [
                        [id: 2, amount: 55, type: "mustard", tasty: true],
                        [id: 3, amount: 66, type: "tomato", tasty: false],
                ]
        ])

        wireMockStub.stub {
            request {
                method "GET"
                url "/seed"
            }
            response {
                status 200

                body(responseBody)
                headers {
                    "Content-Type" "application/json"
                }
            }
        }

        when:
        def result = slurper.parse(new URL("http://localhost:${port}/birdfood"))

        then:
        result.size == 2

        result[0].type == "mustard"
        result[0].quantity == 55

        result[1].type == "tomato"
        result[1].quantity == 66
    }

}