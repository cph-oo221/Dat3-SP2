package dat;

import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherHandlerTest
{
    @Test
    void getWeatherEntity()
    {
        WeatherHandler weatherHandler = new WeatherHandler();
        try
        {
            Weather w = weatherHandler.getWeatherEntity();
            System.out.println(w.getTemperature());
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }
}