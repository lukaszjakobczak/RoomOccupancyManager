package com.lukaszjakobczak.roompccupancymanager.domain;

public class RoomOccupancy {
    private int usagePremium;
    private double pricePremium;
    private int usageEconomy;
    private double priceEconomy;

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
