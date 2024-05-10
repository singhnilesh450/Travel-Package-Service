package com.nilesh.NymblePOC.entities;

public enum PassengerType {
    STANDARD("standardPassengerService"),
    GOLD("goldPassengerService"),
    PREMIUM("premiumPassengerService");

    private final String serviceBeanName;

    PassengerType(String serviceBeanName) {
        this.serviceBeanName = serviceBeanName;
    }

    public String getServiceBeanName() {
        return serviceBeanName;
    }
}