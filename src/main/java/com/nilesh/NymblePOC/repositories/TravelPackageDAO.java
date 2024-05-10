package com.nilesh.NymblePOC.repositories;


import com.nilesh.NymblePOC.entities.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageDAO extends JpaRepository<TravelPackage, Long> {

}