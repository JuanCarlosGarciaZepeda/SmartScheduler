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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Stage;
import javax.swing.ListSelectionModel;
import uam.azc.adsi.smartscheduler.classes.Contacto;
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
    private TableColumn<N,String> nTableColumn;
    @FXML
    private TableColumn<N,String> lnTableColumn;
    @FXML
    private TableColumn<N,String> nkTableColumn;
    @FXML
    private TableColumn<N,String> tTableColumn;
    
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
    public void muestraTablaTel(LinkedList<Contacto> lc){
        
        emailTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        LinkedList<Telefono> listaTel = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
        
        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
        
        telefonoTableView.setItems(observableTel);               
        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        telefonoTableView.setVisible(true);
    }
        
    @FXML
    public void muestraTablaN(LinkedList<Contacto> lc){
        
        ArrayList<N> listaN = new ArrayList<>();
        
        for(int i = 0; i < lc.size(); i++){
            listaN.add(lc.get(i).getN());
        }
        
        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
        
        nTableView.setItems(observableN);
        
        
        /* FALTA VER QUE ONDA CON EL MODO DE SELECCION PARA DUPLICADOS */
        
        nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
            if(!newSelection.equals(-1)){
                if(newSelection != oldSelection){
                    menuComboBox.getSelectionModel().select("Telefonos");
                    muestraTablaTel(lc);
                    
                    //eventoTablaN(lc);
                    actualizaLabels(lc.get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                            lc.get(nTableView.getSelectionModel().getSelectedIndex()).getOrg()
                            );
                    
                }
            }else{
                nTableView.getSelectionModel().select(oldSelection.intValue());
            }
        });
        
        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
       
        nTableView.getSelectionModel().selectFirst();
        
        nTableView.setVisible(true);
    }
    
    @FXML
    public void muestraTablaDir(LinkedList<Contacto> lc){
        telefonoTableView.setVisible(false);
        emailTableView.setVisible(false);
        
        LinkedList<Direccion> listaDir = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
        
        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
        
        direccionTableView.setItems(observableDir);               
        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        direccionTableView.setVisible(true);
    }
    
    @FXML
    public void muestraTablaEmail(LinkedList<Contacto> lc){
        telefonoTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        LinkedList<Email> listaEmail = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
        
        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
        
        emailTableView.setItems(observableEmail);               
        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        emailTableView.setVisible(true);
    }
    
    /*private void eventoTablaN(LinkedList<Contacto> lc){
        //System.out.println(nTableView.getSelectionModel().getSelectedIndex());
        menuComboBox.getSelectionModel().select("Telefonos");
        muestraTablaTel(lc);
    };*/
    
    public void actualizaLabels(String fn, String org){
        nLabel.setText(fn);
        orgLabel.setText(org);
    }
    
    public static <S, T> void columnReorder(TableView table, TableColumn<S, T>...columns) {
        table.getColumns().addListener(new ListChangeListener() {
              public boolean suspended;
              @Override
              public void onChanged(ListChangeListener.Change change) {
                  change.next();
                  if (change.wasReplaced() && !suspended) {
                      this.suspended = true;
                      table.getColumns().setAll(columns);
                      this.suspended = false;
                  }
              }
        });
    }
    
    
    /* ------------------------^ FIXED ^---------------------------*/
    
