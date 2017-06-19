package com.example.runningegg2;
import com.example.runningegg1.R;
import com.example.runningegg2.MainActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class Welcome2 extends Activity{	

	private TextView textView;
	private Button buttonRgt;
	private Button buttonLog;
	private ImageView imageView1;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.welcome2);
			
			 textView= (TextView)findViewById(R.id.textView1);
			 textView.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
				
					 Intent intent = new Intent();
					 intent.setClass(Welcome2.this ,MainActivity.class );					 
					 startActivity(intent);
					 
					 
				 }
			 }
			 );
			 imageView1 = (ImageView)findViewById(R.id.imageView1);
			 imageView1.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
				
					 Intent intent = new Intent();
					 intent.setClass(Welcome2.this ,Main.class );					
					 startActivity(intent);
					 
					 
				 }
			 }
			 );
		        	 
			 buttonRgt= (Button)findViewById(R.id.button2);
			 buttonRgt.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
				
					 Intent intent = new Intent();
					 intent.setClass(Welcome2.this , Register.class );
					 startActivity(intent);
					 
					 
				 }
			 }
			 );

			 buttonLog= (Button)findViewById(R.id.button1);
			 buttonLog.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
				
					 Intent intent = new Intent();
					 intent.setClass(Welcome2.this , Login.class );
					 startActivity(intent);
					 
					 
				 }
			 }
			 );

	}
	}