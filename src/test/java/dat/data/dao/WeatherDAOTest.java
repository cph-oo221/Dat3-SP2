package dat.data.dao;

import dat.WeatherHandler;
import dat.data.dto.WeatherWebscraperDTO;
import dat.data.dto.weather.WeatherReaderDTO;
import dat.data_fetch.WeatherReader;
import dat.data_fetch.WeatherWebscraper;
import dat.model.City;
import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest
{
        WeatherDAO weatherDAO = WeatherDAO.getInstance();

        @Test
        void getInstance()
        {
            WeatherDAO actual = WeatherDAO.getInstance();

            assertEquals(weatherDAO, actual);
        }

        @Test
        void create()
        {
            City city = new City("København", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");

            CityDAO cityDAO = CityDAO.getInstance();

            cityDAO.create(city);

            WeatherHandler wh = new WeatherHandler(city);

            Weather w = null;
            try
            {
                w = wh.getWeatherEntity();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            weatherDAO.create(w);

            Weather actual = weatherDAO.read(w.getId());

            assertEquals(w.getId(), actual.getId());
        }

        @Test
        void read()
        {
        }

        @Test
        void update()
        {
        }

        @Test
        void delete()
        {
        }

}