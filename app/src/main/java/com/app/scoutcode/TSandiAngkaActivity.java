package com.app.scoutcode;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class TSandiAngkaActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    private TextView txtDari, txtKe;
    private EditText txtInput, txtOutput;
    private Button btnTranslate;
    String a, b, inp, outp;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsandian);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtDari = (TextView) findViewById(R.id.txtDari);
        txtKe = (TextView) findViewById(R.id.txtKe);
        txtInput = (EditText) findViewById(R.id.txtInput);
        txtOutput = (EditText) findViewById(R.id.txtOutput);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                b = txtDari.getText().toString().toLowerCase();
                if (b.charAt(0) == 't') {
                    teksSandi();
                } else {
                    sandiTeks();
                }

            }
        });

    }



    public void teksSandi(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        for (i=0; i<j; i++){

            switch (inp.charAt(i)) {
                case 'a':
                    outp += "1";
                    break;
                case 'b':
                    outp += "2";
                    break;
                case 'c':
                    outp += "3";
                    break;
                case 'd':
                    outp += "4";
                    break;
                case 'e':
                    outp += "5";
                    break;
                case 'f':
                    outp += "6";
                    break;
                case 'g':
                    outp += "7";
                    break;
                case 'h':
                    outp += "8";
                    break;
                case 'i':
                    outp += "9";
                    break;
                case 'j':
                    outp += "10";
                    break;
                case 'k':
                    outp += "11";
                    break;
                case 'l':
                    outp += "12";
                    break;
                case 'm':
                    outp += "13";
                    break;
                case 'n':
                    outp += "14";
                    break;
                case 'o':
                    outp += "15";
                    break;
                case 'p':
                    outp += "16";
                    break;
                case 'q':
                    outp += "17";
                    break;
                case 'r':
                    outp += "18";
                    break;
                case 's':
                    outp += "19";
                    break;
                case 't':
                    outp += "20";
                    break;
                case 'u':
                    outp += "21";
                    break;
                case 'v':
                    outp += "22";
                    break;
                case 'w':
                    outp += "23";
                    break;
                case 'x':
                    outp += "24";
                    break;
                case 'y':
                    outp += "25";
                    break;
                case 'z':
                    outp += "26";
                    break;
                default:
                    outp += inp.charAt(i);
                    break;
            }

            if(i!=j-1 && inp.charAt(i) != ' ' && inp.charAt(i+1) != ' ')outp+= "-";


        }

        txtOutput.setText(outp);
    }

    public void sandiTeks(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        String x="";
        for (i=0; i<j; i++){
            if(inp.charAt(i)>='0' && inp.charAt(i)<='9'){
                x +=inp.charAt(i);
            }

            if(!(inp.charAt(i)>='0' && inp.charAt(i)<='9') || i==j-1){

                if (x.equals("1")) {
                    outp += "a";
                } else if (x.equals("2")) {
                    outp += "b";
                } else if (x.equals("3")) {
                    outp += "c";
                } else if (x.equals("4")) {
                    outp += "d";
                } else if (x.equals("5")) {
                    outp += "e";
                } else if (x.equals("6")) {
                    outp += "f";
                } else if (x.equals("7")) {
                    outp += "g";
                } else if (x.equals("8")) {
                    outp += "h";
                } else if (x.equals("9")) {
                    outp += "i";
                } else if (x.equals("10")) {
                    outp += "j";
                } else if (x.equals("11")) {
                    outp += "k";
                } else if (x.equals("12")) {
                    outp += "l";
                } else if (x.equals("13")) {
                    outp += "m";
                } else if (x.equals("14")) {
                    outp += "n";
                } else if (x.equals("15")) {
                    outp += "o";
                } else if (x.equals("16")) {
                    outp += "p";
                } else if (x.equals("17")) {
                    outp += "q";
                } else if (x.equals("18")) {
                    outp += "r";
                } else if (x.equals("19")) {
                    outp += "s";
                } else if (x.equals("20")) {
                    outp += "t";
                } else if (x.equals("21")) {
                    outp += "u";
                } else if (x.equals("22")) {
                    outp += "v";
                } else if (x.equals("23")) {
                    outp += "w";
                } else if (x.equals("24")) {
                    outp += "x";
                } else if (x.equals("25")) {
                    outp += "y";
                } else if (x.equals("26")) {
                    outp += "z";
                }
                x="";
                }
                

                if(!(inp.charAt(i)>='0' && inp.charAt(i)<='9') && inp.charAt(i)!='-'){
                    outp +=inp.charAt(i);
                }


        }

        txtOutput.setText(outp);
    }
}
