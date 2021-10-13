package uam.azc.adsi.smartscheduler.controllers;

import uam.azc.adsi.smartscheduler.clasesdao.ExceptionDAO;
import uam.azc.adsi.smartscheduler.clasesdao.*;
import uam.azc.adsi.smartscheduler.operations.GestorArchivo;
import uam.azc.adsi.smartscheduler.operations.GestorContacto;

import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.operations.GestorAnalisis;

public class Tester {

    public static void main(String[] args) throws IOException, ExceptionDAO {
        GestorContacto gestorC = new GestorContacto();
        GestorArchivo gestorA = new GestorArchivo();
        gestorC.listaContactos = gestorA.leerArchivo();
        //gestorC.showContacts();
        //gestorA.exportarVcf(gestorC.listaContactos);

        
        GestorAnalisis gestorAn = new GestorAnalisis();
        Contacto c = gestorC.listaContactos.getLast();
        System.out.println(c);
        System.out.println(gestorAn.analizadorSintactico(c));
        
        c.setFn("ju4n c4rl05");
        //c.setOrg("mi org@nizacion"); // 3
        //c.getTel().getFirst().setTelefono("mi telefono"); // 4
        //c.getAdr().get(0).setCp("muy lejos"); // 5
        //c.getEmail().get(0).setEmail("juan.com"); // 6
        System.out.println(c);
        System.out.println(gestorAn.analizadorSintactico(c));
        
        // carga los datos en la BD
        //GestorDAO gd = new GestorDAO();
        //gd.guardaTodos(gestorC.listaContactos);
    }
}
