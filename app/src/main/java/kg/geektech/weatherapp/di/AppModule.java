package kg.geektech.weatherapp.di;


import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import kg.geektech.weatherapp.data.local.RoomClient;
import kg.geektech.weatherapp.data.local.WeatherDao;
import kg.geektech.weatherapp.data.remote.RetrofitClient;
import kg.geektech.weatherapp.data.remote.WeatherApi;
import kg.geektech.weatherapp.data.repository.MainRepository;
import kg.geektech.weatherapp.data.local.AppDataBase;


@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static WeatherApi provideApi() {
        return new RetrofitClient().provideApi();
    }


    @Provides
    public static MainRepository provideMainRepository(WeatherApi api){
        return new MainRepository(api);
    }

    @Provides
    public static AppDataBase provideDatabase(@ApplicationContext Context context) {
        return new RoomClient().provideDatabase(context);
    }

    @Provides
    public static WeatherDao provideWeatherDao(AppDataBase database) {
        return database.weatherDao();
    }
}