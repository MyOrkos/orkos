package com.airhacks.persistence.mappers;

import com.airhacks.JPA.UserT;
import com.airhacks.domains.UserD;

public class UserMapper {

    public static UserD convertUserTtoD(UserT userT){
        UserD userD = new UserD();
        userD.setEmail(userT.getEmail());
        userD.setPassword(userT.getPassword());
        userD.setUserId(userT.getUserId());
        userD.setUserName(userT.getUserName());

        return userD;
    }

    public static UserT convertUserDtoT(UserD userD){
        UserT userT = new UserT();
        userT.setEmail(userD.getEmail());
        userT.setPassword(userD.getPassword());
        userT.setUserId(userD.getUserId());
        userT.setUserName(userD.getUserName());

        return userT;
    }

}
