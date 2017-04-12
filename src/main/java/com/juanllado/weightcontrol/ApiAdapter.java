package com.juanllado.weightcontrol;

/**
 * Created by jllado on 12/04/17.
 */
public class ApiAdapter {

    public static Measurement createFrom(final MeasurementDTO measurementDTO) {
        return new Measurement(measurementDTO.getWeight(), measurementDTO.getFatPercentage(), measurementDTO.getMuscleWeight(), measurementDTO.getComment());
    }

    public static MeasurementDTO toDTO(final Measurement measurement) {
        final MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setWeight(measurement.getWeight());
        measurementDTO.setFatPercentage(measurement.getFatPercentage());
        measurementDTO.setMuscleWeight(measurement.getMuscleWeight());
        measurementDTO.setMusclePercentage(measurement.getMusclePercentage());
        measurementDTO.setComment(measurement.getComment());
        return measurementDTO;
    }


}
