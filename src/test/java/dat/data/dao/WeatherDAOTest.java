package dat.data.dao;

import dat.WeatherFetcher;
import dat.data.dto.WeatherWebscraperDTO;
import dat.data.dto.weather.WeatherReaderDTO;
import dat.data_fetch.WeatherReader;
import dat.data_fetch.WeatherWebscraper;
import dat.model.City;
import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.Callable;

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
        void create() throws Exception
        {
            City city = new City("København", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");

            CityDAO cityDAO = CityDAO.getInstance();

            cityDAO.create(city);

            Callable<Weather> wf = new WeatherFetcher(city);

            Weather w = wf.call();

            weatherDAO.create(w);

            Weather actual = weatherDAO.read(w.getId());

            System.out.println(w.toString());
            System.out.println(actual.toString());

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