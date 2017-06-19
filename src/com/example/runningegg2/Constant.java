package com.example.runningegg2;



import com.example.runningegg1.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Constant  {
	
	public static final String KEY = "5ba8185e24f3726d5f1651f31e8944c5";
	public static final String SECRET = "MqgD950D4m4HUUb8MQLpAcnRP-eXh9hk";
	
	
}

/*
    private ImageView mPhoto;
    
    private Button mGetImage;
    private Button mDetect;
    private TextView mTip;
    private View mWaitting;    
    private String mCurrentPhotoStr;
    private Bitmap mPhotoImg;
    
    private static final int PICK_CODE = 0X110;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.face);
		
		initViews();
		initEvents();
	
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		mGetImage.setOnClickListener(this);
		mDetect.setOnClickListener(this);
	}

	private void initViews() {
		mPhoto = (ImageView)findViewById(R.id.id_photo);
		mGetImage = (Button)findViewById(R.id.id_getImage);
		mDetect = (Button)findViewById(R.id.id_detect);
		mTip = (TextView)findViewById(R.id.id_tip);		
		mWaitting = (TextView)findViewById(R.id.id_waitting);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
		if(requestCode == PICK_CODE)
		{
			if(intent != null )
			{
				Uri uri = intent.getData();
				Cursor cursor = getContentResolver().query(uri, null, null, null, null);
			    cursor.moveToFirst();
			    int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
			    cursor.close();
			    
			    resizePhoto();
			    mPhoto.setImageBitmap(mPhotoImg);
			    mTip.setText("呼呼");
			
			}
		}
		super.onActivityResult(requestCode, requestCode, intent);
	}
    private void resizePhoto() {
	
    	BitmapFactory.Options options = new BitmapFactory.Options();
    	options.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile(mCurrentPhotoStr,options);
    	double ratio = Math.max(options.outWidth*1.0d/1024f, options.outHeight*1.0d/1024f);
		
    	options.inSampleSize = (int) Math.ceil(ratio);
		options.inJustDecodeBounds = false;
    	mPhotoImg = BitmapFactory.decodeFile(mCurrentPhotoStr,options);		
	}

	public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	case R.id.id_getImage:
    		Intent intent = new Intent();
    		intent.setType("image/*");
    		startActivityForResult(intent,PICK_CODE);
    		break;
    	}
    	
    }
	
}
*/