package com.lukaszjakobczak.roompccupancymanager.domain

import spock.lang.Specification

class RoomOccupancyManagerFacadeSpec extends Specification {

    private RoomOccupancyManagerFacade roomOccupancyManagerFacade
    private RoomOccupancyManagerService roomOccupancyManagerService

    def setup() {
        roomOccupancyManagerService = Mock()
        roomOccupancyManagerFacade = new RoomOccupancyManagerFacade(roomOccupancyManagerService)
    }

    def "Should call optimize room occupancy"() {
        given: "There is incoming request"
        double[] ordersData = [23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0]
        def orders = new Orders(ordersData)
        when: "Application facade is invoked"
        roomOccupancyManagerFacade.optimize(orders)
        then: "Optimization should be invoked"
        1 * roomOccupancyManagerService.optimize(_) >> { args ->
            def ordersValue = args.first() as Orders
            assert ordersValue.orders == ordersData
        }
    }
}
