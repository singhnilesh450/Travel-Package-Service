package com.nilesh.NymblePOC.dto;

import com.nilesh.NymblePOC.entities.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ActivityDTO {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private String destination;
    private String pricePaidByPassenger;
}