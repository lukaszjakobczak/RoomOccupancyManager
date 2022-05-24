package com.lukaszjakobczak.roompccupancymanager.application;

public class OrdersDto {

    private final double[] orders;

    public OrdersDto(double[] orders) {
        this.orders = orders;
    }

    double[] getOrders() {
        return orders;
    }
}
