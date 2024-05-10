package com.nilesh.NymblePOC.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="passenger")
public class Passenger  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_id;
    @Column(name="name")
    private String name;
    @Column(name="passenger_number")
    private String passengerNumber;
    @Column(name="balance")
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name="passenger_type")
    private PassengerType passengerType;

    @ManyToMany(mappedBy = "passengers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TravelPackage> packages;

}