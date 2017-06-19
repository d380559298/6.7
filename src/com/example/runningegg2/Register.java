package com.example.runningegg2;

import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.runningegg1.R;
//import http.HttpUtils;
public class Register extends Activity  {
	
	EditText et_username, et_password,sel_like,sel_daddr, sel_sex,sel_major, sel_faln,sel_phone;
	Button btn_register;
	TextView response;
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == 0x123)
			{
				// 使用response文本框显示服务器响应
				response.append(msg.obj.toString() + "\n");
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		clikck();
	}	
		
		public void clikck()
		{
			btn_register = (Button)findViewById(R.id.btn_submit);
			btn_register.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
					   et_username=(EditText) findViewById(R.id.sel_name);
						et_password = (EditText) findViewById(R.id.sel_pword);
						sel_like = (EditText) findViewById(R.id.sel_like);
						sel_daddr = (EditText) findViewById(R.id.sel_daddr);
						sel_sex  = (EditText) findViewById(R.id.sel_sex );
						sel_major = (EditText) findViewById(R.id.sel_major);
						sel_faln = (EditText) findViewById(R.id.sel_faln);			
						sel_phone = (EditText) findViewById(R.id.sel_phone);	
						
						final String Ssel_name = et_username.getText().toString();
						final String Ssel_pword = et_password.getText().toString();
						final String Ssel_like = sel_like.getText().toString();
						final String Ssel_daddr = sel_daddr.getText().toString();
						final String Ssel_sex = sel_sex.getText().toString();
						final String Ssel_major =sel_major.getText().toString();
						final String Ssel_faln = sel_faln.getText().toString();
						final String Ssel_phone = sel_phone.getText().toString();
					 new Thread()
						{
							@Override
							public void run()
							{
									HttpUtils utils=new HttpUtils();
									utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/RegisterAction";
									HttpUtils.setUrl(utils.PATH);
									Map<String,String> params=new HashMap<String,String>();								
									params.put("sel_name", Ssel_name);
									params.put("sel_pword", Ssel_pword);
									params.put("sel_like", Ssel_like);
									params.put("sel_faln", Ssel_faln);
									params.put("sel_sex", Ssel_sex);
									params.put("sel_major", Ssel_major);
									params.put("sel_dadd", Ssel_daddr);
									params.put("sel_phone", Ssel_phone);
									String result=utils.sendPostMessage(params,"utf-8",utils.url);
									if(result.equals("register success!")){
									Looper.prepare();
									
									Toast.makeText(Register.this,
											"注册成功", Toast.LENGTH_SHORT).show();
									 Intent intent = new Intent();
									 intent.setClass(Register.this , Login.class );
									 startActivity(intent);
									
									Looper.loop();
							       }else{
							    	   Looper.prepare();
										
										Toast.makeText(Register.this,
												"注册失败", Toast.LENGTH_SHORT).show();
										Looper.loop();
							       }
							}
									
						}.start();
					}
			});
			
			};	

}


