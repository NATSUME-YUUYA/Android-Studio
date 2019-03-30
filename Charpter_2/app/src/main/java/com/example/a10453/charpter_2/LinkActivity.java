package com.example.a10453.charpter_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
    }
}


/*
此活动为"选择应用程序以打开"功能,在Manifest中,对此活动的注册中的"<intent>"项声明了该活动会响应Intent类型的活动
因此当点击第五个按钮时,按钮中有intent,则此活动就会相应这个按钮的点击,就变为选择浏览器打开或者用该活动打开
 */