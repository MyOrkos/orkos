package com.airhacks.Bean;

import com.airhacks.JPA.ToDo_T;
import com.airhacks.persistence.ToDoService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "scopesBean")
@ViewScoped
public class ScopesBean implements Serializable {

    @Inject
    private ToDoService toDoService;

    @Inject
    private transient Logger logger;

    private List<ToDo_T> toDo_tArrayList;


    @PostConstruct
    public void init(){
        logger.info("Initializing Bean");
        logger.info("Service invoke");
        setToDo_tArrayList(toDoService.findAllToDo());
    }

    public void test(){
        logger.info("Filling list");
        setToDo_tArrayList(toDoService.findAllToDo());
    }

    @PreDestroy
    public void kill(){
        logger.info("Destroying Scope Bean");
        logger.info("Kill It");
    }

    public List<ToDo_T> getToDo_tArrayList() {
        return toDo_tArrayList;
    }

    public void setToDo_tArrayList(List<ToDo_T> toDo_tArrayList) {
        this.toDo_tArrayList = toDo_tArrayList;
    }
}
