/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WIN
 */
public class FXMLCargarArchivoController implements Initializable {

    @FXML
    private Label msLabel;
    @FXML
    private Button cargarButton;

    
    @FXML
    public void cargar(ActionEvent event) throws IOException {
        
        //gestorC ya tiene el ID
        
        SmartScheduler.gestorC.setListaContactos(SmartScheduler.gestorA.leerArchivo());
        
        
        SmartScheduler.gestorC.showContacts(SmartScheduler.gestorC.getListaContactos());
        
        SmartScheduler.gestorC.searchDup();
        
        System.out.println("\n\n\n");
        System.out.println(SmartScheduler.gestorC.getListaContactos().size());
        System.out.println(SmartScheduler.gestorC.getListaDuplicados().size());
        System.out.println("\n\n\n");
        SmartScheduler.gestorC.showContacts(SmartScheduler.gestorC.getListaDuplicados());
        

        SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaContactos());
        SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaDuplicados());
        
        System.out.println("\n\n\n");
        SmartScheduler.gestorC.showContacts(SmartScheduler.gestorC.getListaContactos());
        System.out.println("\n\n\n");
        SmartScheduler.gestorC.showContacts(SmartScheduler.gestorC.getListaDuplicados());  
        
        
        Parent bienvenidaParent = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
         Scene bienvenidaScene = new Scene(bienvenidaParent);
         
         Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
         ventanaPrincipal.setTitle("Ventana principal."); 
         ventanaPrincipal.setResizable(false);
         
         ventanaPrincipal.setScene(bienvenidaScene);
         ventanaPrincipal.centerOnScreen();
         ventanaPrincipal.show();
        
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
