package dat;

import dat.data_fetch.WeatherReader;
import dat.data_fetch.WeatherWebscraper;
import dat.model.City;
import dat.model.Weather;

import java.io.IOException;
import java.util.concurrent.Callable;

public class WeatherFetcher implements Callable<Weather>
{

    private String ApiLocation;
    private City city;

    public WeatherFetcher(City city)
    {
        this.city = city;
        this.ApiLocation = city.getName() + ", " + city.getCountry();
    }

    @Override
    public Weather call() throws IOException
    {
        return getWeatherEntity();
    }

    private Weather getWeatherEntity() throws IOException
    {
        WeatherReader weatherReader = new WeatherReader();
        WeatherWebscraper weatherWebscraper = new WeatherWebscraper(city.getYrUrl());
        Weather w = new Weather(weatherReader.read(ApiLocation), weatherWebscraper.scrapeWeather());

        city.addWeatherData(w);

        return w;
    }
}