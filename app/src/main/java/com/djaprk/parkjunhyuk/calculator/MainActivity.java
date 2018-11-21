package com.djaprk.parkjunhyuk.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView Per,Com,exPer,exCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Per=(ImageView)findViewById(R.id.permutation);
        Com=(ImageView)findViewById(R.id.combination);
        exPer=(ImageView)findViewById(R.id.expermutation);
        exCom=(ImageView)findViewById(R.id.excombination);

        Per.setOnClickListener(this);
        Com.setOnClickListener(this);
        exPer.setOnClickListener(this);
        exCom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId) {
            case R.id.permutation:

                Intent  intent=new Intent(v.getContext(),Permutation.class);
                startActivity(intent);
                break;
            case R.id.combination:

                Intent  intent2=new Intent(v.getContext(),Combination.class);
                startActivity(intent2);
                break;
            case R.id.expermutation:

                Intent  intent3=new Intent(v.getContext(),ExPermutation.class);
                startActivity(intent3);
                break;
            case R.id.excombination:

                Intent  intent4=new Intent(v.getContext(),ExCombintation.class);
                startActivity(intent4);
                break;

        }
    }
}

