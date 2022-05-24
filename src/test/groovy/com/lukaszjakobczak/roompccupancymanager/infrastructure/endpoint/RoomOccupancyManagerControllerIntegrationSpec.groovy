package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint

import com.lukaszjakobczak.roompccupancymanager.BaseIntegrationSpec

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class RoomOccupancyManagerControllerIntegrationSpec extends BaseIntegrationSpec {

    private static final String URL = "/rooms/optimize"

    def "Should return OK response when endpoint is invoked"() {
        when: "Endpoint is invoked"
            def response = mockMvc.perform(
                    post(URL)
                    .contentType(APPLICATION_JSON)
                    .content(guestsOrdersJson())
            ).andReturn().response
        then: "HTTP 204 is returned"
            response.status == 204
    }

    private String guestsOrdersJson() {
        """
            {
                "orders": [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
            }
        """
    }
}
