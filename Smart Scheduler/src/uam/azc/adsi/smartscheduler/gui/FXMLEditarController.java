/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.Telefono;

/**
 * FXML Controller class
 *
 * @author WIN
 */
public class FXMLEditarController implements Initializable {
    
    
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField apTextField;
    @FXML
    private TextField titTextField;
    @FXML
    private TextField apodoTextField;
    @FXML
    private TextField orgTextField;
    @FXML
    private TextField telTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField calleTextField;
    @FXML
    private TextField ciudadTextField;
    @FXML
    private TextField edoTextField;
    @FXML
    private TextField paisTextField;
    @FXML
    private TextField cpTextField;
    @FXML
    private Button regresarButton;
    @FXML
    private ImageView ivImagen;
    @FXML
    private Button guardarButton;
    @FXML
    private ComboBox<String> telBox;
    @FXML
    private ComboBox<String> emailBox;
    @FXML
    private ComboBox<String> dirBox;
    @FXML
    private Button btnCargar;
    
    @FXML
    public void cargarButtonAction(ActionEvent event) throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        // Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(null);

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath()){};
            ivImagen.setImage(image);
        }
    }
    
    @FXML
    public void guardarButtonAction(ActionEvent event) throws IOException{
        Contacto c = new Contacto();
        
        c.setFn(nomTextField.getText()+" "+apTextField.getText());
        c.getN().setLn(apTextField.getText());
        c.getN().setNk(apodoTextField.getText());
        c.getN().setT(titTextField.getText());
        c.getN().setN(nomTextField.getText());
        
        Direccion d = new Direccion();
        
        d.setTipo(dirBox.getSelectionModel().getSelectedItem());
        d.setCalle(calleTextField.getText());
        d.setCiudad(ciudadTextField.getText());
        d.setCp(cpTextField.getText());
        d.setEstado(edoTextField.getText());
        d.setPais(paisTextField.getText());
        
        Email e = new Email();
        e.setTipo(emailBox.getSelectionModel().getSelectedItem());
        e.setEmail(emailTextField.getText());
        
        Telefono t = new Telefono();
        t.setTipo(telBox.getSelectionModel().getSelectedItem());
        t.setTelefono(telTextField.getText());
        
        c.getAdr().add(d);
        c.getEmail().add(e);
        c.getTel().add(t);
        
        System.out.println(SmartScheduler.gestorAn.analizadorSintactico(c));
        
        Alert alert;
        
        switch(SmartScheduler.gestorAn.analizadorSintactico(c)){
            case 0:
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EXITO");
                alert.setHeaderText("Contacto guardado con exito.");
                alert.show();
                break;
            case 1:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de nombre incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            case 2:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de nombre incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            case 3:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de organización incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            case 4:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de teléfono incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            case 5:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de dirección incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            case 6:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de email incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.show();
                break;
            default:
                break;
        }
        
        /*  
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información incompleta.");
                alert.setContentText("Por favor llene todos los campos con la información solicitada.");
                alert.show();
                
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Cliente no encontrado.");
                alert.setContentText("El ID buscado no existe en la BD.");
                alert.show();
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Operación exitosa.");
            alert.setContentText("El producto fue añadido.");
            alert.show();
            
            */
        
     
    }
    
    public void inicializarTelBox(){
        
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("HOME");
        lista.add("WORK");
        
        ObservableList<String> obsLista = FXCollections.observableArrayList(lista);
        
        telBox.setItems(obsLista);
    
    }
    
    public void inicializarDirBox(){
        
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("HOME");
        lista.add("WORK");
        
        ObservableList<String> obsLista = FXCollections.observableArrayList(lista);
        
        dirBox.setItems(obsLista);
    
    }

    public void inicializarEmailBox(){
        
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("HOME");
        lista.add("WORK");
        
        ObservableList<String> obsLista = FXCollections.observableArrayList(lista);
        
        emailBox.setItems(obsLista);
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTelBox();
        inicializarDirBox();
        inicializarEmailBox();
        
           
    }
}
