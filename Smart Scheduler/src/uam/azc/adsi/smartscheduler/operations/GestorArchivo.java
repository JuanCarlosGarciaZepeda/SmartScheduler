package uam.azc.adsi.smartscheduler.operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GestorArchivo {

    /*Recupera los clientes del archivo*/
    public static void leerArchivo(){

        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("Smart Scheduler/contacts.vcf");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {

                //StringTokenizer st = new StringTokenizer(cadenaLeida, ";");
                
                //System.out.println(st.nextToken());
                //System.out.println(cadenaLeida);
                //cadenaLeida = archivoLectura.readLine();
                if (cadenaLeida.equals("BEGIN:VCARD")){
                    System.out.println("LA version es: " + archivoLectura.readLine());
                    while(!cadenaLeida.equals("END:VCARD")){
                        StringTokenizer st = new StringTokenizer(cadenaLeida, ":");
                        String attr = st.nextToken();
                        //System.out.println(attr);
                        if(attr.equals("N")){
                            cadenaLeida = cadenaLeida.replaceAll(attr+":", " ");
                            System.out.println("\n" + cadenaLeida + "\n");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

                            String ap1 = st2.nextToken();
                            if(ap1.equals(" ")){
                                System.out.println("Apellido 1 esta vacio");
                            } else {
                                System.out.println("Apellido 1: " + ap1.trim());
                            }
                            
                            try{
                                String ap2 = st2.nextToken();
                                System.out.println("Apellido2: " + ap2);

                            } catch (Exception e){
                                System.out.println("Apellido 2 vacio");
                            }

                            try {
                                String n1 = st2.nextToken();
                                System.out.println("Nombre 1: " + n1);
                                
                            } catch (Exception e){
                                System.out.println("Nombre 1 esta vacio");
                            }

                            try {
                                String n2 = st2.nextToken();
                                System.out.println("Nombre 2: " + n2);
                            } catch (Exception e){
                                System.out.println("Nombre 2 esta vacio");
                            }

                        } 
                        
                        
                        
                        
                        
                        
                        
                        else {
                            cadenaLeida = archivoLectura.readLine();
                        }
                        
                    }
                }
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        leerArchivo();
    }
}