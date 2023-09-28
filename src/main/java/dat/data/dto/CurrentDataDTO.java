package dat.data.dto;

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
    private Integer temperature;
    private String skyText;
    private Integer humidity;
    private String windText;

    @Override
    public String toString()
    {
        return "temperature : " + temperature +
                ", skyText : " + skyText +
                ", humidity : " + humidity +
                ", windText : " + windText;
    }
}