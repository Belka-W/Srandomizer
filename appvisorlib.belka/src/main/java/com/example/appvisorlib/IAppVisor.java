package com.example.appvisorlib;

/**
 * Created by belka-w on 02.12.16.
 */

public interface IAppVisor {

    public void saveScreen();
    public void saveBtnAction(String name);
    public void saveScreenAction();
    public void connectDB(String url);

}
