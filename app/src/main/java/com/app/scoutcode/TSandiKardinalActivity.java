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

public class TSandiKardinalActivity extends AppCompatActivity {
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
        for(i=0; i<j; i++) {
            switch (inp.charAt(i)) {
                case 'a':{outp += "PM"; break;}
                case 'b':{outp += "PE"; break;}
                case 'c':{outp += "PR"; break;}
                case 'd':{outp += "PA"; break;}
                case 'e':{outp += "PH"; break;}
                case 'f':{outp += "UM"; break;}
                case 'g':{outp += "UE"; break;}
                case 'h':{outp += "UR"; break;}
                case 'i':{outp += "UA"; break;}
                case 'j':{outp += "UH"; break;}
                case 'k':{outp += "TM"; break;}
                case 'l':{outp += "TE"; break;}
                case 'm':{outp += "TR"; break;}
                case 'n':{outp += "TA"; break;}
                case 'o':{outp += "TH"; break;}
                case 'p':{outp += "IM"; break;}
                case 'q':{outp += "IE"; break;}
                case 'r':{outp += "IR"; break;}
                case 's':{outp += "IA"; break;}
                case 't':{outp += "IH"; break;}
                case 'u':{outp += "HM"; break;}
                case 'v':{outp += "HE"; break;}
                case 'w':{outp += "HR"; break;}
                case 'x':{outp += "HA"; break;}
                case 'y':{outp += "HH"; break;}
                case 'z':{outp += "H"; break;}

                default :{outp += inp.charAt(i); break;}
            }
            if(i!=j-1 && inp.charAt(i) != ' ' && inp.charAt(i+1) != ' ' && inp.charAt(i+1) != '.')outp += "/";
        }

        txtOutput.setText(outp);
    }

    public void sandiTeks(){
        inp = txtInput.getText().toString().toUpperCase();
        j = inp.length();
        outp = "";
        String x="";
        for (i=0; i<j; i++){

            if(inp.charAt(i)>='A' && inp.charAt(i)<='Z'){
                x +=inp.charAt(i);
            }
            if(!(inp.charAt(i)>='A' && inp.charAt(i)<='Z') || i==j-1){

                switch(x)
                {
                    case "PM":{outp +="a"; break;}
                    case "PE":{outp +="b"; break;}
                    case "PR":{outp +="c"; break;}
                    case "PA":{outp +="d"; break;}
                    case "PH":{outp +="e"; break;}
                    case "UM":{outp +="f"; break;}
                    case "UE":{outp +="g"; break;}
                    case "UR":{outp +="h"; break;}
                    case "UA":{outp +="i"; break;}
                    case "UH":{outp +="j"; break;}
                    case "TM":{outp +="k"; break;}
                    case "TE":{outp +="l"; break;}
                    case "TR":{outp +="m"; break;}
                    case "TA":{outp +="n"; break;}
                    case "TH":{outp +="o"; break;}
                    case "IM":{outp +="p"; break;}
                    case "IE":{outp +="q"; break;}
                    case "IR":{outp +="r"; break;}
                    case "IA":{outp +="s"; break;}
                    case "IH":{outp +="t"; break;}
                    case "HM":{outp +="u"; break;}
                    case "HE":{outp +="v"; break;}
                    case "HR":{outp +="w"; break;}
                    case "HA":{outp +="x"; break;}
                    case "HH":{outp +="y"; break;}
                    case "H":{outp +="z"; break;}

                }
                x="";

            }
            if(!(inp.charAt(i)>='A' && inp.charAt(i)<='Z') && inp.charAt(i)!='/'){
                outp += inp.charAt(i);
            }
        }

        txtOutput.setText(outp);
    }
}
