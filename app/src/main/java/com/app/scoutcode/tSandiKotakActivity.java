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


public class tSandiKotakActivity extends AppCompatActivity {
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
        RelativeLayout.LayoutParams lp ;

        for (i=0; i<j; i++) {
            ImageView iv = new ImageView(this);
            switch (inp.charAt(i))
            {
                    case 'a':{iv.setImageResource(R.drawable.kotaka); break;}
                    case 'b':{iv.setImageResource(R.drawable.kotakb); break;}
                    case 'c':{iv.setImageResource(R.drawable.kotakd); break;}
                    case 'd':{iv.setImageResource(R.drawable.kotake); break;}
                    case 'e':{iv.setImageResource(R.drawable.kotakg); break;}
                    case 'f':{iv.setImageResource(R.drawable.kotakh); break;}
                    case 'g':{iv.setImageResource(R.drawable.kotakj); break;}
                    case 'h':{iv.setImageResource(R.drawable.kotakk); break;}
                    case 'i':{iv.setImageResource(R.drawable.kotakm); break;}
                    case 'j':{iv.setImageResource(R.drawable.kotakn); break;}
                    case 'k':{iv.setImageResource(R.drawable.kotakp); break;}
                    case 'l':{iv.setImageResource(R.drawable.kotakq); break;}
                    case 'm':{iv.setImageResource(R.drawable.kotaks); break;}
                    case 'n':{iv.setImageResource(R.drawable.kotakt); break;}
                    case 'o':{iv.setImageResource(R.drawable.kotakv); break;}
                    case 'p':{iv.setImageResource(R.drawable.kotakw); break;}
                    case 'q':{iv.setImageResource(R.drawable.kotaky); break;}
                    case 'r':{iv.setImageResource(R.drawable.kotakz); break;}
                    case 's':{iv.setImageResource(R.drawable.kotaks2); break;}
                    case 't':{iv.setImageResource(R.drawable.kotakt2); break;}
                    case 'u':{iv.setImageResource(R.drawable.kotaku2); break;}
                    case 'v':{iv.setImageResource(R.drawable.kotakv2); break;}
                    case 'w':{iv.setImageResource(R.drawable.kotakw2); break;}
                    case 'x':{iv.setImageResource(R.drawable.kotakx2); break;}
                    case 'y':{iv.setImageResource(R.drawable.kotaky2); break;}
                    case 'z':{iv.setImageResource(R.drawable.kotakz2); break;}
                    default: {TextView iv1 = new TextView(this);iv1.setText("    ");txtOutput.addView(iv1);break;}
            }

                txtOutput.addView(iv);


        }


    }

}

