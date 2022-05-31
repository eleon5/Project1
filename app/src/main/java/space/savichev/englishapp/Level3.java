package space.savichev.englishapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialogEnd;

    Array array = new Array();
    int [] aa = new int [20]; // массив для номеров неверных ответов
    public int b = 0;// счетчик неверных ответов
    public int textlvl3;
    boolean yeah = true;
    boolean nope = false;
    String q = "Допущенные ошибки в следующих вопрорсах:" + "\n";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal3);


        final TextView text2_level3 = findViewById(R.id.text2_level3);




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

                        Intent intent = new Intent(Level3.this, GameLevels.class);
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
                        Intent intent = new Intent(Level3.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {Intent intent = new Intent(Level3.this, Level3.class);
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

                    Intent intent = new Intent(Level3.this, GameLevels.class);
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


        textlvl3 = 0;
        text2_level3.setText(array.tasks3[textlvl3]);


        //обработчик кнопки
        Button btn_yes = (Button) findViewById(R.id.btn_yes);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (array.answers3[textlvl3] == yeah){

                    TextView tv = findViewById(progress[textlvl3]);
                        tv.setBackgroundResource(R.drawable.style_points_green);


                }
                else
                    {
                    TextView tv = findViewById(progress[textlvl3]);
                    tv.setBackgroundResource(R.drawable.style_points_red);



                    aa [b] =  textlvl3;
                    b++;


                    }
                textlvl3++;



                if (textlvl3 == 20)
                {
                    for (int i = 0; i < b; i++)
                    {
                        q = q + array.tasks3[aa [i]] + " " + "-" + " " +array.extra[aa [i]] +"\n";
                    }
                    if (b > 5)
                    {
                        q = q + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                    }else{
                        q = q + "Игра пройдена. Вернуться к главному меню?";
                    }

                    if (b == 0)
                    {
                       q = "Вы молодец! Все ответы верные! Вы прошли игру. Вернуться к главному меню?";
                    }
                    textdescription.setText(q);
                    dialogEnd.show();

                }
                else
                    {
                    text2_level3.setText(array.tasks3[textlvl3]);
                    }
            }
        });


        //обработчик кнопки
        Button btn_no = (Button) findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (array.answers3[textlvl3] == nope){

                        TextView tv = findViewById(progress[textlvl3]);
                    tv.setBackgroundResource(R.drawable.style_points_green);


                }else {
                        TextView tv = findViewById(progress[textlvl3]);
                        tv.setBackgroundResource(R.drawable.style_points_red);

                    aa [b] =  textlvl3;
                    b++;


                }

                textlvl3++;

                if (textlvl3 == 20)
                {
                    for (int i = 0; i < b; i++)
                    {
                        q = q + array.tasks3[aa [i]] + " " + "-" + " " +array.extra[aa [i]] +"\n";
                    }
                    if (b > 5)
                    {
                        q = q + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                    }else{
                        q = q + "Игра пройдена. Вернуться к главному меню?";
                    }

                    if (b == 0)
                    {
                        q = "Вы молодец! Все ответы верные! Вы прошли игру. Вернуться к главному меню?";
                    }
                    textdescription.setText(q);
                    dialogEnd.show();

                }
                else
                {
                    text2_level3.setText(array.tasks3[textlvl3]);
                }

            }
        });


    }

    @Override
    public void onBackPressed(){

        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent); finish();

        }catch (Exception e) {

        }

    }

}