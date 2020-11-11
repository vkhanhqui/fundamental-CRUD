package com.create.demo.ServiceTest;


import com.create.demo.models.SpringModels;
import com.create.demo.models.SpringRepositories;
import com.create.demo.services.implement.SpringImplements;
import com.create.demo.services.interfaces.SpringServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class TodoServiceTest2 {

    @MockBean
    SpringRepositories springRepositories;
    @Autowired
    private SpringServices springServices;

    @Test
    public void testGetAllModels() {
        List<SpringModels> sample = new ArrayList<>(Arrays.asList(
                new SpringModels("1", 1),
                new SpringModels("2", 2),
                new SpringModels("3", 3)
        ));

        when(springRepositories.findAll())
                .thenReturn(sample);

        Assert.assertEquals(3, springServices.getAll().size());
    }

    @Test
    public void testGetAModelById() {
        SpringModels response = new SpringModels("1", 1);

        when(springRepositories.findById("1"))
                .thenReturn(java.util.Optional.of(response));

        Assert.assertEquals(1
                , springServices.getAModelById("1").getStt());
    }

    @Test
    public void updateAModelById() {
        SpringModels response = new SpringModels("1", 1);

        when(springRepositories.findById("1"))
                .thenReturn(java.util.Optional.of(response));

        response.setStt(4);
        when(springRepositories.save(response))
                .thenReturn(response);

        Assert.assertEquals(4,
                springServices.updateAModelById("1", response).getStt());
    }

    @Test
    public void deleteAModelById() {
        SpringModels response = new SpringModels("1", 1);

        when(springRepositories.findById("1"))
                .thenReturn(java.util.Optional.of(response));

        springServices.deleteAModelById("1");
        verify(springRepositories, times(1)).deleteById("1");
    }

    @TestConfiguration
    public static class TodoServiceTest2Configuration {
        @Bean
        SpringImplements springImplements() {
            return new SpringImplements();
        }


    }
}