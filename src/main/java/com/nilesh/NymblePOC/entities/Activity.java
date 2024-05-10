package com.nilesh.NymblePOC.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="cost")
    private double cost;
    @Column(name="capacity")
    private int capacity;

    @ManyToOne(cascade = CascadeType.ALL)
    private Destination destination;

    @ManyToOne
    private Passenger passenger;
}