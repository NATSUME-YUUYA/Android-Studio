package com.example.a10453.charpter_2;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10453 on 2019/4/2.
 */

public class ActivityCollector {
    public static List<Activity> activities =new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishALL(){
        for(Activity activity : activities){
            if(activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
