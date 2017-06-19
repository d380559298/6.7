package com.example.runningegg2;
import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.jpush.android.api.JPushInterface;

import com.example.runningegg1.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
public class Welcome1 extends Activity{	

	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.welcome1);
		
			
			
			 Timer timer = new Timer();  
	         
		        	 final Intent intent = new Intent();
					 intent.setClass(Welcome1.this , Welcome2.class );
					 TimerTask tast = new TimerTask() {  
			             @Override  
			             public void run() {  
			                 startActivity(intent);  
			             }  
			         };  
			         timer.schedule(tast, 1500);
	}
		@Override
		protected void onResume() {
		super.onResume();
		JPushInterface.onResume(this);
		}
		@Override
		protected void onPause() {
		super.onPause();
		JPushInterface.onPause(this);
		}
	}