package com.example.appvisorlib;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by belka-w on 02.12.16.
 */

public class AppVisor implements IAppVisor{
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet post = null;

    @Override
    public void saveScreen() {

    }

    @Override
    public void saveBtnAction() {

    }

    @Override
    public void saveScreenAction() {

    }

    @Override
    public void connectDB(String url) {
        post = new HttpGet(url);

        try {
            client.execute(post);
            System.out.println("==========OK=============");
            //System.out.println(EntityUtils.toString(post));
            System.out.println("==========OK=============");


        } catch (IOException e){
            System.out.println("=======================");
            System.out.println("!!!Все плохо!!!");
            System.out.println("=======================");
        }

    }
}
