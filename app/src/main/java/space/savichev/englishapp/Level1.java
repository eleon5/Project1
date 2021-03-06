package space.savichev.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Dialog dialogEnd;

    Array array = new Array();
    int [] aa = new int [20]; // массив для номеров неверных ответов

    public int b = 0;// счетчик неверных ответов
    public int textlvl1;
    boolean yeah = true;
    boolean nope = false;
    String q = "Допущенные ошибки в следующих вопрорсах:" + "\n";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);


        final TextView text_level1 = findViewById(R.id.text2_level1);



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);

        TextView textdescription = (TextView)dialogEnd.findViewById(R.id.textdescription);
        textdescription.setText(q);


        TextView btnclose = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    try{

                        Intent intent = new Intent(Level1.this, GameLevels.class);
                        startActivity(intent);
                        finish();

                    }catch (Exception e){

                    }dialogEnd.dismiss();
                }

        });


        Button btncontinue2 = (Button) dialogEnd.findViewById(R.id.btncontinue2);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    if (b <=5 )
                    {
                        Intent intent = new Intent(Level1.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {Intent intent = new Intent(Level1.this, Level1.class);
                        startActivity(intent);
                        finish();
                    }

                }catch (Exception e){

                }
                dialogEnd.dismiss();

            }
        });


        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });




        //my

        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };


        textlvl1 = 0;
        text_level1.setText(array.tasks1[textlvl1]);

        //обработчик кнопки
        Button btn_yes = (Button) findViewById(R.id.btn_yes);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (array.answers1[textlvl1] == yeah){

                    TextView tv = findViewById(progress[textlvl1]);
                        tv.setBackgroundResource(R.drawable.style_points_green);


                }
                else
                    {
                    TextView tv = findViewById(progress[textlvl1]);
                    tv.setBackgroundResource(R.drawable.style_points_red);



                    aa [b] =  textlvl1;
                    b++;


                    }
                textlvl1++;



                //if (textlvl1 == array.tasks1.length){
                if (textlvl1 == 20)
                {
                    for (int i = 0; i < b; i++)
                    {
                    q = q + array.tasks1[aa [i]] + " " + "(" + array.answers1[aa [i]] + ")" +"\n";
                    }
                    if (b > 5)
                    {
                        q = q + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                    }


                    if (b == 0)
                    {
                       q = "Вы молодец! Все ответы верные! Продолжить? ";
                    }
                    textdescription.setText(q);
                    dialogEnd.show();



                }
                else
                    {
                    text_level1.setText(array.tasks1[textlvl1]);
                    }
            }
        });


        //обработчик кнопки
        Button btn_no = (Button) findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (array.answers1[textlvl1] == nope){

                        TextView tv = findViewById(progress[textlvl1]);
                    tv.setBackgroundResource(R.drawable.style_points_green);




                }else {
                        TextView tv = findViewById(progress[textlvl1]);
                        tv.setBackgroundResource(R.drawable.style_points_red);

                    aa [b] =  textlvl1;
                    b++;


                }

                textlvl1++;

                if (textlvl1 == 20){
                    for (int i = 0; i < b; i++)
                    {
                        q = q + array.tasks1[aa [i]] + " " + "(" + array.answers1[aa [i]] + ")" +"\n";
                    }
                    if (b > 5)
                    {
                        q = q + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                    }


                    if (b == 0)
                    {
                        q = "Вы молодец! Все ответы верные! Продолжить? ";
                    }
                    textdescription.setText(q);
                    dialogEnd.show();


                }else{

                    text_level1.setText(array.tasks1[textlvl1]);
                }

            }
        });


    }

    @Override
    public void onBackPressed(){

        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent); finish();

        }catch (Exception e) {

        }

    }

}