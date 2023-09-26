package dat.data.dao;

import dat.WeatherFetcher;
import dat.model.City;
import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest
{
        private WeatherDAO weatherDAO = WeatherDAO.getInstance();
        private CityDAO cityDAO = CityDAO.getInstance();

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

            cityDAO.create(city);

            Callable<Weather> wf = new WeatherFetcher(cityDAO.readByName("København"));

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