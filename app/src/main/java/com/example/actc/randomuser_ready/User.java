package com.example.actc.randomuser_ready;

public class User {


    String gender,title ,first,last ,street ,city ,state,email;

    public User (String gender,String title ,String first,String last ,String street ,String city ,String state,String email){

        ////////////////-------------------
        this.gender=gender;this.title=title;
        this.first=first;this.last=last;
        this.state=state;this.street=street;this.city=city;this.email=email;

    }

    String getGender(){return gender;}

    String getTitle(){return title;}

    String getFirst(){return first;}

    String getLast(){return last;}

    String getState(){return state;}
    String getStreet(){return street;}
    String getCity(){return city;}
    String getEmail(){return email;}









}
