package com.example.cms.service;

import com.example.cms.entity.Content;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ContentService{

    @PersistenceContext
    private EntityManager em;

    public List<Content> findAll() {
        return em.createQuery(
            "SELECT cFROM Content c", Content.class)
            .getResultList();
    }

    public Content findById(Long id){
        return em.find(Content.class, id);
    }

    public void save(Content c){
        em.persist(c);
    }

    public void update(Content c){
        em.merge(c);
    }
    public void delete(Long id){
        Content c = em.find(Content.class, id);
        if (c != null) em.remove(c);
    }
}