package com.example.appvisorlib;


import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by belka-w on 02.12.16.
 */
//Либа
public class AppVisor  implements IAppVisor{


    public void saveControlClick(String controlId) {
        new SaveControlClick(controlId).execute();
    }


    @Override
    public void connectDB(String url) {
       new ConnectToDataBase(url).execute();
    }


    class ConnectToDataBase extends AsyncTask<String, Void, String>{
        private String url = null;

        ConnectToDataBase(String url){
            this.url = url;
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpPost post = new HttpPost(url);
            HttpClient client = HttpClientBuilder.create().build();

            try {
                HttpResponse response = client.execute(post);
                System.out.println("==========OK=============");
                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println("==========OK=============");


            } catch (IOException e){
                System.out.println("=======================");
                System.out.println("!!!Все плохо!!!");
                System.out.println("=======================");
            }
            return null;
        }
    }

    class SaveControlClick extends AsyncTask<String, Void, String>{
        private String controlId = null;
        private String time = null;

        SaveControlClick(String controlId){
            this.controlId = controlId;
            DateFormat df = new SimpleDateFormat("yyyy%20dd%20MM%20HH:mm:ss");
            time = df.format(Calendar.getInstance().getTime());
        }

        @Override
        protected void onPreExecute() {
            Log.d("AppVisorLib","Зашли в поток!");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("http://192.168.43.125:8123/?query=INSERT%20INTO%20ControlClick%20VALUES%20('"+time+"','"+ controlId +"','null')");
//            HttpPost post = new HttpPost("http://192.168.43.125:8123/?query=INSERT%20INTO%20ControlClick%20VALUES%20('2016%2005%2012%2020:07:56','com.example.belka.buttons:id/cncl','')");

            try {
                HttpResponse response = client.execute(post);
                Log.d("AppVisorLib","Сохраняем действие!");

            } catch (IOException e){
                System.out.println("=======================");
//                System.out.println("!!!Все плохо!!!");
                Log.d("AppVisorLib","!!!Ошибка записи в БД!!!!");
                System.out.println("=======================");
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("AppVisorLib","Вышли из потока!");

        }
    }
}
