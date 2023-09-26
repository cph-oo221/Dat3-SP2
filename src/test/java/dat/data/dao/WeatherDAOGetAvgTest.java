package dat.data.dao;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WeatherDAOGetAvgTest
{

    private WeatherDAO weatherDAO;
    private String cophenhagen;
    private String aarhus;
    private String odense;

    @BeforeAll
    void setUpAll()
    {
        weatherDAO = WeatherDAO.getInstance();

        cophenhagen = "København";
        aarhus = "Aarhus";
        odense = "Odense";
    }

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void getAvgTemp()
    {
        double avgTemp = 10;
        assertNotNull(weatherDAO.getAvgTemp());
        assertEquals(avgTemp, weatherDAO.getAvgTemp());
    }

    @Test
    void getAvgTempByCity()
    {
        double cophenhagenTemp = 10;
        double aarhusTemp = 10;
        double odenseTemp = 10;

        assertNotNull(weatherDAO.getAvgTempByCity(cophenhagen));
        assertNotNull(weatherDAO.getAvgTempByCity(aarhus));
        assertNotNull(weatherDAO.getAvgTempByCity(odense));

        assertEquals(cophenhagenTemp, weatherDAO.getAvgTempByCity(cophenhagen));
        assertEquals(aarhusTemp, weatherDAO.getAvgTempByCity(aarhus));
        assertEquals(odenseTemp, weatherDAO.getAvgTempByCity(odense));
    }

    @Test
    void getAvgHumid()
    {
        double avgHumid = 10;
        assertNotNull(weatherDAO.getAvgHumid());
        assertEquals(avgHumid, weatherDAO.getAvgHumid());
    }

    @Test
    void getAvgHumidByCity()
    {
        double cophenhagenHumid = 10;
        double aarhusHumid = 10;
        double odenseHumid = 10;

        assertNotNull(weatherDAO.getAvgHumidByCity(cophenhagen));
        assertNotNull(weatherDAO.getAvgHumidByCity(aarhus));
        assertNotNull(weatherDAO.getAvgHumidByCity(odense));

        assertEquals(cophenhagenHumid, weatherDAO.getAvgHumidByCity(cophenhagen));
        assertEquals(aarhusHumid, weatherDAO.getAvgHumidByCity(aarhus));
        assertEquals(odenseHumid, weatherDAO.getAvgHumidByCity(odense));
    }

    @Test
    void getAvgPrecip()
    {
        double avgPrecip = 10;
        assertNotNull(weatherDAO.getAvgPrecip());
        assertEquals(avgPrecip, weatherDAO.getAvgPrecip());
    }

    @Test
    void getAvgPrecipByCity()
    {
        double cophenhagenPrecip = 10;
        double aarhusPrecip = 10;
        double odensePrecip = 10;

        assertNotNull(weatherDAO.getAvgPrecipByCity(cophenhagen));
        assertNotNull(weatherDAO.getAvgPrecipByCity(aarhus));
        assertNotNull(weatherDAO.getAvgPrecipByCity(odense));

        assertEquals(cophenhagenPrecip, weatherDAO.getAvgPrecipByCity(cophenhagen));
        assertEquals(aarhusPrecip, weatherDAO.getAvgPrecipByCity(aarhus));
        assertEquals(odensePrecip, weatherDAO.getAvgPrecipByCity(odense));
    }

    @Test
    void getAvgWind()
    {
        double avgWind = 10;
        assertNotNull(weatherDAO.getAvgWind());
        assertEquals(avgWind, weatherDAO.getAvgWind());
    }

    @Test
    void getAvgWindByCity()
    {
        double cophenhagenWind = 10;
        double aarhusWind = 10;
        double odenseWind = 10;

        assertNotNull(weatherDAO.getAvgWindByCity(cophenhagen));
        assertNotNull(weatherDAO.getAvgWindByCity(aarhus));
        assertNotNull(weatherDAO.getAvgWindByCity(odense));

        assertEquals(cophenhagenWind, weatherDAO.getAvgWindByCity(cophenhagen));
        assertEquals(aarhusWind, weatherDAO.getAvgWindByCity(aarhus));
        assertEquals(odenseWind, weatherDAO.getAvgWindByCity(odense));
    }
}