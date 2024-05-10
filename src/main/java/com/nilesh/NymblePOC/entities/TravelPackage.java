package com.nilesh.NymblePOC.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_package")
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long package_id;
    @Column(name = "name")
    private String name;
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Destination> destinations;//use set

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers;
}
