package com.example.linux.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.linux.myapplication.SplashScreen.url_main;


public class MainActivity  extends  TabActivity {


   // public static String ip="http://10.87.196.113/";
   // http://kkucleft.kku.ac.th/json2/selProvince.php
   //  public static String ip="http://kkucleft.kku.ac.th/";

  //  public static String ip_main_system="http://10.87.196.170/app_admin/";
    //https://kkucleft.kku.ac.th/app_admin/
    public static String ip_main_system="https://kkucleft.kku.ac.th/app_admin/";

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
   // private EditText  edtDate;
    private int year, month, day;

    private Spinner spin1,spinner3,spinner1,spinner2;


    public   String[] iplTeam;

    //String url = "http://10.87.196.113/json2/selProvince.php";
  //  String url =   ip  +  "json2/selProvince.php";

    InputStream is=null;

    String result=null;
    String line=null;

    String Id_per;
    Intent intent;

  //  int id_weight;
    public String[]  arr_prov_id=new String[1000];


    EditText name;
    EditText lastname;
    EditText id_card;
    EditText  telephone;
    RadioGroup  id_sex;
    RadioButton m_sex,w_sex;
    TextView   birthdate;
    EditText   address;
  //  AutoCompleteTextView   province_id;
    EditText   diagnosis;

    //insert  value
    String  strname;
    String  strlastname;
    String   strid_card;
    String strtelephone;




    String  val_sex;
    String  str_m_sex; //1=เพศชาย
    String   str_w_sex; //2=เพศหญิง


    String  str_id_sex1;
    String strbirthdate;
    String  straddress;
    String  strprovince_id;
    String   strdiagnosis;





    public   String[]  arrProv=new String[1000];

     public   String[]   allprovince=new String[1000];

     public  String[] arrWork=new String[100];

    //private  List<String> arrList = new ArrayList<String>();

    int code;
    String  testjson;

    String  stauts_insert = "บันทึกสำเร็จ";


    /* progress bar */
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();




    //public  String urlinsert="http://10.87.196.113/json2/insertPatient.php";
   //  public  String urlinsert=  ip +  "json2/insertPatient.php";
   // public  String urlinsert="http://kkucleft.kku.ac.th/app_admin/index.php/welcome/insertPatient";


   //http://10.87.196.170/app_admin/index.php/welcome/checklogin

//ip_main_system
  //  public  String urlinsert="http://10.87.196.170/app_admin/index.php/welcome/insertPatient2";


//------------- function กล้อง---------------
    //http://www.thaicreate.com/mobile/android-photo-camera-upload-server.html
    static  final int REQUEST_IMAGE_CAPTURE = 1;  //function camera
    static final int REQUEST_TAKE_PHOTO = 1;
    String mCurrentPhotoPath;

    static String strSDCardPathName = Environment.getExternalStorageDirectory() + "/temp_picture" + "/";

    //http://192.168.2.112/LRUDB/index.php/welcome/uploadfile
    //สามารถกำหนด Path ได้จาก Environment.getExternalStorageDirectory()
    //http://www.thaicreate.com/mobile/android-photo-camera-upload-server.html
    static String strURLUpload =  url_main + "index.php/welcome/uploadfile";

    ImageView imgView;


    //--------- timer--------
    /*
    private int mHour;
    private int mMinute;

    //static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 0;

    EditText edt_time;

    Button btn_time;
*/


     NumberPicker numberPK1;
     NumberPicker numberPK2;

     String str_numberPK1;
     String str_numberPK2;


    public  String urlinsert=  url_main  + "index.php/welcome/insertPatient2";


    //---- Autocomplete  PROVINCE จัวงหว
    private AutoCompleteTextView autocomplete1;
    private  List<String> arrList = new ArrayList<String>();
    private  ArrayAdapter<String> adapter;

    //----- spinner  text ---
    String[] arr = { "---เลือก---","ปากแหว่ง", "เพดานโหว่", "ปากแหว่งและเพดานโหว่", "อื่นๆ" };


    //tabbar
    TabHost mTabHost;

    //เพิ่ม field
    String  strdetail_diagnosis;  //ระบุการวินิจฉัยโรค อื่นๆ
    EditText detail_diagnosis;

    String  strinformative_name;  //ชื่อผู้ให้ ข้อมูล
    EditText informative_name;

