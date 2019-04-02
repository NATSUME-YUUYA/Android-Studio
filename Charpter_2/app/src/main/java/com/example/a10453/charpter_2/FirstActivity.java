package com.example.a10453.charpter_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    @Override

    /*
    关于活动的生命周期,Activity类中定义了7种回调方法覆盖了活动生命周期的每一个环节
    1.onCreate:在活动第一次创建时被调用,主要做这个activity启动的一些必要的初始化的工作
    2.onStart:在活动由不可见变为可见时调用
    3.onResume:在活动准备好与用户交互时调用.此时的活动一定位于返回栈的栈顶,并且处于运行状态
    4.onPause:此活动在系统准备恢复或者启动另一个活动时调用,一般通过这个方法释放些CPU资源,保存关键数据,但一定要快
    5.onStop:在活动完全不可见时调用,与4的主要区别:若新活动是对话框式的活动,则4会执行
    6.onDestroy:在活动被销毁前调用,之后活动状态变为销毁状态
    7.onRestart:在活动由停止状态变为运行状态前调用,也就是活动被重启

    1~6之间的生存期为完整生存周期
    2~5之间为可见生存周期,活动对于用用户总是可见的
    3~4为前台生存周期,活动总是可交互的,对用户来说最多见到的状态
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //定义第一个按钮的功能
        Button button1=(Button) findViewById(R.id.button3);            //实例化一个Button对象,取名为button1,此对象为布局中刚才添加的button3
        button1.setOnClickListener(new View.OnClickListener() {       //调用Button中的此方法设置一个监听器,点击按钮时会执行下面的onClick方法
            @Override
            public void onClick(View  v) {
                Toast.makeText(FirstActivity.this,"U clicked the button",Toast.LENGTH_SHORT).show();
                //通过调用makeText创建出一个Toast的对象,然后调用show显示出来.
                //makeText需要传递三个参数,1:是上下文参数(context)，指当前所在的页面,或者理解成基础页面,2:要显示的文本,3:显示的时间
            }
        });

        //定义第二个按钮的功能,这里定义的销毁活动,效果上类似于退格键
        Button button2=(Button)findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
                finish();
            }
        });

        //定义第三个按钮的功能,功能为完成活动间的跳转
        Button button3=(Button)findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
                String data="The message approched.";
                Intent intent=new Intent(FirstActivity.this,SecActivity.class);             //两个参数,第一个表示我们想"从"这个活动中"对"后面这个参数指明的活动中做事情
                intent.putExtra("E_data",data);
                startActivity(intent);
            }
        });

        //定义隐式调用的按钮
        Button button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.activitytest.ACTION_START");
                startActivity(intent);
            }
        });

        Button link=(Button)findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent  sLink=new Intent(Intent.ACTION_VIEW);       //确定具体的Intent功能,这里为根据所给链接进行跳转
                sLink.setData(Uri.parse("http://www.baidu.com"));   //这里传递"ACTION_VIEW"功能所要求的参数
                startActivity(sLink);
            }
        });

        Button button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){             //当这个按钮被点击的时候,执行下面的代码
            @Override
            public void onClick(View v){
                Intent  b_call=new Intent(Intent.ACTION_DIAL);       //确定具体的Intent功能,这里为根据所给号码进行拨号
                b_call.setData(Uri.parse("tel:911"));   //这里传递"ACTION_DIAL"功能所要求的参数
                startActivity(b_call);                                                      //启动该活动
            }
        });
        //关于按钮的功能定义必须写在onCreate函数里面
    }

    @Override                  //此方法创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
         * (只会在第一次初始化菜单时调用) Inflate the menu; this adds items to the action bar
         * if it is present.
         */
        getMenuInflater().inflate(R.menu.main,menu);   //.inflate的参数指明需要创建的菜单具体在哪个位置
        return true;                                                               //返回true,上面创建的菜单才能被显示出来,false的话只创建了显示不出来
    }

    @Override                 //此方法定义菜单中选项的功能(这里为定义刚才Add和Remove的功能)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"U clicked the Add button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"U clicked the Remove button",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }





}
