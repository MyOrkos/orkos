package com.airhacks.persistence;

import com.airhacks.JPA.ToDo_T;
import com.airhacks.JPA.UserT;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserService implements Serializable {

    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public UserT persistUser(UserT userT){
        logger.info("Persisting user");
        entityManager.persist(userT);
        return userT;
    }

    public UserT updateUser(UserT userT){
        logger.info("Updating user");
        entityManager.merge(userT);
        return userT;
    }

    public UserT findUserById(Long id){
        logger.info("Find User by id");
        return entityManager.find(UserT.class,id);
    }
    public List<UserT> findAllUsers(){
        logger.info("Find all users");
        return entityManager.createQuery("select user from UserT user",UserT.class)
                .getResultList();
    }

    public List<String> findAllUsernames(){
        logger.info("Find all usernames");
        return entityManager.createQuery("select user.userName from UserT user",String.class)
                .getResultList();
    }

    public UserT findUserByUsernameAndPassword(String username,String password){
        try{
            logger.info(username +" "+ password);
        return entityManager.createQuery("select user from UserT " +
                " user where user.userName = :username and user.password = :password",UserT.class)
                .setParameter("username",username)
                .setParameter("password",password)
                .getSingleResult();}
        catch (NoResultException e){
            return null;
        }
    }

}
