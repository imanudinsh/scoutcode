package com.app.scoutcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class DaftarActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    private EditText txtnama, txtuser, txtemail, txtpwd2, txtpwd;
    private Button btnLogin;
    private static final String DAFTAR_URL = "http://scoutcode.web.id/services/daftar.php";

    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_EMAIL ="email";
    private static final String TAG_FOTO ="foto";
    private static final String TAG_USER ="user";
    private static final String TAG_PWD ="pass";
    String myJSON;
    JSONArray user = null;
    JSONArray grade = null;
    ArrayList<HashMap<String, String>> detailuser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_fragdaftar);
        detailuser = new ArrayList<HashMap<String,String>>();
        /*
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent i = new Intent(getBaseContext(),
                        MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
        */


        txtnama = (EditText) findViewById(R.id.txtnama);
        txtpwd2= (EditText) findViewById(R.id.txtpwd2);
        txtuser = (EditText) findViewById(R.id.txtuser);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpwd= (EditText) findViewById(R.id.txtpwd);



        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = txtnama.getText().toString();
                String user = txtuser.getText().toString();
                String email = txtemail.getText().toString();
                String pwd = txtpwd.getText().toString();
                String pwd2 = txtpwd2.getText().toString();



                if(nama.equals("")){
                    Toast.makeText(getApplicationContext(), "Nama tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if(user.equals("")){
                    Toast.makeText(getApplicationContext(), "Username tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if(email.equals("")){
                    Toast.makeText(getApplicationContext(), "Email tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if(pwd.equals("")){
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if(pwd2.equals("")){
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if(!pwd.equals(pwd2)){
                    Toast.makeText(getApplicationContext(), "Password tidak sama",Toast.LENGTH_LONG).show();
                }else{
                    daftarUser();
                }
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void daftarUser() {
        String nama = txtnama.getText().toString();
        String pwd = txtpwd.getText().toString();
        String user = txtuser.getText().toString();
        String email = txtemail.getText().toString();

        daftar(nama, user, email, pwd);
    }

    private void daftar(String nama, String user, String email, String pwd) {
        class DaftarUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            SignUser ruc = new SignUser();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = new ProgressDialog(DaftarActivity.this);
                loading.setMessage("Please wait...");
                loading.setIndeterminate(false);
                loading.setCancelable(true);
                loading.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                myJSON=s;
                insertDB();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("nama",params[0]);
                data.put("user",params[1]);
                data.put("email",params[2]);
                data.put("pwd",params[3]);

                String result = ruc.sendPostRequest(DAFTAR_URL,data);

                return  result;
            }
        }

        DaftarUser ru = new DaftarUser();
        ru.execute(nama, user, email, pwd);
    }

    protected void insertDB(){
        int sukses = 0;

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            user = jsonObj.getJSONArray(TAG_RESULTS);

            DBAdapter db = new DBAdapter(this);
            db.open();

            for(int i=0;i<user.length();i++){
                JSONObject c = user.getJSONObject(i);
                if(c.has("pesan")){
                    Toast.makeText(getApplicationContext(), "Daftar gagal !\n"+c.getString("pesan"),Toast.LENGTH_LONG).show();
                }else {
                    String id = c.getString(TAG_ID);
                    String nama = c.getString(TAG_NAMA);
                    String email = c.getString(TAG_EMAIL);
                    String foto = c.getString(TAG_FOTO);
                    String user = c.getString(TAG_USER);
                    String pwd = c.getString(TAG_PWD);
                    db.isidata("iduser", id);
                    db.isidata("namauser", nama);
                    db.isidata("emailuser", email);
                    db.isidata("fotouser", foto);
                    db.isidata("user", user);
                    db.isidata("pwd", pwd);

                    sukses = 1;

                }
            }

            db.hapustabelgrade();
            db.buattabelgrade();

            db.close();

            if (sukses==1) {
                Toast.makeText(getApplicationContext(), "Daftar berhasil", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getBaseContext(),
                        MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }

        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error : "+e,Toast.LENGTH_LONG).show();
        }

    }

}
