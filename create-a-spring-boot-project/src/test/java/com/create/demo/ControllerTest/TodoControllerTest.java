package com.create.demo.ControllerTest;


import com.create.demo.TestUtil;
import com.create.demo.controllers.SpringControllers;
import com.create.demo.models.SpringModels;
import com.create.demo.services.interfaces.SpringServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SpringControllers.class)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SpringServices springServices;

    @Test
    public void testGetAll() throws Exception {
        List<SpringModels> sample = new ArrayList<>(Arrays.asList(
                new SpringModels("1", 1),
                new SpringModels("2", 2),
                new SpringModels("3", 3)
        ));

        given(springServices.getAll()).willReturn(sample);

        mockMvc.perform(get("/spring")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].stt", is(1)));
    }

    @Test
    public void testGetAModelbyId() throws Exception {
        List<SpringModels> sample = new ArrayList<>(Arrays.asList(
                new SpringModels("1", 1),
                new SpringModels("2", 2),
                new SpringModels("3", 3)
        ));

        given(springServices.getAModelById("2")).willReturn(sample.get(1));

        mockMvc.perform(get("/spring/{id}", "2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("2")))
                .andExpect(jsonPath("$.stt", is(2)));
    }

    @Test
    public void testUpdateAModelById() throws Exception {
        SpringModels response = new SpringModels("2", 4);

        given(springServices.updateAModelById("2", response))
                .willReturn(response);

        mockMvc.perform(put("/spring/2")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtil.convertObjectToJsonBytes(response)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("2")))
                .andExpect(jsonPath("$.stt", is(4)));
    }


}
