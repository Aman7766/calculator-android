package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
TextView result;
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button c,percentage,divide,dot,equal,plus;
    String data="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        plus=findViewById(R.id.plus);
        equal=findViewById(R.id.equal);

        c=findViewById(R.id.c);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            data+="1";
            result.setText(""+data);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="2";
                result.setText(""+data);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="3";
                result.setText(""+data);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="4";
                result.setText(""+data);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="5";
                result.setText(""+data);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="6";
                result.setText(""+data);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="7";
                result.setText(""+data);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="8";
                result.setText(""+data);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="9";
                result.setText(""+data);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="0";
                result.setText(""+data);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data="";
                result.setText(""+data);

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="+";
                result.setText(""+data);


            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sum=0.0;
                String CurV="";
                Stack<Character> s=new Stack<>();
                for(int i=0;i<data.length();i++)
                {
                    if(data.charAt(i)!='+')
                    {
                        CurV+=data.charAt(i);
                    }
                    else
                    {
                    //  sum+=Double.parseDouble(CurV);

                      s.push(CurV);
                      if(i<data.length()-1)
                      {
                          s.push()
                      }
                    }
                }
            }
        });




    }
}
