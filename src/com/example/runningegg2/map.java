package com.example.runningegg2;


import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.example.runningegg1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;



public class map extends ActionBarActivity {


	private MapView mapView;
    private AMap amap;
    Button button1;
    Button button2;
    Button button3;
    
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		button1 = (Button)findViewById(R.id.triffic);
		button1.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){

				 amap.setTrafficEnabled(true);
			 }
		 }
		 );
		button2 = (Button)findViewById(R.id.night);
		button2.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){

				 amap.setMapType(AMap.MAP_TYPE_NIGHT);
			 }
		 }
		 );
		button3 = (Button)findViewById(R.id.normal);
		button3.setOnClickListener(new Button.OnClickListener(){
			 public void onClick(View v){
	 
				 amap.setMapType(AMap.MAP_TYPE_NORMAL);
			 }
		 }
		 );
		
		mapView = (MapView)findViewById(R.id.map); 
		mapView.onCreate(savedInstanceState);
		amap = mapView.getMap();
		MarkerOptions markeroptions = new MarkerOptions();
		markeroptions.position(new LatLng(39.90403,116.407525));
		markeroptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.egg));
		Marker marker = amap.addMarker(markeroptions);
				

	
		
	}
	

	 
	 public void onResume()
	 {
		 super.onResume();
		 mapView.onResume();
		 
	 }
	 public void onPause()
	 {
		 super.onPause();
		 mapView.onPause();
	 }
	 public void onDestory()
	 {
		 super.onDestroy();
		 mapView.onDestroy();
	 }
	 

}
