package dat.data_fetch;

import dat.data.dto.WeatherWebscraperDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WeatherWebscraper
{
    private String url;

    private Document doc;
    public WeatherWebscraper(String url)
    {
        this.url = url;
    }

    public WeatherWebscraperDTO scrapeWeather() throws IOException
    {
        doc = Jsoup.connect(url).get();

        String temperatureStr = doc.selectFirst(".now-hero__next-hour-temperature-text > span:nth-child(1)")
                .text();
        Integer temperature = Integer.parseInt(temperatureStr.replace("°", "").trim());

        String wind = doc.selectFirst(".now-hero__next-hour-wind-value")
                .text();

        String precipitationStr = doc.selectFirst(".now-hero__next-hour-precipitation-value")
                .text();
        Integer precipitation = Integer.parseInt(precipitationStr);

        return new WeatherWebscraperDTO(wind, temperature, precipitation);
    }
}