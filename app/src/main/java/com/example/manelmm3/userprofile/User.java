package com.example.manelmm3.userprofile;

public class User {
    public String name;
    public String lastname;
    public String handle;
    public String following;
    public String followers;
    public String about;

    public String getName() {
        return name+ " " +lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHandle() {
        return handle;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }

    public String getAbout() {
        return about;
    }
}