/*
    --------------------------------------
            MÉTODOS PARA ORIGINALES
    --------------------------------------
*/   
    
    /*
    @FXML
    public void muestraOriginalesTablaN(){
        
        ArrayList<N> listaN = new ArrayList<>();
        
        for(int i = 0; i < SmartScheduler.gestorC.getListaContactos().size(); i++){
            listaN.add(SmartScheduler.gestorC.getListaContactos().get(i).getN());
        }
        
        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
        
        nTableView.setItems(observableN);               
        nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
            if(!newSelection.equals(-1)){
                if(newSelection != oldSelection){
                    eventoTablaN();
                    actualizaLabelsOriginales();
                }
            }else{
                nTableView.getSelectionModel().select(oldSelection.intValue());
            }
        });
        
        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
       
        nTableView.getSelectionModel().selectFirst();
        
        nTableView.setVisible(true);
    }
    
    */
    
  
   /* private void eventoTablaN(){
        //System.out.println(nTableView.getSelectionModel().getSelectedIndex());
        menuComboBox.getSelectionModel().select("Telefonos");
        muestraOriginalesTablaTel();
    };
    */
    /*
    public void actualizaLabelsOriginales(){
        nLabel.setText(SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getFn());
        orgLabel.setText(SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
    }*/
    
    /*
    @FXML
    public void muestraOriginalesTablaDir(){
        telefonoTableView.setVisible(false);
        emailTableView.setVisible(false);
        
        LinkedList<Direccion> listaDir = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
        
        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
        
        direccionTableView.setItems(observableDir);               
        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        direccionTableView.setVisible(true);
    }
    */
    /*
    @FXML
    public void muestraOriginalesTablaEmail(){
        telefonoTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        LinkedList<Email> listaEmail = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
        
        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
        
        emailTableView.setItems(observableEmail);               
        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        emailTableView.setVisible(true);
    }
    */
    
    /*
    @FXML
    public void muestraOriginalesTablaTel(){
        
        emailTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        LinkedList<Telefono> listaTel = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
        
        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
        
        telefonoTableView.setItems(observableTel);               
        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        telefonoTableView.setVisible(true);
    }
    */
/*
    --------------------------------------
            MÉTODOS PARA DUPLICADOS
    --------------------------------------
*/    
    
    /*
    @FXML
    public void duplicadosButtonAction(ActionEvent event) throws IOException {
        
        muestraDuplicadosTablaN(SmartScheduler.gestorC.getListaDuplicados());       
        
        /*
        muestraDuplicadosTablaTel();
        muestraDuplicadosTablaDir();
        muestraDuplicadosTablaEmail();
        
    }
    */
  
    /*
    public void actualizaLabelsDuplicados(){
        nLabel.setText(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getFn());
        orgLabel.setText(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
    }
    */
    /*
    public void muestraDuplicadosTablaN(LinkedList<Contacto> lc){
        
        ArrayList<N> listaN = new ArrayList<>();
        
        for(int i = 0; i < lc.size(); i++){
            listaN.add(SmartScheduler.gestorC.getListaDuplicados().get(i).getN());
        }
        
        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
        
        nTableView.setItems(observableN);               
        nTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
            if(!newSelection.equals(-1)){
                if(newSelection != oldSelection){
                    eventoTablaN();
                    actualizaLabels(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                            SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                }
            }else{
                nTableView.getSelectionModel().select(oldSelection.intValue());
            }
        });
        
        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
       
        nTableView.getSelectionModel().selectFirst();
        
        nTableView.setVisible(true);
        
    }
    */
    public void muestraDuplicadosTablaDir(){
        
        telefonoTableView.setVisible(false);
        emailTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Direccion> listaDir = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
        
        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        direccionTableView.setItems(observableDir);               
        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        direccionTableView.setVisible(true);
        
    }
    
    @FXML
    public void muestraDuplicadosTablaEmail(){
        
        telefonoTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Email> listaEmail = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
        
        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        emailTableView.setItems(observableEmail);               
        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        emailTableView.setVisible(true);
        
    }
    
    @FXML
    public void muestraDuplicadosTablaTel(){
        
        emailTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        //ArrayList<Direccion> listaDir = new ArrayList<>();
        
        LinkedList<Telefono> listaTel = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
        
        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
        
        //ObservableList<String> ads = FXCollections.observableArrayList(b);
        telefonoTableView.setItems(observableTel);               
        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
        //direccionTableView.getSelectionModel().selectFirst();
        
        telefonoTableView.setVisible(true);
        
    }
    
    
