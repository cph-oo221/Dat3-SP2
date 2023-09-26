package dat;

import dat.data_fetch.WeatherReader;
import dat.data_fetch.WeatherWebscraper;
import dat.model.City;
import dat.model.Weather;

import java.io.IOException;

public class WeatherHandler
{
    String ApiLocation;
    City city;

    public WeatherHandler(City city)
    {
        this.city = city;
        this.ApiLocation = city.getName() + ", " + city.getCountry();
    }



    public Weather getWeatherEntity() throws IOException
    {
        WeatherReader weatherReader = new WeatherReader();
        WeatherWebscraper weatherWebscraper = new WeatherWebscraper(city.getYrUrl());
        Weather w = new Weather(weatherReader.read(ApiLocation), weatherWebscraper.scrapeWeather());

        city.addWeatherData(w);

        return w;
    }


}
