package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrdersRestDto {

    private final double[] orders;
    private final int freeEconomyRooms;
    private final int freePremiumRooms;

    @JsonCreator
    OrdersRestDto(
            @JsonProperty("orders") double[] orders,
            @JsonProperty("freeEconomyRooms") int freeEconomyRooms,
            @JsonProperty("freePremiumRooms") int freePremiumRooms
    ) {
        this.orders = orders;
        this.freeEconomyRooms = freeEconomyRooms;
        this.freePremiumRooms = freePremiumRooms;
    }
}
