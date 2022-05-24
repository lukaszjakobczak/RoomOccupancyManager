package com.lukaszjakobczak.roompccupancymanager.application;


public class RoomOccupancyManagerApplicationFacade {

    private final RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService;

    public RoomOccupancyManagerApplicationFacade(RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService) {
        this.roomOccupancyManagerApplicationService = roomOccupancyManagerApplicationService;
    }

    public void optimize(OrdersDto ordersDto){
        roomOccupancyManagerApplicationService.optimize(ordersDto);
    }

}
