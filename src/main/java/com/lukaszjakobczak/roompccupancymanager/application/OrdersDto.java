package com.lukaszjakobczak.roompccupancymanager.application;

public class OrdersDto {

    private final double[] orders;
    private final int freeEconomyRooms;
    private final int freePremiumRooms;

    public OrdersDto(double[] orders, int freeEconomyRooms, int freePremiumRooms) {
        this.orders = orders;
        this.freeEconomyRooms = freeEconomyRooms;
        this.freePremiumRooms = freePremiumRooms;
    }

    double[] getOrders() {
        return orders;
    }

    int getFreeEconomyRooms() {
        return freeEconomyRooms;
    }

    int getFreePremiumRooms() {
        return freePremiumRooms;
    }
}
