package com.technobotik.www.proc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AppLockScreen extends AppCompatActivity {


    static ImageButton emergency;
    public static int emergency_unlock = 2;
    public static int attempts_remaining;
    public static int sow = 0;




    /*public AppLockScreen() {
    yes();
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock_screen);

        activ();

       }

    @Override
    protected void onResume(){
        super.onResume();



    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    public void emernumber(int emergency2){
        SharedPreferences e_num = getSharedPreferences("emergency" , Context.MODE_PRIVATE);
        SharedPreferences.Editor e_change = e_num.edit();
        e_change.putInt("emergency2", emergency2);
        e_change.apply();

    }

    public int getemernumber(){
        SharedPreferences e_num = getSharedPreferences("emergency" , Context.MODE_PRIVATE);
        attempts_remaining = e_num.getInt("emergency2", emergency_unlock);
        return attempts_remaining;

    }


    protected void activ(){
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (getemernumber() > 0) {

                    Toast emer = Toast.makeText(getApplicationContext(), "Emergency attempt successful!", Toast.LENGTH_SHORT);
                    emer.show();
                    emernumber(--emergency_unlock);

                }
                else if ( getemernumber() == 0) {
                    Toast noemer = Toast.makeText(getApplicationContext(), "No emergency attempts left!", Toast.LENGTH_SHORT);
                    noemer.show();

                }

            }
        });

    }

}



