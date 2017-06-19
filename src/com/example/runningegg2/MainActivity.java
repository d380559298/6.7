package com.example.runningegg2;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;



import cn.bmob.v3.Bmob;

import com.example.runningegg1.R;


public class MainActivity extends FragmentActivity
{
	
	public static final String KEY = "";
	public static final String SECRET = "";
	public static final int NOTIFICATION_ID = 1200;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	private LinearLayout mChatLinearLayout;
	int counter = 0;
	private ImageView mTabline;
	private int mScreen1_3;
	private Button button;
	private Button button1;
	private Button button2;
	private Button button3;
	private ImageView mChatImageView;
	private ImageView mFriendImageView;
	private ImageView mContactImageView;
	private ImageView addorder;
	private ImageView more;
    private ImageView mImageView;
    private ImageView mImageView2;
    private ImageView mImageView3;
	private int mCurrentPageIndex;
	private FragmentController controller;
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Bmob.initialize(this,"47ff1048e8db6a621e4c1ba0a71989a7");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		controller = FragmentController.getInstance(this, R.id.container);
		controller.showFragment(0);
	/*	
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
		//		 Intent intent = new Intent();
		//		 intent.setClass(MainActivity.this , face.class );
		//		 startActivity(intent);
				 
				 counter++;
				 Builder build = new NotificationCompat.Builder(MainActivity.this);
			     build.setSmallIcon(R.drawable.ic_launcher);
			     build.setContentTitle("浣犳湁"+counter+"鏉℃柊娑堟伅锛�");
			     build.setContentText("娆㈣繋浣跨敤鎮﹁");
			     Notification notification = build.build();
			     
			     notification.defaults = Notification.DEFAULT_ALL;
			     notification.flags |= Notification.FLAG_SHOW_LIGHTS;
			     notification.flags |= Notification.FLAG_AUTO_CANCEL;
			   //  notification.defaults = Notification.DEFAULT_LIGHTS;
			  //   notification.defaults = Notification.DEFAULT_SOUND;
			 //    notification.defaults = Notification.DEFAULT_VIBRATE;
			    		     
			     NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			     manager.notify(NOTIFICATION_ID, notification);	   			   
			        Intent intent = new Intent(MainActivity.this,send.class);  
			        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);  
			        build.setContentIntent(pendingIntent)  ;
			        
			 }
		 }
		 );
		
		
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(MainActivity.this , send.class );
				 startActivity(intent);
				 
			 
			 }
		 }
		 );
		button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(MainActivity.this , map1.class );
				 startActivity(intent);

			 }
		 }
		 );
		
		mImageView = (ImageView)findViewById(R.id.check);
		 mImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
			//	 intent.setClass(MainActivity.this , check.class );
			//	 startActivity(intent);
				 
			 }
		 }
		 );
		 
		 mImageView2= (ImageView)findViewById(R.id.search);
		 mImageView2.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(MainActivity.this , map.class );
				 startActivity(intent);
				 
			 }
		 }
		 );
		 
		 
		 mImageView3= (ImageView)findViewById(R.id.me);
		 mImageView3.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 Intent intent = new Intent();
				 intent.setClass(MainActivity.this , map1.class );
				 startActivity(intent);
				 
			 }
		 }
		 ); */
			
