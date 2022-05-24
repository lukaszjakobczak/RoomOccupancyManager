package com.lukaszjakobczak.roompccupancymanager.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class RoomOccupancyManagerService {

    RoomOccupancy optimize(Orders orders) {
        int freeEconomyRooms = orders.getFreeEconomyRooms();
        int freePremiumRooms = orders.getFreePremiumRooms();
        List<Double> ordersList = DoubleStream.of(orders.getOrders()).boxed().collect(Collectors.toList());

        List<Double> premiumUsers = getPremiumUsers(freePremiumRooms, ordersList);

        List<Double> economyUsers = ordersList.stream()
                .filter(this::isEconomyUser)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if(freePremiumRooms > premiumUsers.size() && economyUsers.size() > freeEconomyRooms) {
            int numberOfLeftPremiumRooms = freePremiumRooms - premiumUsers.size();

            for (int i = 0; i < numberOfLeftPremiumRooms; i++) {
                premiumUsers.add(economyUsers.get(0));
                economyUsers.remove(0);
            }
        }

        economyUsers = economyUsers.stream().limit(freeEconomyRooms).collect(Collectors.toList());

        return new RoomOccupancy(
                premiumUsers.size(),
                calculateTotalPrice(premiumUsers),
                economyUsers.size(),
                calculateTotalPrice(economyUsers)
        );
    }

    private List<Double> getPremiumUsers(int freePremiumRooms, List<Double> ordersList) {
        return ordersList.stream()
                .filter(this::isPremiumUser)
                .sorted(Comparator.reverseOrder())
                .limit(freePremiumRooms)
                .collect(Collectors.toList());
    }

    private Double calculateTotalPrice(List<Double> premiumUsers) {
        return premiumUsers.stream().reduce(0d, Double::sum);
    }


    private boolean isEconomyUser(Double order) {
        return order < 100;
    }

    private boolean isPremiumUser(Double order) {
        return order >= 100;
    }
}
