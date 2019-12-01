package edu.iastate.cpre388_small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
            }
        });

        mole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
