package com.lukaszjakobczak.roompccupancymanager.application;

import com.lukaszjakobczak.roompccupancymanager.domain.Orders;
import com.lukaszjakobczak.roompccupancymanager.domain.RoomOccupancy;
import com.lukaszjakobczak.roompccupancymanager.domain.RoomOccupancyManagerFacade;

class RoomOccupancyManagerApplicationService {

    private final RoomOccupancyManagerFacade roomOccupancyManagerFacade;

    RoomOccupancyManagerApplicationService(RoomOccupancyManagerFacade roomOccupancyManagerFacade) {
        this.roomOccupancyManagerFacade = roomOccupancyManagerFacade;
    }

    RoomOccupancyDto optimize(OrdersDto ordersDto) {
        return mapToRoomOccupancyDto(roomOccupancyManagerFacade.optimize(mapToDomainObject(ordersDto)));
    }

    private Orders mapToDomainObject(OrdersDto ordersDto) {
        return new Orders(ordersDto.getOrders(), ordersDto.getFreeEconomyRooms(), ordersDto.getFreePremiumRooms());
    }

    private RoomOccupancyDto mapToRoomOccupancyDto(RoomOccupancy roomOccupancy) {
        return new RoomOccupancyDto(
                roomOccupancy.getUsagePremium(),
                roomOccupancy.getPricePremium(),
                roomOccupancy.getUsageEconomy(),
                roomOccupancy.getPriceEconomy()
        );
    }

}
