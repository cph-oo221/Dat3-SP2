package dat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    List<Weather> weatherData;

    public void addWeatherData(Weather weather)
    {
        if (weather != null)
        {
            weather.setCity(this);
            weatherData.add(weather);
        }
    }
}
