package com.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.driver.model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

    @Query("SELECT d FROM Driver d WHERE d.id = (SELECT MIN(d2.id) FROM Driver d2)")
    Driver findDriverWithLowestId();

}
