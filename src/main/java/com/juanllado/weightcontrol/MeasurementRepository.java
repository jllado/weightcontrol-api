package com.juanllado.weightcontrol;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jllado on 27/03/17.
 */
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    public List<Measurement> findAllByOrderByDateDesc();
}
