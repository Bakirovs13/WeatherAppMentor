package kg.geektech.weatherapp.ui.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import kg.geektech.weatherapp.App;
import kg.geektech.weatherapp.common.Resource;
import kg.geektech.weatherapp.data.models.WeatherAppModel;

public class WeatherViewModel  extends ViewModel {

    public LiveData<Resource<WeatherAppModel>> weatherLiveData;

    public void getWeather(){
        weatherLiveData = App.repository.getWeather();
    }


}
