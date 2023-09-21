package com.example.farmacialp.ui.slideshow;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Dialogos {

    public static void mostrarDialogo(Activity activity){

        new AlertDialog.Builder(activity)
                .setTitle("Mi programa de llamadas")
                .setMessage("Desea Finmalizar la Apliación ?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(activity, "Cerrando Sesión", Toast.LENGTH_LONG).show();
                        activity.finish();// cierro sesión
                        //System.exit(0);//cierra sistema


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(activity, "Proceso Cancelado", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
