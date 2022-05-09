package space.savichev.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Level1 extends AppCompatActivity {


    public int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

     /*   final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);*/


        final TextView text_left = findViewById(R.id.text_left);

        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){{

                }}
            }
        });

        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);

        /*img_left.setImageResource(R.drawable.pictagreedef);
        text_left.setText(R.string.lvl1text1);

        img_right.setImageResource(R.drawable.pictdisagreedef);
        text_right.setText(R.string.lvl1text2);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    //если коснулся картинки
                    img_right.setEnabled(false);

                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    //если отпустил картинку

                }
                return true;
            }
        });*/
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