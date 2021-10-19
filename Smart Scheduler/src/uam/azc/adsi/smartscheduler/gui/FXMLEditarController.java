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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uam.azc.adsi.smartscheduler.clasesdao.ExceptionDAO;
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
    public void regresarButtonAction(ActionEvent event) throws IOException{
    
        Parent bienvenidaParent = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Scene bienvenidaScene = new Scene(bienvenidaParent);
        
        Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ventanaPrincipal.setTitle("Ventana principal."); 
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setScene(bienvenidaScene);
        ventanaPrincipal.centerOnScreen();
        ventanaPrincipal.show();
    }
    
    
    
    
    @FXML
    public void guardarButtonAction(ActionEvent event) throws IOException{
        
        //FXMLPrincipalController.c
                
        Contacto c = new Contacto();
        
        /////////
        
        /*
        if(!c.getFn().equals(nomTextField.getText()+" "+apTextField.getText())){
            c.setFn(nomTextField.getText()+" "+apTextField.getText());
        }
        if(!c.getN().getLn().equals(apTextField.getText())){
            c.getN().setLn(apTextField.getText());
        }
        if(!c.getN().getNk().equals(apodoTextField.getText())){
            c.getN().setNk(apodoTextField.getText());
        }
        if(!c.getN().getT().equals(titTextField.getText())){
            c.getN().setT(titTextField.getText());
        }
        if(!c.getN().getN().equals(nomTextField.getText())){
            c.getN().setN(nomTextField.getText());
        }
        if(!c.getOrg().equals(orgTextField.getText())){
            c.setOrg(orgTextField.getText());
        }
        */
        
        
        //////
        
        
        c.setFn(nomTextField.getText()+" "+apTextField.getText());
        c.getN().setLn(apTextField.getText());
        c.getN().setNk(apodoTextField.getText());
        c.getN().setT(titTextField.getText());
        c.getN().setN(nomTextField.getText());
        c.setOrg(orgTextField.getText());
        
        Direccion d = new Direccion();
        
        if(!(dirBox.getSelectionModel().getSelectedItem() == null)){
            d.setTipo(dirBox.getSelectionModel().getSelectedItem());
        }else{
            d.setTipo("");
        }
        
        d.setCalle(calleTextField.getText());
        d.setCiudad(ciudadTextField.getText());
        d.setCp(cpTextField.getText());
        d.setEstado(edoTextField.getText());
        d.setPais(paisTextField.getText());
        
        Email e = new Email();
        
        if(!(emailBox.getSelectionModel().getSelectedItem() == null)){
            e.setTipo(emailBox.getSelectionModel().getSelectedItem());
        }else{
            e.setTipo("");
        }
        
        e.setEmail(emailTextField.getText());
        
        Telefono t = new Telefono();
        
        if(!(telBox.getSelectionModel().getSelectedItem() == null)){
            t.setTipo(telBox.getSelectionModel().getSelectedItem());
        }else{
            t.setTipo("");
        }
        t.setTelefono(telTextField.getText());
        
        c.getAdr().add(d);
        c.getEmail().add(e);
        c.getTel().add(t);
        
        Alert alert;
        
        switch(SmartScheduler.gestorAn.analizadorSintactico(c)){
            case 0:
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EXITO");
                alert.setHeaderText("Contacto guardado con exito.");
                SmartScheduler.gestorC.agregarContacto(c, SmartScheduler.gestorC.getListaContactos());
                alert.showAndWait();
                SmartScheduler.gestorC.searchCompletos();
                SmartScheduler.gestorC.searchInc();
                SmartScheduler.gestorC.searchDup();
                SmartScheduler.gestorC.searchSinFoto();
                
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaContactos());
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaDuplicados());
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaCompletos());
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaIncompletos());
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaSinFoto());
                SmartScheduler.gestorC.orderLista(SmartScheduler.gestorC.getListaConFoto());
                
                Parent bienvenidaParent = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
                Scene bienvenidaScene = new Scene(bienvenidaParent);

                Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
                ventanaPrincipal.setTitle("Ventana principal."); 
                ventanaPrincipal.setResizable(false);
                ventanaPrincipal.setScene(bienvenidaScene);
                ventanaPrincipal.centerOnScreen();
                ventanaPrincipal.show();
                
                break;
            case 1:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de nombre incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            case 2:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de nombre incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            case 3:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de organización incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            case 4:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de teléfono incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            case 5:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de dirección incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            case 6:
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Información de email incorrecta");
                alert.setContentText("Por favor introduzca sus datos nuevamente");
                alert.showAndWait();
                break;
            default:
                break;
        }
    }
    
    
    
    public void inicializarTelBox(){
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("CELL");
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

    public TextField getNomTextField() {
        return nomTextField;
    }

    public void setNomTextField(TextField nomTextField) {
        this.nomTextField = nomTextField;
    }

    public TextField getApTextField() {
        return apTextField;
    }

    public void setApTextField(TextField apTextField) {
        this.apTextField = apTextField;
    }

    public TextField getTitTextField() {
        return titTextField;
    }

    public void setTitTextField(TextField titTextField) {
        this.titTextField = titTextField;
    }

    public TextField getApodoTextField() {
        return apodoTextField;
    }

    public void setApodoTextField(TextField apodoTextField) {
        this.apodoTextField = apodoTextField;
    }

    public TextField getOrgTextField() {
        return orgTextField;
    }

    public void setOrgTextField(TextField orgTextField) {
        this.orgTextField = orgTextField;
    }

    public TextField getTelTextField() {
        return telTextField;
    }

    public void setTelTextField(TextField telTextField) {
        this.telTextField = telTextField;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public TextField getCalleTextField() {
        return calleTextField;
    }

    public void setCalleTextField(TextField calleTextField) {
        this.calleTextField = calleTextField;
    }

    public TextField getCiudadTextField() {
        return ciudadTextField;
    }

    public void setCiudadTextField(TextField ciudadTextField) {
        this.ciudadTextField = ciudadTextField;
    }

    public TextField getEdoTextField() {
        return edoTextField;
    }

    public void setEdoTextField(TextField edoTextField) {
        this.edoTextField = edoTextField;
    }

    public TextField getPaisTextField() {
        return paisTextField;
    }

    public void setPaisTextField(TextField paisTextField) {
        this.paisTextField = paisTextField;
    }

    public TextField getCpTextField() {
        return cpTextField;
    }

    public void setCpTextField(TextField cpTextField) {
        this.cpTextField = cpTextField;
    }

    public Button getRegresarButton() {
        return regresarButton;
    }

    public void setRegresarButton(Button regresarButton) {
        this.regresarButton = regresarButton;
    }

    public ImageView getIvImagen() {
        return ivImagen;
    }

    public void setIvImagen(ImageView ivImagen) {
        this.ivImagen = ivImagen;
    }

    public Button getGuardarButton() {
        return guardarButton;
    }

    public void setGuardarButton(Button guardarButton) {
        this.guardarButton = guardarButton;
    }

    public ComboBox<String> getTelBox() {
        return telBox;
    }

    public void setTelBox(ComboBox<String> telBox) {
        this.telBox = telBox;
    }

    public ComboBox<String> getEmailBox() {
        return emailBox;
    }

    public void setEmailBox(ComboBox<String> emailBox) {
        this.emailBox = emailBox;
    }

    public ComboBox<String> getDirBox() {
        return dirBox;
    }

    public void setDirBox(ComboBox<String> dirBox) {
        this.dirBox = dirBox;
    }

    public Button getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(Button btnCargar) {
        this.btnCargar = btnCargar;
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
