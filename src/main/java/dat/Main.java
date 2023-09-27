package dat;

import dat.config.ExecutorServiceConfig;
import dat.data.dao.CityDAO;
import dat.data.dao.WeatherDAO;
import dat.model.City;
import dat.model.Weather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String[] args)
    {

        City city = new City("København", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");
        City city1 = new City("Odense", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2615876/Danmark/Syddanmark/Odense/Odense");
        City city2 = new City("Esbjerg", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2622447/Danmark/Syddanmark/Esbjerg/Esbjerg");
        City city3 = new City("Rønne", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2614553/Danmark/Region%20Hovedstaden/Bornholm/R%C3%B8nne");
        City city4 = new City("Skagen", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2613939/Danmark/Nordjylland/Frederikshavn/Skagen");
        City city5 = new City("Gedser", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2621551/Danmark/Region%20Sj%C3%A6lland/Guldborgsund/Gedser");
        City city6 = new City("Gilleleje", "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2621471/Danmark/Region%20Hovedstaden/Gribskov/Gilleleje");

        List<City> cityList = Arrays.asList(city, city1, city2, city3, city4, city5, city6);

        CityDAO cityDAO = CityDAO.getInstance();

        cityList.forEach(cityDAO::create);

        WeatherFetcher[] wfArr = new WeatherFetcher[cityList.size()];


        for (int i = 0; i < wfArr.length; i++)
        {
            wfArr[i] = new WeatherFetcher(cityList.get(i));
        }

        ExecutorService executorService = ExecutorServiceConfig.getExecutorService();
        List<Future<Weather>> futures = new ArrayList<>();

        List<Weather> weatherList = new ArrayList<>();

        Arrays.stream(wfArr).forEach(wf -> futures.add(executorService.submit(wf)));


        futures.forEach(f ->
        {
            try
            {
                weatherList.add(f.get());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        });

        WeatherDAO weatherDAO = WeatherDAO.getInstance();

        weatherList.forEach(weatherDAO::create);

        executorService.shutdown();
    }
}