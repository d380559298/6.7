package com.example.runningegg2;

import Json.JsonTest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.runningegg1.R;
import com.example.runningegg2.Main.MySimpleAdapter;
import com.example.runningegg2.Main.MyThread;
import com.example.slidingmenu.view.SlidingMenu;


public class Main3 extends Activity
{	
	private EditText Eorder_name,Eorder_phon,Eorder_addr,Eorder_tips,Eorder_other,Eorder_date;
	private SlidingMenu mLeftMenu;
	private View view3;
	private ImageView image;
	private Button btnxinjian;
	private Button btnchakan;
	private TextView textView;
	private TextView textView2;
	private TextView textView3;
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	private ImageView mChatImageView;
	private ImageView mFriendImageView;
	private ImageView mContactImageView;
	public int flag;
	private ImageView addorder;

	private static final int INT_RESULT = 3;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			final ListView list3=(ListView) findViewById(R.id.list3);
			list3.setAdapter(null);			
			if (msg.what == INT_RESULT) {								
					list3.setAdapter((ListAdapter) msg.obj);
					Toast.makeText(Main3.this,  
	              			"查看订单成功" ,  
	                           Toast.LENGTH_SHORT).show();
				
				
			}
		};
	};
	
	protected void onCreate(Bundle savedInstanceState) 
	{	
		
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main3);
                mLeftMenu=(SlidingMenu)findViewById(R.id.id_menu);
		
