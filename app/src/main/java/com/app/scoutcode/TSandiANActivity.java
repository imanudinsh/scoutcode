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

public class TSandiANActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    private TextView txtDari, txtKe;
    private EditText txtInput, txtOutput;
    private Button btnTranslate;
    String a, b, inp, outp;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsandiangka);

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

    public void tChange(View v){
        a = txtDari.getText().toString();
        b = txtKe.getText().toString();
        txtDari.setText(b);
        txtKe.setText(a);

    }

    public void teksSandi(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        for (i=0; i<j; i++){

            switch (inp.charAt(i)) {
                case 'a':
                    outp += "N";
                    break;
                case 'b':
                    outp += "O";
                    break;
                case 'c':
                    outp += "P";
                    break;
                case 'd':
                    outp += "Q";
                    break;
                case 'e':
                    outp += "R";
                    break;
                case 'f':
                    outp += "S";
                    break;
                case 'g':
                    outp += "T";
                    break;
                case 'h':
                    outp += "U";
                    break;
                case 'i':
                    outp += "V";
                    break;
                case 'j':
                    outp += "W";
                    break;
                case 'k':
                    outp += "X";
                    break;
                case 'l':
                    outp += "Y";
                    break;
                case 'm':
                    outp += "Z";
                    break;
                case 'n':
                    outp += "A";
                    break;
                case 'o':
                    outp += "B";
                    break;
                case 'p':
                    outp += "C";
                    break;
                case 'q':
                    outp += "D";
                    break;
                case 'r':
                    outp += "E";
                    break;
                case 's':
                    outp += "F";
                    break;
                case 't':
                    outp += "G";
                    break;
                case 'u':
                    outp += "H";
                    break;
                case 'v':
                    outp += "I";
                    break;
                case 'w':
                    outp += "J";
                    break;
                case 'x':
                    outp += "K";
                    break;
                case 'y':
                    outp += "L";
                    break;
                case 'z':
                    outp += "M";
                    break;
                default:
                    outp += inp.charAt(i);
                    break;
            }

            if(i!=j-1 && inp.charAt(i) != ' ' && inp.charAt(i+1) != ' ' && inp.charAt(i+1) != '.')outp+= "-";


        }

        txtOutput.setText(outp);
    }

    public void sandiTeks(){
        inp = txtInput.getText().toString().toUpperCase();
        j = inp.length();
        outp = "";
        for (i=0; i<j; i++){

            if(inp.charAt(i)>='A' && inp.charAt(i)<='Z'){
                switch(inp.charAt(i))
                {
                    case 'N':{outp +="a"; break;}
                    case 'O':{outp +="b"; break;}
                    case 'P':{outp +="c"; break;}
                    case 'Q':{outp +="d"; break;}
                    case 'R':{outp +="e"; break;}
                    case 'S':{outp +="f"; break;}
                    case 'T':{outp +="g"; break;}
                    case 'U':{outp +="h"; break;}
                    case 'V':{outp +="i"; break;}
                    case 'W':{outp +="j"; break;}
                    case 'X':{outp +="k"; break;}
                    case 'Y':{outp +="l"; break;}
                    case 'Z':{outp +="m"; break;}
                    case 'A':{outp +="n"; break;}
                    case 'B':{outp +="o"; break;}
                    case 'C':{outp +="p"; break;}
                    case 'D':{outp +="q"; break;}
                    case 'E':{outp +="r"; break;}
                    case 'F':{outp +="s"; break;}
                    case 'G':{outp +="t"; break;}
                    case 'H':{outp +="u"; break;}
                    case 'I':{outp +="v"; break;}
                    case 'J':{outp +="w"; break;}
                    case 'K':{outp +="x"; break;}
                    case 'L':{outp +="y"; break;}
                    case 'M':{outp +="z"; break;}

                }
            }

            if(!(inp.charAt(i)>='A' && inp.charAt(i)<='Z') && inp.charAt(i)!='-'){
                outp += inp.charAt(i);
            }
        }

        txtOutput.setText(outp);
    }
}

