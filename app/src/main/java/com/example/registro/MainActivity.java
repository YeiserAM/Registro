package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText buscar,Direccion,Nombre, Id;
    private Button BtnBuscar, BtnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscar = findViewById(R.id.txtidbuscar);
        Direccion = findViewById(R.id.txtDireccion);
        Nombre = findViewById(R.id.txtNombre);
        Id = findViewById(R.id.txtId);
    }
    //FUNCION PARA BUSCAR
    public void buscar(View view){

        String buscarId=buscar.getText().toString().trim();
        SharedPreferences prefer = getSharedPreferences(buscarId, Context.MODE_PRIVATE);
        String id=prefer.getString("id", "");
        String nombre=prefer.getString("nombre", "");
        String direccion = prefer.getString("direccion", "");

        if (id.length()>0){
            Toast.makeText(this, "Se ha encontrado el registro", Toast.LENGTH_LONG).show();
            Id.setText(id);
            Nombre.setText(nombre);
            Direccion.setText(direccion);

        }else{
            Toast.makeText(this, "No se ah encontrado el registro", Toast.LENGTH_LONG).show();
        }
    }
    //FUNCION PARA GUARDAR
    public void guardar(View view){
        SharedPreferences pref=getSharedPreferences(Id.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("id",Id.getText().toString());
        editor.putString("nombre",Nombre.getText().toString());
        editor.putString("direccion",Direccion.getText().toString());
        editor.commit();
        Toast.makeText(this, "Registro guardado exitosamente", Toast.LENGTH_LONG).show();
        Id.setText("");
        Nombre.setText("");
        Direccion.setText("");
    }


}