package com.example.linux.myapplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class SplashScreen extends Activity {

    // Splash screen timer
    //private static int SPLASH_TIME_OUT = 2000;  //OK code
    //String  ip =  new MainActivity().ip;
    //String  ip =   MainActivity.ip;
    
    String strUser;
    String strPass;

    //String url="http://10.87.196.113/json2/checkLogin_.php";
    // String urlinsert="http://10.87.196.170/app_admin/index.php/welcome/insertPatient2";
   // String url=  ip  +  "json2/checkLogin_.php";

   //public  String  url_main="http://10.87.196.170/app_admin/";
   //https://kkucleft.kku.ac.th/app_admin/index.php/welcome/checklogin
   //public  String  url_main="https://kkucleft.kku.ac.th/app_admin/";

    //public static String  url_main="http://192.168.2.120/LRUDB/";   ip local

    public static String  url_main="http://kk.lru.ac.th/LRUDB/";


   //   public static String ip="http://kkucleft.kku.ac.th/app_admin/";

  //  String url="http://10.87.196.170/app_admin/index.php/welcome/ckecklogin_andriod";

   public String url= url_main +  "index.php/welcome/checklogin";


    InputStream is=null;
    String result=null;
    String line=null;

    String Id_per;
    String id_sex;
    String Name;
    String strError;
    String StatusID;

   // final AlertDialog.Builder ad = new AlertDialog.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginpage);


        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        final EditText txtUser = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPass = (EditText) findViewById(R.id.txtPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);


          txtUser.setText("login1"); //sim login
          txtPass.setText("login1"); //sim login


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                strUser= txtUser.getText().toString();
                strPass= txtPass.getText().toString();




                       if( strUser.length() == 0 )
                       {
                           Toast.makeText(getBaseContext()," INSERT username !! " ,Toast.LENGTH_SHORT).show();
                       }
                       else if(  strPass.length() == 0  )
                       {
                           Toast.makeText(getBaseContext()," INSERT password !! " ,Toast.LENGTH_SHORT).show();
                       }
                       else
                       {

                           checkLogin();

                       }

            }
        });




    }

    public void checkLogin()
    {


        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("us", strUser));
        nameValuePairs.add(new BasicNameValuePair("ps", strPass));
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
           // httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");

        }catch (Exception e)
        {
           Log.e("Fail 1",e.toString());
           Toast.makeText(getApplicationContext(),"Invalid IP",Toast.LENGTH_LONG);
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("pass 2", "connection success ");
        }catch (Exception e)
        {
            Log.e("Fail 2",e.toString());

        }

        try{
            JSONObject json_data = new JSONObject(result);

            /*
            Integer ck_sess_logon=json_data.getInt("sess_logon");

            if( ck_sess_logon.equals(1) )
            {
                Intent sendmain = new Intent(SplashScreen.this,MainActivity.class);
             //   sendmain.putExtra("Id_per", Id_per );
                startActivity(sendmain);
            }
            */


/*
            String  str_us=json_data.getString("us");
            String  str_ps=json_data.getString("ps");
            Toast.makeText(  getBaseContext(),str_us + '/' + str_ps ,Toast.LENGTH_SHORT).show();
            */


            String  str_sess_login=json_data.getString("sess_login"); //สถานะการ login 1=login, 0=logout
            String  str_sess_firstname=json_data.getString("sess_firstname");
            String  str_sess_lastname=json_data.getString("sess_lastname");
            String  str_sess_username=json_data.getString("sess_username");
            String  str_sess_password=json_data.getString("sess_password");
            String   str_sess_id_position=json_data.getString("sess_id_position");
            String   str_sess_position=json_data.getString("sess_position");


         //   Toast.makeText(  getBaseContext(),str_sess_login + '/' + str_sess_firstname  + '/' + str_sess_lastname + '/' + str_sess_password + '/' + str_sess_id_position,Toast.LENGTH_SHORT).show();
               if( str_sess_login.equals("1"))
               {
                   Toast.makeText(  getBaseContext()," ยินดีต้อนรับเข้าสู่ระบบ  ",Toast.LENGTH_SHORT).show();
                   Intent newActivity = new Intent(SplashScreen.this,MainActivity.class);
                   newActivity.putExtra("sess_login",str_sess_login);
                   newActivity.putExtra("sess_firstname",str_sess_firstname);
                   newActivity.putExtra("sess_lastname",str_sess_lastname);
                   newActivity.putExtra("sess_username",str_sess_username);
                   newActivity.putExtra("sess_id_position",str_sess_id_position);
                   newActivity.putExtra("sess_position",str_sess_position);


                   startActivity(newActivity);
               }
               else{
                   Toast.makeText(  getBaseContext()," ไม่สามารถเข้าสู่ระบบได้  ",Toast.LENGTH_SHORT).show();
               }



        }catch (Exception e)
        {

            Log.e("Fail 3",e.toString());
        }


    }


    public void testAlert(String txt)
    {
        final AlertDialog.Builder adb=new AlertDialog.Builder(this);
        AlertDialog ad=adb.create();
        ad.setMessage("Value is : " +  txt );
        ad.show();
    }



    public String getHttpPost(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Status OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }





}
