package uam.azc.adsi.smartscheduler.operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import uam.azc.adsi.smartscheduler.classes.Contacto;


public class GestorArchivo {

    /* Recupera los contactos del archivo vcf*/
    public static void leerArchivo() {

        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("Smart Scheduler/contacts.vcf");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();

            // mientras no se encuentre el final del archivo
            while (cadenaLeida != null) {              

                // se se encuentra una etiqueta de inicio 
                if (cadenaLeida.equals("BEGIN:VCARD")) {
                    System.out.println(archivoLectura.readLine());  // lee la linea de version

                    Contacto c = new Contacto();

                    // mientras no se encuentre una etiqueta de cierre
                    while (!cadenaLeida.equals("END:VCARD")) {
                        StringTokenizer st = new StringTokenizer(cadenaLeida, ":"); // tokenizer para :
                        StringTokenizer st3 = new StringTokenizer(cadenaLeida, ";");// tokenizer para ;

                        // se lee el tipo de etiqueta que este en la actual linea leida del archivo
                        String etiqueta = st.nextToken();   // hasta el primer :
                        String etiqueta2 = st3.nextToken(); // hasta el primer ;

                        // si se encuentra una etiqueta de N
                        if (etiqueta.equals("N")) {
                            System.out.println("\nEtiqueta N");

                            // se elimina del renglon leido la etiqueta y el token para poder leer el siguiente contenido
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", " ");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

                            // se obtienen los contenidos de la etiqueta mediante el token ;
                            String apellido = st2.nextToken();
                            if (apellido.equals(" ")) {
                                System.out.println("Apellido esta vacio");
                                
                            } else {
                                System.out.println("Apellido: " + apellido.trim());
                            }

                            try {
                                String nombre = st2.nextToken();
                                System.out.println("Nombre: " + nombre);

                            } catch (Exception e) {
                                System.out.println("Nombre esta vacio");
                            }

                            try {
                                String nickname = st2.nextToken();
                                System.out.println("Nickname: " + nickname);

                            } catch (Exception e) {
                                System.out.println("Nickname esta vacio");
                            }

                            try {
                                String grado = st2.nextToken();
                                System.out.println("Grado: " + grado);
                            } catch (Exception e) {
                                System.out.println("Grado esta vacio");
                            }

                        // si la etiqueta es FN
                        } else if (etiqueta.equals("FN")) {
                            System.out.println("\nEtiqueta FN");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", "");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

                            try {
                                String nombreCompleto = st2.nextToken();
                                System.out.println("nombreCompleto: " + nombreCompleto);
                            } catch (Exception e) {
                                System.out.println("nombreCompleto esta vacio");
                            }

                        // si la etiqueta es ORG
                        } else if (etiqueta.equals("ORG")) {
                            System.out.println("\nEtiqueta ORG");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", "");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

                            try {
                                String organizacion = st2.nextToken();
                                System.out.println("organizacion: " + organizacion);
                            } catch (Exception e) {
                                System.out.println("organizacion esta vacio");
                            }

                        // si la etiqueta es TEL
                        } else if (etiqueta2.equals("TEL")) {
                            System.out.println("\nEtiqueta TEL");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");

                            try {
                                String tipo = st2.nextToken();
                                String telefono = st2.nextToken();
                                System.out.println(tipo + ": " + telefono);

                            } catch (Exception e) {
                                System.out.println("telefono esta vacio");
                            }

                        // si la etiqueta es EMAIL
                        } else if (etiqueta2.equals("EMAIL")) {
                            System.out.println("\nEtiqueta EMAIL");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");

                            try {
                                String tipo = st2.nextToken();
                                String email = st2.nextToken();
                                System.out.println(tipo + ": " + email);
                            } catch (Exception e) {
                                System.out.println("Email esta vacio");
                            }

                        // si la etiqueta es ADR
                        } else if (etiqueta2.equals("ADR")) {
                            System.out.println("\nEtiqueta ADR");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
                            
                            String tipoAdress = st2.nextToken();
                            System.out.println("Tipo " + tipoAdress);
                            cadenaLeida = cadenaLeida.replaceAll(tipoAdress + ":", " ");
                            StringTokenizer st4 = new StringTokenizer(cadenaLeida, ";");
                            String tipoCalle = st4.nextToken();

                            if (tipoCalle.equals(" ")) {
                                System.out.println("TipoCalle esta vacio");
                            } else {
                                System.out.println("TipoCalle: " + tipoCalle.trim());
                            }

                            try {
                                String calle = st4.nextToken();
                                System.out.println("calle: " + calle);

                            } catch (Exception e) {
                                System.out.println("calle vacio");
                            }

                            try {
                                String ciudad = st4.nextToken();
                                System.out.println("ciudad: " + ciudad);

                            } catch (Exception e) {
                                System.out.println("ciudad vacio");
                            }

                            try {
                                String estado = st4.nextToken();
                                System.out.println("estado: " + estado);

                            } catch (Exception e) {
                                System.out.println("estado vacio");
                            }

                            try {
                                String cp = st4.nextToken();
                                System.out.println("cp: " + cp);

                            } catch (Exception e) {
                                System.out.println("cp vacio");
                            }

                            try {
                                String pais = st4.nextToken();
                                System.out.println("pais: " + pais);

                            } catch (Exception e) {
                                System.out.println("pais vacio");
                            }
                            
                        // si la etiqueta es PHOTO
                        } else if (etiqueta2.equals("PHOTO")) {
                            System.out.println("\nEtiqueta PHOTO");

                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");

                            String encoding = st3.nextToken();
                            cadenaLeida = cadenaLeida.replaceAll(encoding + ";", "");
                            
                            StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
                            cadenaLeida = cadenaLeida.replaceAll(encoding + ":", "");

                            String tipo = st2.nextToken();
                            
                            cadenaLeida = cadenaLeida.replaceAll(tipo + ":", "");

                            String base64 = "";
                            while( !cadenaLeida.endsWith("=")){
                                base64 += cadenaLeida.trim();
                                cadenaLeida = archivoLectura.readLine();
                            }
                            
                            base64 += "=";

                            System.out.println("encoding: " + encoding);
                            System.out.println("tipo: " + tipo);
                            System.out.println("cadena: " + base64);

                        }

                        else {
                            cadenaLeida = archivoLectura.readLine();
                        } 
                    }
                }
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        }catch (NoSuchElementException e){
            System.out.println("Archivo terminado");
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