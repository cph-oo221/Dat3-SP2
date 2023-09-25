package dat.data_fetch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dat.data.dto.weather.WeatherReaderDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherReader
{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public WeatherReaderDTO read(String location)
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://vejr.eu/api.php?location=" +
                        location +
                        "&degree=c")
                .get()
                .build();


        try (Response response = client.newCall(request).execute())
        {
            return gson.fromJson(response.body() != null ? response.body().string() : null, WeatherReaderDTO.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            client.connectionPool().evictAll();
        }
    }
}