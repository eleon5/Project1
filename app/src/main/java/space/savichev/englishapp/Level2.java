package space.savichev.englishapp;

import android.annotation.SuppressLint;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {


    Dialog dialogEnd;
    Array array = new Array();
    Random random = new Random();
    public int numLeft;
    public int numRight;
    public int task;
    public int k;
    int [] aa = new int [10]; // массив для номеров неверных ответов
    public int b = 0;// счетчик неверных ответов
    String p = "Допущенные ошибки в следующих вопрорсах:" + "\n";


    //my
    //public int textlvl2;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal2);

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);


        final TextView text_level2 = findViewById(R.id.text2_level2);


        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);

        TextView textdescription2 = (TextView)dialogEnd.findViewById(R.id.textdescription);
        textdescription2.setText(p);


        TextView btnclose = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    Intent intent = new Intent(Level2.this, GameLevels.class);
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
                        Intent intent = new Intent(Level2.this, Level3.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {Intent intent = new Intent(Level2.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }

                }catch (Exception e){

                }
                dialogEnd.dismiss();

            }
        });



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){{

                }}
            }
        });








        //my

        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
        };

        numLeft = random.nextInt(16);//случайное число
        img_left.setImageResource(array.images2[numLeft]);

        numRight = random.nextInt(16);

        while (numLeft == numRight){
            numRight = random.nextInt(16);
        }

        img_right.setImageResource(array.images2[numRight]);
        if (numLeft % 2 == 0) {task = numLeft;}
        else {task = numRight;}
        text_level2.setText(array.tasks2[task]);
        k = 0;


        // Обработчик левого фото
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    //если коснулся картинки
                    img_right.setEnabled(true);
                    if (task == numLeft) {
                        TextView tv = findViewById(progress[k]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    else
                    {
                        TextView tv = findViewById(progress[k]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                        aa [b] =  task;
                        b++;
                    }

                    task++;
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    //если отпустил картинку
                    k++;
                    if (k == 10){
                        for (int i = 0; i < b; i++)
                        {
                            p = p + (aa[i]+1) + ")" + array.tasks2[aa [i]] + "\n";
                        }
                        if (b > 5)
                        {
                            p = p + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                        }

                        if (b == 0)
                        {
                            p = "Вы молодец! Все ответы верные! Продолжить? ";
                        }
                        textdescription2.setText(p);
                        dialogEnd.show();

                        k = 2;
                    }else{

                        numLeft = random.nextInt(16);//случайное число
                        img_left.setImageResource(array.images2[numLeft]);

                        numRight = random.nextInt(16);

                        while (numLeft == numRight){
                            numRight = random.nextInt(16);
                        }

                        img_right.setImageResource(array.images2[numRight]);
                        if (numLeft % 2 == 0) {task = numLeft;}
                        else {task = numRight;}
                        text_level2.setText(array.tasks2[task]); ;
                    }


                }
                return true;
            }
        });


        //Обработчик правого фото
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    //если коснулся картинки
                    img_left.setEnabled(true);
                    if (task == numRight) {
                        TextView tv = findViewById(progress[k]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    else
                    {
                        TextView tv = findViewById(progress[k]);
                        tv.setBackgroundResource(R.drawable.style_points_red);

                        aa [b] =  task;
                        b++;
                    }
                    task++;
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    //если отпустил картинку
                    k++;
                    if (k == 10){
                        for (int i = 0; i < b; i++)
                        {
                            p = p + (aa[i]+1) + ")" + array.tasks2[aa [i]] + "\n";
                        }
                        if (b > 5)
                        {
                            p = p + "Вы допустили более 5 ошибок, пройдите уровень повторно";
                        }

                        if (b == 0)
                        {
                            p = "Вы молодец! Все ответы верные! Продолжить? ";
                        }
                        textdescription2.setText(p);
                        dialogEnd.show();
                        k = 2;
                    }else{

                        numRight = random.nextInt(16);//случайное число
                        img_right.setImageResource(array.images2[numRight]);

                        numLeft = random.nextInt(16);

                        while (numLeft == numRight){
                            numLeft = random.nextInt(16);
                        }

                        img_left.setImageResource(array.images2[numLeft]);
                        if (numRight % 2 == 0) {task = numRight;}
                        else {task = numLeft;}
                        text_level2.setText(array.tasks2[task]); ;
                    }
                }
                return true;
            }
        });





    }

    @Override
    public void onBackPressed(){

        try {
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent); finish();

        }catch (Exception e) {

        }

    }
}