/*		btnxinjian= (Button)findViewById(R.id.xinjian);
		 btnxinjian.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
		
				 new Thread(new MyThread()).start();
			 }
		 }
		 );
		 btnchakan= (Button)findViewById(R.id.chakan);
		 btnchakan.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 new Thread(new MyThread()).start();
				 
			 }
		 }
		 );
	*/	 
			addorder = (ImageView)findViewById(R.id.check);
			addorder.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
						  
					 b(); 
						 
					 
				 }
			 }
			 );
		 mChatTextView= (TextView)findViewById(R.id.id_tv_chat);
		 mChatTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main3.this , Main.class );
				 startActivity(intent);
				 finish();				
				 
			 }
		 }
		 );
		 
		 mChatImageView= (ImageView)findViewById(R.id.imageView1);
		 mChatImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main3.this ,Main.class );
				 startActivity(intent);
				 finish();				
				 
			 }
		 }
		 );
		 
		 mFriendTextView= (TextView)findViewById(R.id.id_tv_friend);
			mFriendTextView.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View v){
					 Intent intent = new Intent();
					 intent.setClass(Main3.this , Main2.class );
					 startActivity(intent);
					 finish();
				}
			}
			);
			mFriendImageView= (ImageView)findViewById(R.id.ImageView01);
			mFriendImageView.setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v){
						 Intent intent = new Intent();
						 intent.setClass(Main3.this , Main2.class );
						 startActivity(intent);	
						 finish();
					}
				}
				);

		 mContactTextView= (TextView)findViewById(R.id.id_tv_contact);
		 mContactTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
		//		 Intent intent = new Intent();
		//		 intent.setClass(Main3.this , Main3.class );
		//		 startActivity(intent); 
				 
			 }
		 }
		 );
		 mContactImageView= (ImageView)findViewById(R.id.ImageView02);
		 mContactImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
		//		 Intent intent = new Intent();
		//		 intent.setClass(Main3.this , Main3.class );
		//		 startActivity(intent); 
				 				 
			 }
		 }
		 );
		 new Thread(new MyThread()).start();
	String[] nameid={"张翠花","蠢乎","墩儿"};
	String[] phoneid={"13180961110","15688892344","15004348284"};
	String[] menuid={"土豆泥","鸭腿","火山飘雪"};
	String[] addressid={"第一教学楼a105","二基楼b310b","文科楼"};
	String[] otherid={"可以加小费的哦","急急急，好饿","可以没有这几道菜么么哒"};
	List<Map<String,Object>>listItems = new ArrayList<Map<String,Object>>();
	for(int i = 0; i<nameid.length;i++)
	{
		Map<String,Object>listItem = new HashMap<String,Object>();
		listItem.put("tv_nameid", nameid[i]);
		listItem.put("tv_phoneid",phoneid[i]);
		listItem.put("tv_menuid",menuid[i]);
		listItem.put("tv_addressid",addressid[i]);
		listItem.put("tv_otherid",otherid[i]);
		listItems.add(listItem);
	}
	SimpleAdapter myAdapter = new SimpleAdapter(Main3.this,listItems,
			R.layout.a3,
			new String[] {"tv_nameid","tv_phoneid","tv_menuid","tv_addressid","tv_otherid"},
			new int[] {R.id.tv_nameid,R.id.tv_phoneid,R.id.tv_menuid,R.id.tv_addressid,R.id.tv_otherid}  );
	
	final ListView list3=(ListView) findViewById(R.id.list3);
	list3.setAdapter(myAdapter);	
	 list3.setOnItemClickListener(new OnItemClickListener() {  
		   
        @Override  
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
                long arg3) { 
        	 HashMap<String,String> map=(HashMap<String,String>)list3.getItemAtPosition(arg2);   
             final String title=map.get("ord_name");   
             final String content=map.get("ord_phon");   
             Toast.makeText(getApplicationContext(),    
                     "你选择了第"+arg2+"个Item，itemTitle的值是："+title+"itemContent的值是:"+content,   
                     Toast.LENGTH_SHORT).show();  
         	
             new AlertDialog.Builder(Main3.this)
				.setTitle("联系订单")
				.setMessage("是否为您拨打"+content+"")
				.setIcon(R.drawable.comment)
				.setPositiveButton("确认",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
												int which)
							{
								   Intent intent = new Intent();
								   intent.setAction("android.intent.action.CALL");
								   intent.setData(Uri.parse("tel:"+content));
								   startActivity(intent);
							}
						}).setNegativeButton("取消", null).show();
        	new Thread()
			{
				@Override
				public void run()
				{
					try
					{
						
						HttpUtils utils=new HttpUtils();
						utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/Order_deleteAction";
						HttpUtils.setUrl(utils.PATH);
						Map<String,String> params=new HashMap<String,String>();
						params.put("ord_name", title);
						String result=utils.sendPostMessage(params,"utf-8",utils.url);
		     	   		
		     	   		if(result.equals("接单成功"))
		     	   		{
		     	   		Looper.prepare();
						
						Toast.makeText(Main3.this,
								"接单成功！", Toast.LENGTH_SHORT).show();
						Looper.loop();			
		     	   		}
		     	   	else{
		     	   		Looper.prepare();
						
						Toast.makeText(Main3.this,
								"接单失败", Toast.LENGTH_SHORT).show();
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
	public class MyThread implements Runnable {

		@Override
		public void run() {
			
		
		        HttpUtils utils=new HttpUtils();
		        utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/OrderAction";
		      //  utils.PATH="http://dasdasda";
				HttpUtils.setUrl(utils.PATH);
		        List<Map<String,Object>> net=new ArrayList<Map<String, Object>>();
				Map<String,String> params=new HashMap<String,String>();
				params.put("ord_date", "2016.6.4");
				
				String result=utils.sendPostMessage(params,"utf-8",utils.url);
				net=JsonTest.listKeyMaps("orders", result);
				
				
				if (true) {
					MySimpleAdapter myAdapter3 = new MySimpleAdapter(Main3.this,net,
							R.layout.a3,
							new String[] {"ord_name","ord_phon","ord_menu","ord_addr","ord_other"},
					        new int[] {R.id.tv_nameid,R.id.tv_phoneid,R.id.tv_menuid,R.id.tv_addressid,R.id.tv_otherid}   );
					Message message = Message.obtain();
					message.obj = myAdapter3;
					message.what = INT_RESULT;
					handler.sendMessage(message);
				}
				
				
			
				     
			
			
		}

	}
	
	
	public void b()
	{
		final View loginDialog = getLayoutInflater().inflate(
				R.layout.my_order, null);
		// 使用对话框供用户登录系统
		new AlertDialog.Builder(Main3.this)
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
											utils.PATH="http://08ab7ef3.ngrok.io/test_myhttp/Order_setAction";
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
											
											Toast.makeText(Main3.this,
													"上传成功！", Toast.LENGTH_SHORT).show();
											Looper.loop();
							     	   		}

							     	   		else{
							     	   		Looper.prepare();
											
											Toast.makeText(Main3.this,
													"失败了~  哈哈", Toast.LENGTH_SHORT).show();
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
    				 Toast.makeText(Main3.this,  
               			 "预约成功",  
                            Toast.LENGTH_SHORT).show();
    				 
    				 
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main3.this,  
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
    				 Toast.makeText(Main3.this,  
                			 "成功添加到我的喜欢",  
                             Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main3.this,  
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
   				 Toast.makeText(Main3.this,  
               			 "评论成功",  
                            Toast.LENGTH_SHORT).show();
   				 }
   				 else
   				 {
   				//	 textView.setTextColor(android.graphics.Color.WHITE);
   					 Toast.makeText(Main3.this,  
   	            			 "取消评论",  
   	                         Toast.LENGTH_SHORT).show(); 
   				 }
   			 }
            });

          return v;
        }
}
}
