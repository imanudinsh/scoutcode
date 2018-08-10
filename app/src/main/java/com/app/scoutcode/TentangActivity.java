package com.app.scoutcode;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class TentangActivity extends AppCompatActivity {
    public WebView konten, konten2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        konten = (WebView) findViewById(R.id.konten);
        String materi1 = String.valueOf(Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#686868;font-size:13px\"><br><h3>Salam Pramuka !</h3>Scout Code merupakan sebuah media pembelajaran elektronik tentang Semaphore, Morse dan Sandi - sandi dalam pramuka. Anda dapat melatih ketrampilan tentang Semaphore, Morse dan Sandi - sandi Pramuka dengan aplikasi ini. </body>]]>"));
        konten.setVerticalScrollBarEnabled(false);
        konten.loadData(materi1, "text/html", "utf-8");

        konten2 = (WebView) findViewById(R.id.konten2);
        String txtknten = String.valueOf(Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#686868;font-size:13px\">Penggunaan aplikasi : <br><br>Menu <b>Materi</b> berisikan materi pembelajaran dan penjelasan mengenai sandi pramuka.<br>Menu Translator berisikan fitur untuk menterjemahkan teks ke sandi, atau dari sandi ke teks, untuk beberapa sandi hanya bisa menterjemahkan teks ke sandi saja," +
                        " dan untuk Morse fiturnya dilengkapi dengan suara peluit. <br>Menu <b>Latihan</b> digunakan untuk mengasah kemampuan sandi pramuka, setiap latihan dilengkapi lima level, untuk beranjak ke level berikutnya harus mampu mendapatkan skor 80 terlebih dahulu, fitur <b>Latihan</b> hanya dapat digunakan setelah <b>Login</b>.<br>" +
                        "Untuk Masuk atau Mendaftarkan akun dapat dilakukan di Menu <b>Login</b>, manfaat setelah login adalah setiap kali mengerjakan latihan maka skor akan disimpan dan dapat dilihat di Menu Grade, " +
                        "hal tersebut berguna untuk memonitoring kemampuan dan rekam jejak selama melakukan latihan di aplikasi <b>SCOUT CODE</b>." +
                        "<br><br><br><h3>Our Team </h3> </body>]]>"));
        konten2.setVerticalScrollBarEnabled(false);
        konten2.loadData(txtknten, "text/html", "utf-8");
    }





}
