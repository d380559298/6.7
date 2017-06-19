package com.example.runningegg2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.runningegg1.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Register3 extends Activity
{
	TextView response;
	HttpClient httpClient;
	Button btn_register;
	EditText et_username, et_password,sel_like,sel_daddr, sel_sex,sel_major, sel_faln;
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

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		// 创建DefaultHttpClient对象
		httpClient = new DefaultHttpClient();
	//	response = (TextView) findViewById(R.id.response);
	}
	public void accessSecret(View v)
	{
		response.setText("");
		new Thread()
		{
			@Override
			public void run()
			{
				// 创建一个HttpGet对象
				HttpGet get = new HttpGet(
						"http://192.168.1.88:8888/foo/secret.jsp");  // ①
				try
				{
					// 发送GET请求
					HttpResponse httpResponse = httpClient.execute(get);  // ②
					HttpEntity entity = httpResponse.getEntity();
					if (entity != null)
					{
						// 读取服务器响应
						BufferedReader br = new BufferedReader(
								new InputStreamReader(entity.getContent()));
						String line = null;

						while ((line = br.readLine()) != null)
						{
							Message msg = new Message();
							msg.what = 0x123;
							msg.obj = line;
							handler.sendMessage(msg);
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public void showLogin(View v)
	{
		
	
		btn_register = (Button)findViewById(R.id.btn_submit);
		btn_register.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
							

					et_username = (EditText) findViewById(R.id.sel_name);
					et_password = (EditText) findViewById(R.id.sel_pword);
					sel_like = (EditText) findViewById(R.id.sel_like);
					sel_daddr = (EditText) findViewById(R.id.sel_daddr);
					sel_sex  = (EditText) findViewById(R.id.sel_sex );
					sel_major = (EditText) findViewById(R.id.sel_major);
					sel_faln = (EditText) findViewById(R.id.sel_faln);			
					final String Ssel_name = et_username.getText().toString();
					final String Ssel_pword = et_password.getText().toString();
					String Ssel_like = et_password.getText().toString();
					String Ssel_daddr = et_password.getText().toString();
					String Ssel_sex = et_password.getText().toString();
					String Ssel_major = et_password.getText().toString();
					String Ssel_faln = et_password.getText().toString();
								new Thread()
								{
									@Override
									public void run()
									{
										try
										{
											HttpPost post = new HttpPost("http://2ae86f65.ngrok.io/test_myhttp/RegisterAction");//③
											// 如果传递参数个数比较多，可以对传递的参数进行封装
											List<NameValuePair> params = new ArrayList<>();
											params.add(new BasicNameValuePair
													("sel_name", Ssel_name));
											params.add(new BasicNameValuePair
													("sel_pword", Ssel_pword));
											// 设置请求参数
											post.setEntity(new UrlEncodedFormEntity(
													params, HTTP.UTF_8));
											// 发送POST请求
											HttpResponse response = httpClient
													.execute(post);  //④
											// 如果服务器成功地返回响应
											if (response.getStatusLine()
													.getStatusCode() == 200)
											{
												String msg = EntityUtils
														.toString(response.getEntity());
												Looper.prepare();
												// 提示登录成功
												Toast.makeText(Register3.this,
														"成功", Toast.LENGTH_SHORT).show();
												Looper.loop();
											}
										}
										catch (Exception e)
										{
											e.printStackTrace();
										}
									}
								}.start();
							}
		});
	}
}
