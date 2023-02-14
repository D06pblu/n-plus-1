package com.example.nplus1.dao;

import com.example.nplus1.model.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("modelRepoImpl")
public class ModelRepoImpl{

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    protected ModelRepoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    public List<Model> findAllBetween(int minYear, int maxYear) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Model> query = builder.createQuery(Model.class);
        Root<Model> modelRoot = query.from(Model.class);
        query.multiselect(modelRoot.get("productionStartYear"), modelRoot.get("productionStopYear"));
        query.where(builder.between(modelRoot.get("productionStartYear"), minYear, maxYear));
       return entityManager.createQuery(query).getResultList();

    }
}
