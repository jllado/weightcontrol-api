package com.juanllado.weightcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jllado on 27/03/17.
 */
@Service
public class WeightControl {

    @Autowired
    private MeasurementRepository repository;

    public void save(final MeasurementDTO measurementDTO) {
        repository.save(Measurement.createBy(measurementDTO));
    }
}
