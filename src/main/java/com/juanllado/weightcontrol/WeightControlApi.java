package com.juanllado.weightcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jllado on 27/03/17.
 */
@RestController
public class WeightControlApi {

    @Autowired
    private WeightControl weightControl;

    @RequestMapping(value = "/measurement", method = RequestMethod.POST)
    public void newMeasurement(@RequestBody final MeasurementDTO measurementDTO) {
        weightControl.save(measurementDTO);
    }

    @RequestMapping(value = "/measurement", method = RequestMethod.GET)
    public List<MeasurementDTO> getAll() {
        return weightControl.getAll();
    }

}
