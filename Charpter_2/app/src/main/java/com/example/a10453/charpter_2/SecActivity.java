package com.example.a10453.charpter_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Intent intent=getIntent();                                                           //此方法作用为获取到启动该活动的intent,在这里就是button3的功能
        String data=intent.getStringExtra("E_data");                //getStringExtra方法用于获取传递过来的数据
        Log.d("SecActivity",data);

        Button button1=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecActivity.this,FirstActivity.class);             //两个参数,第一个表示我们想"从"这个活动中"对"后面这个参数指明的活动中做事情
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Return to homepage success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
