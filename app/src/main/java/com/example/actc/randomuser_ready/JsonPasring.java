package com.example.actc.randomuser_ready;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonPasring {


    public static User  RandParsing (String responseHttp)throws  Exception {
        String gender = null,title=null,first=null,last=null,street=null,city=null,state=null,email=null;

        User temp_User ;

        JSONObject Starter = new JSONObject(responseHttp);

//-- results or info

        JSONArray results_arr = Starter.getJSONArray("results");
        JSONObject result_obj = results_arr.getJSONObject(0);
        gender = result_obj.getString("gender");

////////////---------------------
        JSONObject name = result_obj.getJSONObject("name");
        //-- parsing name
        title = name.getString("title");
        first = name.getString("first");
        last = name.getString("last");
        //---

        JSONObject Location = result_obj.getJSONObject("location");
        street = Location.getString("street");
        city = Location.getString("city");
        state = Location.getString("state");
        ////------------

        email = result_obj.getString("email");



        temp_User =   new User(gender,title,first,last,street,city,state,email);
        return  temp_User;



    }




}
