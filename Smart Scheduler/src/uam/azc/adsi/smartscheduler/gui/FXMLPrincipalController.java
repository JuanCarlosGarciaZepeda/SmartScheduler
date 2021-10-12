/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Stage;
import javax.swing.ListSelectionModel;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.N;
import uam.azc.adsi.smartscheduler.classes.Telefono;

/**
 * FXML Controller class
 *
 * @author WIN
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private TableView<N> nTableView;
    @FXML
    private ComboBox<String> menuComboBox;
    @FXML
    private Label nLabel;
    @FXML
    private Label orgLabel;
    @FXML
    private TableView<Telefono> telefonoTableView;
    @FXML
    private TableView<Email> emailTableView;
    @FXML
    private TableView<Direccion> direccionTableView;
    
    @FXML
    public void muestraTablaN(){
        
        ArrayList<N> listaN = new ArrayList<>();
        
        for(int i = 0; i < SmartScheduler.gestorC.getListaContactos().size(); i++){
            listaN.add(SmartScheduler.gestorC.getListaContactos().get(i).getN());
        }
        
        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        nTableView.setItems(observableN);               
        nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        nTableView.getSelectionModel().selectFirst();
        
        nTableView.setVisible(true);
        
        nTableView.setOnMouseClicked(e -> {evento();});
        
    }
    
    private void evento(){
        menuComboBox.getSelectionModel().select("Telefonos");
        muestraTablaTel();
    };
    
    @FXML
    public void muestraTablaDir(){
        
        telefonoTableView.setVisible(false);
        emailTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Direccion> listaDir = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
        
        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        direccionTableView.setItems(observableDir);               
        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        direccionTableView.setVisible(true);
        
    }
    
    @FXML
    public void muestraTablaEmail(){
        
        telefonoTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Email> listaEmail = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
        
        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        emailTableView.setItems(observableEmail);               
        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        emailTableView.setVisible(true);
        
    }
    
    @FXML
    public void muestraTablaTel(){
        
        emailTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Telefono> listaTel = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
        
        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        telefonoTableView.setItems(observableTel);               
        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        telefonoTableView.setVisible(true);
        
    }
    
    
     @FXML
    public void seleccionMenu(ActionEvent event) throws IOException {
        
        
        System.out.println(menuComboBox.getSelectionModel().getSelectedItem());
         System.out.println(nTableView.getSelectionModel().getSelectedIndex());
         
         switch(menuComboBox.getSelectionModel().getSelectedItem()){
            case "Direcciones":
                muestraTablaDir();
                 break;
            case "Emails":
                muestraTablaEmail();
                 break;
            case "Telefonos":
                muestraTablaTel();
                 break;
            default:
                break;
         }
        
             
        
        
    }
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
        
        muestraTablaN();
        
        ArrayList<String> arrayMenu = new ArrayList<>();
        
        arrayMenu.add("Direcciones");
        arrayMenu.add("Emails");
        arrayMenu.add("Telefonos");
        
        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
        
        menuComboBox.setItems(listaMenu);
        
    }    
    
}