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


public class TSandiKotakGandaActivity extends AppCompatActivity {
    private EditText txtInput;
    private RelativeLayout txtOutput;
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
        FlowLayout layout = (FlowLayout) findViewById(R.id.flowlayout);
        layout.removeAllViews();
        RelativeLayout.LayoutParams lp ;

        for (i=0; i<j; i++) {
            ImageView iv = new ImageView(this);
            switch (inp.charAt(i))
            {
                case 'a':{iv.setImageResource(R.drawable.kotaka); break;}
                case 'b':{iv.setImageResource(R.drawable.kotakb); break;}
                case 'c':{iv.setImageResource(R.drawable.kotakc);  break;}
                case 'd':{iv.setImageResource(R.drawable.kotakd); break;}
                case 'e':{iv.setImageResource(R.drawable.kotake); break;}
                case 'f':{iv.setImageResource(R.drawable.kotakf); break;}
                case 'g':{iv.setImageResource(R.drawable.kotakg); break;}
                case 'h':{iv.setImageResource(R.drawable.kotakh); break;}
                case 'i':{iv.setImageResource(R.drawable.kotaki); break;}
                case 'j':{iv.setImageResource(R.drawable.kotakj); break;}
                case 'k':{iv.setImageResource(R.drawable.kotakk); break;}
                case 'l':{iv.setImageResource(R.drawable.kotakl); break;}
                case 'm':{iv.setImageResource(R.drawable.kotakm); break;}
                case 'n':{iv.setImageResource(R.drawable.kotakn); break;}
                case 'o':{iv.setImageResource(R.drawable.kotako); break;}
                case 'p':{iv.setImageResource(R.drawable.kotakp); break;}
                case 'q':{iv.setImageResource(R.drawable.kotakq); break;}
                case 'r':{iv.setImageResource(R.drawable.kotakr); break;}
                case 's':{iv.setImageResource(R.drawable.kotaks); break;}
                case 't':{iv.setImageResource(R.drawable.kotakt); break;}
                case 'u':{iv.setImageResource(R.drawable.kotaku); break;}
                case 'v':{iv.setImageResource(R.drawable.kotakv); break;}
                case 'w':{iv.setImageResource(R.drawable.kotakw); break;}
                case 'x':{iv.setImageResource(R.drawable.kotakx); break;}
                case 'y':{iv.setImageResource(R.drawable.kotaky); break;}
                case 'z':{iv.setImageResource(R.drawable.kotakz); break;}
                default: {TextView iv1 = new TextView(this);iv1.setText("    ");layout.addView(iv1);break;}
            }

            layout.addView(iv);


        }


    }

}

