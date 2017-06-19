package com.example.runningegg2;



import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import Json.JsonTest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runningegg1.R;
import com.example.runningegg2.Dish.MySimpleAdapter;
import com.example.runningegg2.Dish.MyThread;
import com.example.slidingmenu.view.SlidingMenu;
public class Main_for_adm extends Activity
{	
    private SlidingMenu mLeftMenu;	
	//String order_name,order_phon,order_addr,order_tips,order_other,order_date;
	private EditText Eorder_name,Eorder_phon,Eorder_addr,Eorder_tips,Eorder_other,Eorder_date;
	private ImageView im;
	private Button btn_add;
	private Button btn_del;
	private Button btn_alt;
	private View view;
	public static String money="5个";
	protected MainActivity activity;
	private TextView textView;
	private TextView textView2;
	private TextView textView3;
	private TextView TextViewName;
	private TextView TextViewMoney;
	private TextView TextViewmap;
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	private ImageView mChatImageView;
	private ImageView mFriendImageView;
	private ImageView mContactImageView;
	private static final int INT_RESULT = 1;
	String flag="一餐";
	private ImageView addorder;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			final ListView list = (ListView)findViewById(R.id.list1);
			list.setAdapter(null);
			if (msg.what == INT_RESULT) {
				
				list.setAdapter((ListAdapter)msg.obj);
				Toast.makeText(Main_for_adm.this,  
              			"成功" ,  
                           Toast.LENGTH_SHORT).show();
			}
		};
	};
	
	
	
	protected void onCreate(Bundle savedInstanceState) 
	{	
	
	//	Bundle bundle = this.getIntent().getExtras();
	//	final String nameC = bundle.getString("name");
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.administer);
	    
	    
	    
	    
	    
	    btn_add= (Button)findViewById(R.id.btn_add);
		 mChatTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
			
			 }
		 }
		 );
		 
		 
	    TextViewName = (TextView)findViewById(R.id.TextViewName);
	    TextViewName.setText("我的姓名:    "+Login.name);
	    TextViewMoney = (TextView)findViewById(R.id.TextViewMoney);
	    TextViewMoney.setText("我的卤蛋币:   "+money);
	    TextViewmap = (TextView)findViewById(R.id.TextViewmap);
	    TextViewmap.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main_for_adm.this , map1.class );	
				 startActivity(intent);
			 }
		 }
		 );
        mLeftMenu=(SlidingMenu)findViewById(R.id.id_menu);         
        addorder = (ImageView)findViewById(R.id.check);
 		addorder.setOnClickListener(new Button.OnClickListener(){
 			 public void onClick(View v){
 				b(); 
 				 
 			 }
 		});
		 mChatTextView= (TextView)findViewById(R.id.id_tv_chat);
		 mChatTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main_for_adm.this , map1.class );
			//	 startActivity(intent);
				
				 
			 }
		 }
		 );
		 
		 mChatImageView= (ImageView)findViewById(R.id.imageView1);
		 mChatImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main_for_adm.this , map1.class );
				 startActivity(intent);			 
			 }
		 }
		 );
		 
		 mFriendTextView= (TextView)findViewById(R.id.id_tv_friend);
			mFriendTextView.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View v){
					 Intent intent = new Intent();
					 intent.setClass(Main_for_adm.this , Main2.class );
					 intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
					 
				//	 Bundle bundle = new Bundle();
				//     bundle.putString("name", nameC);
					 intent.setClass(Main_for_adm.this ,Main2.class );
				//	 intent.putExtras(bundle);
					 startActivity(intent);	
								 
					 finish();
				}
			}
			);
			mFriendImageView= (ImageView)findViewById(R.id.ImageView01);
			mFriendImageView.setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v){
						 Intent intent = new Intent();
						 intent.setClass(Main_for_adm.this , Main2.class );
				//		 Bundle bundle = new Bundle();
				//	     bundle.putString("name", nameC);					
				//		 intent.putExtras(bundle);
						 startActivity(intent);	
									 
						 finish();
					}
				}
				);

		 mContactTextView= (TextView)findViewById(R.id.id_tv_contact);
		 mContactTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main_for_adm.this , Main3.class );
				 startActivity(intent); 
				 finish();				 
			 }
		 }
		 );
		 mContactImageView= (ImageView)findViewById(R.id.ImageView02);
		 mContactImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main_for_adm.this , Main3.class );
				 startActivity(intent); 
				 finish();
			 }
		 }
		 );
          	
	
		 Spinner spinner = (Spinner)findViewById(R.id.spinner);
	        ArrayList<String> data_list = new ArrayList<String>();
	        data_list.add("一餐");
	        data_list.add("二餐");
	        data_list.add("三餐");
	        data_list.add("小吃城");
	        ArrayAdapter<String> arr_adapter= new ArrayAdapter<String>(Main_for_adm.this, android.R.layout.simple_spinner_item, data_list);
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
	            	 
	            	 Toast.makeText(Main_for_adm.this,  
	            			 flag,  
	                         Toast.LENGTH_SHORT).show();           
	            	 
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {
	                // TODO Auto-generated method stub    
	            }
	        });
	   
	    		
		String[] name = { "孙悟空","猪八戒","刁刁"};
		String[] decs = { "很好","一般","很胖"};
		String[] price ={ "10元","20元","0.5元"};
		int[] imageIds = new int[]
				{
				   R.drawable.f1,
				   R.drawable.f1,
				   R.drawable.f1,
				};
		String[] addr = {"二餐","一餐","三餐"};
		List<Map<String,Object>>listItems = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<name.length;i++)
		{
			Map<String,Object>listItem = new HashMap<String,Object>();
			listItem.put("tv_name", name[i]);
			listItem.put("tv_desc", decs[i]);
			listItem.put("tv_addr", addr[i]);
			listItem.put("pic", imageIds[i]);
			listItem.put("price", price[i]);
			listItems.add(listItem);
		}
		
		MySimpleAdapter myAdapter = new MySimpleAdapter(Main_for_adm.this.getApplicationContext(),listItems,
				R.layout.a1,
				new String[] {"tv_name","tv_desc","tv_addr","pic","price"},
		        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.pic,R.id.tv_price}   );
		String[] name1 = { "土豆粉","鸡翅","水饺"};
		String[] decs1 = { "很好","一般","很胖"};
		String[] price1 ={ "3元","9元","5元"};
		int[] imageIds1 = new int[]
				{
				   R.drawable.f1,
				   R.drawable.f1,
				   R.drawable.f1,
				};
		String[] addr1 = {"一餐","一餐","一餐"};
		List<Map<String,Object>>listItems1 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<name.length;i++)
		{
			Map<String,Object>listItem1 = new HashMap<String,Object>();
			listItem1.put("tv_name", name1[i]);
			listItem1.put("tv_desc", decs1[i]);
			listItem1.put("tv_addr", addr1[i]);
			listItem1.put("pic", imageIds1[i]);
			listItem1.put("price", price1[i]);
			listItems1.add(listItem1);
		}
		MySimpleAdapter myAdapter1 = new MySimpleAdapter(Main_for_adm.this.getApplicationContext(),listItems1,
				R.layout.a1,
				new String[] {"tv_name","tv_desc","tv_addr","pic","price"},
		        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.pic,R.id.tv_price}   );
		String[] name2 = { "水煮鱼","麻婆豆腐","剁椒鱼头"};
		String[] decs2 = { "很好","一般","很胖"};
		String[] price2 ={ "31元","32元","33元"};
		int[] imageIds2 = new int[]
				{
				   R.drawable.f1,
				   R.drawable.f1,
				   R.drawable.f1,
				};
		String[] addr2 = {"二餐","二餐","二餐"};
		List<Map<String,Object>>listItems2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<name.length;i++)
		{
			Map<String,Object>listItem2 = new HashMap<String,Object>();
			listItem2.put("tv_name", name2[i]);
			listItem2.put("tv_desc", decs2[i]);
			listItem2.put("tv_addr", addr2[i]);
			listItem2.put("pic", imageIds2[i]);
			listItem2.put("price", price2[i]);
			listItems2.add(listItem2);
		}
		
		MySimpleAdapter myAdapter2 = new MySimpleAdapter(Main_for_adm.this.getApplicationContext(),listItems2,
				R.layout.a1,
				new String[] {"tv_name","tv_desc","tv_addr","pic","price"},
		        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.pic,R.id.tv_price}   );
		ListView list = (ListView)findViewById(R.id.list1);
		list.setAdapter(myAdapter2);
		
		
	}



	public void toggleMenu(View view)
	{
		mLeftMenu.toggle();
	}



	public void b()
	{
		final View loginDialog = getLayoutInflater().inflate(
				R.layout.my_order, null);
		// 使用对话框供用户登录系统
		new AlertDialog.Builder(Main_for_adm.this)
				.setTitle("创建订单")
				.setView(loginDialog)
				.setPositiveButton("创建",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
												int which)
							{
								 Eorder_name = (EditText)loginDialog.findViewById(R.id.order_name);
			 	     	  		 Eorder_phon = (EditText)loginDialog.findViewById(R.id.order_phon);
			 	     	  		 Eorder_addr = (EditText)loginDialog.findViewById(R.id.order_addr);
			 	     	  		 Eorder_tips = (EditText)loginDialog.findViewById(R.id.order_tips);
			 	     	  		 Eorder_other = (EditText)loginDialog.findViewById(R.id.order_other);
			 	     	         final String  order_name = Eorder_name.getText().toString();
			 	     	         final String  order_phon = Eorder_phon.getText().toString();
			 	     	         final String  order_addr = Eorder_addr.getText().toString();
			 	     	         final String  order_tips = Eorder_tips.getText().toString();
			 	     	         final String  order_other = Eorder_other.getText().toString();
								
								new Thread()
								{
									@Override
									public void run()
									{
										try
										{
											HttpUtils utils=new HttpUtils();
											utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/Order_setAction";
											HttpUtils.setUrl(utils.PATH);
							     	        Map<String,String> params=new HashMap<String,String>();
							     	   		params.put("ord_name", order_name);
							     	   		params.put("ord_phon", order_phon);
							     	   		params.put("ord_addr", order_addr);
							     	   		params.put("ord_menu", order_tips);
							     	   		params.put("ord_other", order_other);
							     	   		params.put("ord_date", "2016.6.4");
							     	   		String result=utils.sendPostMessage(params,"utf-8",utils.url);
							     	   		
							     	   		if(result.equals("订单已上传"))
							     	   		{
							     	   		Looper.prepare();
											
											Toast.makeText(Main_for_adm.this,
													"上传成功！", Toast.LENGTH_SHORT).show();
											Looper.loop();
							     	   		}

							     	   		else{
							     	   		Looper.prepare();
											
											Toast.makeText(Main_for_adm.this,
													"亲~   您的网络不好哦！", Toast.LENGTH_SHORT).show();
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
	public class MyThread implements Runnable {

		@Override
		public void run() {
		        HttpUtils utils=new HttpUtils();
		        utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/DishesAction";
				HttpUtils.setUrl(utils.PATH);
		        List<Map<String,Object>> net=new ArrayList<Map<String, Object>>();
				Map<String,String> params=new HashMap<String,String>();
				params.put("dish_date", "5.20中");
				params.put("dish_cant", flag);
				String result=utils.sendPostMessage(params,"utf-8",utils.url);
				net=JsonTest.listKeyMaps("dishes", result);
				if (true) {
					MySimpleAdapter myAdapter2 = new MySimpleAdapter(Main_for_adm.this,net,
							R.layout.a1,
							new String[] {"dish_name","dish_ingr","dish_cant","dish_price"},
					        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.tv_price}   );
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
    				 Toast.makeText(Main_for_adm.this,  
               			 "预约成功",  
                            Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main_for_adm.this,  
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
    				 Toast.makeText(Main_for_adm.this,  
                			 "成功添加到我的喜欢",  
                             Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main_for_adm.this,  
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
   				 Toast.makeText(Main_for_adm.this,  
               			 "评论成功",  
                            Toast.LENGTH_SHORT).show();
   				 }
   				 else
   				 {
   				//	 textView.setTextColor(android.graphics.Color.WHITE);
   					 Toast.makeText(Main_for_adm.this,  
   	            			 "取消评论",  
   	                         Toast.LENGTH_SHORT).show(); 
   				 }
   			 }
            });

          return v;
        }
}
}