package com.nitesh.meteranalytics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.meteranalytics.models.Meter;

public interface MeterReadingRepository extends JpaRepository<Meter, Long>{

}
