package dat;

import dat.data.dto.WeatherWebscraperDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherWebscraperTest
{
    @Test
    void mainTest()
    {
        WeatherWebscraper weatherWebscraper = new WeatherWebscraper("https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618425/Danmark/Region%20Hovedstaden/K%C3%B8benhavn/K%C3%B8benhavn");
        try
        {
            WeatherWebscraperDTO dto = weatherWebscraper.scrapeWeather();
            System.out.println(dto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}