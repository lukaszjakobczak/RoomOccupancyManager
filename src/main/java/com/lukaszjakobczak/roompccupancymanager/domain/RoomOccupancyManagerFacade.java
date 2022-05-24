package com.lukaszjakobczak.roompccupancymanager.domain;

public class RoomOccupancyManagerFacade {

    private final RoomOccupancyManagerService roomOccupancyManagerService;

    public RoomOccupancyManagerFacade(RoomOccupancyManagerService roomOccupancyManagerService) {
        this.roomOccupancyManagerService = roomOccupancyManagerService;
    }

    public RoomOccupancy optimize(Orders orders) {
       return this.roomOccupancyManagerService.optimize(orders);
    }

}
