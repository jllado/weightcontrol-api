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
public class Weight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "peso")
    public float weight;

    @Column(name = "porcentaje_grasa")
    public float fatPercentatge;

    @Column(name = "peso_musculo")
    public float muscleWeight;

    @Column(name = "fecha_medicion")
    public LocalDate date;

    public Weight(final float weight, final float fatPercentatge, final float muscleWeight) {
        this.weight = weight;
        this.fatPercentatge = fatPercentatge;
        this.muscleWeight = muscleWeight;
        this.date = LocalDate.now();
    }

    public static Weight createBy(final WeightDTO weightDTO) {
        return new Weight(weightDTO.getWeight(), weightDTO.getFatPercentatge(), weightDTO.getMuscleWeight());
    }

    public Weight() {
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
}
