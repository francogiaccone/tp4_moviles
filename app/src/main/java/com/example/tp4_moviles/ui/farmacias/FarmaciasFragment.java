package com.example.tp4_moviles.ui.farmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tp4_moviles.databinding.FragmentFarmaciasBinding;
import com.example.tp4_moviles.models.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class FarmaciasFragment extends Fragment {

    private FragmentFarmaciasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FarmaciasViewModel farmaciasViewModel =
                new ViewModelProvider(this).get(FarmaciasViewModel.class);

        binding = FragmentFarmaciasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        farmaciasViewModel.getFarmacias().observe(getViewLifecycleOwner(), new Observer<ArrayList<Farmacia>>() {
            @Override
            public void onChanged(ArrayList<Farmacia> farmacias) {
                FarmaciasAdapter farmaciasAdapter = new FarmaciasAdapter(farmacias, inflater);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.rvFarmacias.setAdapter(farmaciasAdapter);
                binding.rvFarmacias.setLayoutManager(gridLayoutManager);
            }

        });

        farmaciasViewModel.mostrarFarmacias();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}