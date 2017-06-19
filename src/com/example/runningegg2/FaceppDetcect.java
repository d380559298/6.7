package com.example.runningegg2;

import java.io.ByteArrayOutputStream;

import org.json.JSONObject;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.facepp.*;


import android.graphics.Bitmap;
import android.util.Log;

public class FaceppDetcect {
	
	
	public interface CallBack
	{
		void success (JSONObject result);
		void error(FaceppParseException exception);
	}
	
	public static void detect(final Bitmap bm,final CallBack callBack)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
			
				
				try
				{
					HttpRequests requests = new HttpRequests(Constant.KEY,Constant.SECRET,true,true);  
					   
					Bitmap bmSmall = Bitmap.createBitmap(bm,0,0,bm.getWidth(),bm.getHeight());
				
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					
					bmSmall.compress(Bitmap.CompressFormat.JPEG, 100, stream);
				    
					byte[] arrays = stream.toByteArray();
				
					PostParameters params  = new PostParameters();
					params.setImg(arrays);
					JSONObject jsonObject = requests.detectionDetect(params);
					
					//
					
					Log.e("我在这",jsonObject.toString());
					if(callBack != null)
					{
						callBack.success(jsonObject);
					}
				}
				catch (FaceppParseException e)
				{
					e.printStackTrace();
					
					if(callBack != null)
					{
						callBack.error(e);
					}
				}
				
			}
		}).start();
	}

}
