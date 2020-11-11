package com.create.demo.services.interfaces;


import com.create.demo.models.SpringModels;

import java.util.List;
import java.util.Optional;


public interface SpringServices {
    List<SpringModels> getAll();

    SpringModels getAModelById(String id);

    SpringModels updateAModelById(String id, SpringModels request);

    SpringModels createAModel(SpringModels request);

    void deleteAModelById(String id);

    List<SpringModels> getAllByStt(int stt);

}
