package com.nilesh.NymblePOC.repositories;

import com.nilesh.NymblePOC.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationDAO extends JpaRepository<Destination, Long> {

}