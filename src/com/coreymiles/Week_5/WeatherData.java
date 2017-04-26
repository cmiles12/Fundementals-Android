package com.coreymiles.Week_5;

public class WeatherData {
    private final static String TEMP_UNIT = "F";
    private final static String HUMIDITY_UNIT = "%";
    private final static String PRECIPITATION_UNIT = "%";
    private final static int FREEZING_TEMP = 32;

    private String cityName;
    private double temperature;
    private double humidity;
    private double precipitation;

    public WeatherData(String cityName, double temperature, double humidity,
                       double precipitation) {
        this.cityName = cityName;
        setTemperature(temperature);
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature >= -461) {
            this.temperature = temperature;
        }
        else {
            this.temperature = -461;
        }
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double tempFtoC(double fahrenheit) {
        return 5.0 / 9 * (fahrenheit - 32);
    }

    public double tempCtoF(double celsius) {
        return 9.0 / 5 * celsius + 32;
    }

    private static void displayFreezingTemp() {
        System.out.println(FREEZING_TEMP + TEMP_UNIT);
    }

    private boolean willSnow() {
        return (temperature <= FREEZING_TEMP) && (precipitation >= 50);
    }

    public void displayWeatherReport() {
        String temp = temperature + TEMP_UNIT;
        String humid = humidity + HUMIDITY_UNIT;
        String precip = precipitation + PRECIPITATION_UNIT;
        String snowLikely = willSnow() ? "likely" : "unlikely";

        System.out.println("The current temperature in " + cityName + " is " + temp
                + ". The current relative humidity is " + humid
                + ". The current chance of precipitation is " + precip
                + ". It is " + snowLikely + " to snow.");


    }
}