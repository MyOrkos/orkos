package com.airhacks.persistence;

import com.airhacks.JPA.ToDo_T;
import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "ToDoPU")
    EntityManager entityManager;

}
