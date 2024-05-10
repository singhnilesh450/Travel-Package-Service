package com.nilesh.NymblePOC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {
    private String name;
    private int passengerCapacity;
    private int NumberOfPassengersEnrolled;
    private List<PassengerInfoDTO> passengerInfoDTOList;
}
