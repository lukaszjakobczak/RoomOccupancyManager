package com.lukaszjakobczak.roompccupancymanager.domain;

import lombok.Getter;

@Getter
public class Orders {

    private double[] orders;

    public Orders(double[] orders) {
        this.orders = orders;
    }


}
