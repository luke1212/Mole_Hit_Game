package edu.iastate.cpre388_small_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    ImageView mole1,mole2,mole3,mole4;

    TextView time_left, score, tv_high_score;

    EditText editText;

    Button button, save;

    int user_score = 0, fps = 1000, left = 5, tempifleft = 0, high_score = 0;

    int which = 0, whichsave = 0;

    String highScoreUserInfo = "";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String INTEGER = "integer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        button = (Button) findViewById(R.id.button);
        save  = (Button) findViewById(R.id.save);

        editText = (EditText) findViewById(R.id.edit_text);

        time_left = (TextView) findViewById(R.id.time_left);
        score = (TextView) findViewById(R.id.score);
        tv_high_score = (TextView) findViewById(R.id.highScore);

        mole1 = (ImageView) findViewById(R.id.mole1);
        mole2 = (ImageView) findViewById(R.id.mole2);
        mole3 = (ImageView) findViewById(R.id.mole3);
        mole4 = (ImageView) findViewById(R.id.mole4);

        mole1.setVisibility(View.INVISIBLE);
        mole2.setVisibility(View.INVISIBLE);
        mole3.setVisibility(View.INVISIBLE);
        mole4.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highScoreUserInfo = "High Score: " + editText.getText().toString() + high_score;
                tv_high_score.setText(highScoreUserInfo);
                saveData();
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

        loadData();
        updateViews();
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
                    if(user_score > high_score){
                        highScoreUserInfo = "";
                        high_score = user_score;
                        editText.setVisibility(View.VISIBLE);
                        save.setVisibility(View.VISIBLE);
                    }
                    button.setEnabled(true);
                }else if (left > 0 ){
                    startButton();
                }
            }
        },fps);
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();

        editor.putString(TEXT,highScoreUserInfo);
        editor.putInt(INTEGER,high_score);
        editor.apply();
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
        editText.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highScoreUserInfo = sharedPreferences.getString(TEXT,"") ;
        high_score = sharedPreferences.getInt(INTEGER,0);
    }

    public void updateViews(){
        tv_high_score.setText(highScoreUserInfo);
    }
}
