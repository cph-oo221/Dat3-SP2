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
        City city = new City("København", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");
        WeatherHandler weatherHandler = new WeatherHandler(city);

        City city2 = new City("Taastrup", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2611828/Danmark/Region%20Hovedstaden/H%C3%B8je-Taastrup/Taastrup");
        WeatherHandler weatherHandler2 = new WeatherHandler(city2);

        try
        {
            Weather w = weatherHandler.getWeatherEntity();
            Weather w2 = weatherHandler2.getWeatherEntity();

            System.out.println(w.toString());
            System.out.println(w2.toString());
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }
}