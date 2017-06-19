package com.example.runningegg2;

import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;
import android.app.Application;

public class App extends InstrumentedActivity{
	public void onCreate(){
	//	super.onCreate();
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
	}
}
