package com.example.tp4_moviles.ui.farmacias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp4_moviles.MainActivity;
import com.example.tp4_moviles.models.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class FarmaciasViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Farmacia>> farmacias;

    public FarmaciasViewModel() {
    }

    public LiveData<ArrayList<Farmacia>> getFarmacias() {
        if (farmacias == null) {
            farmacias = new MutableLiveData<>();
        }
        return farmacias;
    }

    public void mostrarFarmacias() {
        farmacias.setValue((ArrayList<Farmacia>) MainActivity.farmacias);
    }
}