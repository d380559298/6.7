package com.example.runningegg2;



import http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Json.JsonTest;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runningegg1.R;

import com.example.runningegg2.MainActivity;
public class Copy_2_of_ChatMainTabFragment extends Fragment
{	
	
	private ImageView im;
	private Button button;
	private View view;
	protected MainActivity activity;
	private TextView textView;
	private TextView textView2;
	private TextView textView3;
	private Spinner spinner;
	public int flag;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{   
//		View root = inflater.inflate(R.layout.tab01,container,false);
		activity = (MainActivity) getActivity();
		view = View.inflate(activity, R.layout.tab01, null);
           
		 Spinner spinner = (Spinner)view.findViewById(R.id.spinner);
	        ArrayList<String> data_list = new ArrayList<String>();
	        data_list.add("一餐");
	        data_list.add("二餐");
	        data_list.add("三餐");
	        data_list.add("小吃城");
	        ArrayAdapter<String> arr_adapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, data_list);
	        //设置样式
	        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        //加载适配器
	        spinner.setAdapter(arr_adapter);
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {      
	            	 Toast.makeText(getActivity(),  
	            			 "以选择"+position+"餐",  
	                         Toast.LENGTH_SHORT).show();  
	            	 if(position ==0)
	            	 {
	            		 flag=1;
	            	 }
	            	 else if(position ==1)
	            	 {
	            		 flag=2;
	            	 }           
	            	 
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {
	                // TODO Auto-generated method stub    
	            }
	        });
	        final int[] imageIds8 = new int[]
					{
					   R.drawable.f1,
					   R.drawable.f1,
					   R.drawable.f1,
					};
	        
	        new Thread()
			{
				@Override
				public void run()
				{
	        
	        HttpUtils utils=new HttpUtils();
			utils.PATH="http://2ae86f65.ngrok.io/test_myhttp/LoginAction";
			HttpUtils.setUrl(utils.PATH);
	        List<Map<String,Object>> net=new ArrayList<Map<String, Object>>();
			Map<String,String> params=new HashMap<String,String>();
			params.put("dish_cant", "5.20中");
			String result=utils.sendPostMessage(params,"utf-8",utils.url);
			net=JsonTest.listKeyMaps("dishes", result);
			
			ArrayList<String> dish_name = new ArrayList<String>();
			ArrayList<String> dish_cant = new ArrayList<String>();
			ArrayList<String> dish_remain = new ArrayList<String>();
			ArrayList<String> dish_order = new ArrayList<String>();
			for (Map<String, Object> m : net)  
			   {  
			       dish_name.add((String) m.get("dish_name"));
			       dish_cant.add((String) m.get("dish_cant"));
			       dish_remain.add((String) m.get("dish_remain"));
			       dish_order.add((String) m.get("dish_order"));
			   }
			List<Map<String,Object>>listItems8 = new ArrayList<Map<String,Object>>();
			for(int i = 0; i<dish_name.size();i++)
			{
				Map<String,Object>listItem = new HashMap<String,Object>();
				listItem.put("tv_name", dish_name.get(i));
				listItem.put("tv_desc", dish_remain.get(i));
				listItem.put("tv_addr", dish_cant.get(i));
				listItem.put("pic", imageIds8[i]);
				listItem.put("price", dish_order.get(i));
				listItems8.add(listItem);
			}
				
			
			MySimpleAdapter myAdapter8 = new MySimpleAdapter(getActivity().getApplicationContext(),listItems8,
					R.layout.a1,
					new String[] {"tv_name","tv_desc","tv_addr","pic","price"},
			        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.pic,R.id.tv_price}   );
	        
		ListView list = (ListView)view.findViewById(R.id.list1);
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
		
		MySimpleAdapter myAdapter = new MySimpleAdapter(getActivity().getApplicationContext(),listItems,
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
		MySimpleAdapter myAdapter1 = new MySimpleAdapter(getActivity().getApplicationContext(),listItems1,
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
		
		MySimpleAdapter myAdapter2 = new MySimpleAdapter(getActivity().getApplicationContext(),listItems2,
				R.layout.a1,
				new String[] {"tv_name","tv_desc","tv_addr","pic","price"},
		        new int[] {R.id.tv_name,R.id.tv_desc,R.id.tv_addr,R.id.pic,R.id.tv_price}   );
		list.setAdapter(myAdapter8);
		
		
		
		if(flag ==1)
		{
		//	list.removeAllViewsInLayout();
		//	((List<Map<String, Object>>) myAdapter).clear();
			
			myAdapter.notifyDataSetChanged() ;
			list.setAdapter(myAdapter1);
			
		}
		else if(flag ==2)
		{
	//		list.removeAllViewsInLayout();
	//		((List<Map<String, Object>>) myAdapter).clear();
			myAdapter.notifyDataSetChanged() ;
			list.setAdapter(myAdapter2);
		}
		else
		{
			list.removeAllViewsInLayout();
			list.setAdapter(myAdapter);
		}
				}
			}.start();
		return view;		
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
    				 Toast.makeText(getActivity(),  
               			 "预约成功",  
                            Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(getActivity(),  
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
    				 Toast.makeText(getActivity(),  
                			 "成功添加到我的喜欢",  
                             Toast.LENGTH_SHORT).show();
    				 }
    				 else
    				 {
    					// textView.setTextColor(android.graphics.Color.WHITE);
    					 Toast.makeText(getActivity(),  
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
   				 Toast.makeText(getActivity(),  
               			 "评论成功",  
                            Toast.LENGTH_SHORT).show();
   				 }
   				 else
   				 {
   				//	 textView.setTextColor(android.graphics.Color.WHITE);
   					 Toast.makeText(getActivity(),  
   	            			 "取消评论",  
   	                         Toast.LENGTH_SHORT).show(); 
   				 }
   			 }
            });

          return v;
        }
}
}