package uam.azc.adsi.smartscheduler.operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.N;
import uam.azc.adsi.smartscheduler.classes.Telefono;
import uam.azc.adsi.smartscheduler.classes.Foto;

public class GestorArchivo {
    public GestorArchivo(){}

    // funcion que obtiene el contenido de la etiqueta N
    public void convierteN(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");
        N n = new N();

        // se obtienen los contenidos de la etiqueta mediante el token ;
        String apellido = st2.nextToken();
        if (apellido.equals(" ")) {
            //System.out.println("Apellido esta vacio");
            n.setLn("");
        } else {
            //System.out.println("Apellido: " + apellido.trim());
            n.setLn(apellido.trim());
        }

        try {
            String nombre = st2.nextToken();
            //System.out.println("Nombre: " + nombre);
            n.setN(nombre);
        } catch (Exception e) {
            //System.out.println("Nombre esta vacio");
            n.setN("");
        }

        try {
            String nickname = st2.nextToken();
            //System.out.println("Nickname: " + nickname);
            n.setNk(nickname);
        } catch (Exception e) {
            //System.out.println("Nickname esta vacio");
            n.setNk("");
        }

        try {
            String grado = st2.nextToken();
            //System.out.println("Grado: " + grado);
            n.setT(grado);
        } catch (Exception e) {
            //System.out.println("Grado esta vacio");
            n.setT("");
        }
        // agregando objeto n a contacto
        c.setN(n);
    }

    // funcion que obtiene el contenido de la etiqueta FN
    public void convierteFN(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

        try {
            String nombreCompleto = st2.nextToken();
            //System.out.println("nombreCompleto: " + nombreCompleto);
            c.setFn(nombreCompleto);
        } catch (Exception e) {
            //System.out.println("nombreCompleto esta vacio");
            c.setFn("");
        }

    }

    // funcion que obtiene el contenido de la etiqueta ORG
    public void convierteORG(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ";");

