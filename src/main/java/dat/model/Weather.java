package dat.model;

import dat.data.dto.WeatherWebscraperDTO;
import dat.data.dto.WeatherReaderDTO;
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
    private int id;

    private LocalDateTime time;
    private Integer temperature;
    private String wind;
    private String skyText;
    private Integer humid;
    private Integer precipitation;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

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
