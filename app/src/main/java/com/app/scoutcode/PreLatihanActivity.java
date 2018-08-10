package com.app.scoutcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

public class PreLatihanActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    private TextView txtpre;
    private Button btnMulai;
    String jenis;
    String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelatihan);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("jlatihan"));

        txtpre = (TextView) findViewById(R.id.txtpre);
        btnMulai = (Button) findViewById(R.id.btnMulai);


        inisilLatihan();

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent i = new Intent(v.getContext(),
                        KerjakanLatihanActivity.class);
                i.putExtra("jenis", getIntent().getExtras().getString("jlatihan"));
                v.getContext().startActivity(i);
            }
        });

    }
    
    public void inisilLatihan(){

        String[] parts = getIntent().getExtras().getString("jlatihan").split(" ");

        switch (parts[0]) {
            case "Semaphore":
                jenis = "1";
                level = parts[1];
                break;

            case "Morse":
                jenis = "2";
                level = parts[1];
                break;

            default:

                if(parts[1].equals("Rumput")){
                    jenis = "3";
                    level = parts[2];
                }else if(parts[1].equals("Angka")){
                    jenis = "6";
                    level = parts[2];
                }else if(parts[1].equals("AN")){
                    jenis = "7";
                    level = parts[2];
                }else if(parts[1].equals("AZ")){
                    jenis = "8";
                    level = parts[2];
                }else if(parts[1].equals("Kardinal")){
                    jenis = "9";
                    level = parts[2];
                }else{
                    if(parts[2].equals("Ganda")){
                        jenis = "5";
                        level = parts[3];
                    }else {
                        jenis = "4";
                        level = parts[2];

                    }
                }

                break;
        }

        switch(level){
            case "1" :
                if(jenis=="1"){
                    txtpre.setText("Terjemahkan Semaphore berikut dengan memilih salah satu jawaban yang dianggap benar !");
                }else if(jenis=="2"){
                    txtpre.setText("Terjemahkan Morse berikut dengan memilih salah satu jawaban yang dianggap benar !");
                }else {
                    txtpre.setText("Terjemahkan sandi berikut dengan memilih salah satu jawaban yang dianggap benar !");
                }
                break;
            case "2" : if(jenis=="1"){
                txtpre.setText("Terjemahkan huruf berikut menjadi Semaphore dengan memilih salah satu jawaban yang dianggap benar !");
                }else if(jenis=="2"){
                txtpre.setText("Terjemahkan huruf berikut menjadi sandi dengan memilih salah satu jawaban yang dianggap benar !");
                }else {
                    txtpre.setText("Terjemahkan huruf berikut menjadi sandi dengan memilih salah satu jawaban yang dianggap benar !");
                }
                break;
            case "3" : if(jenis=="1"){
                    txtpre.setText("Terjemahkan Semaphore berikut dengan mengisikan jawaban pada kolom yang tersedia !");
                }else if(jenis=="2"){
                    txtpre.setText("Terjemahkan Morse berikut dengan mengisikan jawaban pada kolom yang tersedia !");
                }else {
                    txtpre.setText("Terjemahkan sandi berikut dengan mengisikan jawaban pada kolom yang tersedia !");
                }
                break;
            case "4" : if(jenis=="1"){
                    txtpre.setText("Jawablah lawan kata (antonim) dari Semaphore berikut !");
                }else if(jenis=="2"){
                    txtpre.setText("Jawablah lawan kata (antonim) dari Morse berikut !");
                }else {
                    txtpre.setText("Jawablah lawan kata (antonim) dari Sandi berikut !");
                }
                break;
            case "5" : if(jenis=="1"){
                    txtpre.setText("Jawablah padan kata (sinonim) dari Semaphore berikut !");
                }else if(jenis=="2"){
                    txtpre.setText("Jawablah padan kata (sinonim) dari Semaphore berikut !");
                }else {
                    txtpre.setText("Jawablah padan kata (sinonim) dari Semaphore berikut !");
                }
                break;

        }

    }
}
