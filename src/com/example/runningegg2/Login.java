package com.example.runningegg2;

import http.HttpUtils;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runningegg1.R;

public class Login extends Activity{
    public static String name;
	private Button button1;;
	private EditText et1;
	private EditText et2;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login3);	
		log();
	}
	
	
	public void log()
	{
		button1= (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				    et1 = (EditText)findViewById(R.id.sel_name);
					final String sel_name=et1.getText().toString();
					name=sel_name;
					et2 = (EditText)findViewById(R.id.sel_pword);
					final String sel_pword=et2.getText().toString();
				 new Thread()
					{
						@Override
						public void run()
						{
								HttpUtils utils=new HttpUtils();
								utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/LoginAction";
								HttpUtils.setUrl(utils.PATH);
								Map<String,String> params=new HashMap<String,String>();								
								params.put("sel_name", sel_name);
								params.put("sel_pword", sel_pword);
								String result=utils.sendPostMessage(params,"utf-8",utils.url);
								
								if(result.equals("登录成功")){
								Looper.prepare();
								
								Toast.makeText(Login.this,
										"登录成功", Toast.LENGTH_SHORT).show();
								Intent intent = new Intent();
							//	 Bundle bundle = new Bundle();
							//     bundle.putString("name", sel_name);
								 intent.setClass(Login.this ,Main.class );
							//	 intent.putExtras(bundle);
								 startActivity(intent);			 
								
								Looper.loop();
						       }
								
								else if(sel_name.equals("adm"))
								{
									     Intent intent = new Intent();
										 intent.setClass(Login.this ,Main_for_adm.class );
										 startActivity(intent);	
								}
								
								else{
						    	   Looper.prepare();
									
									Toast.makeText(Login.this,
											"登录失败", Toast.LENGTH_SHORT).show();
									Looper.loop();
						       }
						}
								
					}.start();
				}
		});
		
		};	
	}

