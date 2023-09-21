package com.example.farmacialp.ui.home;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    RecyclerView rv;
    FarmaciaAdapter farmaciaadapter;

    private MutableLiveData <List<Farmacia>> listaMutable;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context = getApplication().getApplicationContext();


    }


    public LiveData<List<Farmacia>> getlistaM() {
        if (listaMutable == null) {
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void armarLista(){
         List<Farmacia> lista = new ArrayList<>();
        lista.add(new Farmacia("los alamos", "san martin 234","8 a 18",1));
        lista.add(new Farmacia("los redondos", "rivadavia","8 a 18",2));
        lista.add(new Farmacia("Farmacity", "Rivadavia esquina balcarce","8 a 18",3));
        lista.add(new Farmacia("alamos", "av. viento 123","8 a 18",4));
        listaMutable.setValue(lista);
        Log.d("salida", lista.size()+"");
    }



}
