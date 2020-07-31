package com.create.demo.ServiceTest;

import com.create.demo.models.SpringModels;
import com.create.demo.models.SpringRepositories;
import com.create.demo.services.interfaces.SpringServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest1 {
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

        Mockito.when(springRepositories.findAll())
                .thenReturn(sample);

        Assert.assertEquals(3, springServices.getAll().size());
    }

}
