package com.example.demo.racingfactory;

import com.example.demo.racingfactory.impl.BikeRacing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacingRepository extends JpaRepository<BikeRacing, Long> {


}
