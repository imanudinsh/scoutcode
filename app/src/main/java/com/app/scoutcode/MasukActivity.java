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


public class MasukActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    private EditText txtuser, txtpwd;
    private Button btnLogin;
    private Button btnDaftar;
    private static final String LOGIN_URL = "http://scoutcode.web.id/services/login.php";

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

        setContentView(R.layout.activity_fraglogin);
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


        txtuser = (EditText) findViewById(R.id.txtuser);
        txtpwd= (EditText) findViewById(R.id.txtpwd);

        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        btnDaftar = (Button) findViewById(R.id.btndaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),
                        DaftarActivity.class);
                startActivity(i);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void loginUser() {
        String user = txtuser.getText().toString();
        String pwd = txtpwd.getText().toString();

        login(user, pwd);
    }

    private void login(String user, String pwd) {
        class LoginUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            SignUser ruc = new SignUser();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = new ProgressDialog(MasukActivity.this);
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
                data.put("user",params[0]);
                data.put("pwd",params[1]);

                String result = ruc.sendPostRequest(LOGIN_URL,data);

                return  result;
            }
        }

        LoginUser ru = new LoginUser();
        ru.execute(user, pwd);
    }

    protected void insertDB(){
        int sukses = 0;

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            user = jsonObj.getJSONArray(TAG_RESULTS);
            grade = jsonObj.getJSONArray("grade");

            DBAdapter db = new DBAdapter(this);
            db.open();

            for(int i=0;i<user.length();i++){
                JSONObject c = user.getJSONObject(i);
                if(c.has("pesan")){
                    Toast.makeText(getApplicationContext(), "Login gagal !\n"+c.getString("pesan"),Toast.LENGTH_LONG).show();
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
            for(int i=0;i<grade.length();i++) {
                JSONObject c = grade.getJSONObject(i);
                db.isigrade(c.getString("id_grade"), c.getString("jenis"), c.getString("level"), c.getString("grade"), c.getString("tgl"));
            }

            db.close();

            if (sukses==1) {
                Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();

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
