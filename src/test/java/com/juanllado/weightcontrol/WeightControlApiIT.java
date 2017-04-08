package com.juanllado.weightcontrol;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeightControlApiIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private MeasurementRepository repository;

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
	public void should_save_a_new_measurement() throws Exception {
		this.mockMvc.perform(post("/measurement")
				.content("{\"weight\":70, \"fat_percentage\": 20, \"muscle_weight\": 55, \"comment\": \"regular week\"}")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());

        final Measurement newMeasurement = repository.findAll().get(0);
        assertThat(newMeasurement.getWeight(), is(70f));
        assertThat(newMeasurement.getFatPercentage(), is(20f));
        assertThat(newMeasurement.getMuscleWeight(), is(55f));
        assertThat(newMeasurement.getMusclePercentage(), is(78.57143f));
        assertThat(newMeasurement.getComment(), is("regular week"));
        assertThat(newMeasurement.getDate(), is(LocalDate.now()));
    }

    @Test
	public void should_retrieve_all_measurement() throws Exception {
        final Measurement mesaurement = new Measurement(100f, 25f, 50f, "test week");
        repository.save(mesaurement);

		this.mockMvc.perform(get("/measurement")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("" +
                        "[{\"weight\":100.0,\"fat_percentage\":25.0,\"muscle_weight\":50.0," +
                        "\"muscle_percentage\":50.0,\"comment\":\"test week\"}]"));
    }

}
