package com.app.scoutcode;


import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class TMorseActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    private TextView txtDari, txtKe;
    private EditText txtInput, txtOutput;
    private Button btnTranslate;
    private ImageButton btnMute;
    MediaPlayer peluitpanjang;
    MediaPlayer peluitpendek;
    String a, b, inp, outp;
    Boolean mute = false;
    boolean isRunning = false;
    MyCount counter;
    int i, j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmorse);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        peluitpanjang = new MediaPlayer().create(this, R.raw.peluitpanjang);

        peluitpendek = new MediaPlayer().create(this, R.raw.peluitpendek);

        txtDari = (TextView) findViewById(R.id.txtDari);
        txtKe = (TextView) findViewById(R.id.txtKe);
        txtInput = (EditText) findViewById(R.id.txtInput);
        txtOutput = (EditText) findViewById(R.id.txtOutput);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnMute = (ImageButton) findViewById(R.id.btnmute);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                b=txtDari.getText().toString().toLowerCase();
                txtOutput.setText("");
                if(b.charAt(0)=='t') {
                    teksMorse();
                }else{
                    morseTeks();
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

    public void tmute(View v){
        if(mute==false){
            peluitpanjang.setVolume(0,0);
            peluitpendek.setVolume(0,0);
            btnMute.setImageResource(R.drawable.volume_off);
            mute=true;
        }else{
            peluitpanjang.setVolume(1,1);
            peluitpendek.setVolume(1,1);
            btnMute.setImageResource(R.drawable.volume_high);
            mute=false;
        }



    }

    public void teksMorse(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        for (i=0; i<j; i++){

            switch (inp.charAt(i)) {
                case 'a':
                    outp += ".-";
                    break;
                case 'b':
                    outp += "-...";
                    break;
                case 'c':
                    outp += "-.-.";
                    break;
                case 'd':
                    outp += "-..";
                    break;
                case 'e':
                    outp += ".";
                    break;
                case 'f':
                    outp += "..-.";
                    break;
                case 'g':
                    outp += "--.";
                    break;
                case 'h':
                    outp += "....";
                    break;
                case 'i':
                    outp += "..";
                    break;
                case 'j':
                    outp += ".---";
                    break;
                case 'k':
                    outp += "-.-";
                    break;
                case 'l':
                    outp += ".-..";
                    break;
                case 'm':
                    outp += "--";
                    break;
                case 'n':
                    outp += "-.";
                    break;
                case 'o':
                    outp += "---";
                    break;
                case 'p':
                    outp += ".--.";
                    break;
                case 'q':
                    outp += "--.-";
                    break;
                case 'r':
                    outp += ".-.";
                    break;
                case 's':
                    outp += "...";
                    break;
                case 't':
                    outp += "-";
                    break;
                case 'u':
                    outp += "..-";
                    break;
                case 'v':
                    outp += "...-";
                    break;
                case 'w':
                    outp += ".--";
                    break;
                case 'x':
                    outp += "-..-";
                    break;
                case 'y':
                    outp += "-.--";
                    break;
                case 'z':
                    outp += "--..";
                    break;
                case '0':
                    outp += "-----";
                    break;
                case '1':
                    outp += ".----";
                    break;
                case '2':
                    outp += "..---";
                    break;
                case '3':
                    outp += "...--";
                    break;
                case '4':
                    outp += "....-";
                    break;
                case '5':
                    outp += ".....";
                    break;
                case '6':
                    outp += "-....";
                    break;
                case '7':
                    outp += "--...";
                    break;
                case '8':
                    outp += "---..";
                    break;
                case '9':
                    outp += "----.";
                    break;
                case '.':
                    outp += "......";
                    break;
                case ';':
                    outp += "-.-.-.";
                    break;
                case ',':
                    outp += ".-.-.-";
                    break;
                case '"':
                    outp += ".---.";
                    break;
                case '?':
                    outp += "..--..";
                    break;
                case ':':
                    outp += "---...";
                    break;
                default:
                    outp += inp.charAt(i);
                    break;
            }

            if(i!=j-1 && inp.charAt(i) != ' ' && inp.charAt(i+1) != ' ')outp+= "/";


        }


        counter= new MyCount(1000,outp);
        counter.start();
        //txtOutput.setText(outp);
    }

    public void morseTeks(){
        inp = txtInput.getText().toString().toLowerCase();
        j = inp.length();
        outp = "";
        String x="";
        for (i=0; i<j; i++){
            if(inp.charAt(i)=='.' || inp.charAt(i)=='-'){
                x +=inp.charAt(i);
            }

            if(!(inp.charAt(i)=='.' || inp.charAt(i)=='-') || i==j-1){

                if (x.equals(".-")) {
                    outp += "a";
                } else if (x.equals("-...")) {
                    outp += "b";
                } else if (x.equals("-.-.")) {
                    outp += "c";
                } else if (x.equals("-..")) {
                    outp += "d";
                } else if (x.equals(".")) {
                    outp += "e";
                } else if (x.equals("..-.")) {
                    outp += "f";
                } else if (x.equals("--.")) {
                    outp += "g";
                } else if (x.equals("....")) {
                    outp += "h";
                } else if (x.equals("..")) {
                    outp += "i";
                } else if (x.equals(".---")) {
                    outp += "j";
                } else if (x.equals("-.-")) {
                    outp += "k";
                } else if (x.equals(".-..")) {
                    outp += "l";
                } else if (x.equals("--")) {
                    outp += "m";
                } else if (x.equals("-.")) {
                    outp += "n";
                } else if (x.equals("---")) {
                    outp += "o";
                } else if (x.equals(".--.")) {
                    outp += "p";
                } else if (x.equals("--.-")) {
                    outp += "q";
                } else if (x.equals(".-.")) {
                    outp += "r";
                } else if (x.equals("...")) {
                    outp += "s";
                } else if (x.equals("-")) {
                    outp += "t";
                } else if (x.equals("..-")) {
                    outp += "u";
                } else if (x.equals("...-")) {
                    outp += "v";
                } else if (x.equals(".--")) {
                    outp += "w";
                } else if (x.equals("-..-")) {
                    outp += "x";
                } else if (x.equals("-.--")) {
                    outp += "y";
                } else if (x.equals("--..")) {
                    outp += "z";
                } else if (x.equals("-----")) {
                    outp += "0";
                } else if (x.equals(".----")) {
                    outp += "1";
                } else if (x.equals("..---")) {
                    outp += "2";
                } else if (x.equals("...--")) {
                    outp += "3";
                } else if (x.equals("....-")) {
                    outp += "4";
                } else if (x.equals(".....")) {
                    outp += "5";
                } else if (x.equals("-....")) {
                    outp += "6";
                } else if (x.equals("--...")) {
                    outp += "7";
                } else if (x.equals("---..")) {
                    outp += "8";
                } else if (x.equals("----.")) {
                    outp += "9";
                } else if (x.equals("......")) {
                    outp += ".";
                } else if (x.equals("-.-.-.")) {
                    outp += ";";
                } else if (x.equals(".-.-.-")) {
                    outp += ",";
                } else if (x.equals(".---.")) {
                    outp += '"';
                } else if (x.equals("..--..")) {
                    outp += "?";
                } else if (x.equals("---...")) {
                    outp += ":";
                }
                x="";
                if(inp.charAt(i) !='/' && inp.charAt(i) !='-'  && inp.charAt(i) !='.'){
                    outp +=inp.charAt(i);
                }

            }
        }

        txtOutput.setText(outp);
    }

    public class MyCount extends CountDownTimer
    {
        String teks;
        int i = 0;
        public MyCount( long countDownInterval, String txt)
        {
            super((txt.length()+1)*1000 , countDownInterval);
            this.teks = txt;
        }

        public void onFinish()
        {
            isRunning= false;

        }

        public void onTick(long millisUntilFinished)
        {
            isRunning = true;
            String outp2 = txtOutput.getText().toString();
            if(peluitpanjang.isPlaying())
            {
                peluitpanjang.stop();
            }else if(peluitpendek.isPlaying())
            {
                peluitpendek.stop();
            }

            switch (teks.charAt(i)){
                case '.' :
                    txtOutput.setText(outp2 + ".");
                    peluitpendek.start();
                    break;

                case '-' :
                    txtOutput.setText(outp2 +"-");

                    peluitpanjang.start();

                    break;

                default:
                    txtOutput.setText(outp2 + teks.charAt(i));
                    break;
            }



            i++;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isRunning) counter.cancel();
    }
}
