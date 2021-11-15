package com.example.chanel.swipegestures;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.GestureDetector.*;

public class MainActivity extends AppCompatActivity {

    float x1,x2;
    float y1, y2;
    float diffx, diffy;
    TextView txtmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmsg=(TextView) findViewById(R.id.TextViewmsg);

        gestureDetectorCompat = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float angle = (float) Math.toDegrees(Math.atan2(e1.getY() - e2.getY(), e2.getX() - e1.getX()));

                if (angle > -45 && angle <= 45) {
                   txtmsg.setText("Left to Right swipe performed");
                    return true;
                }

                if (angle >= 135 && angle < 180 || angle < -135 && angle > -180) {
                    txtmsg.setText("Right to Left swipe performed");

                    return true;
                }

                if (angle < -45 && angle >= -135) {
                    txtmsg.setText( "Up to Down swipe performed");
                    return true;
                }

                if (angle > 45 && angle <= 135) {
                    txtmsg.setText(  "Down to Up swipe performed");
                    return true;
                }

                return false;
            }


        });



    }

    GestureDetectorCompat gestureDetectorCompat;
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }



}
