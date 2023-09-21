package com.example.farmacialp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmacialp.MainActivity;
import com.example.farmacialp.R;
import com.example.farmacialp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;


        homeViewModel.getlistaM().observe(getViewLifecycleOwner(), new Observer<List<Farmacia>>() {
            @Override
            public void onChanged(List<Farmacia> farmacias) {
                Log.d("salida", "entra por el onchange");
              RecyclerView rv= root.findViewById(R.id.rvfarmacias);
                GridLayoutManager glm= new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);

                FarmaciaAdapter iad= new FarmaciaAdapter(farmacias,getContext(),getLayoutInflater());
                rv.setAdapter(iad);
            }
        });
        homeViewModel.armarLista();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}