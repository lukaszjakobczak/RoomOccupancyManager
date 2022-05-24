package com.lukaszjakobczak.roompccupancymanager.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class RoomOccupancyManagerService {

    RoomOccupancy optimize(Orders orders) {
        int freeEconomyRooms = orders.getFreeEconomyRooms();
        int freePremiumRooms = orders.getFreePremiumRooms();
        List<Double> ordersList = DoubleStream.of(orders.getOrders()).boxed().collect(Collectors.toList());

        List<Double> premiumUsers =
                ordersList.stream()
                .filter(this::isPremiumUser)
                .sorted(Comparator.reverseOrder())
                .limit(freePremiumRooms)
                .collect(Collectors.toList());

        List<Double> economyUsers =
                ordersList.stream()
                        .filter(this::isEconomyUser)
                        .sorted(Comparator.reverseOrder())
                        .limit(freeEconomyRooms)
                        .collect(Collectors.toList());

        return new RoomOccupancy(
                premiumUsers.size(),
                premiumUsers.stream().reduce(0d, Double::sum),
                economyUsers.size(),
                economyUsers.stream().reduce(0d, Double::sum)
        );
    }

    private boolean isEconomyUser(Double order) {
        return order < 100;
    }

    private boolean isPremiumUser(Double order) {
        return order >= 100;
    }
}
