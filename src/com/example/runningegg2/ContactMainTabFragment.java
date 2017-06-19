package com.example.runningegg2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.runningegg1.R;


public class ContactMainTabFragment extends Fragment
{	
	
	private View view3;
	private ImageView image;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		view3 = View.inflate(getActivity(), R.layout.tab03, null);
		ListView list3=(ListView) view3.findViewById(R.id.list3);
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
	SimpleAdapter myAdapter = new SimpleAdapter(this.getActivity().getApplicationContext(),listItems,
			R.layout.a3,
			new String[] {"tv_nameid","tv_phoneid","tv_menuid","tv_addressid","tv_otherid"},
			new int[] {R.id.tv_nameid,R.id.tv_phoneid,R.id.tv_menuid,R.id.tv_addressid,R.id.tv_otherid}  );
	list3.setAdapter(myAdapter);	
			
		
      
		return view3;
	    
	}
}
