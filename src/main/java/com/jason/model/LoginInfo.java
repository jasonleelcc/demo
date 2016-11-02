package com.jason.model;

import javax.persistence.*;

/**
 * Created by innofin-04 on 2016/10/27.
 */
@Entity
public class LoginInfo {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    private String userId;
    private String passwd;

}
