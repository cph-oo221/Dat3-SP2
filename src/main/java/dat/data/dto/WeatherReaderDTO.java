package dat.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReaderDTO
{
    private String LocationName;
    private CurrentDataDTO CurrentData;

    @Override
    public String toString()
    {
        return "Location Name : " + LocationName +
                ", Current Data : " + CurrentData;
    }
}