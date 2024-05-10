package com.nilesh.NymblePOC.services.print;

import com.nilesh.NymblePOC.dto.*;
import com.nilesh.NymblePOC.entities.*;
import com.nilesh.NymblePOC.repositories.PassengerDAO;
import com.nilesh.NymblePOC.repositories.TravelPackageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrintService {
    @Autowired
    TravelPackageDAO travelPackageDAO;
    @Autowired
    PassengerDAO passengerDAO;

    public TravelPackageItineraryDTO getInternaryinTravelPackage(Long travelPackageId) {

        TravelPackage travelPackage = travelPackageDAO.findById(travelPackageId).orElseThrow(() -> new RuntimeException("Travel package not found"));
        List<DestinationDTO> destinationDTOs = travelPackage.getDestinations().stream().map(destination -> convertToDestinationDTO(destination)).collect(Collectors.toList());
        return new TravelPackageItineraryDTO(travelPackage.getName(), destinationDTOs);
    }

    private DestinationDTO convertToDestinationDTO(Destination destination) {

        List<ActivityDTO> activityDTOs = destination.getActivities().stream().map(activity -> convertToActivityDTO((activity))).collect(Collectors.toList());
        return new DestinationDTO(destination.getName(), activityDTOs);

    }

    private ActivityDTO convertToActivityDTO(Activity activity) {
        //return new ActivityDTO(activity.getName(), activity.getDescription(), activity.getCost(), activity.getCapacity());
        return ActivityDTO.builder()
                .name(activity.getName())
                .description(activity.getDescription())
                .cost(activity.getCost())
                .capacity(activity.getCapacity())
                .build();
    }

    public PackageDTO getInfoiFromTravelPackage(Long travelPackageId) {

        TravelPackage travelPackage = travelPackageDAO.findById(travelPackageId).orElseThrow(() -> new RuntimeException("Travel package not found"));
        List<PassengerInfoDTO> passengerInfoDTOS = travelPackage.getPassengers().stream().map(passenger -> convertToPassengerInfoDTO(passenger)).collect(Collectors.toList());
        return new PackageDTO(travelPackage.getName(),travelPackage.getPassengerCapacity(),travelPackage.getPassengers().size(),passengerInfoDTOS);
    }

    private PassengerInfoDTO convertToPassengerInfoDTO(Passenger passenger) {
        //return new PassengerInfoDTO(passenger.getName(), passenger.getPassengerNumber());
        return PassengerInfoDTO.passengerInfoDTO()
                .name(passenger.getName())
                .passengerNumber(passenger.getPassengerNumber())
                .build();
    }

    public PassengerDetailsDTO getPassengerInfoiFromTravelPackage(Long passengerId) {

        Passenger passenger = passengerDAO.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));


        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        PassengerType passengerType=passenger.getPassengerType();

        if (passenger.getBalance() > 0) {
            System.out.println("Balance: " + passenger.getBalance());
        }


        System.out.println("Signed-up Activities:");
        List<ActivityDTO> activityDTOList=new ArrayList<>();
        for (TravelPackage travelPackage : passenger.getPackages()) {
            System.out.println("Travel Package: " + travelPackage.getName());
            System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());


            for (Destination destination : travelPackage.getDestinations()) {

                for (Activity activity : destination.getActivities())
                    if (activity.getPassenger().equals(passenger)) {
                        System.out.println("- Activity Name: " + activity.getName());
                        System.out.println("  Destination: " + activity.getDestination().getName());
                        System.out.println("  Price: " + activity.getCost());
                        double pricePaidByPassenger=0;
                        if(passengerType.equals(PassengerType.STANDARD)){
                            pricePaidByPassenger=activity.getCost();
                        }else if(passengerType.equals(PassengerType.GOLD)){
                            pricePaidByPassenger= activity.getCost() - activity.getCost()*0.1;
                        }
                        ActivityDTO activityDTO= ActivityDTO.builder()
                                .name(activity.getName())
                                .cost(activity.getCost())
                                .description(activity.getDescription())
                                .capacity(activity.getCapacity())
                                .destination(destination.getName())
                                .pricePaidByPassenger(pricePaidByPassenger+"")
                                .build();

                        activityDTOList.add(activityDTO);
                    }
            }
        }

            return PassengerDetailsDTO.passengerDetailsDTO()
                    .name(passenger.getName())
                    .passengerNumber(passenger.getPassengerNumber())
                    .activities(activityDTOList)
                    .build();



    }
}
