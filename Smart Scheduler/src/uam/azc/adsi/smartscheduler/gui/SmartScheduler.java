/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uam.azc.adsi.smartscheduler.operations.GestorArchivo;
import uam.azc.adsi.smartscheduler.operations.GestorContacto;


/**
 *
 * @author antra
 */
public class SmartScheduler extends Application {
    
    public static GestorArchivo gestorA = new GestorArchivo();
    public static GestorContacto gestorC = new GestorContacto(); 
    
         @Override
    public void start(Stage ventanaPrincipal) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCargarArchivo.fxml"));
        Scene scene = new Scene(root);
        ventanaPrincipal.setTitle("Ventana de carga de archivo.");
        //ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.centerOnScreen();
        ventanaPrincipal.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        launch(args);
        
    }
    
}
