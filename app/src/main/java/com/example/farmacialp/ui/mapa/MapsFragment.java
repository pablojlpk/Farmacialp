package com.example.farmacialp.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmacialp.R;
import com.example.farmacialp.databinding.FragmentHomeBinding;
import com.example.farmacialp.databinding.FragmentMapsBinding;
import com.example.farmacialp.ui.home.HomeViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private FragmentMapsBinding binding;
    private MapaViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(MapaViewModel.class);


        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getMp().observe(getViewLifecycleOwner(), new Observer<MapaViewModel.MapaActual>() {
            @Override
            public void onChanged(MapaViewModel.MapaActual mapaActual) {
                SupportMapFragment smf= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
                smf.getMapAsync(mapaActual);
            }
        });
        vm.obtenerMapa();



        return root;
    }

}


