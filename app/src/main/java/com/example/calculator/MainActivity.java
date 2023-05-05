package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
TextView result;
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button c,percentage,divide,dot,equal,plus,minus,multilply;
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
        dot=findViewById(R.id.dot);
        divide=findViewById(R.id.divide);

        minus=findViewById(R.id.minus);
        multilply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        percentage=findViewById(R.id.percent);

        c=findViewById(R.id.c);
//        percentage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                data+="%";
//                result.setText(""+data);
//            }
//        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="/";
                result.setText(""+data);
            }
        });
//       // dot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                data+=".";
//                result.setText(""+data);
//            }
//        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="-";
                result.setText(""+data);
            }
        });
        multilply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data+="*";
                result.setText(""+data);
            }
        });
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
                double Opvalue=0.0;
                char[] chr=data.toCharArray();
                Stack<Double> oprands=new Stack<>();
                Stack<Character> oprators=new Stack<>();
                Stack<String> opdot=new Stack<>();
                String dataV="";

                for(int i=0;i<chr.length;i++)
                {
                    dataV="";

//                    if(chr[i]=='.')
//                    {
//                        dataV=Double.toString(oprands.pop());
//                        dataV+='.';
//                        opdot.push(dataV);
//                    }
//                 else
                  if (chr[i]>='0' && chr[i]<='9')
                    {
//                        if(opdot.size()>0)
//                        {
//                            dataV+=opdot.pop();
//                        }


                     while(i<chr.length && chr[i]>='0' && chr[i]<='9')
                     {
                         dataV+=chr[i];
                         i++;
                     }



                        System.out.println(dataV);
                     Opvalue=Double.parseDouble(dataV);
                     System.out.println(Opvalue);
                     oprands.push(Opvalue);
                     i--;
                    }
                 else if(chr[i]=='+'|| chr[i]=='-'|| chr[i]=='*'|| chr[i]=='/')
                {
                    while(oprators.size()>0 && Precedence(chr[i])<=Precedence(oprators.peek()))
                    {
                      double v2=oprands.pop();
                        double v1=oprands.pop();
                        char opr=oprators.pop();
                        double oprResult=Operation(v1,v2,opr);
                        oprands.push((oprResult));
                    }

                    oprators.push(chr[i]);
                }
                }


                while(oprators.size()!=0 )
                {
                    if(oprands.size()==1)
                    {
                        Context context=getApplicationContext();
                        CharSequence charSequence="Inavlid Format";
                        int duration=Toast.LENGTH_SHORT;
                        Toast toast=Toast.makeText(context,charSequence,duration);
                        toast.show();

                        return;
                    }
                    double v2=oprands.pop();
                    double v1=oprands.pop();
                    char opr=oprators.pop();
                    double oprResult=Operation(v1,v2,opr);
                    oprands.push((oprResult));
                }


                result.setText("" +oprands.peek());

            }



        });




    }
    public static int Precedence(char ch)
    {
        if(ch=='+')
        {
            return 1;
        }
        else if(ch=='-')
        {
            return 1;
        }
        else if(ch=='*')
        {
            return 1;
        }
        else
        {
            return 1;
        }
    }

    public static double Operation(double v1,double v2,char ch)
    {
        if(ch=='+')
        {
            return v1+v2;
        }
        else if(ch=='-')
        {
            return v1-v2;
        }
        else if(ch=='*')
        {
            return v1*v2;
        }
        else
        {
            return v1/v2;
        }
    }


}
