package kg.geektech.weatherapp.data.repository;

import static kg.geektech.weatherapp.BuildConfig.BASE_URL;

import androidx.lifecycle.MutableLiveData;

import kg.geektech.weatherapp.common.Resource;
import kg.geektech.weatherapp.data.models.WeatherAppModel;
import kg.geektech.weatherapp.data.remote.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private WeatherApi api;

    public MainRepository(WeatherApi api) {
        this.api = api;

    }

    public MutableLiveData<Resource<WeatherAppModel>> getWeather() {

        MutableLiveData<Resource<WeatherAppModel>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());

        api.getWeather("Bishkek",BASE_URL,"metric").enqueue(new Callback<WeatherAppModel>() {
            @Override
            public void onResponse(Call<WeatherAppModel> call, Response<WeatherAppModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<WeatherAppModel> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));

            }
        });
        return liveData;
    }
}
