/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_andresmoncada;

import java.util.ArrayList;
import java.util.Scanner;

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
    private ArrayList todo = new ArrayList();
    private ArrayList respuestas = new ArrayList();
    Scanner sc = new Scanner(System.in);
    
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
    public void setNotas(int i, int n){
        notas.set(i, n);
    }
    public void setNotas(){
        System.out.print("Ingrese el indice de la clase (indices comienzan en 0): ");
        int i = sc.nextInt();
        System.out.print("Ingrese la nota nueva: ");
        int n = sc.nextInt();
        notas.set(i, n);
    }
    public int getNota(int i){
        return notas.get(i);
    }
    public void preparar(){
        respuestas = new ArrayList();
    }
    public void responder(String r){
        respuestas.add(r);
    }
    public void finExamen(int i){
        todo.add(i, respuestas);
    }
    public void inicio(){
        todo.ensureCapacity(clases.size());
    }
    public String getresp(int e, int p){
        return ((ArrayList)todo.get(e)).get(p).toString();
    }
}
