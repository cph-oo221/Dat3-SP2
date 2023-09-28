package dat.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WeatherWebscraperDTO
{
    private String wind;
    private Integer temperature;
    private Integer precipitation;
}