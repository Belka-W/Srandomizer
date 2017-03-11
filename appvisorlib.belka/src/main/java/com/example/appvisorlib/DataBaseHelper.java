package com.example.appvisorlib;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

/**
 * Created by belka-w on 07.12.16.
 */

public class DataBaseHelper implements IDataBaseHelper {
    private final String LOG_TAG = "DataBaseHelper";

    private String ip;
    private String port;
    private String login;
    private String password;

    private static final String DATABASE_TABLE = "ControlClick";
    private static final String SEP = "%20";

    public DataBaseHelper(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public DataBaseHelper(String ip, String login, String password) {
        this.ip = ip;
        this.login = login;
        this.password = password;
    }

    @Override
    public void saveToDataBaseContrloAction(String date,String dateAndTime, String sessionId, String eventId,
                                            String controlId, String viewId) {
        new SaveControlAction(date, dateAndTime, sessionId, eventId,controlId, viewId).execute();
    }

    private class SaveControlAction extends AsyncTask<String, Void, Void> {

        private String date;
        private String dateAndTime;
        private String sessionId;
        private String eventId;
        private String controlId;
        private String viewId;

        SaveControlAction(String date, String dateAndTime, String sessionId, String eventId, String controlId, String viewId) {
            this.date = date;
            this.dateAndTime = dateAndTime;
            this.sessionId = sessionId;
            this.eventId = eventId;
            this.controlId = controlId;
            this.viewId = viewId;
        }

        @Override
        protected Void doInBackground(String... params) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("http://"+ip+":"+port+"/?query=INSERT"+SEP+"INTO"+SEP+DATABASE_TABLE+SEP+"VALUES"+SEP+"('"+date+"','"+ dateAndTime+"','" + sessionId + "'," + eventId +",'"+ controlId+"','"+viewId+"')");
//            HttpPost post = new HttpPost(dbInsert(params[0],params[1],params[2],params[3],params[4]));
            Log.d(LOG_TAG, "doInBackground: "+"http://"+ip+":"+port+"/?query=INSERT"+SEP+"INTO"+SEP+DATABASE_TABLE+SEP+"VALUES"+SEP+"('"+date+"','"+ dateAndTime+"','"+ sessionId+"','"+eventId +"','"+ controlId+"','"+viewId+"')");

            try {
                HttpResponse response = client.execute(post);
                Log.d(LOG_TAG,"StatusLine = "+response.getStatusLine());
                if (response.getStatusLine().equals("HTTP/1.1 500 Internal Server Error"))
                    Log.e(LOG_TAG, "Ничего не сохраняем. Ошибка 500");
                Log.d(LOG_TAG,"Сохраняем действие!");
            } catch (IOException e){
                System.out.println("=======================");
                Log.d(LOG_TAG,"!!!Ошибка записи в БД!!!!");
                System.out.println("=======================");
            }

            return null;
        }
    }
    @Deprecated
    private String dbInsert(String... args){
        String query = "";
        query+="http://";
        query+=ip;
        query+=":";
        query+=port;
        query+="/?query=INSERT";
        query+=SEP;
        query+="INTO";
        query+=SEP;
        query+=DATABASE_TABLE;
        query+=SEP;
        query+="VALUES";
        query+=SEP;
        query+="('";


        for (int i = 0; i < args.length; i++) {
            query+=args[i];
            if (i<args.length-1)
                query+="','";
        }
        query+="')";
        return query;
    }
}