		addorder = (ImageView)findViewById(R.id.check);
		addorder.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
					  
	            	 
//	               ToastUtils.showToast(getActivity(), "add", Toast.LENGTH_SHORT);
	     		TableLayout loginForm = (TableLayout)getLayoutInflater()
	     				.inflate(R.layout.my_order,null);
	     		AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
	     		build.setView(loginForm);
	     		build.setTitle("新建订单");
	     		build.setPositiveButton("创建", null);
	     		build.setNegativeButton("取消",null);
	     		build.create().show();
					 
				 
			 }
		 }
		 );
		 mChatTextView= (TextView)findViewById(R.id.id_tv_chat);
		 mChatTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
			
				 mViewPager.setCurrentItem(0, false);
				 
			 }
		 }
		 );
		 
		 mChatImageView= (ImageView)findViewById(R.id.imageView1);
		 mChatImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
			
				 mViewPager.setCurrentItem(0, false);
				 
			 }
		 }
		 );
		 
		 mFriendTextView= (TextView)findViewById(R.id.id_tv_friend);
			mFriendTextView.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View v){
					mViewPager.setCurrentItem(1, false);
				}
			}
			);
			mFriendImageView= (ImageView)findViewById(R.id.ImageView01);
			mFriendImageView.setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v){
						mViewPager.setCurrentItem(1, false);
					}
				}
				);

		 mContactTextView= (TextView)findViewById(R.id.id_tv_contact);
		 mContactTextView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 mViewPager.setCurrentItem(2, false);
				 
			 }
		 }
		 );
		 mContactImageView= (ImageView)findViewById(R.id.ImageView02);
		 mContactImageView.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
				 mViewPager.setCurrentItem(2, false);
				 
			 }
		 }
		 );
           

		initTabLine();
		initView();
	}


	
	private void initTabLine()
	{
		mTabline = (ImageView) findViewById(R.id.id_iv_tabline);
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		mScreen1_3 = outMetrics.widthPixels / 3;
		LayoutParams lp = mTabline.getLayoutParams();
		lp.width = mScreen1_3;
		mTabline.setLayoutParams(lp);
	}

	@SuppressWarnings("deprecation")
	private void initView()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mChatTextView = (TextView) findViewById(R.id.id_tv_chat);
		mFriendTextView = (TextView) findViewById(R.id.id_tv_friend);
		mContactTextView = (TextView) findViewById(R.id.id_tv_contact);
		mChatLinearLayout = (LinearLayout) findViewById(R.id.id_ll_chat);
	
		mDatas = new ArrayList<Fragment>();

		ChatMainTabFragment tab01 = new ChatMainTabFragment();
		FriendMainTabFragment tab02 = new FriendMainTabFragment();
		ContactMainTabFragment tab03 = new ContactMainTabFragment();

		mDatas.add(tab01);
		mDatas.add(tab02);
		mDatas.add(tab03);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
				return mDatas.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mDatas.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int position)
			{
				resetTextView();
				switch (position)
				{
				case 0:
				/*	if (mBadgeView != null)
					{
						mChatLinearLayout.removeView(mBadgeView);
					}
					mBadgeView = new BadgeView(MainActivity.this);
					mBadgeView.setBadgeCount(7);
					mChatLinearLayout.addView(mBadgeView);
                 */
					mChatTextView.setTextColor(Color.parseColor("#008000"));
					break;
				case 1:
					mFriendTextView.setTextColor(Color.parseColor("#008000"));
					break;
				case 2:
					mContactTextView.setTextColor(Color.parseColor("#008000"));
					break;

				}

				mCurrentPageIndex = position;

			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPx)
			{
				Log.e("TAG", position + " , " + positionOffset + " , "
						+ positionOffsetPx);

				LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabline
						.getLayoutParams();

				if (mCurrentPageIndex == 0 && position == 0)// 0->1
				{
					lp.leftMargin = (int) (positionOffset * mScreen1_3 + mCurrentPageIndex
							* mScreen1_3);
				} else if (mCurrentPageIndex == 1 && position == 0)// 1->0
				{
					lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1)
							* mScreen1_3);
				} else if (mCurrentPageIndex == 1 && position == 1) // 1->2
				{
					lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset
							* mScreen1_3);
				} else if (mCurrentPageIndex == 2 && position == 1) // 2->1
				{
					lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + ( positionOffset-1)
							* mScreen1_3);
				}
				mTabline.setLayoutParams(lp);

			}
			public void onClick(View v)
			{
				clickTab(v);

			}

			private void clickTab(View v)
			{
				

				switch (v.getId())
				{
				case R.id.id_tv_chat:
				//	mTabIndicators.get(0).setIconAlpha(1.0f);
					mViewPager.setCurrentItem(0, false);
					break;
				case R.id.id_tv_friend:
			//		mTabIndicators.get(1).setIconAlpha(1.0f);
					mViewPager.setCurrentItem(1, false);
					break;
				case R.id.id_tv_contact:
			//		mTabIndicators.get(2).setIconAlpha(1.0f);
					mViewPager.setCurrentItem(2, false);
					break;
			//	case R.id.id_indicator_four:
			//		mTabIndicators.get(3).setIconAlpha(1.0f);
			//		mViewPager.setCurrentItem(3, false);
			//		break;
				}
			}

			
			@Override
			public void onPageScrollStateChanged(int arg0)
			{
				// TODO Auto-generated method stub

			}
		});

	}

	protected void resetTextView()
	{
		mChatTextView.setTextColor(Color.BLACK);
		mFriendTextView.setTextColor(Color.BLACK);
		mContactTextView.setTextColor(Color.BLACK);
	}

}
