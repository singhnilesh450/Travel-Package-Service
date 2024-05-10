package com.nilesh.NymblePOC.services.signup;

import com.nilesh.NymblePOC.repositories.PassengerDAO;
import com.nilesh.NymblePOC.entities.Activity;
import com.nilesh.NymblePOC.entities.Passenger;
import com.nilesh.NymblePOC.entities.PassengerType;
import com.nilesh.NymblePOC.services.passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupService {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private PassengerDAO passengerDAO;

    public void signUpActivity(Long passengerId, Activity activity) {
        Optional<Passenger> passengerOptional = passengerDAO.findById(passengerId);
        passengerOptional.ifPresent(passenger -> {
            PassengerService passengerService = getPassengerService(passenger.getPassengerType());
            if (passengerService != null) {
                passengerService.signUpActivity(passenger, activity);
                passengerDAO.save(passenger);
            } else {

            }
        });
        if (!passengerOptional.isPresent()) {

        }
    }

    private PassengerService getPassengerService(PassengerType passengerType) {
        try {

            return applicationContext.getBean(passengerType.getServiceBeanName(), PassengerService.class);
        } catch (Exception e) {
            return null;
        }
    }
}
