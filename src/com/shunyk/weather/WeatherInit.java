package com.shunyk.weather;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WeatherInit {
	
	private String info;
	private Scanner sc;
	
	public WeatherInit() {
		info = "seoul ,맑음 ,10 ,20 ,0.3 , daejon, 비, -22, 50, 0.1,"
				+ "incheon ,태풍 , 56, 90, 22.2, jeju, 흐림, 15,10 ,1.2";
		sc = new Scanner(System.in);
	}

	
	public ArrayList<Weather> getWeathers() {
		ArrayList<Weather> weathers = new ArrayList<Weather>();
		StringTokenizer st = new StringTokenizer(info, ",");
		while(st.hasMoreTokens()) {
			Weather weather = new Weather();
			weather.setCity(st.nextToken().trim());
			weather.setState(st.nextToken().trim());
			weather.setGion(Integer.parseInt(st.nextToken().trim()));
			weather.setHum(Integer.parseInt(st.nextToken().trim()));
			weather.setMise(Double.parseDouble(st.nextToken().trim()));
			weathers.add(weather);
		}
		
		/*String[] ar =info.split(",");
		int count=0;
		for(int i=0; i<ar.length; i++) {
			Weather weather = new Weather();
			weather.setCity(ar[i].trim());
			weather.setState(ar[++i].trim());
			weather.setGion(Integer.valueOf(ar[++i].trim()));
			weather.setHum(Integer.valueOf(ar[++i].trim()));
			weather.setMise(Double.valueOf(ar[++i].trim()));
			weathers.add(weather);
		}*/	
		
		return weathers;
	}
	
	public Weather setWeather() {
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
		Weather weather = null;
		System.out.println("찾는 도시 이름 입력");
		String city = sc.next();
		for(int i=0; i<weathers.size(); i++) {
			if(city.equals(weathers.get(i).getCity())){
				weather = weathers.get(i);
				break;
			}
		}
		
		return weather;
		
	}
	
	public String deleteWeather(ArrayList<Weather> weathers) {
		System.out.println("삭제하고 싶은 도시 입력");
		String city = sc.next();
		String result="없는 도시명";
		for(int i=0; i<weathers.size(); i++) {
			if(city.equals(weathers.get(i).getCity())){
				weathers.remove(i);
				result = "삭제 완료";
				break;
			}
		}
		return result;
	}
	
}
