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
public class Examen {
    Scanner sc = new Scanner(System.in);
    private String clase;
    private ArrayList<String> preguntas = new ArrayList();
    private ArrayList respuestas = new ArrayList();
    
    public Examen(String c){
        clase = c;
    }
    public void CrearEx(){
        sc.useDelimiter("\\n");
        char res;
        do{
            System.out.println("Ingrese una pregunta:");
            preguntas.add(sc.next());
            System.out.println("Ingrese la respuesta:");
            respuestas.add(sc.next());
            System.out.print("Desea ingresar otra pregunta? [s/n]: ");
            res = sc.next().charAt(0);
        }while (res == 's' || res == 'S');
    }
    public String getClase(){
        return clase;
    }
    @Override
    public String toString(){
        String salida = "";
        int c = 1;
        for (String temp : preguntas) {
            salida += c + ") "+temp + "\\n";
            c++;
        }
        return salida;
    }
    public int tamaño(){
        return preguntas.size();
    }
    public String pr(int i){
        return preguntas.get(i);
    }
    public String rsp(int i){
        return respuestas.get(i).toString();
    }
}
