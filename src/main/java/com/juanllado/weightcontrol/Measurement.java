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
    private float fatPercentage;

    @Column(name = "peso_musculo")
    private float muscleWeight;

    @Column(name = "fecha_medicion")
    private LocalDate date = LocalDate.now();

    @Column(name = "porcentaje_musculo")
    private float musclePercentage;

    @Column(name = "comentario_medicion")
    private String comment;

    public Measurement(final float weight, final float fatPercentage, final float muscleWeight, final String comment) {
        this.weight = weight;
        this.fatPercentage = fatPercentage;
        this.muscleWeight = muscleWeight;
        this.musclePercentage = calculateMusclePercentatge(weight, muscleWeight);
        this.comment = comment;
    }

    public Measurement(final float weight, final float fatPercentage, final float muscleWeight, final String comment, final LocalDate date) {
        this(weight, fatPercentage, muscleWeight, comment);
        this.date = date;
    }

    public Measurement() {
        //JPA
    }

    private float calculateMusclePercentatge(final float weight, final float muscleWeight) {
        return muscleWeight * 100f / weight;
    }

    public static Measurement createBy(final MeasurementDTO measurementDTO) {
        return new Measurement(measurementDTO.getWeight(), measurementDTO.getFatPercentage(), measurementDTO.getMuscleWeight(), measurementDTO.getComment());
    }

    public Long getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public float getFatPercentage() {
        return fatPercentage;
    }

    public float getMuscleWeight() {
        return muscleWeight;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getMusclePercentage() {
        return musclePercentage;
    }

    public String getComment() {
        return comment;
    }

    public MeasurementDTO toDTO() {
        final MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setWeight(weight);
        measurementDTO.setFatPercentage(fatPercentage);
        measurementDTO.setMuscleWeight(muscleWeight);
        measurementDTO.setMusclePercentage(musclePercentage);
        measurementDTO.setComment(comment);
        return measurementDTO;
    }
}
