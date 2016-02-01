package com.tygern.seagull

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import spock.lang.Specification

@SpringApplicationConfiguration(classes = SeagullApplication.class)
@WebIntegrationTest(randomPort = true)
class SeagullApplicationTest extends Specification {

    @Value('${local.server.port}')
    int port;

    JsonSlurper slurper;

    def setup() {
        slurper = new JsonSlurper()
    }

    def "birdfood returns seed"() {
        when:
        def result = slurper.parse(new URL("http://localhost:${port}/birdfood"))

        then:
        result.size == 2

        result[0].type == "fennel"
        result[0].quantity == 7

        result[1].type == "millet"
        result[1].quantity == 50
    }
}
