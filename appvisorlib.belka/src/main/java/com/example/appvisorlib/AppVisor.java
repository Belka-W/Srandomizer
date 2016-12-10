package com.example.appvisorlib;


import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


/**
 * Created by belka-w on 02.12.16.
 */
//Либа
public class AppVisor implements IAppVisor {
    private final String LOG_TAG = "AppVisor";
    private DataBaseHelper dbHelper;
    private String sessionId;
    private int eventId;

    public AppVisor() {
        this.sessionId = UUID.randomUUID().toString();
        eventId = 0;
    }

    @Override
    public void connectDB(String ip, String port) {
        this.dbHelper = new DataBaseHelper(ip, port);
    }

    public void saveControlClick(String controlId, String viewId) {
        if (dbHelper != null) {
            DateFormat df = new SimpleDateFormat("yyyy%20dd%20MM%20HH:mm:ss");
            String time = df.format(Calendar.getInstance().getTime());
            ++this.eventId;
            dbHelper.saveToDataBaseContrloAction(time, sessionId, Integer.toString(eventId), controlId.split(":")[1], viewId.split(":")[1]);
        } else {
            Log.d(LOG_TAG, "!!!Нет связи с базой!!!");
        }
    }

//    DateFormat df = new SimpleDateFormat("yyyy%20dd%20MM%20HH:mm:ss");
//    time = df.format(Calendar.getInstance().getTime());
}
