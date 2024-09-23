package com.example.tp4_moviles.ui.mapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4_moviles.R;
import com.example.tp4_moviles.databinding.FragmentMapaBinding;
import com.google.android.gms.maps.SupportMapFragment;

public class MapaFragment extends Fragment {

    private FragmentMapaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapaViewModel mapaViewModel =
                new ViewModelProvider(this).get(MapaViewModel.class);

        binding = FragmentMapaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mapaViewModel.getMapaActual().observe(getViewLifecycleOwner(), new Observer<MapaViewModel.MapaActual>() {
            @Override
            public void onChanged(MapaViewModel.MapaActual mapaActual) {
                ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
            }
        });
        mapaViewModel.mostrarMapa();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}