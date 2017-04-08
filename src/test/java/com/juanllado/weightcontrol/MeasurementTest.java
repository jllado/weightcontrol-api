package com.juanllado.weightcontrol;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jllado on 8/04/17.
 */
public class MeasurementTest {

    private float anyNumber = 0f;
    private String anyComment = "";

    @Test
    public void create_should_calculate_muscle_percentatge() throws Exception {
        final Measurement measurement = new Measurement(100f, anyNumber, 75f, anyComment);

        assertThat(measurement.getMusclePercentage(), is(75f));
    }
}