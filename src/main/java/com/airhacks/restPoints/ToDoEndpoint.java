package com.airhacks.restPoints;

import com.airhacks.JPA.ToDo_T;
import com.airhacks.persistence.ToDoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoEndpoint {

    @Inject
    private ToDoService toDoService;

    @Path("persist")
    @POST
    public Response createTodo(ToDo_T toDoT){
         toDoService.persistToDo(toDoT);
         return Response.ok(toDoT).build();
    }

    @Path("update")
    @PUT
    public Response update(ToDo_T toDoT){
        toDoService.updateToDo(toDoT);
        return Response.ok(toDoT).build();
    }

    @Path("{id}")
    @GET
    public ToDo_T getTodo(@PathParam("id")Long id){
        return toDoService.findToDoById(id);
    }

    @Path("findAll")
    @GET
    public List<ToDo_T> getTodo(){
        return toDoService.findAllToDo();
    }
}
