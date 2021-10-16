/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.operations;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.N;
import uam.azc.adsi.smartscheduler.classes.Telefono;

/**
 *
 * @author antra
 */
public class GestorAnalisis {

    // analizador de N
    public boolean analizaN(N n) {
        Pattern N_FN = Pattern.compile("[A-Za-z\\s]+", Pattern.CASE_INSENSITIVE);
        // si la cadena esta vacia no se analiza
        if (!n.getN().equals("")) {
            Matcher matcherN = N_FN.matcher(n.getN());
            if (!matcherN.find()) {
                return false;
            }
        } else if (!n.getLn().equals("")) {
            Matcher matcherLn = N_FN.matcher(n.getLn());
            if (!matcherLn.find()) {
                return false;
            }
        } else if (!n.getNk().equals("")) {
            Matcher matcherNk = N_FN.matcher(n.getNk());
            if (!matcherNk.find()) {
                return false;
            }
        } else if (!n.getT().equals("")) {
            Matcher matcherT = N_FN.matcher(n.getT());
            if (!matcherT.find()) {
                return false;
            }
        }
        return true;
    }

    // analizador para FN
    public boolean analizaFN(String fn) {
        Pattern N_FN = Pattern.compile("[A-Za-z\\s]+", Pattern.CASE_INSENSITIVE);
        Matcher matcherFn = N_FN.matcher(fn);
        if(!fn.equals("")){
            if (!matcherFn.find()) {
                return false;
            }
        }
        return true;
    }

    // analizacor para ORG
    public boolean analizaORG(String org) {
        Pattern Adr_ORG = Pattern.compile("[A-Za-z0-9\\s]+", Pattern.CASE_INSENSITIVE);
        
        // si la cadena esta vacia no se analiza
        if (!org.equals("")) {
            Matcher matcherOrg = Adr_ORG.matcher(org);
            if (!matcherOrg.find()) {
                return false;
            }
        }
        return true;
    }

    // analizador para la lista de telefonos
    public boolean analizaTel(LinkedList<Telefono> tel) {
        Pattern Tel = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);

        // si la lista no esta vacia entonces se analiza
        if (!tel.isEmpty()) {
            for (Telefono t : tel) {
                Matcher matcherTel = Tel.matcher(t.getTelefono());
                if (!matcherTel.find()) {
                    return false;
                }
            }
        }
        return true;
    }

    // analizador para la lista de direcciones
    public boolean analizaAdr(LinkedList<Direccion> dir) {
        Pattern Adr_ORG = Pattern.compile("[A-Za-z0-9\\s]+", Pattern.CASE_INSENSITIVE);
        Pattern cp = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
        
        // si la lista no esta vacia entonces se analiza
        if (!dir.isEmpty()){
            for(Direccion d: dir){
                if(!d.getCampo1().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getCampo1());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getCampo2().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getCampo2());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getCalle().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getCalle());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getCiudad().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getCiudad());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getEstado().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getEstado());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getCp().equals("")){
                    Matcher matcherAdr = cp.matcher(d.getCp());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
                if(!d.getPais().equals("")){
                    Matcher matcherAdr = Adr_ORG.matcher(d.getPais());
                    if (!matcherAdr.find()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // analizador para la lista de emails
    public boolean analizaEmail(LinkedList<Email> correos){
        Pattern Email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
        
        // si la lista no esta vacia entonces se analiza
        if(!correos.isEmpty()){
            for(Email e: correos){
                Matcher matcherTel = Email.matcher(e.getEmail());
                if (!matcherTel.find()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // funcion que analiza sintacticamente los campos de un objeto contacto
    public int analizadorSintactico(Contacto c) {

        if (!analizaN(c.getN())) {
            return 1;
        } else if (!analizaFN(c.getFn())) {
            return 2;
        } else if (!analizaORG(c.getOrg())) {
            return 3;
        } else if (!analizaTel(c.getTel())) {
            return 4;
        } else if (!analizaAdr(c.getAdr())){
            return 5;
        } else if (!analizaEmail(c.getEmail())){
            return 6;
        }
        return 0;
    }
}
