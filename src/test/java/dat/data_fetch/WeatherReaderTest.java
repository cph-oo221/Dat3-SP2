package dat.data_fetch;

import dat.data.dto.weather.CurrentDataDTO;
import dat.data.dto.weather.WeatherReaderDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherReaderTest
{

    private WeatherReader weatherReader;
    @BeforeEach
    void setUp()
    {
        weatherReader = new WeatherReader();
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void read()
    {
        WeatherReaderDTO weatherReaderDTO = weatherReader.read("København");
        assertNotNull(weatherReaderDTO);

        WeatherReaderDTO wrd = WeatherReaderDTO.builder()
                .LocationName("København, Region Hovedstaden")
                .CurrentData(CurrentDataDTO.builder()
                        .temperature(17)
                        .skyText("Skyet")
                        .humidity(78)
                        .windText("19 m/s Syd")
                        .build())
                .build();

        assertEquals(wrd.toString(), weatherReaderDTO.toString());
    }
}