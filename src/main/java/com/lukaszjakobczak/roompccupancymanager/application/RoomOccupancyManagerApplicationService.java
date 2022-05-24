package com.lukaszjakobczak.roompccupancymanager.application;

import com.lukaszjakobczak.roompccupancymanager.domain.Orders;
import com.lukaszjakobczak.roompccupancymanager.domain.RoomOccupancyManagerFacade;

class RoomOccupancyManagerApplicationService {

    private final RoomOccupancyManagerFacade roomOccupancyManagerFacade;

    RoomOccupancyManagerApplicationService(RoomOccupancyManagerFacade roomOccupancyManagerFacade) {
        this.roomOccupancyManagerFacade = roomOccupancyManagerFacade;
    }

    void optimize(OrdersDto ordersDto) {
        roomOccupancyManagerFacade.optimize(mapToDomainObject(ordersDto));
    }

    private Orders mapToDomainObject(OrdersDto ordersDto) {
        return new Orders(ordersDto.getOrders());
    }

}
