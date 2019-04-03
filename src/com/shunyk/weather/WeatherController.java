package com.shunyk.weather;

import java.util.ArrayList;
import java.util.Scanner;

public class WeatherController {

	private Scanner sc;
	private ArrayList<Weather> weathers;
	private WeatherInit wi;
	private WeatherView view;
	private Weather weather;

	public WeatherController() {
		sc = new Scanner(System.in);
		weathers = new ArrayList<Weather>();
		wi = new WeatherInit();
		view = new WeatherView();
		weather = new Weather();
	}

	public void start() {
		boolean check = true;
		while(check) {
			weathers = wi.getWeathers();
			System.out.println("원하는 번호 입력");
			System.out.println("1. 날씨 정보 추가");
			System.out.println("2. 날씨       검색");
			System.out.println("3. 날씨       삭제");
			System.out.println("4. 날씨 정보 출력");
			System.out.println("5. 종            료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				weathers.add(wi.setWeather());
				break;
			case 2:
				weather = wi.findWeather(weathers);
				view.View(weather);
				break;
			case 3:
				wi.deleteWeather(weathers);
				break;
			case 4:
				view.Views(weathers);
				break;
			case 5:
				check = !check;
				System.out.println("종료합니다");
				break;
			}
		}
	}

}
