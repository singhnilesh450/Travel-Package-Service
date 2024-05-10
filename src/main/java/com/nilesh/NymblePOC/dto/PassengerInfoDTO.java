package com.nilesh.NymblePOC.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassengerInfoDTO extends  PassengerBaseDTO{

    @Builder(builderMethodName = "passengerInfoDTO")
    public PassengerInfoDTO(String name, String passengerNumber) {
        super(name, passengerNumber);
    }
}
