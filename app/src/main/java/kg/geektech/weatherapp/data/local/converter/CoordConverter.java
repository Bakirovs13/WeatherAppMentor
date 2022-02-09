package kg.geektech.weatherapp.data.local.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import kg.geektech.weatherapp.data.models.Clouds;
import kg.geektech.weatherapp.data.models.Coord;

public class CoordConverter {
    @TypeConverter
    public String fromMainString(Coord main){
        if (main==null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Coord>(){}.getType();
        return gson.toJson(main,type);
    }

    @TypeConverter
    public Coord fromMainString(String fromString){
        if (fromString == null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Coord>(){}.getType();
        return gson.fromJson(fromString,type);
    }
}
