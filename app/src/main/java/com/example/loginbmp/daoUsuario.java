package com.example.loginbmp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    //Parametros que va a tener la tabla en la DB
    String tabla="create table if not exists usuarioa(id integer primary key autoincrement, usuario text, pass text, email text, nombre text, apell text )";

    //Creamos la DB
    public daoUsuario(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuario();

    }

    //Metodo de insertar usuario
    //put, realacionar una llave con un valor
    /*ContentValues se usa para añadir valores o información
     sin que usuarios tenga acceso a ella*/
    public boolean insertUsuario(Usuario u){
        if (buscar(u.getUsuario())==0){
            ContentValues cv=new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("pass", u.getPassword());
            cv.put("email", u.getEmail());
            cv.put("nombre", u.getNombre());
            cv.put("apell", u.getApellidos());
            return (sql.insert("usuarioa", null,cv)>0);

        }else{
            return false;
        }
    }

    //Se recibe un String con el valor del usuario
    public int buscar(String u){
        int x=0;
        lista= selectUsuarios();
        //recorremos el array
        for (Usuario us: lista
             ) {
            /*Verificamos si el usuario que buscamos para
             registrarnos no sea igual a alguno de la DB. Si retorna 0
             nos permite registrarlo, de lo contrario no*/
            if (us.getUsuario().equals(u)){
                x++;
            }

        }
        return x;
    }

    //Retorna todos los usuarios en la base de datos
    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista =new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuarioa", null);
        if (cr!=null&&cr.moveToFirst()){
            //Si el if devuelve un resultado, lo recorremos
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setEmail(cr.getString(3));
                u.setNombre(cr.getString(4));
                u.setApellidos(cr.getString(5));
                lista.add(u);
            }while (cr.moveToNext());

        }
        return lista;
    }


    public int login(String u, String p){
        int a=0;
        Cursor cr = sql.rawQuery("select * from usuarioa", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());

        }
        return a;

    }

    //Retornar los datos del usuario
    public Usuario getUsuario(String u, String p){
        lista = selectUsuarios();
        for (Usuario us: lista
             ) {
            if (us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }

    //Busqueda por el id
    public Usuario getUsuarioById(int id){
        lista = selectUsuarios();
        for (Usuario us: lista
        ) {
            if (u.getId()==id){
                return us;
            }
        }
        return null;
    }
}
