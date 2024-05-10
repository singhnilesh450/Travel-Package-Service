package com.nilesh.NymblePOC.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class PassengerDetailsDTO extends PassengerBaseDTO{
    private double balance;
    private List<ActivityDTO> activities;

    @Builder(builderMethodName = "passengerDetailsDTO")
    public PassengerDetailsDTO(String name, String passengerNumber, double balance,
                               List<ActivityDTO> activities) {
        super(name, passengerNumber);
        this.balance=balance;
        this.activities = activities;
    }
}
