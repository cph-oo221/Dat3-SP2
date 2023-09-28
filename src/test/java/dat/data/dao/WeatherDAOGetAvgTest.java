package dat.data.dao;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WeatherDAOGetAvgTest
{

    private WeatherDAO weatherDAO;
    private String cophenhagen;
    private String rønne;
    private String odense;

    @BeforeAll
    void setUpAll()
    {
        weatherDAO = WeatherDAO.getInstance();

        cophenhagen = "København";
        rønne = "Rønne";
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
        double avgTemp = 19.02;
        double actual = weatherDAO.getAvgTemp();

        System.out.println("avg temp: " + actual);
        assertNotNull(actual);
        assertEquals(avgTemp, actual, 0.1);
    }

    @Test
    void getAvgTempByCity()
    {
        double cophenhagenTemp = 10;
        double aarhusTemp = 10;
        double odenseTemp = 10;

        double actualCophenhagen = weatherDAO.getAvgTempByCity(cophenhagen);
        double actualRønne = weatherDAO.getAvgTempByCity(rønne);
        double actualOdense = weatherDAO.getAvgTempByCity(odense);

        System.out.println("avg temp by city: " + actualCophenhagen);
        System.out.println("avg temp by city: " + actualRønne);
        System.out.println("avg temp by city: " + actualOdense);

        assertNotNull(actualCophenhagen);
        assertNotNull(actualRønne);
        assertNotNull(actualOdense);

        assertEquals(cophenhagenTemp, actualCophenhagen);
        assertEquals(aarhusTemp, actualRønne);
        assertEquals(odenseTemp, actualOdense);
    }

    @Test
    void getAvgHumid()
    {
        double avgHumid = 82.6;
        double actual = weatherDAO.getAvgHumid();

        System.out.println("avg humid: " + actual);
        assertNotNull(actual);
        assertEquals(avgHumid, actual, 0.1);
    }

    @Test
    void getAvgHumidByCity()
    {
        double cophenhagenHumid = 84.55;
        double rønneHumid = 95.0;
        double odenseHumid = 72.0;

        double actualCophenhagen = weatherDAO.getAvgHumidByCity(cophenhagen);
        double actualRønne = weatherDAO.getAvgHumidByCity(rønne);
        double actualOdense = weatherDAO.getAvgHumidByCity(odense);

        System.out.println("avg humid by city: " + actualCophenhagen);
        System.out.println("avg humid by city: " + actualRønne);
        System.out.println("avg humid by city: " + actualOdense);

        assertNotNull(actualCophenhagen);
        assertNotNull(actualRønne);
        assertNotNull(actualOdense);

        assertEquals(cophenhagenHumid, actualCophenhagen, 0.1);
        assertEquals(rønneHumid, actualRønne, 0.1);
        assertEquals(odenseHumid, actualOdense, 0.1);
    }

    @Test
    void getAvgPrecip()
    {
        double avgPrecip = 0;
        double actual = weatherDAO.getAvgPrecip();

        System.out.println("avg precip: " + actual);

        assertNotNull(actual);
        assertEquals(avgPrecip, actual);
    }

    @Test
    void getAvgPrecipByCity()
    {
        double cophenhagenPrecip = 0.0;
        double rønnePrecip = 0.0;
        double odensePrecip = 0.0;

        double actualCophenhagen = weatherDAO.getAvgPrecipByCity(cophenhagen);
        double actualRønne = weatherDAO.getAvgPrecipByCity(rønne);
        double actualOdense = weatherDAO.getAvgPrecipByCity(odense);

        System.out.println("avg precip by city: " + actualCophenhagen);
        System.out.println("avg precip by city: " + actualRønne);
        System.out.println("avg precip by city: " + actualOdense);

        assertNotNull(actualCophenhagen);
        assertNotNull(actualRønne);
        assertNotNull(actualOdense);

        assertEquals(cophenhagenPrecip, actualCophenhagen, 0.1);
        assertEquals(rønnePrecip, actualRønne, 0.1);
        assertEquals(odensePrecip, actualOdense, 0.1);
    }

    @Test
    void getAvgWind()
    {
        double avgWind = 3.2;

        double actual = weatherDAO.getAvgWind();

        System.out.println("avg wind: " + actual);

        assertNotNull(actual);
        assertEquals(avgWind, actual, 0.1);
    }

    @Test
    void getAvgWindByCity()
    {
        double cophenhagenWind = 2.7;
        double rønneWind = 2.5;
        double odenseWind = 3.3;

        double actualCophenhagen = weatherDAO.getAvgWindByCity(cophenhagen);
        double actualRønne = weatherDAO.getAvgWindByCity(rønne);
        double actualOdense = weatherDAO.getAvgWindByCity(odense);


        System.out.println("avg wind by city: " + actualCophenhagen);
        System.out.println("avg wind by city: " + actualRønne);
        System.out.println("avg wind by city: " + actualOdense);

        assertNotNull(actualCophenhagen);
        assertNotNull(actualRønne);
        assertNotNull(actualOdense);

        assertEquals(cophenhagenWind, actualCophenhagen, 0.1);
        assertEquals(rønneWind, actualRønne, 0.1);
        assertEquals(odenseWind, actualOdense, 0.1);
    }
}