package com.example.actc.randomuser_ready;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView gender ,title , first ,last,street,city,state,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gender = (TextView) findViewById(R.id.tv1);
        title = (TextView)findViewById(R.id.tv2);
        first=(TextView)findViewById(R.id.tv3);
        last=(TextView)findViewById(R.id.tv4);
        street=(TextView)findViewById(R.id.tv5);
        city=(TextView)findViewById(R.id.tv6);
        state =(TextView)findViewById(R.id.tv7);
        email=(TextView)findViewById(R.id.tv8) ;


        ///////////////-------------------


        URL url = NetworkUtils.buildUrl("https://randomuser.me/api/");

        new findRandom().execute(url);

        ///////////////---------------------


    } //// end of oncreate


    public class findRandom extends AsyncTask<URL, Void, String> {

        // COMPLETED (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String Results = null;
            try {
                Results = NetworkUtils.getResponseFromHttpUrl(searchUrl);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return Results;
        } //-- end of background



        @Override
        protected void onPostExecute(String Results) {
            if (Results != null && !Results.equals("")) {

                try {


                      User ready = JsonPasring.RandParsing(Results);
                    fitting(ready);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } //-- end of post excecute



        public  void fitting (User temp){


            first.setText(temp.getFirst());
            last.setText(temp.getLast());
            gender.setText(temp.getGender());
            title.setText(temp.getTitle());
            state.setText(temp.getState());
            street.setText(temp.getStreet());
            email.setText(temp.getEmail());
            city.setText(temp.getCity());




        }




    }//-- end of class find random


}
