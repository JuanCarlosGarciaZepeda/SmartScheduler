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

public class Tester {
    public static void main(String[] args) throws IOException, ExceptionDAO {
        GestorContacto gestorC = new GestorContacto();
        GestorArchivo gestorA = new GestorArchivo();

        gestorC.setListaContactos(gestorA.leerArchivo());

        gestorC.showContacts(gestorC.getListaContactos());
        
        gestorC.searchDup();
        
        System.out.println("\n\n\n");
        System.out.println(gestorC.getListaContactos().size());
        System.out.println(gestorC.getListaDuplicados().size());
        System.out.println("\n\n\n");
        gestorC.showContacts(gestorC.getListaDuplicados());
        

        gestorC.orderLista(gestorC.getListaContactos());
        gestorC.orderLista(gestorC.getListaDuplicados());
        
        System.out.println("\n\n\n");
        gestorC.showContacts(gestorC.getListaContactos());
        System.out.println("\n\n\n");
        gestorC.showContacts(gestorC.getListaDuplicados());            
        // ver atribs de Contacto
        

        //gestorDAO.guardaTodos(gestorC.listaContactos);
/*
        String num = "+5215588015129";
        String num2 = "558-801-512-9";

        if (num.startsWith("+")) {
            System.out.println(num.replace("+521", ""));
        }

        System.out.println(num2.replace("-", ""));

        String correo = "antrax_3.16@hotmail.com";

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
*/

       
       
       /*GestorDAO gd = new GestorDAO();
       gd.guardaTodos(gestorC.getListaContactos());*/
    }
}
