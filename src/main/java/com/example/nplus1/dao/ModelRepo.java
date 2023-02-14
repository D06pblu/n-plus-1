package com.example.nplus1.dao;

import com.example.nplus1.model.Model;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("modelRepo")
public interface ModelRepo extends CrudRepository<Model, Long> {
//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "manufacturer-graph")
    List<Model> findAll();

//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "manufacturer-graph")
    List<Model> findAllByManufacturerId(Long id);
}
