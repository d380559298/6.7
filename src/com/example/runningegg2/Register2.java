package com.example.runningegg2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
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


public class Register2 extends Activity
{
	TextView response;
	HttpClient httpClient;
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
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
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
		// 加载登录界面
		final View loginDialog = getLayoutInflater().inflate(
				R.layout.register, null);
		// 使用对话框供用户登录系统
		new AlertDialog.Builder(Register2.this)
				.setTitle("登录系统")
				.setView(loginDialog)
				.setPositiveButton("登录",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
												int which)
							{
								// 获取用户输入的用户名、密码
								final String name = ((EditText) loginDialog
										.findViewById(R.id.sel_name)).getText()
										.toString();
								final String pass = ((EditText) loginDialog
										.findViewById(R.id.sel_pword)).getText()
										.toString();
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
													("sel_name", name));
											params.add(new BasicNameValuePair
													("sel_pword", pass));
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
												Toast.makeText(Register2.this,
														msg, Toast.LENGTH_SHORT).show();
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
						}).setNegativeButton("取消", null).show();
	}
}