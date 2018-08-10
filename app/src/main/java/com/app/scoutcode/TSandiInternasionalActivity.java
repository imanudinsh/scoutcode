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

public class TSandiInternasionalActivity extends AppCompatActivity {
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
                case 'a':{outp += "Alpa"; break;}
                case 'b':{outp += "Bravo"; break;}
                case 'c':{outp += "Charlie"; break;}
                case 'd':{outp += "Delta"; break;}
                case 'e':{outp += "Echo"; break;}
                case 'f':{outp += "Foxtrot"; break;}
                case 'g':{outp += "Golf"; break;}
                case 'h':{outp += "Hotel"; break;}
                case 'i':{outp += "Indian"; break;}
                case 'j':{outp += "Juliet"; break;}
                case 'k':{outp += "Kilo"; break;}
                case 'l':{outp += "Lima"; break;}
                case 'm':{outp += "Mike"; break;}
                case 'n':{outp += "November"; break;}
                case 'o':{outp += "Oscar"; break;}
                case 'p':{outp += "Papa"; break;}
                case 'q':{outp += "Quibeck"; break;}
                case 'r':{outp += "Romeo"; break;}
                case 's':{outp += "Sierra"; break;}
                case 't':{outp += "Tanggo"; break;}
                case 'u':{outp += "Uniform"; break;}
                case 'v':{outp += "Victor"; break;}
                case 'w':{outp += "Wishkey"; break;}
                case 'x':{outp += "X-ray"; break;}
                case 'y':{outp += "Yankee"; break;}
                case 'z':{outp += "Zulu"; break;}

                default :{outp += inp.charAt(i); break;}
            }
            if(i!=j-1 && inp.charAt(i) != ' ' && inp.charAt(i+1) != ' ' && inp.charAt(i+1) != '.')outp += " ";
        }

        txtOutput.setText(outp);
    }

    public void sandiTeks(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        String[] parts = inp.split(" ");
        for (String part : parts) {
            switch(part) {
                case "alpa": {
                    outp += "a";
                    break;
                }
                case "bravo": {
                    outp += "b";
                    break;
                }
                case "charlie": {
                    outp += "c";
                    break;
                }
                case "delta": {
                    outp += "d";
                    break;
                }
                case "echo": {
                    outp += "e";
                    break;
                }
                case "foxtrot": {
                    outp += "f";
                    break;
                }
                case "golf": {
                    outp += "g";
                    break;
                }
                case "hotel": {
                    outp += "h";
                    break;
                }
                case "indian": {
                    outp += "i";
                    break;
                }
                case "juliet": {
                    outp += "j";
                    break;
                }
                case "kilo": {
                    outp += "k";
                    break;
                }
                case "lima": {
                    outp += "l";
                    break;
                }
                case "mike": {
                    outp += "m";
                    break;
                }
                case "november": {
                    outp += "n";
                    break;
                }
                case "oscar": {
                    outp += "o";
                    break;
                }
                case "papa": {
                    outp += "p";
                    break;
                }
                case "quibeck": {
                    outp += "q";
                    break;
                }
                case "romeo": {
                    outp += "r";
                    break;
                }
                case "sierra": {
                    outp += "s";
                    break;
                }
                case "tanggo": {
                    outp += "t";
                    break;
                }
                case "uniform": {
                    outp += "u";
                    break;
                }
                case "victor": {
                    outp += "v";
                    break;
                }
                case "wishkey": {
                    outp += "w";
                    break;
                }
                case "x-ray": {
                    outp += "x";
                    break;
                }
                case "yankee": {
                    outp += "y";
                    break;
                }
                case "zulu": {
                    outp += "z";
                    break;
                }
                default: {
                    outp += part;
                    break;
                }
            }

        }

        txtOutput.setText(outp);
    }
}
