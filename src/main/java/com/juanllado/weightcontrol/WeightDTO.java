package com.juanllado.weightcontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jllado on 27/03/17.
 */
public class WeightDTO {

    public float weight;

    @JsonProperty(value = "fat_percentage")
    public float fatPercentatge;

    @JsonProperty(value = "muscle_weight")
    public float muscleWeight;

    public WeightDTO() {
    }

    public WeightDTO(final float weight, final float fatPercentatge, final float muscleWeight) {
        this.weight = weight;
        this.fatPercentatge = fatPercentatge;
        this.muscleWeight = muscleWeight;
    }

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

    @Override
    public String toString() {
        return "WeightDTO{" +
                "weight=" + weight +
                ", fatPercentatge=" + fatPercentatge +
                ", muscleWeight=" + muscleWeight +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final WeightDTO weightDTO = (WeightDTO) o;

        if (Float.compare(weightDTO.weight, weight) != 0) return false;
        if (Float.compare(weightDTO.fatPercentatge, fatPercentatge) != 0) return false;
        return Float.compare(weightDTO.muscleWeight, muscleWeight) == 0;
    }

    @Override
    public int hashCode() {
        int result = (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (fatPercentatge != +0.0f ? Float.floatToIntBits(fatPercentatge) : 0);
        result = 31 * result + (muscleWeight != +0.0f ? Float.floatToIntBits(muscleWeight) : 0);
        return result;
    }

}
