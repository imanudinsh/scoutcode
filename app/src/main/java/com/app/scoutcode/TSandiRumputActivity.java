package com.app.scoutcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class TSandiRumputActivity extends AppCompatActivity {
    private EditText txtInput;
    private FlowLayout txtOutput;
    private Button btnTranslate;
    String a, b, inp, outp;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsandirumuput);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txtInput = (EditText) findViewById(R.id.txtInput);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teksSandi();

            }
        });

    }



    public void teksSandi(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        txtOutput = (FlowLayout) findViewById(R.id.flowlayout);
        txtOutput.removeAllViews();

        for (i=0; i<j; i++) {

            switch (inp.charAt(i)) {
                case 'a': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);break;
                }
                case 'b': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'c': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'd': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);break;
                }
                case 'e': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);break;
                }
                case 'f': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'g': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);break;
                }
                case 'h': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'i': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);break;
                }
                case 'j': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);break;
                }
                case 'k': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);break;
                }
                case 'l': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'm': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);break;
                }
                case 'n': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);break;
                }
                case 'o': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);break;
                }
                case 'p': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }
                case 'q': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);break;
                }
                case 'r': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);break;
                }
                case 's': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);break;
                }
                case 't': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);break;
                }
                case 'u': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);break;
                }
                case 'v': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);break;
                }
                case 'w': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);break;
                }
                case 'x': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);break;
                }
                case 'y': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);break;
                }
                case 'z': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);break;
                }

                case '0': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);break;
                }
                case '1': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);break;
                }
                case '2': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);break;
                }
                case '3': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);break;
                }
                case '4': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);break;
                }
                case '5': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '6': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '7': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '8': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '9': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '.': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);
                    ImageView iv6 = new ImageView(this);
                    iv6.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv6);break;
                }
                case ';': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv5);
                    ImageView iv6 = new ImageView(this);
                    iv6.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv6);break;
                }
                case ',': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);
                    ImageView iv6 = new ImageView(this);
                    iv6.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv6);break;
                }
                case '\'': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);break;
                }
                case '?': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);
                    ImageView iv6 = new ImageView(this);
                    iv6.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv6);break;
                }
                case ':': {
                    ImageView iv1 = new ImageView(this);
                    iv1.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv1);
                    ImageView iv2 = new ImageView(this);
                    iv2.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv2);
                    ImageView iv3 = new ImageView(this);
                    iv3.setImageResource(R.drawable.strip);
                    txtOutput.addView(iv3);
                    ImageView iv4 = new ImageView(this);
                    iv4.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv4);
                    ImageView iv5 = new ImageView(this);
                    iv5.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv5);
                    ImageView iv6 = new ImageView(this);
                    iv6.setImageResource(R.drawable.titik);
                    txtOutput.addView(iv6);
                    ImageView iv7 = new ImageView(this);
                    iv7.setImageResource(R.drawable.spasi);
                    
                    break;
                }

                default: {
                    TextView iv1 = new TextView(this);
                    iv1.setText("    ");
                    txtOutput.addView(iv1);
                    break;
                }
            }

            if (i != j - 1 && inp.charAt(i) != ' ' && inp.charAt(i + 1) != ' ' && inp.charAt(i + 1) != '\n' && inp.charAt(i) != '\n') {
                ImageView iv7 = new ImageView(this);
                iv7.setImageResource(R.drawable.spasi);
                txtOutput.addView(iv7);
            }

        }


    }

}
