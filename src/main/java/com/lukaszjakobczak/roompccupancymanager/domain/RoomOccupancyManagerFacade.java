package com.lukaszjakobczak.roompccupancymanager.domain;

public class RoomOccupancyManagerFacade {

    private final RoomOccupancyManagerService roomOccupancyManagerService;

    public RoomOccupancyManagerFacade(RoomOccupancyManagerService roomOccupancyManagerService) {
        this.roomOccupancyManagerService = roomOccupancyManagerService;
    }

    public void optimize(Orders orders) {
        this.roomOccupancyManagerService.optimize(orders);
    }

}
