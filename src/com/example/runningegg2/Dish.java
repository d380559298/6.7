package com.example.runningegg2;



import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import Json.JsonTest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.runningegg1.R;
import com.example.runningegg2.ChatMainTabFragment.MySimpleAdapter;
public class Dish extends Activity
{
	
	private TextView textView;
	private TextView textView2;
	private TextView textView3;
	private Button button;
	private static final int INT_RESULT = 1;
	String flag="一餐";
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			final ListView list = (ListView)findViewById(R.id.list1);
			list.setAdapter(null);
			if (msg.what == INT_RESULT) {
				Toast.makeText(Dish.this,  
              			"成功" ,  
                           Toast.LENGTH_SHORT).show();
				list.setAdapter((ListAdapter) msg.obj);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish);
		
		
		 Spinner spinner = (Spinner)findViewById(R.id.spinner);
	        ArrayList<String> data_list = new ArrayList<String>();
	        data_list.add("一餐");
	        data_list.add("二餐");
	        data_list.add("三餐");
	        data_list.add("小吃城");
	        ArrayAdapter<String> arr_adapter= new ArrayAdapter<String>(Dish.this, android.R.layout.simple_spinner_item, data_list);
	        //设置样式
	        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        //加载适配器
	        spinner.setAdapter(arr_adapter);
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {      
	            	 
	            	 if(position ==0)
	            	 {
	            		 flag="一餐";
	            		 new Thread(new MyThread()).start();
	            	 }
	            	 else if(position ==1)
	            	 {
	            		 flag="二餐";
	            		 new Thread(new MyThread()).start();
	            	 }
	            	 else if(position ==2)
	            	 {
	            		 flag="三餐";
	            		 new Thread(new MyThread()).start();
	            	 } 
	            	 else if(position ==3)
	            	 {
	            		 flag="小吃城";
	            		 new Thread(new MyThread()).start();
	            	 } 
	            	 
	            	 Toast.makeText(Dish.this,  
	            			 flag,  
	                         Toast.LENGTH_SHORT).show(); 
	            }

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}     	 
	            });
	        
		button = (Button) this.findViewById(R.id.button1);		
	    button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new MyThread()).start();
				
			}
		});
	}

	public class MyThread implements Runnable {

		@Override
		public void run() {
		        HttpUtils utils=new HttpUtils();

		        utils.PATH="http://08ab7ef3.ngrok.io/test_myhttp/DishesAction";
				HttpUtils.setUrl(utils.PATH);
		        List<Map<String,Object>> net=new ArrayList<Map<String, Object>>();
				Map<String,String> params=new HashMap<String,String>();
				params.put("dish_date", "5.20中");
				params.put("dish_cant", flag);
				
				String result=utils.sendPostMessage(params,"utf-8",utils.url);
				net=JsonTest.listKeyMaps("dishes", result);
				
				
				if (true) {
					MySimpleAdapter myAdapter2 = new MySimpleAdapter(Dish.this,net,
							R.layout.a1,
							new String[] {"dish_name","dish_remain","dish_cant","dish_order"},
					        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.tv_price}   );
					String a =(String)net.get(1).get("dish_name");
					Message message = Message.obtain();
					message.obj = myAdapter2;
					message.what = INT_RESULT;
					handler.sendMessage(message);
				}       
			
			
		}

	}
	
	

public class MySimpleAdapter extends SimpleAdapter{

    Context context;

    public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data,
     int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        // TODO Auto-generated constructor stub
    }

     public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View v = super.getView(position, convertView, parent);

            textView = (TextView) v.findViewById(R.id.tv_share_bottom);
    		textView.setOnClickListener(new Button.OnClickListener(){
    			int i = 1;
    			 public void onClick(View v){
    				 
    				 i = (-1)*i;
    				 
    				 if(i==-1)
    				 {
    		//			 textView.setTextColor(android.graphics.Color.RED);
    				 Toast.makeText(Dish.this,  
               			 "预约成功",  
                            Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Dish.this,  
    	            			 "取消预约",  
    	                         Toast.LENGTH_SHORT).show(); 
    				 }
    			  }  
           });
    		textView2 = (TextView) v.findViewById(R.id.tv_like_bottom);
    		textView2.setOnClickListener(new Button.OnClickListener(){
    			int i = 1;
    			 public void onClick(View v){
    				 i = (-1)*i;
    				// textView2.setTextColor(android.graphics.Color.RED);
    				 if(i==-1)
    				 {
    				 Toast.makeText(Dish.this,  
                			 "成功添加到我的喜欢",  
                             Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Dish.this,  
    	            			 "取消添加",  
    	                         Toast.LENGTH_SHORT).show(); 
    				 }
    			  }  
            });
    		textView3 = (TextView) v.findViewById(R.id.tv_comment_bottom);
    		textView3.setOnClickListener(new Button.OnClickListener(){
    			int i = 1;
   			 public void onClick(View v){
   				 i = (-1)*i;
   				// textView3.setTextColor(android.graphics.Color.RED);
   				 if(i==-1)
   				 {
   				 Toast.makeText(Dish.this,  
               			 "评论成功",  
                            Toast.LENGTH_SHORT).show();
   				 }
   				 else
   				 {
   				//	 textView.setTextColor(android.graphics.Color.WHITE);
   					 Toast.makeText(Dish.this,  
   	            			 "取消评论",  
   	                         Toast.LENGTH_SHORT).show(); 
   				 }
   			 }
            });

          return v;
        }
}

}
