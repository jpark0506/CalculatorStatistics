package com.djaprk.parkjunhyuk.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ExPermutation extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout back, result;
    TextView resulttext;
    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_permutation);
        back = (RelativeLayout) findViewById(R.id.back);
        result = (RelativeLayout) findViewById(R.id.button);
        resulttext = (TextView) findViewById(R.id.textView7);
        num1 = (EditText) findViewById(R.id.editText2);
        num2 = (EditText) findViewById(R.id.editText);
        back.setOnClickListener(this);
        result.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId) {
            case R.id.back:
                finish();
                break;
            case R.id.button:
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 치세요!", Toast.LENGTH_LONG).show();
                    resulttext.setText("숫자를 치세요!");
                } else {
                    float result2 = caculate(num1.getText().toString(), num2.getText().toString());
                    if (result2 == -2) {
                        Toast.makeText(getApplicationContext(), "숫자가 규칙에 맞지 않아요!", Toast.LENGTH_LONG).show();
                        resulttext.setText("오류");
                    }else if(result2 == -3){
                        Toast.makeText(getApplicationContext(), "숫자는 3자리 이하!", Toast.LENGTH_LONG).show();
                    } else if (result2 == -1) {
                        Toast.makeText(getApplicationContext(), "숫자가 너무 커요!", Toast.LENGTH_LONG).show();
                        resulttext.setText("오류");
                    } else if (result2 == 0) {
                        resulttext.setText("1");
                        Toast.makeText(getApplicationContext(), "계산결과 1", Toast.LENGTH_LONG).show();
                    } else {
                        String result = String.valueOf(result2);
                        resulttext.setText(result);
                        Toast.makeText(getApplicationContext(),  result, Toast.LENGTH_LONG).show();
                    }
                }
        }
    }
    private float caculate(String alpha, String beta) {
        float um1 = Integer.parseInt(alpha);
        float um2 = Integer.parseInt(beta);
        float temp=um2;
        float result;
        if ( um1 < 0 || um2 < 0) {
            Toast.makeText(getApplicationContext(), "숫자가 음수이면 안되요!", Toast.LENGTH_LONG).show();
            result = -2;
        }
        else if(um2>=1000 || um1>=1000){
            result = -3;
        }
        else if(um1==0){
            result=0;
        }else {
            for (int i = 1; i <= um1; i++) {
                um2 = um2 * temp;
            }
            if(um2/temp<0){
                result=-1;
            }else{
                result = um2/temp;
                Toast.makeText(getApplicationContext(), "계산결과 " + result, Toast.LENGTH_LONG).show();
            }

        }
        return result;
    }
}
