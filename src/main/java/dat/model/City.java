package dat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    String yrUrl;
    String country;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    List<Weather> weatherData = new ArrayList<>();

    public City(String name, String country, String yrUrl)
    {
        this.name = name;
        this.country = country;
        this.yrUrl = yrUrl;
    }

    public City(String name, String yrUrl)
    {
        this.name = name;
        this.yrUrl = yrUrl;
        this.country = "Denmark";
    }


    public void addWeatherData(Weather weather)
    {
        if (weather != null)
        {
            weather.setCity(this);
            weatherData.add(weather);
        }
    }
}
