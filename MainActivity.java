package com.technobotik.www.proc;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static ImageButton buttonPlay;
    private ImageButton onoff;
    public TextView example;
    public static int totshow ;

    public double hour;
    public  double minutes;
    AppLockScreen obj = new AppLockScreen();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        TextView para = (TextView) findViewById(R.id.para);
        para.setText("Select the apps you want to stay away from\nThis is the second line\nThird line...");
    */
        if (getftime() == false) {
            AlertDialog.Builder oncreate = new AlertDialog.Builder(MainActivity.this);
            oncreate.setTitle(R.string.dialog);
            oncreate.setMessage(R.string.welcome_message);
            oncreate.setCancelable(false);
            oncreate.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = oncreate.create();
            alertDialog.show();
            ftime(true);

        }




    }


    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        final EditText Hourss = (EditText) findViewById(R.id.Hours);
        final EditText Minutess = (EditText) findViewById(R.id.Minutes);

        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        onoff = (ImageButton) findViewById(R.id.onoff);
        //obj.getemernumber();

        onoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String iput = Hourss.getText().toString().trim();
                String iput2 = Minutess.getText().toString().trim();

                if(iput.isEmpty() || iput.length() == 0 || iput.equals("") || iput == null)
                {
                    //EditText is empty
                     hour = 0;
                }
                else
                {
                    //EditText is not empty
                    hour = Double.valueOf(Hourss.getText().toString());
                }
                if(iput2.isEmpty() || iput2.length() == 0 || iput2.equals("") || iput2 == null)
                {
                    //EditText is empty
                    minutes = 0;
                }
                else
                {
                    //EditText is not empty
                    minutes = Double.valueOf(Minutess.getText().toString());
                }



                AlertDialog.Builder mAlert = new AlertDialog.Builder(MainActivity.this);
                mAlert.setTitle(R.string.alert_title);
                mAlert.setMessage("All your selected app will be locked down for " + hour + " hours and " + minutes + " minutes. And you have " + AppLockScreen.attempts_remaining +" emergency unlock attempts remaining.\nProceed?");
                mAlert.setCancelable(false);
                mAlert.setPositiveButton("Proceed", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        startActivity(new Intent(getBaseContext(),AppLockScreen.class));


                    }

                });
                mAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j){
                        dialogInterface.dismiss();

                    }
                });

                AlertDialog alertDialog = mAlert.create();
                alertDialog.show();



            }

        });

        TextView example = (TextView) findViewById(R.id.example);
        example.setText(R.string.example);


    }

    public void acstart(){

    }


    @Override
    public void onClick(View v) {
        if (v == buttonPlay) {
            //starting game activity
            startActivity(new Intent(this, AppActivity.class));
        }


    }



private void ftime(boolean time){
    SharedPreferences mShare = getSharedPreferences("ttime", MODE_PRIVATE);
    SharedPreferences.Editor mEditor = mShare.edit();
    mEditor.putBoolean("time", time);
    mEditor.apply();

}

    private boolean getftime(){
        SharedPreferences mShare = getSharedPreferences("ttime", MODE_PRIVATE);
        boolean selected = mShare.getBoolean("time", false);
        return selected;

    }



}





