package com.lukaszjakobczak.roompccupancymanager.domain;

public class RoomOccupancy {
    private final int usagePremium;
    private final double pricePremium;
    private final int usageEconomy;
    private final double priceEconomy;

    public RoomOccupancy(int usagePremium, double pricePremium, int usageEconomy, double priceEconomy) {
        this.usagePremium = usagePremium;
        this.pricePremium = pricePremium;
        this.usageEconomy = usageEconomy;
        this.priceEconomy = priceEconomy;
    }

    public int getUsagePremium() {
        return usagePremium;
    }

    public double getPricePremium() {
        return pricePremium;
    }

    public int getUsageEconomy() {
        return usageEconomy;
    }

    public double getPriceEconomy() {
        return priceEconomy;
    }
}
