package com.example.nplus1.service;

import com.example.nplus1.dao.ModelRepo;
import com.example.nplus1.dao.ModelRepoImpl;
import com.example.nplus1.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ModelService {

    @Qualifier("modelRepo")
    @Autowired
    private ModelRepo modelRepo;

    @Qualifier("modelRepoImpl")
    @Autowired
    private ModelRepoImpl modelRepoImpl;

    public List<Model> findAll(){
        Iterable<Model> models = modelRepo.findAll();
        for (Model model : models){
            System.out.println(model.getManufacturer());
            break;
        }
        return StreamSupport.stream(models.spliterator(), false).toList();
    }

    public  List<Model> findByManufacturerId(long id){
        return modelRepo.findAllByManufacturerId(id);
    }

    public List<Model> findAllBetween(int minYear, int maxYear){
        return modelRepoImpl.findAllBetween(minYear, maxYear);
    }
}
