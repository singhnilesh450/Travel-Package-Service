package com.nilesh.NymblePOC.repositories;

import com.nilesh.NymblePOC.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger, Long> {
//    @Query("SELECT DISTINCT p FROM Passenger p " +
//            "LEFT JOIN FETCH p.packages tp " +
//            "LEFT JOIN FETCH tp.destinations d " +
//            "LEFT JOIN FETCH d.activities a " +
//            "WHERE p.passenger_id = :passengerId")
//    Optional<Passenger> findPassengerWithActivities(Long passengerId);
}