/*
    --------------------------------------
            MÉTODOS PARA INCOMPLETOS (PENDIENTE)
    --------------------------------------
*/    
    
    /*
    @FXML
    public void seleccionMenuOriginales(ActionEvent event) throws IOException {
        
        //Añadir ComboBox para demás listas
        
        //Editar visibilidad para manejo de múltiples ComboBox
        
        System.out.println(menuComboBox.getSelectionModel().getSelectedItem());
        System.out.println(nTableView.getSelectionModel().getSelectedIndex());
         
        switch(menuComboBox.getSelectionModel().getSelectedItem()){
            case "Direcciones":
                muestraOriginalesTablaDir();
                 break;
            case "Emails":
                muestraOriginalesTablaEmail();
                 break;
            case "Telefonos":
                muestraOriginalesTablaTel();
                 break;
            default:
                break;
        }
    }
    */
    public void inicializaComboBox(){
        ArrayList<String> arrayMenu = new ArrayList<>();
        
        arrayMenu.add("Direcciones");
        arrayMenu.add("Emails");
        arrayMenu.add("Telefonos");
        
        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
        
        menuComboBox.setItems(listaMenu);
        
    }
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializaComboBox();
      
        muestraTablaN(SmartScheduler.gestorC.getListaContactos());
        
    }    
    
}








