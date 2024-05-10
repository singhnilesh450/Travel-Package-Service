package com.nilesh.NymblePOC.repositories;

import com.nilesh.NymblePOC.entities.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDAO extends JpaRepository<Activity, Long> {

}