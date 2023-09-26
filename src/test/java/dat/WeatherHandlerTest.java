package dat;

import dat.model.City;
import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherHandlerTest
{
    @Test
    void getWeatherEntity()
    {
        City city = new City("København", "Danmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");
        WeatherHandler weatherHandler = new WeatherHandler(city);
        try
        {
            Weather w = weatherHandler.getWeatherEntity();
            System.out.println(w.toString());
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }
}