    String  strinformative_lastname; //นามสกุลผู้ให้ข้อมูล
    EditText informative_lastname;

    EditText informative_tel; //เบอร์โทรศัพท์ผู้ให้ข้อมูล
    String  strinformative_tel;

    ImageButton img1; //image

   final String[] arr_place = { "สำนักงานฯ", "อาคาร CI01","อาคาร CL02","อาคาร 1","อาคาร 2","อาคาร 3","ภาคสนาม" };

    final String[] arr_header = { "ผู้อำนวยการศูนย์การศึกษาฯ", "รองผู้อำนวยการศูนย์การศึกษาฯ","คำสั่งมหาวิทยาลัย","หนังสือสั่งการ"};

   String str_position;

    EditText position;




    //------------- สร้าง Form สำหรับการบันทึกค่า -link 492--------
TextView date1;
String  str_date1;

TimePicker timePicker1;
String str_timePicker1;

EditText txt_firstname;
String str_txt_firstname;

    Spinner sp_place;
    String str_sp_place;


    String str_spinner_working;

    EditText txt_working_detail;


    //ผู้สั่งงาน/ผู้บังคับบัญชา
    Spinner spinner_header;

   Spinner  spinner_evaluation;

String url_insert= url_main  + "index.php/welcome/insert_data";
//-----------------------





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);  //Main program OK
       // setContentView(R.layout.loginpage);

        intent=getIntent();
       // Id_per=intent.getStringExtra("Id_per");

/*    //check id_per from  table intent
        final AlertDialog.Builder adb=new AlertDialog.Builder(this);
        AlertDialog ad=adb.create();
        ad.setMessage(Id_per);
        ad.show();
 */

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

         mTabHost = (TabHost) findViewById(android.R.id.tabhost);
         mTabHost = getTabHost();
         mTabHost = getTabHost();
         mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("Page 1").setContent(R.id.tab1));
         mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Page 2").setContent(R.id.tab2));
        // mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("TAB 3").setContent(R.id.tab3));

        dateView = (TextView) findViewById(R.id.date1);
       // edtDate = (EditText) findViewById(R.id.edtDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR) ;
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);


        //String url = "http://10.87.196.113/json2/selProvince.php";
        //callJSON(); //CALL JSON MYSQL SERVER  for  spinner

        Intent intent=getIntent();
        final String sess_login=intent.getStringExtra("sess_login");
       // Toast.makeText(  getBaseContext(),sess_login,Toast.LENGTH_SHORT).show();

        final  String firstname=intent.getStringExtra("sess_firstname");

        final  String str_id_position=intent.getStringExtra("sess_id_position");

        final  String str_sess_position=intent.getStringExtra("sess_position");

       // Toast.makeText(  getBaseContext(),str_sess_position,Toast.LENGTH_SHORT).show();

        final EditText txt_Firstname=(EditText) findViewById(R.id.txt_firstname);
        txt_Firstname.setText(firstname);

        Spinner  sp_place=(Spinner)findViewById(R.id.sp_place);
        ArrayAdapter<String> arr_adap_place=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr_place);
        arr_adap_place.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_place.setAdapter(arr_adap_place);


         position=(EditText) findViewById(R.id.position);
         position.setText(str_sess_position);
         str_position=position.getText().toString();



