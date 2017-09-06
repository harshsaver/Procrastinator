package com.technobotik.www.proc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout myappact = new RelativeLayout(this);
        myappact.setBackgroundColor(Color.DKGRAY);
        setContentView(myappact);
    }
}
