package com.nilesh.NymblePOC.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerBaseDTO {
    private String name;
    private String passengerNumber;
}
