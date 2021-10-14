package com.company.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAc,btnDel,btnPlus,btnMinus,btnDivide,btnMulti,btnDot,btnEqual;
    private TextView textViewresult,textViewHistory;
    private String number = null;
    double first_number=0;
    double last_number=0;

    String status = null;
    boolean operator = false;
    DecimalFormat myformatter =new DecimalFormat("######.######");

    String history , currentResult ;//create two variable for maintain history
    boolean dot = true;

    boolean btnACcontrol = true;
    boolean btnEqualControl = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAc=findViewById(R.id.btnAC);
        btnDel=findViewById(R.id.btnDel);
        btnDot=findViewById(R.id.btndot);
        btnEqual=findViewById(R.id.btnEqualto);

        btnPlus=findViewById(R.id.btnPlus);
        btnMinus=findViewById(R.id.btnMinus);
        btnDivide=findViewById(R.id.btnDivide);
        btnMulti=findViewById(R.id.btnMulti);

        textViewresult=findViewById(R.id.textViewResult);
        textViewHistory=findViewById(R.id.textViewHistroy);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");

            }
        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               number=null;
               status=null;
               textViewresult.setText("0");
               textViewHistory.setText("");
               first_number=0;
               last_number=0;
               dot = true;
               btnACcontrol = true;

            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnACcontrol)
                {
                    textViewresult.setText("0");
                }
                else
                {
                    number=number.substring(0,number.length()-1);

                    if(number.length()==0)//string length
                    {
                        btnDel.setClickable(false);//after press del button the data is deleted
                    }
                    else if(number.contains("."))
                    {
                        dot = false;
                    }
                    else
                    {
                        dot = true;
                    }
                    textViewresult.setText(number);
                }


            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");
                if(operator)
                {
                    if(status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status=="division")
                    {
                        divide();
                    }
                    else if(status=="subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }

                }
                status="sum";
                operator=false;
                number=null;

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");
                if(operator)
                {
                    if(status=="multiplication")
                    {
                        multiply();
                    }
                    else if(status=="division")
                    {
                        divide();
                    }
                    else if(status=="sum")
                    {
                        plus();
                    }
                    else
                    {
                        minus();
                    }
                }
                status="subtraction";
                operator=false;
                number=null;

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");
                if(operator)
                {
                    if(status=="sum")
                    {
                        plus();
                    }
                    else if(status=="division")
                    {
                        divide();
                    }
                    else if(status=="subtraction")
                    {
                        divide();
                    }
                    else
                    {
                        multiply();
                    }
                }
                status="multiplication";
                operator=false;
                number=null;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewresult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");

                if(operator)
                {
                    if(status=="multiplication")
                    {
                        multiply();
                    }
                    else if(status=="sum")
                    {
                        plus();
                    }
                    else if(status=="subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        divide();
                    }
                }
                status="division";
                operator=false;
                number=null;

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator)
                {
                    if(status == "sum")
                    {
                        plus();
                    }
                    else if(status=="subtraction")
                    {
                       minus();
                    }
                    else if(status=="multiplication")
                    {
                        multiply();
                    }
                    else if(status=="division")
                    {
                        divide();
                    }
                    else
                    {
                        first_number=Double.parseDouble(textViewresult.getText().toString());
                    }
                }

                operator=false;
                btnEqualControl = true;

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dot) {

                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }

                textViewresult.setText(number);

                dot =false;

            }
        });




    }
       public void numberClick(String view)
       {
          if(number==null)
          {
              number=view;
          }
          else if (btnEqualControl)
          {
              first_number = 0;
              last_number = 0;
              number = view;
          }
          else
          {
              number=number + view;
          }

          textViewresult.setText(number);
          operator = true;
          btnACcontrol = false;
          btnDel.setClickable(true);
          btnEqualControl = false;
       }

       public void plus()
       {
           last_number=Double.parseDouble(textViewresult.getText().toString());
           first_number=first_number + last_number;
           textViewresult.setText(myformatter.format(first_number));

           dot = true;

       }
       public void minus()
       {
           if(first_number==0)
           {
               first_number=Double.parseDouble(textViewresult.getText().toString());
           }
           else
           {
               last_number=Double.parseDouble(textViewresult.getText().toString());
               first_number = first_number - last_number;
           }

           textViewresult.setText(myformatter.format(first_number));
           dot = true;

       }
       public void multiply()
       {
           if(first_number==0)
           {
               first_number=1;
               last_number=Double.parseDouble(textViewresult.getText().toString());
               first_number=first_number*last_number;
           }
           else
           {
               last_number=Double.parseDouble(textViewresult.getText().toString());
               first_number=first_number*last_number;
           }
           textViewresult.setText(myformatter.format(first_number));
           dot = true;
       }
       public void divide()
       {
           if(first_number == 0)
           {
               last_number =Double.parseDouble(textViewresult.getText().toString());
               first_number=last_number/1;
           }
           else
           {
               last_number =Double.parseDouble(textViewresult.getText().toString());
               first_number=last_number/last_number;

           }
           textViewresult.setText(myformatter.format(first_number));
           dot = true;
       }
}