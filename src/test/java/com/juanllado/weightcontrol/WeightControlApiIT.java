package com.juanllado.weightcontrol;

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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeightControlApiIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private WeightRepository repository;

    @Test
	public void should_save_a_new_weight() throws Exception {
		this.mockMvc.perform(post("/weight")
				.content("{\"weight\":70, \"fat_percentage\": 20, \"muscle_weight\": 55}")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());

        final Weight newWeight = repository.findAll().get(0);
        assertThat(newWeight.getWeight(), is(70f));
        assertThat(newWeight.getFatPercentatge(), is(20f));
        assertThat(newWeight.getMuscleWeight(), is(55f));
        assertThat(newWeight.getDate(), is(LocalDate.now()));
    }

}
