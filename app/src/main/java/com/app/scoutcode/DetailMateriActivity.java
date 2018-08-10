package com.app.scoutcode;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.HashMap;


public class DetailMateriActivity extends AppCompatActivity {
    private Toolbar toolbar;
    LinearLayout materiView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblatihan);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9385526466975115~6049629388");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        String jmateri = getIntent().getExtras().getString("jmateri");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materiView = (LinearLayout) findViewById(R.id.materiview);
        loadMateri(jmateri);
    }

    public void loadMateri(String jmateri){
        switch (jmateri) {
            case "Semaphore": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Semaphore adalah cara pengiriman informasi jarak jauh secara visual (<i>Optical Telegraph</i>) menggunakan kombinasi kedua belah tangan. Agar mudah dilihat, pengirim isyarat Semaphore biasanya memegang benda seperti bendera, dayung, atau benda lain yang mencolok. Bisa juga dilakukan dengan tangan kosong atau sarung tangan yang berwarna kontras dengan latar belakang. Apabila pengiriman berita dilakukan saat malam hari, pengirim memegang benda yang bercahaya seperti lampu senter, lampu tongkat atau semacamnya. Informasi yang dikirimkan berupa huruf huruf yang dibentuk oleh kombinasi kedua belah tangan pengirim.</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_semaphore);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp; </body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");

                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
            case "Morse": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Kode Morse adalah cara pengiriman informasi berupa huruf, angka, tanda baca dan sinyal dalam bentuk titik dan garis. Kode ini diciptakan oleh Samuel F. B. Morse dan Alfred Vail pada tahun 1836. Hingga saat ini kode Morse tetap populer di kalangan pengguna radio amatir. Penggunaan paling terkenal adalah untuk mengirimkan sinyal darurat \"SOS\" . SOS bukan sebuah singkatan, tetapi dipilih karena mudah dikirim dengan kode Morse, 3 titik - 3 garis - 3 titik. <br><br>" +
                        "\tSejak 1836, Fisikawan asal Amerika Serikat Samuel F. B. Morse dan Alfred Vail mengembangkan sebuah telegrap elektrik. Telegrap ini mengirimkan sinyal arus listrik melalui kabel yang dihubungkan dari pengirim ke penerima. Untuk itu, ia perlu mengembangkan sebuah kode agar sinyal tersebut dapat diartikan menjadi huruf. Dari kebutuhan inilah Morse mengembangkan kode Morse yang menjadi dasar kode Morse moderen yang dipakai saat ini secara internasional.  <br><br>" +
                        "\tKode Morse mulai dikembangkan, sehinga operator penerima pesan dapat menerjemahkan pola pada pita kertas menjadi rangkaian huruf. Awalnya, Morse hanya direncanakan untuk mengirimkan angka saja dan dari kombinasi angka-angka tersebut diterjemahkan menjadi huruf menggunakan buku manual. Tetapi, selanjutnya kode tersebut dikembangkan oleh Alfred Vail dengan memasukkan kode untuk huruf, sehingga lebih mudah penggunaannya. Vail meneliti frekuensi penggunaan (sering atau jarang) tiap huruf dalam alfabet berdasarkan huruf-huruf yang digunakan untuk mencetak sebuah surat kabar di Morristown. Huruf yang paling sering digunakan sengaja dirancang dengan kombinasi titik dan garis sependek mungkin. Itulah kenapa pola huruf dalam kode Morse dibuat tidak urut abjad.</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1,"text/html","utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_morse);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp; </body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");

                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
            case "Sandi Rumput": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi rumput merupakan pengembangan Morse, yang memiliki kunci titik (.) digambarkan sebagai rumput pendek, sedangkan strip (-) digambarkan sebagai rumput tinggi.\n" +
                                "<br><br>Contoh:<br>" +
                                "PRAMUKA = (P).--. (R).-. (A).- (M)- - (U)..- (K)-.- (A).-\n</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_srumput);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp; </body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");

                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
            case "Sandi Kotak": {

                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi kotak memiliki kunci sebagai berikut:</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");
                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_skotak1);


                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi ini terdiri dari palang-palang atau kotak dan sudut-sudut, untuk membedakan antara kedua huruf tiap kotak maka huruf kedua diberi tanda titik.\n" +
                                "<br>Contoh :\n</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");

                ImageView iv2 = new ImageView(this);
                iv2.setImageResource(R.drawable.materi_skotak2);


                String materi3 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Jawaban : PRAMUKA <br><br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang <br><br><br>&nbsp;</body>]]>"));
                WebView web3 =new WebView(this);
                web3.setVerticalScrollBarEnabled(false);
                web3.loadData(materi3, "text/html", "utf-8");


                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                materiView.addView(iv2);
                materiView.addView(web3);
                break;
            }
            case "Sandi Kotak Ganda": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi kotak ganda memiliki kunci sebagai berikut:</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_skotakganda1);


                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi ini terdiri dari kotak-kotak saja tanpa sudut-sudut, untuk membedakan antara ketiga huruf tiap kotak maka huruf kedua diberi satu tanda titik dan huruf ketiga diberi tiga tanda titik.\n" +
                                "<br><br>Contoh :\n</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");

                ImageView iv2 = new ImageView(this);
                iv2.setImageResource(R.drawable.materi_skotakganda2);

                String materi3 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Jawaban : PRAMUKA<br><br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp;</body>]]>"));
                WebView web3 =new WebView(this);
                web3.setVerticalScrollBarEnabled(false);
                web3.loadData(materi3, "text/html", "utf-8");

                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                materiView.addView(iv2);
                materiView.addView(web3);
                break;
            }
            case "Sandi Angka": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi angka memiliki kunci sebagai berikut:<br>" +
                                "A=1 B=2 C=3 D=4 E=5 F=6 G=7 H=8 I=9 J=10 K=11 L=12 M=13 N=14 O=15 P=16 Q=17 R=18 S=19 T=20 U=21 V=22 W=23 X=24 Y=25 X=26<br>" +
                                "<BR>Sandi ini mengganti huruf menjadi angka, dimulai dari huruf A diubah menjadi angka 1 hingga huruf Z menjadi angka 26.<br>" +
                                "<br><br>Contoh : PRAMUKA = 16-18-1-13-21-11-1<br><br><br>Sumber : Panduan Resmi Pramuka<br><br><br>&nbsp;\n" +
                                "</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");
                materiView.addView(web1);
                break;
            }
            case "Sandi AN": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi AN memiliki kunci sebagai berikut:</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_san);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi ini dapat dipecahkan dengan cara tulis hurf A sampai dengan huruf M didalam sebuah tabel. Kedua, dibawah setiap huruf dari A sampai M ditulis huruf N sampai dengan huruf Z, tulis setiap huruf persis dibawah huruf yang berada di atasnya sesuai urutan. Untuk membuat atau memecahkan sandi, ganti setiap huruf dalam sebuah kata dengan huruf yang berada di atas huruf aslinya, begitu pula sebaliknya. Jika huruf aslinya ada di atas, cari penggantinya di bawah. Dan jika huruf aslinya di bawah, cari penggantinya di bawah. Tanda baca ataupun angka, tidak berubah.<br>" +
                                " <br>Contoh : <br>" +
                                "PRAMUKA = CENZHXN<br><br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp;</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");
                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
            case "Sandi AZ": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi AZ memiliki kunci sebagai berikut:</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_saz);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi ini dapat dipecahkan dengan cara tulis hurf A sampai dengan huruf M dalam sebuah tabel. Kemudian dibawah setiap huruf dari A sampai M ditulis huruf Z sampai dengan huruf N, tulis setiap huruf persis dibawah huruf yang berada di atasnya sesuai urutan. Untuk membuat atau memecahkan sandi, ganti setiap huruf dalam sebuah kata dengan huruf yang berada di atas huruf aslinya, begitu pula sebaliknya. Jika huruf aslinya ada di atas, cari penggantinya di bawah. Dan jika huruf aslinya di bawah, cari penggantinya di bawah.\n" +
                                "<br><br>Contoh :<br>" +
                                "PRAMUKA = KIZNFPZ\n<br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br>&nbsp;</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");
                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
            case "Sandi Kardinal": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Sandi Kardinal/Koordinat memiliki kunci sebagai berikut:</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_skardinal);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Kata Merah Putih bisa diganti dengan kata apapun yang jumlah hurufnya sama antara atas dan sampingnya (5 - 5).\n" +
                                "<br><br>Contoh :<br>" +
                                "PRAMUKA = IM-IR-PM-TR-HM-TM-PM\n<br><br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br>&nbsp;</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");
                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }

            case "Sandi Internasional": {
                String materi1 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Abjad Telekomunikasi Internasional adalah abjad yang digunakan untuk berkomunikasi dengan orang yang berbeda bahasa. Karena biasanya akan terjadi kesulitan (kurang dapat mendeskripsikan secara jelas) untuk mengartikan kata apa yang diucapkan oleh saudara kita dari negara lain tersebut. Dengan Abjad Internasional inilah yang dapat membantu agar berita yang disampaikan dapat diterima dengan jelas dan dapat dimengerti oleh kedua belah pihak.</body>]]>"));
                WebView web1 =new WebView(this);
                web1.setVerticalScrollBarEnabled(false);
                web1.loadData(materi1, "text/html", "utf-8");

                ImageView iv1 = new ImageView(this);
                iv1.setImageResource(R.drawable.materi_sinternasional);

                String materi2 = String.valueOf(Html
                        .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222;\">Contoh :<br>" +
                                "<b>B</b>ravo <b>O</b>scar <b>Y</b>ankey <b>S</b>ierra <b>C</b>harlie <b>O</b>scar <b>U</b>nion <b>T</b>ango <br>" +
                                "Dibaca: BOY SCOUT\n<br><br><br>Sumber : Ensiklopedia Penggalang - Materi Kepramukaan Lengkap untuk Penggalang<br><br><br><br>&nbsp;&nbsp;</body>]]>"));
                WebView web2 =new WebView(this);
                web2.setVerticalScrollBarEnabled(false);
                web2.loadData(materi2, "text/html", "utf-8");
                materiView.addView(web1);
                materiView.addView(iv1);
                materiView.addView(web2);
                break;
            }
        }
    }


}