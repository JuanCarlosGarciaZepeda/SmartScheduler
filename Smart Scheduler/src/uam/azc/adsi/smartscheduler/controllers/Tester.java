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
        GestorContacto gestorC = new GestorContacto();
        GestorArchivo gestorA = new GestorArchivo();
        GestorDAO gestorDAO =  new GestorDAO();

        gestorC.listaContactos = gestorA.leerArchivo();

        gestorC.showContacts();

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
       
       /*Contacto de prueba*/
        Contacto prueba2 = new Contacto();
        Contacto prueba3 = new Contacto();
        N n3 = new N();
        n3.setN("Jose");
        n3.setLn("Perrez");
        n3.setNk("nacho");
        n3.setT("Mr.");
        prueba3.setN(n1);
        prueba3.setFn(n1.getN()+n1.getLn());
        prueba3.setOrg("ATT");
        Telefono tel5 = new Telefono ();
        tel5.setTelefono("133333327890");
        tel5.setTipo("home");
        Telefono tel6 = new Telefono ();
        tel6.setTelefono("0333354321");
        tel6.setTipo("work");
        LinkedList<Telefono> telList3 = new LinkedList<>();
        telList3.add(tel1);
        telList3.add(tel2);
        prueba3.setTel(telList3);
        Direccion d6 = new Direccion();
       d6.setTipo("home");
       d6.setCalle("Miguel Flores");
       d6.setCampo1("13");
       d6.setCampo2("lote 26");
       d6.setCiudad("ALVARO OBREGON");
       d6.setCp("56789");
       d6.setEstado("CDMX");
       d6.setPais("Mexico");
       Direccion d5 = new Direccion();
       d5.setTipo("work");
       d5.setCalle("San pablo xalpa");
       d5.setCampo1("234");
       d5.setCampo2("lote 99");
       d5.setCiudad("Azcapotzalco");
       d5.setCp("56666");
       d5.setEstado("CDMX");
       d5.setPais("Mexico");
       LinkedList<Direccion> dirList3 = new LinkedList<>();
       dirList3.add(d5);
       dirList3.add(d6);
       prueba3.setAdr(dirList3);
       Email m5 = new Email();
       m5.setTipo("work");
       m5.setEmail("al22345657@azc.uam.mx");
       Email m6 = new Email();
       m6.setTipo("home");
       m6.setEmail("adios@gmail.com");
       LinkedList<Email> mailList3 = new LinkedList<>();
       mailList3.add(m5);
       mailList3.add(m6);
        prueba3.setEmail(mailList);
        prueba3.setPhoto(pic);
       
      N n2 = new N();
        n2.setN("Joel");
        n2.setLn("gutierrez");
        n2.setNk("nacho");
        n2.setT("Mr.");
        prueba2.setN(n2);
        prueba2.setFn(n2.getN()+n2.getLn());
        prueba2.setOrg("TELCEL");
        Telefono tel3 = new Telefono ();
        tel3.setTelefono("12342328890");
        tel3.setTipo("home");
        Telefono tel4 = new Telefono ();
        tel4.setTelefono("09227754321");
        tel4.setTipo("work");
        LinkedList<Telefono> telList2 = new LinkedList<>();
        telList2.add(tel3);
        telList2.add(tel4);
        prueba2.setTel(telList2);
        Direccion d3 = new Direccion();
       d3.setTipo("home");
       d3.setCalle("Miguel Flores");
       d3.setCampo1("13");
       d3.setCampo2("lote 26");
       d3.setCiudad("ALVARO OBREGON");
       d3.setCp("56789");
       d3.setEstado("CDMX");
       d3.setPais("Mexico");
       Direccion d4 = new Direccion();
       d4.setTipo("work");
       d4.setCalle("San pablo xalpa");
       d4.setCampo1("234");
       d4.setCampo2("lote 99");
       d4.setCiudad("Azcapotzalco");
       d4.setCp("56666");
       d4.setEstado("CDMX");
       d4.setPais("Mexico");
       LinkedList<Direccion> dirList2 = new LinkedList<>();
       dirList.add(d3);
       dirList.add(d4);
       prueba2.setAdr(dirList2);
       Email m3 = new Email();
       m3.setTipo("work");
       m3.setEmail("msl22345657@azc.uam.mx");
       Email m4 = new Email();
       m4.setTipo("home");
       m4.setEmail("adios@gmail.com");
       LinkedList<Email> mailList2 = new LinkedList<>();
       mailList.add(m3);
       mailList.add(m4);
        prueba2.setEmail(mailList2);
        prueba2.setPhoto(pic);  
        
        LinkedList<Contacto> lc2 = new LinkedList<>();
        lc2.add(prueba3);
        lc2.add(prueba2);
       
       
       GestorDAO gd = new GestorDAO();
       //gd.createC(prueba);
       //gd.deleteC(prueba);
       //cdao1.insertar(prueba);//guardar el contacto funciona
       //int identificador = cdao1.buscarUltimoId();
       //System.out.println("Se guardo en id:"+ identificador);
       //prueba.setidCcontacto(2);
       //gd.createC(prueba); //guardar el contacto con todos los campos no funciona :(
       //gd.guardaTodos(lc2);
       gd.guardaTodos(gestorC.listaContactos);
    }
}
