package dat.data.dto.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDataDTO
{
    String temperature;
    String skyText;
    String humidity;
    String windText;

    @Override
    public String toString()
    {
        return "temperature : " + temperature +
                ", skyText : " + skyText +
                ", humidity : " + humidity +
                ", windText : " + windText;
    }
}