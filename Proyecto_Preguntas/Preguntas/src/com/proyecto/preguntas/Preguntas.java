
package com.proyecto.preguntas;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Preguntas {
    
    public static Pregunta[] crear_Array_preguntas(){
        
        // Rango de 0 a 46
        int i = 46;
                
        // Array donde guardaremos las preguntas
        Pregunta []preguntas = new Pregunta [i];
        
        // Fichero del que sacaremos las preguntas
        File fichero = new File("C:\\Users\\Usuario\\Documents\\DAM 1\\Programación\\Proyecto_Preguntas\\Preguntas_cultura");
        
        // Instanciar scanner
        Scanner scnr = null;
        
        try {
            
            scnr = new Scanner(fichero);
            
            // Variable usada dentro del bucle while
            i = 0;
            
            while (scnr.hasNextLine()) {   

                // Metemos cada linea del fichero de texto en una variable, 'linea'
                String linea = scnr.nextLine();
                
                // Array temporal que separa los 'campos'
                String[] campos = linea.split(";");
                
                /*
                "¿Pregunta?","B","Nose","Si","No","Puede ser"
                */

                // Campos del array temporal
                String pregunta = campos[0];
                String respuesta = campos[1];
                String opcionA = campos[2];
                String opcionB = campos[3];
                String opcionC = campos[4];
                String opcionD = campos[5];

                // Crea un objeto preguntas con los campos del array temporal 'campos'
                Pregunta x = new Pregunta(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
                
                // Lo mete en el array Preguntas
                preguntas[i] = x;
                
                i++;
            }
            
            scnr.close();
            
        } catch (FileNotFoundException e) {
            
            System.out.println("El fichero " + fichero + " no se ha encontrado");
            
        }

        return preguntas;        
    
    }
    
}
