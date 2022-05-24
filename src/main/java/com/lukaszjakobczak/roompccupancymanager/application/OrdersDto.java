package com.lukaszjakobczak.roompccupancymanager.application;

import lombok.Getter;

@Getter
public class OrdersDto {

    private final double[] orders;

    public OrdersDto(double[] orders) {
        this.orders = orders;
    }

}
