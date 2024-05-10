package com.nilesh.NymblePOC;

import com.nilesh.NymblePOC.repositories.TravelPackageDAO;
import com.nilesh.NymblePOC.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NymblePocApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NymblePocApplication.class, args);
	}
	@Autowired
 	TravelPackageDAO travelPackageDAO;
	@Override
	public void run(String... args){
		TravelPackage travelPackage1=new TravelPackage();
		travelPackage1.setName("pack1");
		travelPackage1.setPassengerCapacity(23);
		TravelPackage travelPackage2=new TravelPackage();
		travelPackage2.setName("pack2");
		travelPackage2.setPassengerCapacity(33);

		Destination destination1=new Destination();
		destination1.setName("maldives");
		Destination destination2=new Destination();
		destination2.setName("lakshdweep");
		Destination destination3=new Destination();
		destination3.setName("goa");





		Activity activity1=new Activity();
		activity1.setName("act1");
		activity1.setCost(43);
		activity1.setCapacity(5);
		activity1.setDestination(destination1);
		activity1.setDescription("fdfs");
		Activity activity2=new Activity();
		activity2.setName("act2");
		activity2.setCost(32);
		activity2.setCapacity(7);
		activity2.setDestination(destination2);
		activity2.setDescription("fdvfddfs");
		Activity activity3=new Activity();
		activity3.setName("act3");
		activity3.setCost(15);
		activity3.setCapacity(5);
		activity3.setDestination(destination2);
		activity3.setDescription("fgdagfadgghytg");

		List<Activity> activityListForDestination1=new ArrayList<>();
		List<Activity> activityListForDestination2=new ArrayList<>();


		activityListForDestination1.add(activity1);
		activityListForDestination2.add(activity2);
		activityListForDestination2.add(activity3);
		destination1.setActivities(activityListForDestination1);
		destination2.setActivities(activityListForDestination2);

		Passenger passenger1=new Passenger();
		passenger1.setBalance(15);
		passenger1.setPassengerType(PassengerType.GOLD);
		passenger1.setName("Pass1");
		passenger1.setPassengerNumber("22");
		activity1.setPassenger(passenger1);
		activity2.setPassenger(passenger1);
		activity3.setPassenger(passenger1);
		Passenger passenger2=new Passenger();
		passenger2.setBalance(22);
		passenger2.setPassengerType(PassengerType.GOLD);
		passenger2.setName("Pass2");
		passenger2.setPassengerNumber("232");
		Passenger passenger3=new Passenger();
		passenger3.setBalance(222);
		passenger3.setPassengerType(PassengerType.PREMIUM);
		passenger3.setName("Pass3");
		passenger3.setPassengerNumber("233332");
		List<Destination> destinationList=new ArrayList<>();
		destinationList.add(destination2);
		destinationList.add(destination1);
		List<Passenger> passengerList=new ArrayList<>();
		passengerList.add(passenger3);
		passengerList.add(passenger1);

		travelPackage1.setDestinations(destinationList);
		travelPackage1.setPassengers(passengerList);
		travelPackageDAO.save(travelPackage1);
	}

}
