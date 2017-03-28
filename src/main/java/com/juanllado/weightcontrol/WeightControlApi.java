package com.juanllado.weightcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jllado on 27/03/17.
 */
@RestController
public class WeightControlApi {

    @Autowired
    private WeightControl weightControl;

    @RequestMapping(value = "/weight", method = RequestMethod.POST)
    public void newWeight(@RequestBody final WeightDTO weightDTO) {
        weightControl.save(weightDTO);
    }

}
