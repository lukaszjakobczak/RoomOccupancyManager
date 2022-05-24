package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrdersDto {

    private final double[] orders;

    @JsonCreator
    OrdersDto(@JsonProperty("orders") double[] orders) {
        this.orders = orders;
    }
}
