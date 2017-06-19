package com.example.runningegg2;

import cn.jpush.android.api.JPushInterface;
import android.app.Application;

public class JPush extends Application{

	public void onCreate(){
		super.onCreate();
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		
	}
}
