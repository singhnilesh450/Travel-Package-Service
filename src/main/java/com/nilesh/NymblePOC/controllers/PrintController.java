package com.nilesh.NymblePOC.controllers;

import com.nilesh.NymblePOC.dto.PackageDTO;
import com.nilesh.NymblePOC.dto.PassengerDetailsDTO;
import com.nilesh.NymblePOC.dto.PassengerInfoDTO;
import com.nilesh.NymblePOC.dto.TravelPackageItineraryDTO;
import com.nilesh.NymblePOC.services.print.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrintController {


    private final PrintService printService;
    @Autowired
    public PrintController(PrintService printService) {
        this.printService = printService;
    }


    @GetMapping("/itinerary/{travelPackageId}")
    public ResponseEntity<TravelPackageItineraryDTO> printIternary(@PathVariable Long travelPackageId){
        TravelPackageItineraryDTO response= printService.getInternaryinTravelPackage(travelPackageId);

        if(response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/passenger-list/{travelPackageId}")
    public ResponseEntity<PackageDTO> printPassenger(@PathVariable Long travelPackageId){
        PackageDTO response= printService.getInfoiFromTravelPackage(travelPackageId);

        if(response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<PassengerDetailsDTO> printPassengerInfo(@PathVariable Long passengerId){
        PassengerDetailsDTO response= printService.getPassengerInfoiFromTravelPackage(passengerId);

        if(response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
