package com.juanllado.weightcontrol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by jllado on 27/03/17.
 */
@Entity
@Table(name = "medicion_peso")
public class Measurement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "peso")
    private float weight;

    @Column(name = "porcentaje_grasa")
    private float fatPercentatge;

    @Column(name = "peso_musculo")
    private float muscleWeight;

    @Column(name = "fecha_medicion")
    private LocalDate date;

    @Column(name = "porcentaje_musculo")
    private float musclePercentatge;

    public Measurement(final float weight, final float fatPercentatge, final float muscleWeight) {
        this.weight = weight;
        this.fatPercentatge = fatPercentatge;
        this.muscleWeight = muscleWeight;
        this.musclePercentatge = calculateMusclePercentatge(weight, muscleWeight);
        this.date = LocalDate.now();
    }

    private float calculateMusclePercentatge(final float weight, final float muscleWeight) {
        return muscleWeight * 100f / weight;
    }

    public Measurement() {
        //JPA
    }

    public static Measurement createBy(final MeasurementDTO measurementDTO) {
        return new Measurement(measurementDTO.getWeight(), measurementDTO.getFatPercentatge(), measurementDTO.getMuscleWeight());
    }

    public Long getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public float getFatPercentatge() {
        return fatPercentatge;
    }

    public float getMuscleWeight() {
        return muscleWeight;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getMusclePercentatge() {
        return musclePercentatge;
    }

    public void setMusclePercentatge(final float musclePercentatge) {
        this.musclePercentatge = musclePercentatge;
    }
}
