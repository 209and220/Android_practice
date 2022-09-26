package com.example.sqlitedemo2;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sqlitedemo2.CityManagement;
import com.example.sqlitedemo2.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    //主界面数据
    private TextView cityNameT,temperatureT,typeT,shiduT,type1T,low1T,high1T,wuranzhishuT,type2T,low2T,high2T,type3T,low3T,high3T,week3T,timeT;
    private ImageView backgroundImg,typeIcon1,typeIcon2,typeIcon3;
    //城市界面数据
    private String UpdateCityCode,cityname,todaywendu,zhishu,type;
    //温度数据名
    private String mdate0,mdate1,mdate2,mdate3,mdate4;
    //天气类型名
    private String mtype0_d,mtype0_n,mtype1_d,mtype1_n,mtype2_d,mtype2_n,mtype3_d,mtype3_n,mtype4_d,mtype4_n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run(){
//                ('101181406','shangshui','商水','henan','河南','China','中国','zhoukou','周口','33.543845','114.60927'),
//                https://www.yiketianqi.com/free/day?appid=78718793&appsecret=Nvb2GZtK&unescape=1
                MyRequest myRequest=new MyRequest();
//                String result=myRequest.post("http://apis.juhe.cn/simpleWeather/query","city=%E5%91%A8%E5%8F%A3&key=c54aedd2f715dd6ff6d6bc06e3be08be");
//                Log.i("1",result1);
//                String queryname="";
//                String querycityid="";
                String result1=myRequest.post("https://www.yiketianqi.com/free/day?appid=78718793&appsecret=Nvb2GZtK&unescape=1","");
                Log.i("周口天气",result1);
//                try {
//                    JSONObject jsonObject=new JSONObject(result1);
//                    Log.i("name", String.valueOf(jsonObject.get("city")));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }.start();
        //去掉标题栏
        getSupportActionBar().hide();
        Button weather = (Button) findViewById(R.id.viewweather);
        weather.getBackground().setAlpha(100);
        //监听跳转至MainActivity2
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("date0",mdate0);
                intent.putExtra("date1",mdate1);
                intent.putExtra("date2",mdate2);
                intent.putExtra("date3",mdate3);
                intent.putExtra("date4",mdate4);

                intent.putExtra("mtype0_d",mtype0_d);
                intent.putExtra("mtype0_n",mtype0_n);
                intent.putExtra("mtype1_d",mtype1_d);
                intent.putExtra("mtype1_n",mtype1_n);
                intent.putExtra("mtype2_d",mtype2_d);
                intent.putExtra("mtype2_n",mtype2_n);
                intent.putExtra("mtype3_d",mtype3_d);
                intent.putExtra("mtype3_n",mtype3_n);
                intent.putExtra("mtype4_d",mtype4_d);
                intent.putExtra("mtype4_n",mtype4_n);
                startActivity(intent);
            }
        });
        ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton3);
        //监听跳转至CityManagement界面
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityManagement.class);

                intent.putExtra("cityname",cityname);
                intent.putExtra("todaywendu",todaywendu);
                intent.putExtra("zhishu",zhishu);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }

    //初始化主页面数据
    public void initView(){
        cityNameT = (TextView)findViewById(R.id.detailaddress);
        cityNameT.setText("N/A");

        temperatureT = (TextView)findViewById(R.id.temperature);
        temperatureT.setText("N/A");

        type1T = (TextView)findViewById(R.id.weather_forcast1);
        type1T.setText("N/A");

        typeT = (TextView)findViewById(R.id.weathercondition);
        typeT.setText("N/A");

        shiduT = (TextView)findViewById(R.id.shidu);
        shiduT.setText("N/A");

        high1T = (TextView)findViewById(R.id.high1);
        high1T.setText("N/A");

        low1T = (TextView)findViewById(R.id.low1);
        low1T.setText("N/A");

        type2T = (TextView)findViewById(R.id.weather_forcast2);
        type2T.setText("N/A");

        high2T = (TextView)findViewById(R.id.high2);
        high2T.setText("N/A");

        low2T = (TextView)findViewById(R.id.low2);
        low2T.setText("N/A");

        type3T = (TextView)findViewById(R.id.weather_forcast3);
        type3T.setText("N/A");

        high3T = (TextView)findViewById(R.id.high3);
        high3T.setText("N/A");

        low3T = (TextView)findViewById(R.id.low3);
        low3T.setText("N/A");

        week3T = (TextView)findViewById(R.id.date3);
        week3T.setText("N/A");

        wuranzhishuT = (TextView)findViewById(R.id.pollutionlevel);
        wuranzhishuT.setText("N/A");

        timeT = (TextView)findViewById(R.id.blankshang);
        timeT.setText("N/A");

        backgroundImg = (ImageView)findViewById(R.id.main_background);

        typeIcon1 = (ImageView)findViewById(R.id.weather_icon1);
        typeIcon2 = (ImageView)findViewById(R.id.weather_icon2);
        typeIcon3 = (ImageView)findViewById(R.id.weather_icon3);

    }

}