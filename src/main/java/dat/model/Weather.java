package dat.model;

import dat.data.dto.WeatherWebscraperDTO;
import dat.data.dto.weather.WeatherReaderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Weather
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    LocalDateTime time;
    Integer temperature;
    String wind;
    String skyText;
    Integer humid;
    Integer precipitation;

    @ManyToOne(fetch = FetchType.EAGER)
    City city;

    public Weather(WeatherReaderDTO wrdto, WeatherWebscraperDTO wwdto)
    {
        this.time = LocalDateTime.now();
        this.temperature = wwdto.getTemperature();
        this.wind = wwdto.getWind();
        this.skyText = wrdto.getCurrentData().getSkyText();
        this.humid = wrdto.getCurrentData().getHumidity();
        this.precipitation = wwdto.getPrecipitation();
    }
}
