package com.example.runningegg2;

import java.util.HashMap;
import java.util.Random;

import com.example.runningegg1.R;

//import cn.smssdk.EventHandler;
//import cn.smssdk.SMSSDK;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

@SuppressLint("NewApi")
public class check extends ActionBarActivity {
 
    Button mBtnBindPhone;
    String APPKEY="109b9cb33d3c8";
    String APPSECRET="3c4041b1def91ce7e78827191dc47ae3";
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check);
		//SMSSDK.initSDK(this, APPKEY,APPSECRET);
		mBtnBindPhone = (Button) findViewById(R.id.btn_bind_phone);
/*		mBtnBindPhone.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
		//		RegisterPage registerPage = new RegisterPage();
				
				registerPage.setRegisterCallback(new EventHandler()
				{
					public void afterEvert(int event,int result,Object data)
					{
						if(result==SMSSDK.RESULT_COMPLETE)
						{
							HashMap<String,Object> maps = (HashMap<String, Object>) data;
							String country =(String)maps.get("country");
							String phone =(String)maps.get("phone");
						    submitInfo(country,phone);
						}
					}
				});
				registerPage.show(check.this);		 
			 }
		});		
	}

	public void submitInfo(String country,String phone){
		Random r = new Random();
		String uid = Math.abs(r.nextInt())+"";
		String nickName = "Running";
		SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//	return true;
		//}
		return super.onOptionsItemSelected(item);
		*/
	}
}
