package com.example.demo.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customers")
public class Customer {

    @Id
    private String _id;
    private String name;
    private String email;
    private Date birthday;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
}