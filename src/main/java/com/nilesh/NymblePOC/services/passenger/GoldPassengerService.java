package com.nilesh.NymblePOC.services.passenger;

import com.nilesh.NymblePOC.entities.Activity;
import com.nilesh.NymblePOC.entities.Passenger;
import org.springframework.stereotype.Service;

@Service
public class GoldPassengerService implements PassengerService {
    @Override
    public boolean signUpActivity(Passenger passenger, Activity activity) {
        double balance=passenger.getBalance();
        double discountedCost = activity.getCost() * 0.9;
        if (balance >= discountedCost) {
            balance -= discountedCost;
            passenger.setBalance(balance);
            return true;
        }
        return false;
    }
}