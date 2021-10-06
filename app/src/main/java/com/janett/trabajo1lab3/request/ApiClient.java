package com.janett.trabajo1lab3.request;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

import com.janett.trabajo1lab3.model.Usuario;

public class ApiClient {

    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context)
    {
        if(sp==null)
        {
            sp=context.getSharedPreferences("datos",0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario u)
    {
        SharedPreferences sp=conectar(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putLong("dni",u.getDni());
        editor.putString("apellido", u.getApellido());
        editor.putString("nombre", u.getNombre());
        editor.putString("email", u.getEmail());
        editor.putString("password", u.getPassword());
        editor.commit();

    }

    public static Usuario leer(Context context)
    {

        SharedPreferences sp = conectar(context);

        Long dni = sp.getLong("dni",-1);
        String apellido = sp.getString("apellido", "Sin dato");
        String nombre = sp.getString("nombre", "Sin dato");
        String email = sp.getString("email", "Sin dato");
        String password = sp.getString("password", "Sin dato");

        Usuario us = new Usuario(dni,apellido,nombre,email,password);

        return us;
    }

    public static Usuario login(Context context, String mail, String pass)
    {
        Usuario us = null;

        SharedPreferences sp = conectar(context);

        Long dni = sp.getLong("dni",-1);
        String apellido = sp.getString("apellido", "Sin dato");
        String nombre = sp.getString("nombre", "Sin dato");
        String email = sp.getString("email", "Sin dato");
        String password = sp.getString("password", "Sin dato");

        if(mail.equals(email) && pass.equals(password))
        {
            us = new Usuario(dni,apellido,nombre,email,password);

        }

        return  us;

    }

}
