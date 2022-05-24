package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint

import com.fasterxml.jackson.databind.ObjectMapper
import com.lukaszjakobczak.roompccupancymanager.BaseIntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class RoomOccupancyManagerControllerIntegrationSpec extends BaseIntegrationSpec {

    private static final String URL = "/rooms/optimize"

    @Autowired
    ObjectMapper objectMapper

    def "Should return OK response when endpoint is invoked"() {
        when: "Endpoint is invoked"
            def response = mockMvc.perform(
                    post(URL)
                    .contentType(APPLICATION_JSON)
                    .content(guestsOrdersJson())
            ).andReturn().response
        then: "HTTP 200 is returned"
            response.status == 200
        and: "Correct optimization is returned"
            RoomOccupancyRestDto roomOccupancyRestDto = objectMapper.readValue(response.getContentAsString(), RoomOccupancyRestDto.class)
            roomOccupancyRestDto.getUsagePremium() == 3
            roomOccupancyRestDto.getPricePremium() == 738
            roomOccupancyRestDto.getUsageEconomy() == 3
            roomOccupancyRestDto.getPriceEconomy() == 167.99d
    }

    private String guestsOrdersJson() {
        """
            {
                "orders": [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209],
                "freeEconomyRooms": 3,
                "freePremiumRooms": 3
            }
        """
    }
}