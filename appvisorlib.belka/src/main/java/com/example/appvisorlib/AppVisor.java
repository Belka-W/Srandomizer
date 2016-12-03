package com.example.appvisorlib;


import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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

public class AppVisor  implements IAppVisor{
    @Override
    public void saveScreen() {

    }

    @Override
    public void saveBtnAction(String name) {
        new SaveBtnAction(name).execute();
    }

    @Override
    public void saveScreenAction() {

    }

    @Override
    public void connectDB(String url) {
       new ConnectToDB(url).execute();
    }


    class ConnectToDB extends AsyncTask<String, Void, String>{
        private String url = null;

        ConnectToDB(String url){
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

    class SaveBtnAction extends AsyncTask<String, Void, String>{
        private String nameBtn = null;
        private String time = null;

        SaveBtnAction(String nameBtn){
            this.nameBtn = nameBtn;
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            time = df.format(Calendar.getInstance().getTime());
        }

        @Override
        protected void onPreExecute() {
            Log.d("AppVisorLib","Зашли в поток!");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("http://192.168.1.149:8123/?query=INSERT%20INTO%20login_btn%20VALUES%20('"+time+"','"+nameBtn+"')");

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
