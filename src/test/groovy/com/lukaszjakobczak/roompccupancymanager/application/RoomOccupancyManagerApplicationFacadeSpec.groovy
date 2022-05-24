package com.lukaszjakobczak.roompccupancymanager.application

import spock.lang.Specification

class RoomOccupancyManagerApplicationFacadeSpec extends Specification {

    private RoomOccupancyManagerApplicationFacade roomOccupancyManagerApplicationFacade
    private RoomOccupancyManagerApplicationService roomOccupancyManagerApplicationService

    def setup() {
        roomOccupancyManagerApplicationService = Mock()
        roomOccupancyManagerApplicationFacade = new RoomOccupancyManagerApplicationFacade(roomOccupancyManagerApplicationService)
    }

    def "Should call optimize room occupancy"() {
        given: "There is incoming request"
            double[] ordersData = [23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0]
            def ordersDto = new OrdersDto(ordersData, 3, 3)
        when: "Application facade is invoked"
            roomOccupancyManagerApplicationFacade.optimize(ordersDto)
            then: "Optimization should be invoked"
        1 * roomOccupancyManagerApplicationService.optimize(_) >> { args ->
            def orders = args.first() as OrdersDto
            assert orders.orders == ordersData
            assert orders.getFreeEconomyRooms() == 3
            assert orders.getFreePremiumRooms() == 3
        }
    }
}
