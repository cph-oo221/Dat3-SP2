package dat;

import dat.data_fetch.WeatherReader;
import dat.data_fetch.WeatherWebscraper;
import dat.model.Weather;

import java.io.IOException;

public class WeatherHandler
{
    String yrUrl;
    String ApiLocation;

    public WeatherHandler(String yrUrl, String ApiLocation)
    {
        this.yrUrl = yrUrl;
        this.ApiLocation = ApiLocation;
    }

    public Weather getWeatherEntity() throws IOException
    {
        WeatherReader weatherReader = new WeatherReader();
        WeatherWebscraper weatherWebscraper = new WeatherWebscraper(yrUrl);

        return new Weather(weatherReader.read(ApiLocation), weatherWebscraper.scrapeWeather());
    }
}
