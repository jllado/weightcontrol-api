package com.juanllado.weightcontrol;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jllado on 8/04/17.
 */
public class MeasurementTest {

    private float any = 0f;

    @Test
    public void create_should_calculate_muscle_percentatge() throws Exception {
        final Measurement measurement = new Measurement(100f, any, 75f);

        assertThat(measurement.getMusclePercentatge(), is(75f));
    }
}