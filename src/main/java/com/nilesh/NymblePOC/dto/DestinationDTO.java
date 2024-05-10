package com.nilesh.NymblePOC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class DestinationDTO {
    private String name;
    private List<ActivityDTO> activities;
}
