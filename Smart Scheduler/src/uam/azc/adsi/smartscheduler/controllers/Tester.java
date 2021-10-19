package uam.azc.adsi.smartscheduler.controllers;

import uam.azc.adsi.smartscheduler.clasesdao.ExceptionDAO;
import uam.azc.adsi.smartscheduler.clasesdao.*;
import uam.azc.adsi.smartscheduler.operations.GestorArchivo;
import uam.azc.adsi.smartscheduler.operations.GestorContacto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.operations.GestorAnalisis;

public class Tester {

    public static void main(String[] args) throws IOException, ExceptionDAO {
//        GestorContacto gestorC = new GestorContacto();
//        GestorArchivo gestorA = new GestorArchivo();
//        GestorDAO gd = new GestorDAO();
//       
//        gestorC.setId(gd.obtieneCuantos());
//        gestorC.setListaContactos(gestorA.leerArchivo());
//        gestorC.searchDup();
//        gestorC.searchInc();
//        gestorC.searchCompletos();
//        gestorC.searchSinFoto();
//        
//        gd.guardaTodos(gestorC.getListaContactos());
//        
//        
//        
        
        //gestorC.showContacts();
        //gestorA.exportarVcf(gestorC.listaContactos);

        
  //      GestorAnalisis gestorAn = new GestorAnalisis();
//        Contacto c = gestorC.getListaContactos().getLast();
    //    System.out.println(c);
      //  System.out.println(gestorAn.analizadorSintactico(c));
        
        //c.setFn("ju4n c4rl05");
        //c.setOrg("mi org@nizacion"); // 3
        //c.getTel().getFirst().setTelefono("mi telefono"); // 4
        //c.getAdr().get(0).setCp("muy lejos"); // 5
        //c.getEmail().get(0).setEmail("juan.com"); // 6
        //System.out.println(c);
        //System.out.println(gestorAn.analizadorSintactico(c));
        
        // carga los datos en la BD
        //GestorDAO gd = new GestorDAO();
        //gd.guardaTodos(gestorC.listaContactos);

        //gestorC.setListaContactos(gestorA.leerArchivo());
        
        //System.out.println("\n\n\nContactos: "+gestorC.getListaContactos().size()+"\n");
        //gestorC.showContacts(gestorC.getListaContactos());
        
        //gestorC.searchDup();
        //gestorC.searchInc();
        //gestorC.searchCompletos();
        //gestorC.searchSinFoto();
        
        //gestorC.showContacts(gestorC.getListaContactos());
        
      /*  gestorC.orderLista(gestorC.getListaContactos());
        gestorC.orderLista(gestorC.getListaDuplicados());
        */
     /*   System.out.println("\n\n\nContactos acomodados\n");
        gestorC.showContacts(gestorC.getListaContactos());
        System.out.println("\n\n\nDuplicados acomodados\n");
        gestorC.showContacts(gestorC.getListaDuplicados()); 
       */ 
        
        /*
        gestorC.searchSinFoto();
        System.out.println("Sin foto: "+gestorC.getListaSinFoto().size()+"\n");
        System.out.println(gestorC.getListaSinFoto());
        */
        
        
        /*
        gestorC.searchCompletos();
        System.out.println("completos: "+gestorC.getListaCompletos().size()+"\n");
        //gestorC.showContacts(gestorC.getListaCompletos());
        */
        
        
/*
        gestorC.searchDup();
        System.out.println("\n\n\ndup\n");
        gestorC.showContacts(gestorC.getListaDuplicados());
        
        gestorC.orderLista(gestorC.getListaContactos());
        gestorC.orderLista(gestorC.getListaDuplicados());
        
        System.out.println("\n\n\ncontactos acomodados\n");
        gestorC.showContacts(gestorC.getListaContactos());
        System.out.println("\n\n\nduplicados acomodados\n");
        gestorC.showContacts(gestorC.getListaDuplicados());    
*/
/*

        gestorC.searchInc();
        System.out.println("\n\n\nincompletos: "+gestorC.getListaIncompletos().size()+"\n");
        gestorC.showContacts(gestorC.getListaIncompletos());
        gestorC.orderLista(gestorC.getListaIncompletos());
        System.out.println("\n\n\nincompletos acomodados: "+gestorC.getListaIncompletos().size()+"\n");
        gestorC.showContacts(gestorC.getListaIncompletos());
        
*/        
        // ver atribs de Contacto
        

        //gd.guardaTodos(gestorC.listaContactos);
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

  
       
       
       //System.out.println("\n\n\n\nSIN FOTO");
       //gestorC.showContacts(gd.obtieneSinFoto());
        
       //System.out.println("\n\n\n\nINCOMPLETOS");
       //gestorC.showContacts(gd.obtieneIncompletos());
        
       //System.out.println("\n\n\n\nCOMPLETOS");
       //gestorC.showContacts(gd.obtieneCompletos());
       
       //System.out.println("\n\n\n\nDUPLICADOS");
       //gestorC.showContacts(gd.obtieneduplicados());
        
       
        
    }
}
