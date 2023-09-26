package dat;

import dat.config.ExecutorServiceConfig;
import dat.model.City;
import dat.model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class WeatherFetcherTest
{

    @Test
    void getWeatherEntity()
    {
        City city = new City("København", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");
        WeatherFetcher weatherFetcher = new WeatherFetcher(city);

        City city2 = new City("Taastrup", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2611828/Danmark/Region%20Hovedstaden/H%C3%B8je-Taastrup/Taastrup");
        WeatherFetcher weatherFetcher2 = new WeatherFetcher(city2);

        try
        {
            Weather w = weatherFetcher.call();
            Weather w2 = weatherFetcher2.call();

            System.out.println(w.toString());
            System.out.println(w2.toString());
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }

    @Test
    void fetchWeatherConcurrently()
    {
        ExecutorService executorService = ExecutorServiceConfig.getExecutorService();
        List<City> cities = new ArrayList<>();
        List<Future> futures = new ArrayList<>();

        cities.add(new City("Aalborg", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2624886/Danmark/Nordjylland/Aalborg/Aalborg"));
        cities.add(new City("Aarhus", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2624652/Danmark/Midtjylland/Aarhus/Aarhus"));
        cities.add(new City("Odense", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2615876/Danmark/Syddanmark/Odense/Odense"));
        cities.add(new City("Esbjerg", "Denmark", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2622447/Danmark/Syddanmark/Esbjerg/Esbjerg"));

        cities.forEach(c ->
        {
            futures.add(executorService.submit(new WeatherFetcher(c)));
        });

        futures.forEach(f ->
        {
            try
            {
                System.out.println(f.get().toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}