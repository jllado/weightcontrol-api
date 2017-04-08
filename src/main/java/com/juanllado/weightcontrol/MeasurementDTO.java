package com.juanllado.weightcontrol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by jllado on 27/03/17.
 */
@JsonPropertyOrder({"weight", "fat_percentage", "muscle_weight", "muscle_percentage", "comment"})
public class MeasurementDTO {

    private float weight;

    @JsonProperty(value = "fat_percentage")
    private float fatPercentage;

    @JsonProperty(value = "muscle_weight")
    private float muscleWeight;

    private String comment;

    @JsonProperty(value = "muscle_percentage")
    private float musclePercentage;

    public float getWeight() {
        return weight;
    }

    public void setWeight(final float weight) {
        this.weight = weight;
    }

    public float getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(final float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public float getMuscleWeight() {
        return muscleWeight;
    }

    public void setMuscleWeight(final float muscleWeight) {
        this.muscleWeight = muscleWeight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public void setMusclePercentage(final float musclePercentage) {
        this.musclePercentage = musclePercentage;
    }

    public float getMusclePercentage() {
        return musclePercentage;
    }
}
