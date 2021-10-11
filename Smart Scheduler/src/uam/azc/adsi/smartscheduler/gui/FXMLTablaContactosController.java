/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.Collection;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uam.azc.adsi.smartscheduler.classes.Telefono;
//import modeloProducto.ProductoDAO;

/**
 * FXML Controller class
 *
 * @author WIN
 */
public class FXMLTablaContactosController implements Initializable {

    
    @FXML 
    private TableView<Telefono> tablaContactos;
    
    @FXML
    public void muestraTabla(){
        
        ArrayList<Telefono> b = new ArrayList<>();
        
        Telefono t = new Telefono();
        
        t.setTelefono("tel");
        t.setTipo("tipo");
        //n.setNk("nk");
        //n.setT("t");
        
        b.add(t);
        b.add(t);
        b.add(t);
        
        
        ObservableList<Telefono> a = FXCollections.observableArrayList(b);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        
        tablaContactos.setItems(a);
    /* 
        ProductoDAO pdao = new ProductoDAO();
        
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tablaProductos.setItems(pdao.verProductos());
    */
    }
         
    @FXML
    public void regresar(ActionEvent event) throws IOException {
         Parent bienvenidaParent = FXMLLoader.load(getClass().getResource("FXMLCargarArchivo.fxml"));
         Scene bienvenidaScene = new Scene(bienvenidaParent);
         
         Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
         ventanaPrincipal.setTitle("Ventana de carga de archivo."); 
         ventanaPrincipal.setScene(bienvenidaScene);
         ventanaPrincipal.centerOnScreen();
         ventanaPrincipal.show();
    }
    
    @FXML
    public void agregar(ActionEvent event) throws IOException {
        Parent agregarParent = FXMLLoader.load(getClass().getResource("FXMLAgregarContacto.fxml"));
        Scene agregarScene = new Scene(agregarParent);
         
        Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ventanaPrincipal.setTitle("Formulario para agregar productos."); 
        
        ventanaPrincipal.setScene(agregarScene);
        ventanaPrincipal.centerOnScreen();
        ventanaPrincipal.show();
    }
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        muestraTabla();
    }    
    
}


/*
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        muestraTabla();
    }    
    
}


*/
