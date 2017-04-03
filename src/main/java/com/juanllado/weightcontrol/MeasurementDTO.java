package com.juanllado.weightcontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jllado on 27/03/17.
 */
public class MeasurementDTO {

    private float weight;

    @JsonProperty(value = "fat_percentage")
    public float fatPercentatge;

    @JsonProperty(value = "muscle_weight")
    public float muscleWeight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(final float weight) {
        this.weight = weight;
    }

    public float getFatPercentatge() {
        return fatPercentatge;
    }

    public void setFatPercentatge(final float fatPercentatge) {
        this.fatPercentatge = fatPercentatge;
    }

    public float getMuscleWeight() {
        return muscleWeight;
    }

    public void setMuscleWeight(final float muscleWeight) {
        this.muscleWeight = muscleWeight;
    }
}