/*
//ตัวอย่างการ connect
        Spinner   spinner_working=(Spinner)findViewById(R.id.spinner_working); //เลิอกเพศ
        autoProvince();  //call  autocomplete province
        arr_adap_place=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arrList);
        arr_adap_place.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_working.setAdapter(arr_adap_place);
*/



        Spinner   spinner_working=(Spinner)findViewById(R.id.spinner_working); //เลิอกเพศ
        autoActivity(str_id_position);
        arr_adap_place=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arrList);
        arr_adap_place.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_working.setAdapter(arr_adap_place);



        //*** Take Photo
        //http://www.thaicreate.com/mobile/android-photo-camera.html
        final Button btnTakePhoto = (Button) findViewById(R.id.btnTakePhoto);
        // Perform action on click




        // *** Create Folder
        createFolder();

         imgView = (ImageView) findViewById(R.id.imgView);



        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {

                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                    }
                }

            }
        });



        final Button btnUpload = (Button) findViewById(R.id.btnUpload);

        // Perform action on click
        btnUpload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // *** Upload file to Server
                uploadFiletoServer(mCurrentPhotoPath, strURLUpload);
            }
        });



    //   final String[] arr_header = { "ผู้อำนวยการศูนย์การศึกษาฯ", "รองผู้อำนวยการศูนย์การศึกษาฯ","คำสั่งมหาวิทยาลัย","หนังสือสั่งการ"};
        /*
        Spinner  spinner_header=(Spinner)findViewById(R.id.spinner_header);
        ArrayAdapter<String> arr_adap_header=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr_header);
        arr_adap_header.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_header.setAdapter(arr_adap_header );
*/


        /*
        Spinner  spinner_header=(Spinner)findViewById(R.id.spinner_header);
        ArrayAdapter<String> arr_adap_header=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr_header);
        arr_adap_header.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_header.setAdapter(arr_adap_header);
*/



        /*
        String url2 = "http://192.168.2.112/LRUDB/index.php/welcome/tb_working";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id_position", str_id_position));

        try{
            JSONArray data = new JSONArray(getJSONUrl(url2,params));


            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for(int i = 0; i < data.length(); i++){
                JSONObject c = data.getJSONObject(i);



                arrProv[i]=c.getString("working");

                arrList.add( arrProv[i]  );



            }




        }catch (JSONException e)
        {
            e.printStackTrace();
        }


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, arrList);

        sp_working.setAdapter(adapter);
*/





        /*
        ArrayAdapter<String> arrAd=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arrList);
        arrAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_working.setAdapter(arrAd);
*/

        /*
           spinner1=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> arrAd=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr);
        arrAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrAd);
         */




/*
        spinner1=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> arrAd=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr);
        arrAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrAd);

        //ระบุการวินิจฉัยโรค อื่นๆ
        detail_diagnosis=(EditText)findViewById(R.id.detail_diagnosis);
       // detail_diagnosis.setEnabled(false);
       // strdetail_diagnosis=detail_diagnosis.getText().toString();



        //ชื่อผู้ให้ ข้อมูล
        informative_name=(EditText)findViewById(R.id.informative_name);
      //  informative_name.setText("วิชิต");
       // strinformative_name=informative_name.getText().toString();

        ////นามสกุลผู้ให้ข้อมูล
        informative_lastname=(EditText)findViewById(R.id.informative_lastname);
      //  informative_lastname.setText("ศรีเชียง");
       // strinformative_lastname=informative_lastname.getText().toString();


        //เบอร์โทรศัพท์ผู้ให้ข้อมูล
        informative_tel=(EditText)findViewById(R.id.informative_tel);
       // informative_tel.setText("0858539042");
       // strinformative_tel=informative_tel.getText().toString();

*/



//-------- บันทึกข้อมูล--- link 229
TextView date1=(TextView) findViewById(R.id.date1);
 str_date1=date1.getText().toString();

       // timePicker1=(TimePicker)findViewById(R.id.timePicker1);








       EditText  txt_firstname = (EditText) findViewById(R.id.txt_firstname);
       str_txt_firstname=txt_firstname.getText().toString();

        str_sp_place=sp_place.getSelectedItem().toString();

        // spinner_working

         str_spinner_working=spinner_working.getSelectedItem().toString();


        txt_working_detail=(EditText)findViewById(R.id.txt_working_detail);

        spinner_header=(Spinner) findViewById(R.id.spinner_header);

        spinner_evaluation=(Spinner)findViewById(R.id.spinner_evaluation);


        Button btn_save=(Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(getApplicationContext(),str_timePicker1,Toast.LENGTH_LONG);

              // Toast.makeText(getApplicationContext(),str_spinner_header ,Toast.LENGTH_LONG);

                insertPatient(v);
                //uploadFiletoServer(mCurrentPhotoPath, strURLUpload);


            }
        });




        // numberPicker2  ชั่วโมง
         numberPK1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPK1.setMaxValue(24);
        numberPK1.setMinValue(1);
        numberPK1.setWrapSelectorWheel(false);

      //  str_numberPK1= numberPK1.toString();

