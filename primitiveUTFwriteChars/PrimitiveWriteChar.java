/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitiveUTFwriteChars;

import java.io.*;

/**
 *
 * @author Xavier
 */
public class PrimitiveWriteChar {
    public static void escribirUTFChars(){
        File dirArch;
        String str="Está en casa";
        DataOutputStream salida=null;
        dirArch=new File("texto6.dat");
        try{
            salida=new DataOutputStream(new FileOutputStream(dirArch));
                System.out.println("writeUTF escribiendo: " + str);
                salida.writeUTF(str);
                System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
                System.out.println("writeChars escribiendo: " + str);
                salida.writeChars(str);
                System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
                System.out.println("writeUTF escribiendo: " + str);
                salida.writeUTF(str);
                System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
        }catch(IOException e){
            System.out.println("Error al operar con el archivo");
        }finally{
            if(salida != null){
                try{
                    salida.close();
                }catch(IOException e2){
                    System.out.println("Hubo un error al cerrar el archivo");
                }
            }
        }
    }
    public static void leerUTFChars(){
        File dirArch;
        DataInputStream entrada=null;
        String str="";
        
        dirArch=new File("texto6.dat");
        try{
            entrada=new DataInputStream(new FileInputStream(dirArch));
            while(entrada.available()!=0){
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Primera cadena leida con readUTF: " + entrada.readUTF());
                for(int i=0;i<12;i++){
                    str=str+entrada.readChar();
                }
                System.out.println("Segunda cadena leida con readChar(): " + str);
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Tercera cadena leida con readUTF: " + entrada.readUTF());
                System.out.println("Numero de Bytes por leer: " + entrada.available() + " Bytes");
                str="";
            }
        }catch(IOException e){
            System.out.println("Error al operar con el archivo");
        }finally{
            if(entrada != null){
                try{
                    entrada.close();
                }catch(IOException e2){
                    System.out.println("Hubo un error al cerrar el archivo");
                }
            }
        }
    }
}
