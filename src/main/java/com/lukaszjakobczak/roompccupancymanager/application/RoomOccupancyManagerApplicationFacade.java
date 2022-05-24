package com.lukaszjakobczak.roompccupancymanager.application;

public class RoomOccupancyManagerApplicationFacade {

    private final RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService;

    public RoomOccupancyManagerApplicationFacade(RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService) {
        this.roomOccupancyManagerApplicationService = roomOccupancyManagerApplicationService;
    }

    public RoomOccupancyDto optimize(OrdersDto ordersDto){
        return roomOccupancyManagerApplicationService.optimize(ordersDto);
    }

}
