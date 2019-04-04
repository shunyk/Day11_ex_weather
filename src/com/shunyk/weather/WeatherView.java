package com.shunyk.weather;

import java.util.ArrayList;

public class WeatherView {
	
	public void View(String str) {
		System.out.println(str);
	}
	
	public void Views(ArrayList<Weather> weathers) {
		for (int i=0; i<weathers.size(); i++) {
			Weather weather = weathers.get(i);
			this.View(weather);
			/*
			System.out.println("도시: " + weathers.get(i).getCity());
			System.out.println("날씨: " + weathers.get(i).getState());
			System.out.println("기온: " + weathers.get(i).getGion());
			System.out.println("습도: " + weathers.get(i).getHum());
			System.out.println("미세먼지: " + weathers.get(i).getMise());
			System.out.println("=======================");
			*/
		}
	}
	
	public void View(Weather weather) {
		System.out.println("도시: " + weather.getCity());
		System.out.println("날씨: " + weather.getState());
		System.out.println("기온: " + weather.getGion());
		System.out.println("습도: " + weather.getHum());
		System.out.println("미세먼지: " + weather.getMise());
		System.out.println("=======================");
	}
	
}
