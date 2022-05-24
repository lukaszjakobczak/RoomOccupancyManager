package com.lukaszjakobczak.roompccupancymanager.domain

import spock.lang.Specification
import spock.lang.Unroll

class RoomOccupancyManagerServiceSpec extends Specification {

    private RoomOccupancyManagerService roomOccupancyManagerService

    def setup() {
        roomOccupancyManagerService = new RoomOccupancyManagerService()
    }

    @Unroll
    def "Should return correct optimization for incoming orders"() {
        when: "Optimization algorithm is invoked"
            def result = roomOccupancyManagerService.optimize(orders)
        then: "Correct optimization is returned"
            result.getUsageEconomy() == usageEconomy
            result.getPriceEconomy() == priceEconomy
            result.getUsagePremium() == usagePremium
            result.getPricePremium() == pricePremium
        where:
            orders             | usageEconomy | priceEconomy | usagePremium | pricePremium
            createOrders(3, 3) | 3            | 167.99d       | 3            | 738
    }

    private Orders createOrders(int freeEconomyRooms, int freePremiumRooms) {
        double[] orders = [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
        new Orders(orders, freeEconomyRooms, freePremiumRooms)
    }
}
