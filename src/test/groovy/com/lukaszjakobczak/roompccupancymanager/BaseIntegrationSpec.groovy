package com.lukaszjakobczak.roompccupancymanager

import com.lukaszjakobczak.roompccupancymanager.RoompccupancymanagerApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest(classes = [RoompccupancymanagerApplication], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseIntegrationSpec extends Specification {

    @Autowired
    protected MockMvc mockMvc

    @LocalServerPort
    protected int port
}
