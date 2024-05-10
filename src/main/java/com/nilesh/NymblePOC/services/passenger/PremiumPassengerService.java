package com.nilesh.NymblePOC.services.passenger;

import com.nilesh.NymblePOC.entities.Activity;
import com.nilesh.NymblePOC.entities.Passenger;
import org.springframework.stereotype.Service;

@Service
public class PremiumPassengerService implements PassengerService {
    @Override
    public boolean signUpActivity(Passenger passenger, Activity activity) {
       return true;
    }
}