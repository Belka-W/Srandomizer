package com.example.belka.buttons;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


import static com.example.belka.buttons.R.layout.scnd_activity;


public class ScndActivity extends Activity  implements View.OnClickListener{


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(scnd_activity);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(ScndActivity.this, NewActivity.class);
        startActivity(intent1);
    }

   /* public void clickBtn31 (View View) {
        Intent intent1 = new Intent(ScndActivity.this, NewActivity.class);
        startActivity(intent1);
    }
    public void clickBtn32 (View View) {
        Intent intent2 = new Intent(ScndActivity.this, MainActivity.class);
        startActivity(intent2);
    }*/


}