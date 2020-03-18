package com.airhacks.JPA;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Named("USER")
public class UserT implements Serializable {

    static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name ="USER_ID")
    private Long userId;

    @Column(name ="USER_NAME")
    private String userName;

    @Column(name ="PASSWORD")
    private String password;

    @Column(name ="EMAIL")
    private String email;



    public UserT() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long toDoId) {
        this.userId = toDoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserT{" +
                "toDoId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
