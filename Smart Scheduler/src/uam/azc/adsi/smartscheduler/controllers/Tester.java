package uam.azc.adsi.smartscheduler.controllers;

import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.N;
import uam.azc.adsi.smartscheduler.classes.Telefono;
import uam.azc.adsi.smartscheduler.classes.Foto;
import uam.azc.adsi.smartscheduler.clasesdao.ExceptionDAO;
import uam.azc.adsi.smartscheduler.clasesdao.*;
import uam.azc.adsi.smartscheduler.operations.GestorArchivo;
import uam.azc.adsi.smartscheduler.operations.GestorContacto;

import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) throws IOException, ExceptionDAO {
        //GestorContacto gestorC = new GestorContacto();
        //GestorArchivo gestorA = new GestorArchivo();
        //GestorDAO gestorDAO =  new GestorDAO();

        //gestorC.listaContactos = gestorA.leerArchivo();

        //gestorC.showContacts();

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

        /*Contacto de prueba*/
        Foto pic = new Foto(); 
        Contacto prueba = new Contacto();
        N n1 = new N();
        n1.setN("Osacar");
        n1.setLn("Perezaas");
        n1.setNk("pepind");
        n1.setT("Msr.");
        prueba.setN(n1);
        prueba.setFn(n1.getN()+n1.getLn());
        prueba.setOrg("ATT");
        Telefono tel1 = new Telefono ();
        tel1.setTelefono("12242327890");
        tel1.setTipo("home");
        Telefono tel2 = new Telefono ();
        tel2.setTelefono("09227254321");
        tel2.setTipo("work");
        LinkedList<Telefono> telList = new LinkedList<>();
        telList.add(tel1);
        telList.add(tel2);
        prueba.setTel(telList);
        Direccion d1 = new Direccion();
       d1.setTipo("home");
       d1.setCalle("Miguel Aleman");
       d1.setCampo1("13");
       d1.setCampo2("lote 26");
       d1.setCiudad("Venustiano Carranza");
       d1.setCp("56789");
       d1.setEstado("CDMX");
       d1.setPais("Mexico");
       Direccion d2 = new Direccion();
       d2.setTipo("work");
       d2.setCalle("San pablo xalpa");
       d2.setCampo1("234");
       d2.setCampo2("lote 99");
       d2.setCiudad("Azcapotzalco");
       d2.setCp("56666");
       d2.setEstado("CDMX");
       d2.setPais("Mexico");
       LinkedList<Direccion> dirList = new LinkedList<>();
       dirList.add(d1);
       dirList.add(d2);
       prueba.setAdr(dirList);
       Email m1 = new Email();
       m1.setTipo("work");
       m1.setEmail("al22345657@azc.uam.mx");
       Email m2 = new Email();
       m2.setTipo("home");
       m2.setEmail("adios@gmail.com");
       LinkedList<Email> mailList = new LinkedList<>();
       mailList.add(m1);
       mailList.add(m2);
       prueba.setEmail(mailList);
       prueba.setPhoto(pic);
       MySQLContactoDAO cdao1 = new MySQLContactoDAO();
       GestorDAO gd = new GestorDAO();
       //gd.createC(prueba);
       //gd.deleteC(prueba);
       cdao1.insertar(prueba);//guardar el contacto funciona
       //gd.createC(prueba); //guardar el contacto con todos los campos no funciona :(

    }
}
