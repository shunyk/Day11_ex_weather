package com.shunyk.weather;

import java.util.ArrayList;
import java.util.Scanner;

public class WeatherInit {
	
	private String info;
	
	public WeatherInit() {
		info = "seoul ,맑음 ,10 ,20 ,0.3 , daejon, 비, -22, 50, 0.1,"
				+ "incheon ,태풍 , 56, 90, 22.2, jeju, 흐림, 15,10 ,1.2";
	}

	
	public ArrayList<Weather> getWeathers() {
		ArrayList<Weather> weathers = new ArrayList<Weather>();
		String[] ar =info.split(",");
		int count=0;
		for(int i=0; i<ar.length; i++) {
			Weather weather = new Weather();
			weather.setCity(ar[i].trim());
			weather.setState(ar[++i].trim());
			weather.setGion(Integer.valueOf(ar[++i].trim()));
			weather.setHum(Integer.valueOf(ar[++i].trim()));
			weather.setMise(Double.valueOf(ar[++i].trim()));
			weathers.add(weather);
		}
		
		for(int i=0; i<weathers.size(); i++) {
			weathers.get(i).getCity();
		}
		
		
		return weathers;
	}
	
	public Weather setWeather() {
		Scanner sc = new Scanner(System.in);
		Weather weather = new Weather();
		System.out.println("도시 입력");
		String city = sc.next();
		weather.setCity(city);
		System.out.println("날씨 입력");
		String state = sc.next();
		weather.setState(state);
		System.out.println("기온 입력");
		int gion = sc.nextInt();
		weather.setGion(gion);
		System.out.println("습도 입력");
		int hum = sc.nextInt();
		weather.setHum(hum);
		System.out.println("미세먼지 입력");
		double mise = sc.nextDouble();
		weather.setMise(mise);
		return weather;
	}
	
	public Weather findWeather(ArrayList<Weather> weathers) {
		Scanner sc = new Scanner(System.in);
		Weather weather = new Weather();
		System.out.println("찾는 도시 이름 입력");
		String city = sc.next();
		for(int i=0; i<weathers.size(); i++) {
			if(city.equals(weathers.get(i).getCity())){
				weather.setCity(weathers.get(i).getCity());
				weather.setState(weathers.get(i).getState());
				weather.setGion(weathers.get(i).getGion());
				weather.setHum(weathers.get(i).getHum());
				weather.setMise(weathers.get(i).getMise());
				break;
			}
		}
		
		return weather;
		
	}
	
	public void deleteWeather(ArrayList<Weather> weathers) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하고 싶은 도시 입력");
		String city = sc.next();
		for(int i=0; i<weathers.size(); i++) {
			if(city.equals(weathers.get(i).getCity())){
				weathers.remove(i);
				break;
			}
		}
	}
	
}