//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uam.azc.adsi.smartscheduler.gui;
//
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ListChangeListener;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TableView.TableViewSelectionModel;
//import javafx.stage.Stage;
//import javax.swing.ListSelectionModel;
//import uam.azc.adsi.smartscheduler.classes.Contacto;
//import uam.azc.adsi.smartscheduler.classes.Direccion;
//import uam.azc.adsi.smartscheduler.classes.Email;
//import uam.azc.adsi.smartscheduler.classes.N;
//import uam.azc.adsi.smartscheduler.classes.Telefono;
//
///**
// * FXML Controller class
// *
// * @author WIN
// */
//public class FXMLPrincipalController implements Initializable {
//
//    @FXML
//    private TableView<N> nTableView;
//    @FXML
//    private TableColumn<N,String> nTableColumn;
//    @FXML
//    private TableColumn<N,String> lnTableColumn;
//    @FXML
//    private TableColumn<N,String> nkTableColumn;
//    @FXML
//    private TableColumn<N,String> tTableColumn;
//    
//    @FXML
//    private ComboBox<String> menuComboBox;
//    @FXML
//    private Label nLabel;
//    @FXML
//    private Label orgLabel;
//    @FXML
//    private TableView<Telefono> telefonoTableView;
//    @FXML
//    private TableView<Email> emailTableView;
//    @FXML
//    private TableView<Direccion> direccionTableView;
//    
//    
//    @FXML
//    public void muestraTablaN(LinkedList<Contacto> lc){
//        
//        ArrayList<N> listaN = new ArrayList<>();
//        
//        for(int i = 0; i < lc.size(); i++){
//            listaN.add(lc.get(i).getN());
//        }
//        
//        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
//        
//        nTableView.setItems(observableN);
//        nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        
//        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
//            if(!newSelection.equals(-1)){
//                if(newSelection != oldSelection){
//                    eventoTablaN();
//                    actualizaLabelsOriginales();
//                }
//            }else{
//                nTableView.getSelectionModel().select(oldSelection.intValue());
//            }
//        });
//        
//        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
//       
//        nTableView.getSelectionModel().selectFirst();
//        
//        nTableView.setVisible(true);
//    }
//    
//    
//    
///*
//    --------------------------------------
//            MÉTODOS PARA ORIGINALES
//    --------------------------------------
//*/   
//    
//    @FXML
//    public void muestraOriginalesTablaN(){
//        
//        ArrayList<N> listaN = new ArrayList<>();
//        
//        for(int i = 0; i < SmartScheduler.gestorC.getListaContactos().size(); i++){
//            listaN.add(SmartScheduler.gestorC.getListaContactos().get(i).getN());
//        }
//        
//        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
//        
//        nTableView.setItems(observableN);               
//        nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        
//        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
//            if(!newSelection.equals(-1)){
//                if(newSelection != oldSelection){
//                    eventoTablaN();
//                    actualizaLabelsOriginales();
//                }
//            }else{
//                nTableView.getSelectionModel().select(oldSelection.intValue());
//            }
//        });
//        
//        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
//       
//        nTableView.getSelectionModel().selectFirst();
//        
//        nTableView.setVisible(true);
//    }
//    
//    public static <S, T> void columnReorder(TableView table, TableColumn<S, T>...columns) {
//        table.getColumns().addListener(new ListChangeListener() {
//              public boolean suspended;
//              @Override
//              public void onChanged(ListChangeListener.Change change) {
//                  change.next();
//                  if (change.wasReplaced() && !suspended) {
//                      this.suspended = true;
//                      table.getColumns().setAll(columns);
//                      this.suspended = false;
//                  }
//              }
//        });
//    }
//    
//    private void eventoTablaN(){
//        System.out.println(nTableView.getSelectionModel().getSelectedIndex());
//        menuComboBox.getSelectionModel().select("Telefonos");
//        muestraOriginalesTablaTel();
//    };
//    
//    public void actualizaLabelsOriginales(){
//        nLabel.setText(SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getFn());
//        orgLabel.setText(SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
//    }
//    
//    @FXML
//    public void muestraOriginalesTablaDir(){
//        telefonoTableView.setVisible(false);
//        emailTableView.setVisible(false);
//        
//        LinkedList<Direccion> listaDir = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
//        
//        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
//        
//        direccionTableView.setItems(observableDir);               
//        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
//        
//        direccionTableView.setVisible(true);
//    }
//    
//    @FXML
//    public void muestraOriginalesTablaEmail(){
//        telefonoTableView.setVisible(false);
//        direccionTableView.setVisible(false);
//        
//        LinkedList<Email> listaEmail = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
//        
//        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
//        
//        emailTableView.setItems(observableEmail);               
//        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
//        
//        emailTableView.setVisible(true);
//    }
//    
//    @FXML
//    public void muestraOriginalesTablaTel(){
//        
//        emailTableView.setVisible(false);
//        direccionTableView.setVisible(false);
//        
//        LinkedList<Telefono> listaTel = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
//        
//        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
//        
//        telefonoTableView.setItems(observableTel);               
//        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
//        
//        telefonoTableView.setVisible(true);
//    }
//    
///*
//    --------------------------------------
//            MÉTODOS PARA DUPLICADOS
//    --------------------------------------
//*/    
//    
//    
//    @FXML
//    public void duplicadosButtonAction(ActionEvent event) throws IOException {
//        
//        SmartScheduler.gestorC.searchDup();
//        
//        muestraDuplicadosTablaN();
//        
//        
//        /*
//        muestraDuplicadosTablaTel();
//        muestraDuplicadosTablaDir();
//        muestraDuplicadosTablaEmail();
//        */
//    }
//    
//    public void actualizaLabels(String fn, String org){
//        nLabel.setText(fn);
//        orgLabel.setText(org);
//    }
//    /*
//    public void actualizaLabelsDuplicados(){
//        nLabel.setText(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getFn());
//        orgLabel.setText(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
//    }
//    */
//    public void muestraDuplicadosTablaN(){
//        
//        ArrayList<N> listaN = new ArrayList<>();
//        
//        for(int i = 0; i < SmartScheduler.gestorC.getListaDuplicados().size(); i++){
//            listaN.add(SmartScheduler.gestorC.getListaDuplicados().get(i).getN());
//        }
//        
//        ObservableList<N> observableN = FXCollections.observableArrayList(listaN);
//        
//        nTableView.setItems(observableN);               
//        nTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        
//        nTableView.getSelectionModel().selectedIndexProperty().addListener((obs, oldSelection, newSelection)->{
//            if(!newSelection.equals(-1)){
//                if(newSelection != oldSelection){
//                    eventoTablaN();
//                    actualizaLabels(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
//                            SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
//                }
//            }else{
//                nTableView.getSelectionModel().select(oldSelection.intValue());
//            }
//        });
//        
//        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
//       
//        nTableView.getSelectionModel().selectFirst();
//        
//        nTableView.setVisible(true);
//        
//    }
//    
//    public void muestraDuplicadosTablaDir(){
//        
//        telefonoTableView.setVisible(false);
//        emailTableView.setVisible(false);
//        
//        //ArrayList<Direccion> listaDir = new ArrayList<>();
//        
//        LinkedList<Direccion> listaDir = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
//        
//        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
//        
//        //ObservableList<String> ads = FXCollections.observableArrayList(b);
//        direccionTableView.setItems(observableDir);               
//        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
//        //direccionTableView.getSelectionModel().selectFirst();
//        
//        direccionTableView.setVisible(true);
//        
//    }
//    
//    @FXML
//    public void muestraDuplicadosTablaEmail(){
//        
//        telefonoTableView.setVisible(false);
//        direccionTableView.setVisible(false);
//        
//        //ArrayList<Direccion> listaDir = new ArrayList<>();
//        
//        LinkedList<Email> listaEmail = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
//        
//        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
//        
//        //ObservableList<String> ads = FXCollections.observableArrayList(b);
//        emailTableView.setItems(observableEmail);               
//        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
//        //direccionTableView.getSelectionModel().selectFirst();
//        
//        emailTableView.setVisible(true);
//        
//    }
//    
//    @FXML
//    public void muestraDuplicadosTablaTel(){
//        
//        emailTableView.setVisible(false);
//        direccionTableView.setVisible(false);
//        
//        //ArrayList<Direccion> listaDir = new ArrayList<>();
//        
//        LinkedList<Telefono> listaTel = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
//        
//        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
//        
//        //ObservableList<String> ads = FXCollections.observableArrayList(b);
//        telefonoTableView.setItems(observableTel);               
//        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
//        //direccionTableView.getSelectionModel().selectFirst();
//        
//        telefonoTableView.setVisible(true);
//        
//    }
//    
//    
///*
//    --------------------------------------
//            MÉTODOS PARA INCOMPLETOS (PENDIENTE)
//    --------------------------------------
//*/    
//    
//    
//    @FXML
//    public void seleccionMenuOriginales(ActionEvent event) throws IOException {
//        
//        //Añadir ComboBox para demás listas
//        
//        //Editar visibilidad para manejo de múltiples ComboBox
//        
//        System.out.println(menuComboBox.getSelectionModel().getSelectedItem());
//        System.out.println(nTableView.getSelectionModel().getSelectedIndex());
//         
//        switch(menuComboBox.getSelectionModel().getSelectedItem()){
//            case "Direcciones":
//                muestraOriginalesTablaDir();
//                 break;
//            case "Emails":
//                muestraOriginalesTablaEmail();
//                 break;
//            case "Telefonos":
//                muestraOriginalesTablaTel();
//                 break;
//            default:
//                break;
//        }
//    }
//    
//    public void inicializaComboBox(){
//        ArrayList<String> arrayMenu = new ArrayList<>();
//        
//        arrayMenu.add("Direcciones");
//        arrayMenu.add("Emails");
//        arrayMenu.add("Telefonos");
//        
//        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
//        
//        menuComboBox.setItems(listaMenu);
//        
//    }
//       
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        inicializaComboBox();
//      
//        
//        muestraOriginalesTablaN();
//        
//        
//    }    
//    
//}