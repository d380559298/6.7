package com.example.runningegg2;



import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobGeoPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.runningegg1.R;
import com.example.runningegg2.ChatMainTabFragment.MySimpleAdapter;

import android.R.string;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.Toast;

public class FriendMainTabFragment extends Fragment
{	
	int[]images = new int[]
		{R.drawable.news,
		R.drawable.news2,
		R.drawable.news3
		};

	int currentImg = 0;
	private View view2;
	private ImageView image;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	int counter=0;
	public static final int NOTIFICATION_ID = 1200;
	//private Footballer footballer;
	//private Menu menu;
	
	
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState)
{
	
	view2 = View.inflate(getActivity(), R.layout.tab02, null);
	image = (ImageView) view2.findViewById(R.id.imageView1);
	ListView list2=(ListView) view2.findViewById(R.id.list2);
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
	SimpleAdapter myAdapter = new SimpleAdapter(this.getActivity().getApplicationContext(),listItems,
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
     
	return view2;
    
}
}