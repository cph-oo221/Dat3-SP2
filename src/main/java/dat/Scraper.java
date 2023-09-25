package dat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Scraper
{
    public static void main(String[] args)
    {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=-54.516667&lon=-67.166667";

        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Firefox/90.0\"")
                .header("Accept-Language", "en-US,en;q=0.5")
                .build();

        try
        {
            Response response = client.newCall(request).execute();

            if (response.isSuccessful())
            {
                // System.out.println(response.body().toString());
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonObject jsonResponse = gson.fromJson(response.body().string(), JsonObject.class);
            }

            else
            {
                System.out.println("Error: " + response.code() + " " + response.message());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally
        {
            client.connectionPool().evictAll();
        }
    }




}
