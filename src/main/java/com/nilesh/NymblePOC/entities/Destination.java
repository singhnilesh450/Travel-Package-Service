package com.nilesh.NymblePOC.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dest_id;
    @Column(name = "name")
    private String name;



    @ManyToMany(mappedBy = "destinations",cascade = CascadeType.ALL)
    private List<TravelPackage>  packages;
    @OneToMany(mappedBy = "destination",cascade = CascadeType.ALL)
    private List<Activity> activities;
}