package com.airhacks.persistence;

import com.airhacks.JPA.ToDo_T;
import org.apache.log4j.Logger;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@DataSourceDefinition(
        name = "java:app/Todo",
        className = "com.mysql.cj.jdbc.Driver",
        url = "jdbc:mysql://localhost:3306/javaeetesting?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC&amp;\n" +
                "\n" +
                "                             createDatabaseIfNotExist=true&amp;useSSL=false",
        user = "root",
        password = "root")
@Stateless
public class ToDoService implements Serializable {

    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public ToDo_T persistToDo(ToDo_T toDo_t){
        logger.info("Persisting object");
        entityManager.persist(toDo_t);
        return toDo_t;
    }

    public ToDo_T updateToDo(ToDo_T toDo_t){
        logger.info("Updating object");
        entityManager.merge(toDo_t);
        return toDo_t;
    }

    public ToDo_T findToDoById(Long id){
        logger.info("Find object by id");
        return entityManager.find(ToDo_T.class,id);
    }
    public List<ToDo_T> findAllToDo(){
        logger.info("Find all objects");
        return entityManager.createQuery("select todo from ToDo_T todo",ToDo_T.class)
                .getResultList();
    }
}
