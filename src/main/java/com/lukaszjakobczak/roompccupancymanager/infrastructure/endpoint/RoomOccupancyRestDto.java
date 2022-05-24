package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint;

import com.lukaszjakobczak.roompccupancymanager.application.RoomOccupancyDto;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class RoomOccupancyRestDto {
    private int usagePremium;
    private double pricePremium;
    private int usageEconomy;
    private double priceEconomy;

    static RoomOccupancyRestDto fromDto(RoomOccupancyDto roomOccupancyDto) {
        return new RoomOccupancyRestDto(
                roomOccupancyDto.getUsagePremium(),
                roomOccupancyDto.getPricePremium(),
                roomOccupancyDto.getUsageEconomy(),
                roomOccupancyDto.getPriceEconomy()

        );
    }
}
