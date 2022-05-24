package com.lukaszjakobczak.roompccupancymanager.domain;

public class RoomOccupancy {
    private int usagePremium;
    private double pricePremium;
    private int usageEconomy;
    private double priceEconomy;

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
