package com.nilesh.NymblePOC.services.passenger;

import com.nilesh.NymblePOC.entities.Activity;
import com.nilesh.NymblePOC.entities.Passenger;

public interface PassengerService {
    boolean signUpActivity(Passenger passenger, Activity activity);
}