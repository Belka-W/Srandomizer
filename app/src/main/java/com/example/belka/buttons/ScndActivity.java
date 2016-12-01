package com.example.belka.buttons;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


import static com.example.belka.buttons.R.layout.scnd_activity;


public class ScndActivity extends Activity  implements View.OnClickListener{


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(scnd_activity);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(ScndActivity.this, Randomizer.class);
        startActivity(intent1);
    }


}