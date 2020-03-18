package com.airhacks.Bean;

import com.airhacks.domains.UserD;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import com.airhacks.persistence.UserService;
import com.airhacks.persistence.mappers.UserMapper;
import org.apache.log4j.Logger;

@Named("eventBean")
@ViewScoped
public class EventBean implements Serializable {

    private UserD user;

    @Inject
    private transient Logger logger;

    @Inject
    private UserService userService;



    @PostConstruct
    private void init(){
        logger.info("Initializing event bean");
        setUser(new UserD());
    }

    public void createNewUser(){
        try{
            if(validateNewUser()){
                logger.info("Validation Correct");
        userService.persistUser(UserMapper.convertUserDtoT(getUser()));}
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
    }

    public boolean validateNewUser(){
        List<String> usernames =userService.findAllUsernames();
        if(usernames!=null || usernames.contains(user.getUserName())){
            logger.info("Succesfull Validation");
            return true;
        }
        logger.info("Failed Validation");
            return false;
    }

    public boolean login(){
        if(userService.findUserByUsernameAndPassword(getUser().getUserName(),getUser().getPassword())==null){
            logger.info("False Login");
            return false;}
        logger.info("False Login");
        return true;
    }

    public UserD getUser() {
        return user;
    }
    public void setUser(UserD user) {
        this.user = user;
    }




}