// numberPicker2 นาที
         numberPK2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPK2.setMaxValue(60);
        numberPK2.setMinValue(0);
        numberPK2.setWrapSelectorWheel(false);


        //-------------time-----------------

        /*
        edt_time = (EditText) findViewById(R.id.edt_time);
        btn_time = (Button) findViewById(R.id.btn_time);

        // add a click listener to the button
        btn_time.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR);
        mMinute = c.get(Calendar.MINUTE);
        */




    }






    /*
    private void updateCurrentTime() {
        edt_time.setText(
                new StringBuilder()
                        .append(mHour).append(":")
                        .append(mMinute));
    }


    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {

                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    // TODO Auto-generated method stub
                    mHour = hourOfDay;
                    mMinute = minute;
                    updateCurrentTime();
                }
            };
     */


    private void insertPatient(View v)
    {


      //  uploadFiletoServer(mCurrentPhotoPath, strURLUpload);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("date1",str_date1 ));
        nameValuePairs.add(new BasicNameValuePair("hr", Integer.toString( numberPK1.getValue() )  ));
        nameValuePairs.add(new BasicNameValuePair("min", Integer.toString( numberPK2.getValue() ) ));
        nameValuePairs.add(new BasicNameValuePair("firstname",str_txt_firstname ));
        nameValuePairs.add(new BasicNameValuePair("place",str_sp_place ));
        nameValuePairs.add(new BasicNameValuePair("position",str_position ));
        nameValuePairs.add(new BasicNameValuePair("working",str_spinner_working ));
        nameValuePairs.add(new BasicNameValuePair("working_detail", txt_working_detail.getText().toString() ));
        nameValuePairs.add(new BasicNameValuePair("header", spinner_header.getSelectedItem().toString() ));
        nameValuePairs.add(new BasicNameValuePair("evaluation", spinner_evaluation.getSelectedItem().toString() ));


        File storageDir = new File(strSDCardPathName);
        String strFileName = storageDir.getName();

/*
        File filePath= new File(mCurrentPhotoPath);
        File[] fileList = filePath.listFiles();
        String filename = fileList [0].getName().toString();
*/

      //  nameValuePairs.add(new BasicNameValuePair("filUpload", strFileName ));

/*

 //------------- upload file picure-------------------
int bytesRead, bytesAvailable, bufferSize;
byte[] buffer;
int maxBufferSize = 1 * 1024 * 1024;
int resCode = 0;
String resMessage = "";

String lineEnd = "\r\n";
String twoHyphens = "--";
String boundary = "*****";

try {

    File file = new File(strSDPath);
    if (!file.exists()) {
        return false;
    }

    FileInputStream fileInputStream = new FileInputStream(new File(strSDPath));

    URL url = new URL(strUrlServer);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setUseCaches(false);
    conn.setRequestMethod("POST");

    conn.setRequestProperty("Connection", "Keep-Alive");
    conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

    DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
    outputStream.writeBytes(twoHyphens + boundary + lineEnd);
    outputStream.writeBytes(
            "Content-Disposition: form-data; name=\"filUpload\";filename=\"" + strSDPath + "\"" + lineEnd);
    outputStream.writeBytes(lineEnd);

    bytesAvailable = fileInputStream.available();
    bufferSize = Math.min(bytesAvailable, maxBufferSize);
    buffer = new byte[bufferSize];

    // Read file
    bytesRead = fileInputStream.read(buffer, 0, bufferSize);

    while (bytesRead > 0) {
        outputStream.write(buffer, 0, bufferSize);
        bytesAvailable = fileInputStream.available();
        bufferSize = Math.min(bytesAvailable, maxBufferSize);
        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
    }

    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

    // Response Code and Message
    resCode = conn.getResponseCode();
    if (resCode == HttpURLConnection.HTTP_OK) {
        InputStream is = conn.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int read = 0;
        while ((read = is.read()) != -1) {
            bos.write(read);
        }
        byte[] result = bos.toByteArray();
        bos.close();

        resMessage = new String(result);

    }

    fileInputStream.close();
    outputStream.flush();
    outputStream.close();

    return true;

} catch (Exception ex) {
    // Exception handling
    return false;
}
 //------------- upload file picure-------------------
*/


        try{
            HttpClient httpclient = new DefaultHttpClient();
            //HttpPost httppost = new HttpPost(url);
            //ip_main_system
            //  HttpPost httppost = new HttpPost("http://10.87.196.170/app_admin/index.php/welcome/insertPatient2");

            HttpPost httppost = new HttpPost(  url_insert );

            // httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
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


             $data=array(
               "name"=>$name,
              "lastname"=>$lastname,
              "id_card"=>$id_card,
            "telephone"=>$telephone,
                "id_sex"=>  $id_va_sex,
                   "birthdate"=>$conv_dmy,
                   "address"=>$address,
                   "province_id"=> $id_prov,
                   "diagnosis"=>$diagnosis,
                  "detail_diagnosis"=>$detail_diagnosis,
                   "info_name"=>$informative_name,
                      "informative_lastname"=>$informative_lastname,

                    "informative_tel"=>$informative_tel,

          );



            // echo json_encode(array("name"=>$name));
            //  echo  json_encode($data);



           String  ck_name=json_data.getString("name");
           String   ck_lastname=json_data.getString("lastname");
           String   ck_id_card=json_data.getString("id_card");
           String   ck_telephone=json_data.getString("telephone");
           String   ck_id_sex=json_data.getString("id_sex");
           String   ck_birthdate=json_data.getString("birthdate");
           String   ck_address=json_data.getString("address");
           String   ck_province_id=json_data.getString("province_id");
           String   ck_diagnosis=json_data.getString("diagnosis");
           String   ck_detail_diagnosis=json_data.getString("detail_diagnosis");
           String   ck_informative_name=json_data.getString("info_name");
           String   ck_informative_lastname=json_data.getString("informative_lastname");
           String   ck_strinformative_tel=json_data.getString("informative_tel");

           Toast.makeText(  getBaseContext(),  ck_name + '/' + ck_lastname  + '/' +  ck_id_card + '/' + ck_telephone + '/' + ck_id_sex  +  '/' +  ck_birthdate + '/' + ck_address + '/' + ck_province_id + '/' + ck_diagnosis + '/' + ck_detail_diagnosis + '/' + ck_informative_name + '/' + ck_informative_lastname + '/' +  ck_strinformative_tel ,Toast.LENGTH_SHORT).show();

           */

            // echo json_encode(array("success"=>1));

            //String  success  =   json_data.getString("success");
            // String  success  =   json_data.getString("success");

            Toast.makeText(  getBaseContext(), json_data.getString("date1") + '/' + json_data.getString("id_user") + '/' + json_data.getString("place") + '/' + json_data.getString("id_position")
              +  '/' +  json_data.getString("working_detail")
              + '/' +  json_data.getString("id_header")
                            + '/' +  json_data.getString("hr")
                            + '/' +  json_data.getString("time1")
                    ,Toast.LENGTH_SHORT).show();


            Integer success = json_data.getInt("success");
            // Integer  int1 =

            // Toast.makeText(  getBaseContext(),  success.toString() ,Toast.LENGTH_SHORT).show();


            if( success == 1 )
            {
                progressBar(v); //แสดงสถานะการบันทึก
                // Toast.makeText(  getBaseContext(),  "บันทึกข้อมูลแล้ว" ,Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(  getBaseContext(),  "ไม่สามารถบันทึกข้อมูลได้" ,Toast.LENGTH_SHORT).show();
            }



        }catch (Exception e)
        {

            Log.e("Fail 3",e.toString());
        }


    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = new File(strSDCardPathName);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK)
        {

            //*** สร้ืางไฟล์ ใน Device storage
            Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
            imgView.setImageBitmap(bitmap);


            //*** Rename File
/*
            String strNewName = "MyPicture.jpg";
            String NewPath = strSDCardPathName + strNewName;

            File CurrPath = new File(mCurrentPhotoPath);
            CurrPath.renameTo(new File(NewPath));
*/


  //********** ภาพที่ถ่ายมาได้
/*
             // Get the dimensions of the View
        //int targetW = 300;
        //int targetH = 300;
        int targetW = imgView.getWidth();
        int targetH = imgView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        imgView.setImageBitmap(bitmap);

*/


        }
    }



    public static void createFolder() {
        File folder = new File(strSDCardPathName);
        try {
            // Create folder
            if (!folder.exists()) {
                folder.mkdir();
            }
        } catch (Exception ex) {
        }

    }





