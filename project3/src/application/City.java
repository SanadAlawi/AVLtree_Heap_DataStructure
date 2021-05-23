package application;

public class City implements Comparable<City> {
	private String CityName;
	private String FileCityName;
	
	public City(String cityName, String fileCityName) {
		CityName = cityName;
		FileCityName = fileCityName;
	}



	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getFileCityName() {
		return FileCityName;
	}

	public void setFileCityName(String fileCityName) {
		FileCityName = fileCityName;
	}

	@Override
	public int compareTo(City o) {
		return CityName.compareToIgnoreCase(o.getCityName());
	}

	@Override
	public String toString() {
		return CityName;
	}
	
	
		
}
