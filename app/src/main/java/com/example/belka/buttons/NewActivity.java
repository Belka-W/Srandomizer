package com.example.belka.buttons;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import static com.example.belka.buttons.R.layout.activity;



public class NewActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity);


    }
    public void clickBtn (View View) {
        Intent intent4 = new Intent(NewActivity.this, ScndActivity.class);
        startActivity(intent4);
    }

}
