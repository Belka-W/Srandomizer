package com.example.belka.buttons;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.belka.buttons.R.layout.activity_randomizer;


public class Randomizer extends Activity {
    //Подключение визора

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_randomizer);

        final TextView viewMatch = (TextView) findViewById(R.id.viewMatch);
        final TextView countWorld = (TextView) findViewById(R.id.countWorld);
        Button addMatch = (Button) findViewById(R.id.addMatch);
        final EditText newMatch = (EditText) findViewById(R.id.newMatch);

        final MatchVar varMatch = new MatchVar();

        countWorld.setText("" + varMatch.getCountMatch());

        viewMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMatch.setText(varMatch.getRandomMatch());
                MainActivity.appVisor.saveControlClick(v.getResources().getResourceName(v.getId()),
                        v.getResources().getResourceName(((View) v.getParent()).getId()));
            }
        });

        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(newMatch.getText().toString())) {
                    varMatch.addMatch(newMatch.getText().toString());
                    newMatch.setText("");
                    countWorld.setText("" + varMatch.getCountMatch());
                }
                //Логирование
                MainActivity.appVisor.saveControlClick(v.getResources().getResourceName(v.getId()),
                        v.getResources().getResourceName(((View) v.getParent()).getId()));
            }
        });


    }

    public void onMyViewClick(View view) {
        MainActivity.appVisor.saveControlClick(view.getResources().getResourceName(view.getId()),
                view.getResources().getResourceName(((View) view.getParent()).getId()));
    }


    public static class MatchVar {

        private ArrayList<String> listMatch = new ArrayList();

        public MatchVar() {
            listMatch.add("Да");
            listMatch.add("Нет");
            listMatch.add("Подумай");
            listMatch.add("Уже лучше");
        }

        public int getCountMatch() {
            return this.listMatch.size();
        }

        public void addMatch(String s) {
            listMatch.add(s);
        }

        public String getRandomMatch() {
            return listMatch.get(((int) (Math.random() * listMatch.size())));
        }
    }

    public void clickBtn(View View) {
        Intent intent4 = new Intent(Randomizer.this, ScndActivity.class);
        startActivity(intent4);
    }

}
