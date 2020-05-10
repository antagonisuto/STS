package com.example.soultosoul.MarfaQ.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Sts_user(id, username, password, first_name, last_name, image_url, role)

public class Users {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("image_url")
    @Expose
    private String image_url;

    @SerializedName("role")
    @Expose
    private String role;

    public Users(String username,  String password,  String first_name,  String last_name,  String image_url,  String role) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.image_url = image_url;
        this.role = role;
    }

    public long getId() {
        return this.id;
    }

    public void setId( long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername( String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name( String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name( String last_name) {
        this.last_name = last_name;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url( String image_url) {
        this.image_url = image_url;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole( String role) {
        this.role = role;
    }
}
