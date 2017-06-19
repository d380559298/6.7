package com.example.runningegg2;



import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Json.JsonTest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runningegg1.R;
import com.example.runningegg2.Main3.MySimpleAdapter;
import com.example.runningegg2.Main3.MyThread;

public class Main2 extends Activity
{	
	private EditText Eorder_name,Eorder_phon,Eorder_addr,Eorder_tips,Eorder_other,Eorder_date;
	private static final int INT_RESULT = 3;
	private TextView textView;
	private TextView textView2;
	private TextView textView3;
	private EditText EditText1;
	private Button button1;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			final ListView list2=(ListView)findViewById(R.id.list2);
			list2.setAdapter(null);			
			if (msg.what == INT_RESULT) {								
					list2.setAdapter((ListAdapter) msg.obj);
					Toast.makeText(Main2.this,  
	              			"查看订单成功" ,  
	                           Toast.LENGTH_SHORT).show();
				
				
			}
		};
	};
	
	int[]images = new int[]
		{R.drawable.news,
		R.drawable.news2,
		R.drawable.news3
		};

	int currentImg = 0;

	private ImageView image;
	private Button button;
	public static final int NOTIFICATION_ID = 1200;
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	private ImageView mChatImageView;
	private ImageView mFriendImageView;
	private ImageView mContactImageView;
	public int flag;
	private ImageView addorder;

	protected void onCreate(Bundle savedInstanceState) 
	{	
	//	Bundle bundle = this.getIntent().getExtras();
	//	final String nameC = bundle.getString("name");
		final String nameStatic =Login.name;
		Toast.makeText(Main2.this,
				nameStatic, Toast.LENGTH_SHORT).show();
		 new Thread(new MyThread()).start();
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main2);
	 
		button1 = (Button)findViewById(R.id.btnsubmit);
		button1.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				
				        EditText1=(EditText) findViewById(R.id.editText2);
						
						
						final String content = EditText1.getText().toString();
						
					 new Thread()
						{
							@Override
							public void run()
							{
									HttpUtils utils=new HttpUtils();
									utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/Ads_setAction";
									HttpUtils.setUrl(utils.PATH);
									Map<String,String> params=new HashMap<String,String>();
									params.put("ads_editor",nameStatic);
									params.put("ads",content);
									params.put("ads_date", "6.6");					
									String result=utils.sendPostMessage(params,"utf-8",utils.url);
									
									if(result.equals("fail")){
										Looper.prepare();
										
										Toast.makeText(Main2.this,
												"评论失败！", Toast.LENGTH_SHORT).show();							 							
										Looper.loop();
										EditText1.setText("");	
								       }
									else{
										Looper.prepare();					
										Toast.makeText(Main2.this,
												"评论成功！", Toast.LENGTH_SHORT).show();								 							
										Looper.loop();
										EditText1.setText("");																	
										}  
							}
									
						}.start();
					}
				 
			 
			 
		 }
		 );
		
		
		
		 mChatImageView= (ImageView)findViewById(R.id.imageView1);
		 mChatImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main2.this ,Main.class );
				 startActivity(intent);
				 finish();
				 
			 }
		 }
		 );
		 mChatTextView= (TextView)findViewById(R.id.id_tv_chat);
		 mChatTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main2.this , Main.class );
				 startActivity(intent);
				 finish();
				 
			 }
		 }
		 );
			addorder = (ImageView)findViewById(R.id.check);
			addorder.setOnClickListener(new Button.OnClickListener(){
				 public void onClick(View v){
						  
					 b(); 
					 
				 }
			 }
			 );
		 
		 
		 mFriendTextView= (TextView)findViewById(R.id.id_tv_friend);
			mFriendTextView.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View v){
				//	 Intent intent = new Intent();
				//	 intent.setClass(Main2.this , Main2.class );
				//	 startActivity(intent);
				}
			}
			);
			mFriendImageView= (ImageView)findViewById(R.id.ImageView01);
			mFriendImageView.setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v){
			//			 Intent intent = new Intent();
			//			 intent.setClass(Main2.this , Main2.class );
			//			 startActivity(intent);	
					}
				}
				);

		 mContactTextView= (TextView)findViewById(R.id.id_tv_contact);
		 mContactTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main2.this , Main3.class );
				 startActivity(intent); 
				 finish();
			 }
		 }
		 );
		 mContactImageView= (ImageView)findViewById(R.id.ImageView02);
		 mContactImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(Main2.this , Main3.class );
				 intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
				 startActivity(intent); 
				 finish();
			 }
		 }
		 );
          
	image = (ImageView)findViewById(R.id.imageViewlun);
    ListView list2=(ListView)findViewById(R.id.list2);
	String[] id={"gb232123","dfsf4323","12133","小蠢乎","df342342","小墩儿","hahahaha","fsfew66666"};
	String[] comment={"土豆泥太好吃了","今天食堂阿姨好凶啊","其实阿姨每天都好凶啊","啊好饿啊想去吃饭","灌水水水水水水水水","今天的猪肝和平时一样难吃","在食堂把饭洒了一身","啊啊啊啊这些菜都好好吃"};
	List<Map<String,Object>>listItems = new ArrayList<Map<String,Object>>();
	for(int i = 0; i<id.length;i++)
	{
		Map<String,Object>listItem = new HashMap<String,Object>();
		listItem.put("tv_id", id[i]);
		listItem.put("tv_comment", comment[i]);
		listItems.add(listItem);
	}
	SimpleAdapter myAdapter = new SimpleAdapter(Main2.this.getApplicationContext(),listItems,
			R.layout.a2,
			new String[] {"tv_id","tv_comment"},new int[] {R.id.tv_id,R.id.tv_comment}  );
	list2.setAdapter(myAdapter);	
			
			
	new CountDownTimer(1000,1000) {

         @Override
         public void onTick(long millisUntilFinished) {}

         @Override
         public void onFinish() {
        	 image.setImageResource(images[++currentImg % images.length]);
            
             start();
         }
     }.start();

}
	

	
	public class MyThread implements Runnable {

		@Override
		public void run() {
			
		
		        HttpUtils utils=new HttpUtils();
		        utils.PATH="http://c62ea81f.ngrok.io/test_myhttp/AdsmanageAction";
		      //  utils.PATH="http://dasdasda";
				HttpUtils.setUrl(utils.PATH);
				List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
				Map<String,String> params=new HashMap<String,String>();
				String result=utils.sendPostMessage(params,"utf-8",utils.url);
				System.out.println("-result->"+result);
				list=JsonTest.listKeyMaps("ads", result);
	/*			System.out.println(list);
		        List<Map<String,Object>> net=new ArrayList<Map<String, Object>>();
				Map<String,String> params=new HashMap<String,String>();
				params.put("ord_date", "2016.6.4");
				
				String result=utils.sendPostMessage(params,"utf-8",utils.url);
				net=JsonTest.listKeyMaps("orders", result);
	*/			
				
				if (true) {
					MySimpleAdapter myAdapter3 = new MySimpleAdapter(Main2.this,list,
							R.layout.a2,
							new String[] {"ads_editor","ads"},
							new int[] {R.id.tv_id,R.id.tv_comment}  );
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
		new AlertDialog.Builder(Main2.this)
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
											
											Toast.makeText(Main2.this,
													"上传成功！", Toast.LENGTH_SHORT).show();
											Looper.loop();
							     	   		}

							     	   		else{
							     	   		Looper.prepare();
											
											Toast.makeText(Main2.this,
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
    				 Toast.makeText(Main2.this,  
               			 "预约成功",  
                            Toast.LENGTH_SHORT).show();
    				 
    				 
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main2.this,  
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
    				 Toast.makeText(Main2.this,  
                			 "成功添加到我的喜欢",  
                             Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(Main2.this,  
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
   				 Toast.makeText(Main2.this,  
               			 "评论成功",  
                            Toast.LENGTH_SHORT).show();
   				 }
   				 else
   				 {
   				//	 textView.setTextColor(android.graphics.Color.WHITE);
   					 Toast.makeText(Main2.this,  
   	            			 "取消评论",  
   	                         Toast.LENGTH_SHORT).show(); 
   				 }
   			 }
            });

          return v;
        }
}
}