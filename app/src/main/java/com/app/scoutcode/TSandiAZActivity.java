package com.app.scoutcode;


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

public class TSandiAZActivity extends AppCompatActivity {
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
                    outp += "Z";
                    break;
                case 'b':
                    outp += "Y";
                    break;
                case 'c':
                    outp += "X";
                    break;
                case 'd':
                    outp += "W";
                    break;
                case 'e':
                    outp += "V";
                    break;
                case 'f':
                    outp += "U";
                    break;
                case 'g':
                    outp += "T";
                    break;
                case 'h':
                    outp += "S";
                    break;
                case 'i':
                    outp += "R";
                    break;
                case 'j':
                    outp += "Q";
                    break;
                case 'k':
                    outp += "P";
                    break;
                case 'l':
                    outp += "O";
                    break;
                case 'm':
                    outp += "N";
                    break;
                case 'n':
                    outp += "M";
                    break;
                case 'o':
                    outp += "L";
                    break;
                case 'p':
                    outp += "K";
                    break;
                case 'q':
                    outp += "J";
                    break;
                case 'r':
                    outp += "I";
                    break;
                case 's':
                    outp += "H";
                    break;
                case 't':
                    outp += "G";
                    break;
                case 'u':
                    outp += "F";
                    break;
                case 'v':
                    outp += "E";
                    break;
                case 'w':
                    outp += "D";
                    break;
                case 'x':
                    outp += "C";
                    break;
                case 'y':
                    outp += "B";
                    break;
                case 'z':
                    outp += "A";
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
                    case 'Z':{outp +="a"; break;}
                    case 'Y':{outp +="b"; break;}
                    case 'X':{outp +="c"; break;}
                    case 'W':{outp +="d"; break;}
                    case 'V':{outp +="e"; break;}
                    case 'U':{outp +="f"; break;}
                    case 'T':{outp +="g"; break;}
                    case 'S':{outp +="h"; break;}
                    case 'R':{outp +="i"; break;}
                    case 'Q':{outp +="j"; break;}
                    case 'P':{outp +="k"; break;}
                    case 'O':{outp +="l"; break;}
                    case 'N':{outp +="m"; break;}
                    case 'M':{outp +="n"; break;}
                    case 'L':{outp +="o"; break;}
                    case 'K':{outp +="p"; break;}
                    case 'J':{outp +="q"; break;}
                    case 'I':{outp +="r"; break;}
                    case 'H':{outp +="s"; break;}
                    case 'G':{outp +="t"; break;}
                    case 'F':{outp +="u"; break;}
                    case 'E':{outp +="v"; break;}
                    case 'D':{outp +="w"; break;}
                    case 'C':{outp +="x"; break;}
                    case 'B':{outp +="y"; break;}
                    case 'A':{outp +="z"; break;}

                }
            }

            if(!(inp.charAt(i)>='A' && inp.charAt(i)<='Z') && inp.charAt(i)!='-'){
                outp += inp.charAt(i);
            }
        }

        txtOutput.setText(outp);
    }
}
