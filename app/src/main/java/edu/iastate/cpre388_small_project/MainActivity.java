package edu.iastate.cpre388_small_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    ImageView mole1,mole2,mole3,mole4;

    TextView time_left, score;

    Button button;

    int user_score = 0, fps = 1000, left = 5, tempifleft = 0;

    int which = 0, whichsave = 0;

    AnimatedImageDrawable animatedImageDrawablel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        button = (Button) findViewById(R.id.button);

        time_left = (TextView) findViewById(R.id.time_left);
        score = (TextView) findViewById(R.id.score);

        mole1 = (ImageView) findViewById(R.id.mole1);
        mole2 = (ImageView) findViewById(R.id.mole2);
        mole3 = (ImageView) findViewById(R.id.mole3);
        mole4 = (ImageView) findViewById(R.id.mole4);

        mole1.setVisibility(View.INVISIBLE);
        mole2.setVisibility(View.INVISIBLE);
        mole3.setVisibility(View.INVISIBLE);
        mole4.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left = 5;
                time_left.setText("Time Left: " + left);
                user_score = 0;
                score.setText("Score: ");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startButton();
                    }
                },1000);
                button.setEnabled(false);
            }
        });


        mole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft = 1;
                mole1.setImageResource(R.drawable.img_sign_in_whack_mole_rat_normal_18);
                user_score += 1;
                score.setText("Score: " + user_score);
                mole1.setEnabled(false);
            }
        });

        mole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft = 1;
                mole2.setImageResource(R.drawable.img_sign_in_whack_mole_rat_normal_18);
                user_score += 1;
                score.setText("Score: " + user_score);
                mole2.setEnabled(false);
            }
        });

        mole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft = 1;
                mole3.setImageResource(R.drawable.img_sign_in_whack_mole_rat_normal_18);
                user_score += 1;
                score.setText("Score: " + user_score);
                mole3.setEnabled(false);
            }
        });

        mole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempifleft = 1;
                mole4.setImageResource(R.drawable.img_sign_in_whack_mole_rat_normal_18);
                user_score += 1;
                score.setText("Score: " + user_score);
                mole4.setEnabled(false);
            }
        });
    }

    private void startButton(){
        do{
            which = random.nextInt(4)+1;
        } while (whichsave == which);
        whichsave = which;

        switch (which){
            case 1:
                mole1.setImageResource( R.drawable.img_sign_in_whack_mole_rat_normal_18);
                mole1.setVisibility(View.VISIBLE);
                mole4.setEnabled(true);
                break;
            case 2:
                mole2.setImageResource( R.drawable.img_sign_in_whack_mole_rat_normal_18);
                mole2.setVisibility(View.VISIBLE);
                mole2.setEnabled(true);
                break;
            case 3:
                mole3.setImageResource( R.drawable.img_sign_in_whack_mole_rat_normal_18);
                mole3.setVisibility(View.VISIBLE);
                mole3.setEnabled(true);
                break;
            case 4:
                mole4.setImageResource( R.drawable.img_sign_in_whack_mole_rat_normal_18);
                mole4.setVisibility(View.VISIBLE);
                mole4.setEnabled(true);
                break;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mole1.setVisibility(View.INVISIBLE);
                mole2.setVisibility(View.INVISIBLE);
                mole3.setVisibility(View.INVISIBLE);
                mole4.setVisibility(View.INVISIBLE);

                mole1.setEnabled(false);
                mole2.setEnabled(false);
                mole3.setEnabled(false);
                mole4.setEnabled(false);

                if(tempifleft == 0){
                    left = left-1;
                    time_left.setText("Time Left: " + left);
                }else if(tempifleft == 1){
                    tempifleft = 0;
                }

                if(left==0){
                    Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                    button.setEnabled(true);
                }else if (left > 0 ){
                    startButton();
                }
            }
        },fps);
    }

}
