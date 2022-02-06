package kg.geektech.weatherapp.ui.city;


import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.View;
import dagger.hilt.android.AndroidEntryPoint;
import kg.geektech.weatherapp.R;
import kg.geektech.weatherapp.base.BaseFragment;
import kg.geektech.weatherapp.databinding.FragmentCityBinding;
import kg.geektech.weatherapp.ui.weather.WeatherFragmentDirections;


@AndroidEntryPoint
public class CityFragment extends BaseFragment<FragmentCityBinding>{
    private NavController controller;
    @Override
    protected FragmentCityBinding bind() {
        return FragmentCityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void callRequest() {
    }

    @Override
    protected void setupObservers() {
    }

    @Override
    protected void setupListeners() {
    }

    @Override
    protected void setupViews() {
        controller = Navigation.findNavController(requireActivity(),R.id.nav_host);
        viewBinding.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.navigate((NavDirections) CityFragmentDirections.actionCityFragmentToWeatherFragment(viewBinding.editText.getText().toString()));
        }
    });
    }
}