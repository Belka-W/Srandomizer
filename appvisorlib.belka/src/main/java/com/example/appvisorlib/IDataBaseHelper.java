package com.example.appvisorlib;

/**
 * Created by belka-w on 09.12.16.
 */

public interface IDataBaseHelper {

//    public void saveMotions();

    public void saveToDataBaseContrloAction(String date, String sessionId, String eventId,
                                            String controlId, String viewId);
}
