package kg.geektech.weatherapp.data.local;

import android.content.Context;

import androidx.room.Room;

public class RoomClient {

    public AppDataBase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "database")
                .allowMainThreadQueries().build();
    }
}
