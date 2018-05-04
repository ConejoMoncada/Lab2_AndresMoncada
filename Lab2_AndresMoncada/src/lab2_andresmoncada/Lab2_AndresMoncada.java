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
public class Lab2_AndresMoncada {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList examenes = new ArrayList();
    static ArrayList alumnos = new ArrayList();
    static Examen e;
    static Alumno a;
    static int indexAl;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        do{
            System.out.println("1. Administración");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Log in");
            System.out.println("0. Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                    admin();
                    break;
                case 2:
                    cuenta();
                    break;
                case 3:
                    login();
                    break;
                case 0: 
                    break;
                default:
                    System.out.println("Comando no válido.");
                    break;
            }
        }while(op != 0);
    }
    public static void admin(){
        int op;
        do{
            System.out.println("1. Crear examen");
            System.out.println("2. Revisar examenes");
            System.out.println("3. Ver notas");
            System.out.println("4. Modificar notas");
            System.out.println("0. Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                    crearE();
                    break;
                case 2:
                    revisar();
                    break;
                case 3:
                    notasA();
                    break;
                case 4:
                    modif();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Comando no válido. ");
            }
        }while(op!=0);
    }
    public static void crearE(){
        sc.useDelimiter("\\n");
        boolean val;
        String entrada;
        do{
            val = false;
        System.out.print("Clase del examen: ");
        entrada = sc.next();
        for (int i = 0; i < 10; i++) {
            val = (entrada.equals((((Examen)examenes.get(i)).getClase())));
            if(val)
                break;
        }
        if(!val)
                System.out.println("Ya se creo un examen para esta clase");
        }while(!val);
        e = new Examen(entrada);
        e.CrearEx();
        examenes.add(e);
    }
    public static void revisar(){
        sc.useDelimiter("\\n");
        System.out.println("Ingrese el nombre del alumno");
        String entrada = sc.next();
        boolean val = false;
        indexAl = -1;
        for (int i = 0; i < alumnos.size(); i++) {
            if(entrada.equals((((Alumno)alumnos.get(i)).getNombre()))){
                indexAl = i;
                break;
            }
        }
        if (indexAl != -1){
            System.out.println("Ingrese la clase del examen");
            entrada = sc.next();
            int indexamen = -1;
            for (int i = 0; i < examenes.size(); i++) {
                if(entrada.equals((((Examen)examenes.get(i)).getClase()))){
                    indexamen = i;
                    break;
                }
            }
            if (indexamen != -1){
                for (int i = 0; i < (((Examen)examenes.get(indexamen)).tamaño()); i++) {
                    System.out.println(((Examen)examenes.get(indexamen)).pr(i));
                    System.out.print("Respuesta estudiante: " + ((Alumno)alumnos.get(indexAl)).getresp(indexamen, i));
                    System.out.println("Respuesta correcta: " + ((Examen)examenes.get(indexamen)).rsp(i));
                }System.out.println("Ingrese la nota del alumno: ");
                ((Alumno)alumnos.get(indexAl)).setNotas(indexamen, sc.nextInt());
                
            }else
                System.out.println("Clase no válida.");
        }else
            System.out.println("Estudiante no encontrado.");
    }
    public static void notasA(){
        System.out.println("Notas registradas");
        for (int i = 0; i < alumnos.size(); i++) {
            ((Alumno)alumnos.get(indexAl)).getNombre();
            ((Alumno)alumnos.get(indexAl)).listado();
        }
    }
    public static void modif(){
        sc.useDelimiter("\\n");
        System.out.println("Ingrese el nombre del alumno");
        String entrada = sc.next();
        boolean val = false;
        indexAl = -1;
        for (int i = 0; i < alumnos.size(); i++) {
            if(entrada.equals((((Alumno)alumnos.get(i)).getNombre()))){
                indexAl = i;
                break;
            }
        }
        if (indexAl != -1){
            System.out.println("Ingrese la clase del examen");
            entrada = sc.next();
            int indexamen = -1;
            for (int i = 0; i < examenes.size(); i++) {
                if(entrada.equals((((Examen)examenes.get(i)).getClase()))){
                    indexamen = i;
                    break;
                }
            }
            if (indexamen != -1){
                System.out.println("Ingrese la nota del alumno: ");
                ((Alumno)alumnos.get(indexAl)).setNotas(indexamen, sc.nextInt());
                
            }else
                System.out.println("Clase no válida.");
        }else
            System.out.println("Estudiante no encontrado.");
    }
    public static void cuenta(){
        sc.useDelimiter("\\n");
        System.out.print("Nombre completo: ");
        String nom = sc.next();
        System.out.print("Numero de cuenta: ");
        long nc = sc.nextLong();
        System.out.print("Fecha de nacimiento (DD/MM/YYYY): ");
        String fn = sc.next();
        System.out.print("Edad: ");
        int ed = sc.nextInt();
        System.out.print("Ciudad de residencia: ");
        String cres = sc.next();
        System.out.print("Nacionalidad: ");
        String nac = sc.next();
        System.out.print("Número de identidad: ");
        long NID = sc.nextLong();
        System.out.print("Nombre de usuario: ");
        String u = sc.next();
        System.out.print("Contraseña: ");
        String pass = sc.next();
        a = new Alumno(nom, nc, fn, ed, cres, nac, NID, u, pass);
        for (int i = 0; i < examenes.size(); i++) {
            a.clases(((Examen)examenes.get(i)).getClase());
        }
        a.inicio();
        alumnos.add(a);
        System.out.println("Cuenta creada.");
    }
    public static void login(){
        sc.useDelimiter("\\n");
        int op;
        String entrada;
        boolean val = false;
        do{
            System.out.println("Ingrese su usuario: ");
            entrada = sc.next();
            indexAl = -1;
            for (int i = 0; i < alumnos.size(); i++) {
                if(entrada.equals(((Alumno)alumnos.get(i)).getUser())){
                    indexAl = i;
                    break;
                }
            }
            if(indexAl == -1)
                System.out.println("Usuario no valido");
        }while (indexAl == -1);
        do{
            System.out.println("Ingrese su contraseña: ");
            entrada = sc.next();
                if(entrada.equals(((Alumno)alumnos.get(indexAl)).getPass())){
                    val = true;
                }
            if(!val)
                System.out.println("Contraseña incorrecta.");
        }while (!val );
        char res;
        do{
            System.out.println("Bienvenid@, " + ((Alumno)alumnos.get(indexAl)).getNombre());
            System.out.println("1. Ver notas");
            System.out.println("2. Tomar examen");
            System.out.println("0. Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                    ((Alumno)alumnos.get(indexAl)).listado();
                    break;
                case 2:
                    tExa();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Comando no válido");
            }
        }while (op != 0);
    }
    public static void tExa(){
        sc.useDelimiter("\\n");
        int indexamen;
        do{
            System.out.println("Ingrese la clase del examen");
            String entrada = sc.next();
            indexamen = -1;
            for (int i = 0; i < examenes.size(); i++) {
                if(entrada.equals((((Examen)examenes.get(i)).getClase()))){
                    indexamen = i;
                    break;
                }
            }
            if(indexamen == -1)
                System.out.println("Clase no válida");
        }while(indexamen == -1);
        if (((Alumno)alumnos.get(indexAl)).getNota(indexamen) != -1)
            System.out.println("Ya tomó este examen");
        else
            tomar(indexamen,indexAl);
    }
    public static void tomar(int j, int k){
        String resp;
        ((Alumno)alumnos.get(k)).preparar();
        for (int i = 0; i < ((Examen)examenes.get(j)).tamaño(); i++) {
            System.out.println(((Examen)examenes.get(j)).pr(i));
            resp = sc.next();
            ((Alumno)alumnos.get(k)).responder(resp);
        }
        ((Alumno)alumnos.get(k)).finExamen(j);
        ((Alumno)alumnos.get(k)).setNotas(j, 0);
        System.out.println("Por favor espera hasta que el maestro califique para ver su nota");
    }
}
