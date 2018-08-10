package com.app.scoutcode;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class TSemaphoreActivity extends AppCompatActivity {
    public String tinput;
    private EditText txtInput;
    private ImageView imgSem;
    private Button bTranslate;
    private Button btnPause;
    private Button btnResume;
    private Button btnStop;
    MyCount counter;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsemaphore);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        txtInput = (EditText) findViewById(R.id.txtInput);
        imgSem = (ImageView) findViewById(R.id.imgSem);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bTranslate = (Button) findViewById(R.id.btnTranslate);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnResume = (Button) findViewById(R.id.btnResume);
        btnStop = (Button) findViewById(R.id.btnStop);


        bTranslate.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                btnPause.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                bTranslate.setVisibility(View.INVISIBLE);
                tinput = txtInput.getText().toString().toLowerCase();
                i=0;
                int j = (tinput.length()+1)*1000;
                counter= new MyCount(j,1000);
                counter.start();


            }
        });


    }

    public void aksiRunning(View v)
    {
        switch(v.getId())
        {
            case R.id.btnPause:
                btnPause.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.VISIBLE);
                counter.cancel();
                break;
            case R.id.btnStop:
                btnPause.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
                bTranslate.setVisibility(View.VISIBLE);
                imgSem.setImageResource(R.drawable.sem_awal);
                counter.cancel();
                break;
            case R.id.btnResume:
                btnPause.setVisibility(View.VISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
                int j = (tinput.length()+1-i)*1000;
                counter= new MyCount(j,1000);
                counter.start();
        }
    }

    public class MyCount extends CountDownTimer
    {

        public MyCount(long millisInFuture, long countDownInterval)
        {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish()
        {

            imgSem.setImageResource(R.drawable.sem_awal);
            btnPause.setVisibility(View.INVISIBLE);
            btnStop.setVisibility(View.INVISIBLE);
            btnResume.setVisibility(View.INVISIBLE);
            bTranslate.setVisibility(View.VISIBLE);
        }

        public void onTick(long millisUntilFinished)
        {

            switch (tinput.charAt(i)){
                case 'a' : imgSem.setImageResource(R.drawable.sem_a);
                    break;

                case 'b' : imgSem.setImageResource(R.drawable.sem_b);
                    break;

                case 'c' : imgSem.setImageResource(R.drawable.sem_c);
                    break;

                case 'd' : imgSem.setImageResource(R.drawable.sem_d);
                    break;

                case 'e' : imgSem.setImageResource(R.drawable.sem_e);
                    break;

                case 'f' : imgSem.setImageResource(R.drawable.sem_f);
                    break;

                case 'g' : imgSem.setImageResource(R.drawable.sem_g);
                    break;

                case 'h' : imgSem.setImageResource(R.drawable.sem_h);
                    break;

                case 'i' : imgSem.setImageResource(R.drawable.sem_i);
                    break;

                case 'j' : imgSem.setImageResource(R.drawable.sem_j);
                    break;

                case 'k' : imgSem.setImageResource(R.drawable.sem_k);
                    break;

                case 'l' : imgSem.setImageResource(R.drawable.sem_l);
                    break;

                case 'm' : imgSem.setImageResource(R.drawable.sem_m);
                    break;

                case 'n' : imgSem.setImageResource(R.drawable.sem_n);
                    break;

                case 'o' : imgSem.setImageResource(R.drawable.sem_o);
                    break;

                case 'p' : imgSem.setImageResource(R.drawable.sem_p);
                    break;

                case 'q' : imgSem.setImageResource(R.drawable.sem_q);
                    break;

                case 'r' : imgSem.setImageResource(R.drawable.sem_r);
                    break;

                case 's' : imgSem.setImageResource(R.drawable.sem_s);
                    break;

                case 't' : imgSem.setImageResource(R.drawable.sem_t);
                    break;

                case 'u' : imgSem.setImageResource(R.drawable.sem_u);
                    break;

                case 'v' : imgSem.setImageResource(R.drawable.sem_v);
                    break;

                case 'w' : imgSem.setImageResource(R.drawable.sem_w);
                    break;

                case 'x' : imgSem.setImageResource(R.drawable.sem_x);
                    break;

                case 'y' : imgSem.setImageResource(R.drawable.sem_y);
                    break;

                case 'z' : imgSem.setImageResource(R.drawable.sem_z);
                    break;

                default: imgSem.setImageResource(R.drawable.sem_awal);
                    break;
            }
            i++;
        }
    }


}
