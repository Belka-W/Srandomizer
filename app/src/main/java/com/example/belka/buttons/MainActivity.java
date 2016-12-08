package com.example.belka.buttons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appvisorlib.AppVisor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonCancel;
    Button buttonOk;
    Button buttonNewPage;
    TextView textView;
    EditText editText;
    //Подключение визора
    AppVisor appVisor = new AppVisor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mysource);

        buttonCancel = (Button) findViewById(R.id.cncl);
        buttonOk = (Button) findViewById(R.id.ok);
        buttonNewPage = (Button) findViewById (R.id.btn3);

        textView = (TextView) findViewById(R.id.myText);
        editText = (EditText) findViewById(R.id.mainEditText);

        buttonCancel.setOnClickListener(this);
        buttonOk.setOnClickListener(this);
        buttonNewPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn3: Intent intent = new Intent(MainActivity.this, Randomizer.class);
                startActivity(intent); break;
            case R.id.ok: if ((!editText.getText().toString().equals(""))&&(!editText.getText().toString().equals(" "))){
                textView.setText(editText.getText().toString());
                editText.getText().clear();}break;
            case R.id.cncl: textView.setText(R.string.textview);
                editText.getText().clear(); break;

        }

        appVisor.saveControlClick(v.getResources().getResourceName(v.getId()));
    }

    public void onMyViewClick(View view)
    {
        appVisor.saveControlClick(view.getResources().getResourceName(view.getId()));
    }



}
