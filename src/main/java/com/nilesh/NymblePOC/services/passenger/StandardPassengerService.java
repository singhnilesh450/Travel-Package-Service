package com.nilesh.NymblePOC.services.passenger;

import com.nilesh.NymblePOC.entities.Activity;
import com.nilesh.NymblePOC.entities.Passenger;
import org.springframework.stereotype.Service;

@Service
public class StandardPassengerService implements PassengerService {
    @Override
    public boolean signUpActivity(Passenger passenger, Activity activity) {
        double balance=passenger.getBalance();
        if (balance >= activity.getCost()) {
            balance -= activity.getCost();
            passenger.setBalance(balance);
            return true;
        }
        return false;
    }
}