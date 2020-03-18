package com.airhacks.JPA;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Named("TODO")
public class ToDo_T implements Serializable {

    static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name ="TO_DO_ID")
    private Long ToDoId;

    @Column(name ="TO_DO_DESCRIPTION")
    private String description;

    @Column(name ="COMPLETED")
    private Boolean completed;

    @Column(name ="DUE_DATE")
    private LocalDate dueDate;

    @Column(name ="DATE_COMPLETED")
    private LocalDate dateCompleted;


    public ToDo_T() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getToDoId() {
        return ToDoId;
    }

    public void setToDoId(Long toDoId) {
        ToDoId = toDoId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
