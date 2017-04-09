package com.juanllado.weightcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MeasurementDTO> getAll() {
        final List<Measurement> measurements = repository.findAllByOrderByDateDesc();
        return measurements.stream().map(Measurement::toDTO).collect(Collectors.toList());
    }
}
