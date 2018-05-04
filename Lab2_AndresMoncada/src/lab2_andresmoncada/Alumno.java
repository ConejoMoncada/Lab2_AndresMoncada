/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_andresmoncada;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Alumno {
    private String nombre;
    private long cta;
    private String DoB;
    private int edad;
    private String ciudad;
    private String nacio;
    private long id;
    private String usuario;
    private String password;
    private ArrayList<String> clases = new ArrayList();
    private ArrayList<Integer> notas = new ArrayList();
    
    public Alumno(String nom, long nc, String fn, int ed, String cres, String nac, long NID, String u, String pass){
        nombre = nom;
        cta = nc;
        DoB = fn;
        edad = ed;
        ciudad = cres;
        nacio = nac;
        id = NID;
        usuario = u;
        password = pass;
    }
    public String getUser(){
        return usuario;
    }
    public String getPass(){
        return password;
    }
    public String getNombre(){
        return nombre;
    }
    public void clases(String c){
        clases.add(c);
        notas.add(-1);
    }
    public void listado(){
        for (int i = 0; i < clases.size(); i++) {
            if(notas.get(i) != -1)
                System.out.println(clases.get(i) + " - " + notas.get(i));
            else
                System.out.println(clases.get(i) + " - Examen no tomado");
        }
    }
}