//strURLUpload
    public static boolean uploadFiletoServer(String strSDPath, String strUrlServer) {

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;
        int resCode = 0;
        String resMessage = "";

        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";

        try {
            File file = new File(strSDPath);
            if (!file.exists()) {
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(new File(strSDPath));

            URL url = new URL(strUrlServer);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream.writeBytes(
                    "Content-Disposition: form-data; name=\"filUpload\";filename=\"" + strSDPath + "\"" + lineEnd);
            outputStream.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // Read file
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(lineEnd);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            // Response Code and Message
            resCode = conn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                int read = 0;
                while ((read = is.read()) != -1) {
                    bos.write(read);
                }
                byte[] result = bos.toByteArray();
                bos.close();

                resMessage = new String(result);

            }

            fileInputStream.close();
            outputStream.flush();
            outputStream.close();


            return true;

        } catch (Exception ex) {
            // Exception handling
            return false;
        }
    }



    public void  autoProvince() //ใช้เรียกจังหวัด
    {
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        try{
           // String url= "http://192.168.2.112/LRUDB/index.php/welcome/json_province_backend";
            String url=  url_main  +   "index.php/welcome/json_province_backend";
            JSONArray data = new  JSONArray(getHttpPost(url,params));  //post value in table
            for(int i=0;i<data.length();i++)
            {
                JSONObject c = data.getJSONObject(i);
                // id_weight=c.getInt("id_weight");
                arr_prov_id[i]=c.getString("PROVINCE_ID");
                arrProv[i]=c.getString("PROVINCE_NAME");

                allprovince[i]=arr_prov_id[i]+ "-" + arrProv[i];

                 arrList.add(   allprovince[i]  );
            }
        }catch (JSONException e) {
            // e.printStackTrace();
            Log.e("false autocomplete", e.toString());
        }
    }

    public void autoActivity(String str_id_position) //เรียกภาระงาน
    {
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id_position", str_id_position));
        try{
            // String url= "http://192.168.2.112/LRUDB/index.php/welcome/tb_working";
            String url=  url_main  +   "index.php/welcome/tb_working";
            JSONArray data = new  JSONArray(getHttpPost(url,params));  //post value in table
            for(int i=0;i<data.length();i++)
            {
                JSONObject c = data.getJSONObject(i);


                arrList.add(  c.getString("working") );

               // Toast.makeText(  getBaseContext(),  c.getString("working")  ,Toast.LENGTH_SHORT).show();

            }
        }catch (JSONException e) {
            // e.printStackTrace();
            Log.e("false autocomplete", e.toString());
        }

    }

    public String getJSONUrl(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
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






 public void progressBar(View v)
 {
     progressBar =new ProgressDialog(v.getContext());
     progressBar.setCancelable(true);
     progressBar.setMessage("กำลังดำเนินการบันทึกข้อมูล...");
     progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
     progressBar.setProgress(0);
     progressBar.setMax(100);
     progressBar.show();

        progressBarStatus = 0;
     new Thread(new Runnable() {
         public void run() {
             while (progressBarStatus < 100) {

                 // process some tasks
                 progressBarStatus = DoWork();

                 try {
                     Thread.sleep(15);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

                 // Update the progress bar
                 progressBarHandler.post(new Runnable() {
                     public void run() {
                         progressBar.setProgress(progressBarStatus);
                        // Toast.makeText(  getBaseContext(),  "บันทึกข้อมูลแล้ว" ,Toast.LENGTH_SHORT).show();
                     }
                 });
             }

         }
     }).start();


 }


    // DoWork & Set Status Progress Bar
    public int DoWork() {

        // Do some work EG: Save , Download , Insert , ..
        // **** Work
        // **** Work
        // **** Work
        // **** Work
        progressBarStatus++; // Work process and return status

        if( progressBarStatus < 100)
        {
            return progressBarStatus;
        }

        // When Finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progressBar.dismiss();

        return 100;

    }






    public void testalert(String str)
    {
         final AlertDialog.Builder adb=new AlertDialog.Builder(this);
        AlertDialog ad=adb.create();
        ad.setMessage(str);
        ad.show();
    }







    public String getHttpPost(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
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






    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year  , month, day);
        }
        return null;
    }



    private DatePickerDialog.OnDateSetListener myDateListener
            = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1  , arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {


        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year+543));


        //edtDate.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));

    }



    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), " เลือกวันที่  ", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);



        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
