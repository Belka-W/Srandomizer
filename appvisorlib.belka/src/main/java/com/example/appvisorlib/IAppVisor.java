package com.example.appvisorlib;

/**
 * Created by belka-w on 02.12.16.
 */

public interface IAppVisor {


    public void saveControlClick (String controlId, String viewId);

    public void connectDB(String ip, String port);

}
//это номер события нажатия кнопки/вьюшки и тд