        try {
            String organizacion = st2.nextToken();
            //System.out.println("organizacion: " + organizacion);
            c.setOrg(organizacion);
        } catch (Exception e) {
            //System.out.println("organizacion esta vacio");
            c.setOrg("");
        }
    }

    // funcion que obtiene el contenido de la etiqueta TEL
    public void convierteTEL(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
        Telefono t = new Telefono();

        try {
            String tipo = st2.nextToken();
            //System.out.println("tipo: " + tipo);
            t.setTipo(tipo);
        } catch (Exception e) {
            //System.out.println("tipo esta vacio");
            t.setTipo("");
        }

        try {
            String telefono = st2.nextToken();
            //System.out.println("telefono: " + telefono);
            t.setTelefono(telefono);
        } catch (Exception e) {
            //System.out.println("telefono esta vacio");
            t.setTelefono("");
        }

        c.agregarTelefono(t);
    }

    // funcion que obtiene el contenido de la etiqueta EMAIL
    public void convierteEmail(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
        Email email = new Email();

        try {
            String tipo = st2.nextToken();
            //System.out.println("tipo: " + tipo);
            email.setTipo(tipo);
        } catch (Exception e) {
            //System.out.println("Tipo esta vacio");
            email.setTipo("");
        }

        try {
            String correo = st2.nextToken();
            //System.out.println("correo: " + correo);
            email.setEmail(correo);
        } catch (Exception e) {
            //System.out.println("Email esta vacio");
            email.setEmail("");
        }

        // agregar email a la lista de email de c
        c.agregarEmail(email);
    }

    // funcion que obtiene el contenido de la etiqueta ADR
    public void convierteAdr(String cadenaLeida, Contacto c) {
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
        Direccion d = new Direccion();

        String tipoAdress = st2.nextToken();
        //System.out.println("Tipo " + tipoAdress);
        d.setTipo(tipoAdress);

        cadenaLeida = cadenaLeida.replaceAll(tipoAdress + ":", " ");
        StringTokenizer st4 = new StringTokenizer(cadenaLeida, ";");
        String tipoCalle = st4.nextToken();

        if (tipoCalle.equals(" ")) {
            //System.out.println("TipoCalle esta vacio");
            d.setCampo1("");
        } else {
            //System.out.println("TipoCalle: " + tipoCalle.trim());
            d.setCampo2("");
        }

        try {
            String calle = st4.nextToken();
            //System.out.println("calle: " + calle);
            d.setCalle(calle);
        } catch (Exception e) {
            //System.out.println("calle vacio");
            d.setCalle("");
        }

        try {
            String ciudad = st4.nextToken();
            //System.out.println("ciudad: " + ciudad);
            d.setCiudad(ciudad);
        } catch (Exception e) {
            //System.out.println("ciudad vacio");
            d.setCiudad("");
        }

        try {
            String estado = st4.nextToken();
            //System.out.println("estado: " + estado);
            d.setEstado(estado);
        } catch (Exception e) {
            //System.out.println("estado vacio");
            d.setEstado("");
        }

        try {
            String cp = st4.nextToken();
            //System.out.println("cp: " + cp);
            d.setCp(cp);
        } catch (Exception e) {
            //System.out.println("cp vacio");
            d.setCp("");
        }

        try {
            String pais = st4.nextToken();
            //System.out.println("pais: " + pais);
            d.setPais(pais);
        } catch (Exception e) {
            //System.out.println("pais vacio");
            d.setPais("");
        }

        // agregando direccion a lista de direcciones
        c.agregarDireccion(d);
    }

    // funcion que obtiene el contenido de la etiqueta PHOTO
    public void conviertePhoto(String cadenaLeida, Contacto c, BufferedReader archivoLectura) throws IOException {
        StringTokenizer st3 = new StringTokenizer(cadenaLeida, ";");
        String encoding = st3.nextToken();
        Foto f = new Foto();

        cadenaLeida = cadenaLeida.replaceAll(encoding + ";", "");
        StringTokenizer st2 = new StringTokenizer(cadenaLeida, ":");
        cadenaLeida = cadenaLeida.replaceAll(encoding + ":", "");
        String tipo = st2.nextToken();
        cadenaLeida = cadenaLeida.replaceAll(tipo + ":", "");

        String base64 = "";
        while (!cadenaLeida.endsWith("=")) {
            base64 += cadenaLeida.trim();
            cadenaLeida = archivoLectura.readLine();
        }
        base64 += "=";

        encoding = encoding.replace("ENCODING=", "");
        //System.out.println("encoding: " + encoding);
        //System.out.println("tipo: " + tipo);
        //System.out.println("cadena: " + base64);
        cadenaLeida = archivoLectura.readLine();

        f.setTipo(tipo);
        f.setEncoding(encoding);
        f.setCadena(base64);
        c.setPhoto(f);
    }

    /* Recupera los contactos del archivo vcf */
    public LinkedList <Contacto> leerArchivo() {
        LinkedList <Contacto> listaContactos = new LinkedList<>();
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
                    //System.out.println(archivoLectura.readLine()); // lee la linea de version
                    archivoLectura.readLine();  // lee la version del archivo 
                    Contacto c = new Contacto();// crea un objeto contacto para guardar la informacion

                    // mientras no se encuentre una etiqueta de cierre
                    while (!cadenaLeida.equals("END:VCARD")) {
                        StringTokenizer st = new StringTokenizer(cadenaLeida, ":"); // tokenizer para :
                        StringTokenizer st3 = new StringTokenizer(cadenaLeida, ";");// tokenizer para ;

                        // se lee el tipo de etiqueta que este en la actual linea leida del archivo
                        String etiqueta = st.nextToken(); // hasta el primer :
                        String etiqueta2 = st3.nextToken(); // hasta el primer ;

                        // si se encuentra una etiqueta de N
                        if (etiqueta.equals("N")) {
                            //System.out.println("\nEtiqueta N");

                            // se elimina del renglon N:
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", " ");
                            // se invoca a la funcion que obtiene el contenido de la etiqueta
                            convierteN(cadenaLeida, c);

                            // si la etiqueta es FN
                        } else if (etiqueta.equals("FN")) {
                            //System.out.println("\nEtiqueta FN");

                            // se elimina del renglon la etiqueta FN:
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", "");
                            // se llama a la funcion que obtiene el contenido
                            convierteFN(cadenaLeida, c);

                            // si la etiqueta es ORG
                        } else if (etiqueta.equals("ORG")) {
                            //System.out.println("\nEtiqueta ORG");

                            // se borra ORG:
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta + ":", "");
                            // se llama a la funcion que obtiene el contenido
                            convierteORG(cadenaLeida, c);

                            // si la etiqueta es TEL
                        } else if (etiqueta2.equals("TEL")) {
                            //System.out.println("\nEtiqueta TEL");

                            // se elimina TEL;
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            // se llama a la funcion que extrae el contenido
                            convierteTEL(cadenaLeida, c);

                            // si la etiqueta es EMAIL
                        } else if (etiqueta2.equals("EMAIL")) {
                            //System.out.println("\nEtiqueta EMAIL");

                            // se elimina EMAIL;
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            // se llama a la funcion que extrae el contenido
                            convierteEmail(cadenaLeida, c);

                            // si la etiqueta es ADR
                        } else if (etiqueta2.equals("ADR")) {
                            //System.out.println("\nEtiqueta ADR");

                            // se quita la etiqueta ADR;
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            // se llama a la funcion que extrae el contenido
                            convierteAdr(cadenaLeida, c);

                            // si la etiqueta es PHOTO
                        } else if (etiqueta2.equals("PHOTO")) {
                            //System.out.println("\nEtiqueta PHOTO");

                            // se quita de la cadena PHOTO;
                            cadenaLeida = cadenaLeida.replaceAll(etiqueta2 + ";", "");
                            // se llama a la funcion
                            conviertePhoto(cadenaLeida, c, archivoLectura);

                        }

                        else {
                            // si la etiqueta no es una de las anteriores, se omite pasando al siguiente renglon del archivo
                            cadenaLeida = archivoLectura.readLine();
                        }
                    }
                    // agregando contacto a la lista
                    listaContactos.add(c);
                }
                // cuando encuentra una END:VCARD se pasa a la siguiente linea del archivo
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close(); // se cierra el buffer de lectura
        } catch (NoSuchElementException e) {
            System.out.println("Archivo terminado");
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        return listaContactos;
    }
}