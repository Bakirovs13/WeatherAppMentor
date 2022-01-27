package kg.geektech.weatherapp;

import android.app.Application;

import kg.geektech.weatherapp.data.remote.RetrofitClient;
import kg.geektech.weatherapp.data.remote.WeatherApi;
import kg.geektech.weatherapp.data.repository.MainRepository;

public class App extends Application {

    private RetrofitClient client;
    private WeatherApi api;
    public static MainRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        client = new RetrofitClient();
        api = client.provideApi();
        repository = new MainRepository(api);
    }
}
