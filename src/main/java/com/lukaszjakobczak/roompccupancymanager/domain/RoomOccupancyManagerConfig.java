package com.lukaszjakobczak.roompccupancymanager.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomOccupancyManagerConfig {

    @Bean
    RoomOccupancyManagerFacade roomOccupancyManagerFacade(RoomOccupancyManagerService roomOccupancyManagerService) {
        return new RoomOccupancyManagerFacade(roomOccupancyManagerService);
    }

    @Bean
    RoomOccupancyManagerService roomOccupancyManagerService() {
        return new RoomOccupancyManagerService();
    }
}
