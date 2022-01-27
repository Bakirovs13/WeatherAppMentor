package kg.geektech.weatherapp.ui.weather;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

import kg.geektech.weatherapp.R;
import kg.geektech.weatherapp.data.models.WeatherAppModel;
import kg.geektech.weatherapp.databinding.ItemRecyclerBinding;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<WeatherAppModel> weather = new ArrayList<>();


    @SuppressLint("NotifyDataSetChanged")
    public void setWeather(List<WeatherAppModel> weather) {
        this.weather = weather;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerBinding binding = ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        holder.onBind(weather.get(position));
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemRecyclerBinding binding;
        public ViewHolder(@NonNull ItemRecyclerBinding itemView) {
            super(itemView.getRoot());
        }


        public void onBind(WeatherAppModel weatherAppModel) {
            Glide.with(binding.getRoot())
                    .load(R.drawable.ic__sun)
                    .centerCrop()
                    .into(binding.ivItemIcon);


            binding.tvForecastDate.setText("Mon 21");
            binding.tvForecastTempUp.setText(String.valueOf((int) Math.round(weatherAppModel.getMain().getTempMin())));
            binding.tvForecastTempDown.setText(String.valueOf((int) Math.round(weatherAppModel.getMain().getTempMax())));
        }
    }
}
