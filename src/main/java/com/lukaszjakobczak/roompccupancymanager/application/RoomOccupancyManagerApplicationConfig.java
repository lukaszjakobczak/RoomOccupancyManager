package com.lukaszjakobczak.roompccupancymanager.application;

import com.lukaszjakobczak.roompccupancymanager.domain.RoomOccupancyManagerFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RoomOccupancyManagerApplicationConfig {

    @Bean
    RoomOccupancyManagerApplicationFacade roomOccupancyManagerApplicationFacade(RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService) {
        return new RoomOccupancyManagerApplicationFacade(roomOccupancyManagerApplicationService);
    }

    @Bean
    RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService(RoomOccupancyManagerFacade roomOccupancyManagerFacade) {
        return new RoomOccupancyManagerApplicationService(roomOccupancyManagerFacade);
    }
}
