package com.juanllado.weightcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jllado on 27/03/17.
 */
@Service
public class WeightControl {

    private final MeasurementRepository repository;

    @Autowired
    public WeightControl(final MeasurementRepository repository) {
        this.repository = repository;
    }

    public void save(final Measurement measurement) {
        repository.save(measurement);
    }

    public List<Measurement> getAll() {
        return repository.findAllByOrderByDateDesc();
    }
}
