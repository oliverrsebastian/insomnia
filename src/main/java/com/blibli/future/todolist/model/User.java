package com.blibli.future.todolist.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AuditModel{
    @Id
    @Column(name = "userName", columnDefinition = "text", unique = true)
    @Size(min = 5, max = 100)
    private String userName;

    @NotBlank
    @Column(name = "fullName", columnDefinition = "text")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
