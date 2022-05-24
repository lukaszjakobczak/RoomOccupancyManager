package com.lukaszjakobczak.roompccupancymanager.domain;

import lombok.Getter;


@Getter
public class Orders {

    private final double[] orders;
    private final int freeEconomyRooms;
    private final int freePremiumRooms;

    public Orders(double[] orders, int freeEconomyRooms, int freePremiumRooms) {
        this.orders = orders;
        this.freeEconomyRooms = freeEconomyRooms;
        this.freePremiumRooms = freePremiumRooms;
    }
}
