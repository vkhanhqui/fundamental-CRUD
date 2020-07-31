package com.create.demo.services.implement;


import com.create.demo.exceptions.*;
import com.create.demo.models.SpringModels;
import com.create.demo.models.SpringRepositories;
import com.create.demo.services.interfaces.SpringServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class SpringImplements implements SpringServices {
    @Autowired
    private SpringRepositories springRepositories;

    @Override
    public List<SpringModels> getAll() {
        if (springRepositories.findAll().isEmpty())
            throw new isAnEmptyList();
        try {
            return new ArrayList<>(springRepositories.findAll());
        } catch (FailedGetting ex) {
            throw new FailedGetting();
        }
    }

    @Override
    public SpringModels getAModelById(String id) {
        if (id.isEmpty())
            throw new isANullRequest();
        else {
            if (springRepositories.findById(id).isPresent()) {
                try {
                    return springRepositories.findById(id).get();
                } catch (FailedGetting ex) {
                    throw new FailedGetting();
                }
            } else
                throw new CouldNotFind();
        }
    }

    @Override
    public SpringModels updateAModelById(String id, SpringModels request) {
        if (springRepositories.findById(id).isPresent()) {
            if (request.getId() == null)
                throw new isANullRequest();
            SpringModels target = springRepositories.findById(id).get();
            target.setStt(request.getStt());
            try {
                return springRepositories.save(target);
            } catch (FailedUpdating ex) {
                throw new FailedUpdating();
            }
        } else
            throw new CouldNotFind();

    }

    @Override
    public SpringModels createAModel(SpringModels request) {
        if (request.getId() == null)
            throw new isANullRequest();
        try {
            return springRepositories.save(request);
        } catch (FailedCreating ex) {
            throw new FailedCreating();
        }

    }

    @Override
    public void deleteAModelById(String id) {
        if (id.isEmpty()) {
            throw new isANullRequest();
        }
        if (springRepositories.findById(id).isPresent())
            try {
                springRepositories.deleteById(id);
            } catch (FailedDeleting ex) {
                throw new FailedDeleting();
            }
        else
            throw new CouldNotFind();
    }

    @Override
    public List<SpringModels> getAllByStt(int stt) {
        if (springRepositories.findAllBySttOrderByIdAsc(stt).isEmpty())
            throw new isAnEmptyList();
        try {
            return new ArrayList<>(springRepositories.findAllBySttOrderByIdAsc(stt));
        } catch (FailedGetting ex) {
            throw new FailedGetting();
        }
    }
}
