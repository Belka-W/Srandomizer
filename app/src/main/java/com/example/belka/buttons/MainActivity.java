package com.example.belka.buttons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button cncl;
    Button Ok;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mysource);

        cncl = (Button) findViewById(R.id.cncl);
        Ok = (Button) findViewById(R.id.ok);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
                editText.getText().clear();

            }
        });

        cncl.setText("отменить");
        cncl.setOnClickListener(this);
    }
public void clickNewBtn (View View) {
    Intent intent = new Intent(MainActivity.this, NewActivity.class);
    startActivity(intent);
}
    @Override
    public void onClick(View v) {

        textView.setText(R.string.textview);
        editText.getText().clear();

    }
}
