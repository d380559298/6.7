package com.example.runningegg2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.runningegg1.R;

public class Info implements Serializable
{
	private static final long serialVersionUID = -1010711775392052966L;
	private double latitude;
	private double longitude;
	private int imgId;
	private String name;
	private String distance;
	private int zan;

	public static List<Info> infos = new ArrayList<Info>();

	static
	{
		infos.add(new Info(30.564257,104.009359, R.drawable.a01, "计算机学院",
				"距离209米", 1456));
		infos.add(new Info(30.562788,104.006282, R.drawable.a02, "四川大学图书馆",
				"距离897米", 456));
		infos.add(new Info(30.565019,104.006942, R.drawable.a03, "建筑与环境学院",
				"距离249米", 1456));
		infos.add(new Info(30.562189,104.001867, R.drawable.a04, "艺术学院",
				"距离679米", 1456));

	}

	public Info(double latitude, double longitude, int imgId, String name,
			String distance, int zan)
	{
		this.latitude = latitude;
		this.longitude = longitude;
		this.imgId = imgId;
		this.name = name;
		this.distance = distance;
		this.zan = zan;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public int getImgId()
	{
		return imgId;
	}

	public void setImgId(int imgId)
	{
		this.imgId = imgId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDistance()
	{
		return distance;
	}

	public void setDistance(String distance)
	{
		this.distance = distance;
	}

	public int getZan()
	{
		return zan;
	}

	public void setZan(int zan)
	{
		this.zan = zan;
	}

}