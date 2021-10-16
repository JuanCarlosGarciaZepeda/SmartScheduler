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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Stage;
import javax.swing.ListSelectionModel;
import uam.azc.adsi.smartscheduler.clasesdao.ExceptionDAO;
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

    
    private int flag;
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
    private ComboBox<String> listaComboBox;
    @FXML
    private Label nLabel;
    @FXML
    private Label orgLabel;
    @FXML
    private TableView<Telefono> telefonoTableView;
    @FXML
    private TableColumn<N,String> tipoTelColumn;
    @FXML
    private TableColumn<N,String> telTelColumn;
    @FXML
    private TableView<Email> emailTableView;
    @FXML
    private TableColumn<N,String> tipoEmailColumn;
    @FXML
    private TableColumn<N,String> emEmailColumn;
    @FXML
    private TableView<Direccion> direccionTableView;
    @FXML
    private TableColumn<N,String> tipoDirColumn;
    @FXML
    private TableColumn<N,String> c1DirColumn;
    @FXML
    private TableColumn<N,String> c2DirColumn;
    @FXML
    private TableColumn<N,String> calleDirColumn;
    @FXML
    private TableColumn<N,String> ciudadDirColumn;
    @FXML
    private TableColumn<N,String> edoDirColumn;
    @FXML
    private TableColumn<N,String> cpDirColumn;
    @FXML
    private TableColumn<N,String> paisDirColumn;
    
    /* BOTONES */
    @FXML 
    private Button incompletosButton;
    @FXML 
    private Button duplicadosButton;
    @FXML 
    private Button editarButton;
    @FXML 
    private Button agregarButton;
    @FXML 
    private Button eliminarButton;
    @FXML 
    private Button exportarButton;  
    @FXML 
    private Button fusionarButton;
    
    
    /*
    --------------------------------------
            MÉTODOS PARA CONTROLES
    --------------------------------------
*/    
    
    public void muestraTablaTel(LinkedList<Contacto> lc){
        
        emailTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        System.out.println(lc.size() + " " + nTableView.getSelectionModel().getSelectedIndex());
        
        LinkedList<Telefono> listaTel = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getTel();
              
        ObservableList<Telefono> observableTel = FXCollections.observableArrayList(listaTel);
        
        telefonoTableView.setItems(observableTel);               
        telefonoTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        telefonoTableView.setVisible(true);
    }
        
    public void muestraTablaN(LinkedList<Contacto> lc){
        
        nTableView.getSelectionModel().clearSelection();
        
        ArrayList<N> listaN = new ArrayList<N>();
        
            for(int i = 0; i < lc.size(); i++){
                listaN.add(lc.get(i).getN());
            }

            ObservableList<N> observableN = FXCollections.observableArrayList(listaN);

            nTableView.setItems(observableN);
            
            if(flag == 0){
                nTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }else{
                nTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            }
            
            nTableView.getSelectionModel().selectFirst();
                
            nTableView.setVisible(true);
    }
    
    public void muestraTablaDir(LinkedList<Contacto> lc){
        telefonoTableView.setVisible(false);
        emailTableView.setVisible(false);
        
        LinkedList<Direccion> listaDir = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getAdr();
        
        ObservableList<Direccion> observableDir = FXCollections.observableArrayList(listaDir);
        
        direccionTableView.setItems(observableDir);               
        direccionTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        direccionTableView.setVisible(true);
    }
    
    public void muestraTablaEmail(LinkedList<Contacto> lc){
        telefonoTableView.setVisible(false);
        direccionTableView.setVisible(false);
        
        LinkedList<Email> listaEmail = lc.get(nTableView.getSelectionModel().getSelectedIndex()).getEmail();
        
        ObservableList<Email> observableEmail = FXCollections.observableArrayList(listaEmail);
        
        emailTableView.setItems(observableEmail);               
        emailTableView.getSelectionModel().setCellSelectionEnabled(false);
        
        emailTableView.setVisible(true);
    }
    
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
    
    
    
    
/*
    ---------------------------------------------
            MÉTODOS PARA MANEJO DE EVENTOS
    ---------------------------------------------
*/    
    
    @FXML
    public void incompletosButtonAction(ActionEvent event) throws IOException {
        
        flag = 1;
        
        muestraTablaN(SmartScheduler.gestorC.getListaIncompletos());       
        
    }
    
    @FXML
    public void fusionarButtonAction(ActionEvent event) throws IOException {
        
        
        /*
        Implementar lo siguiente en caso de requerir selección múltiple por arrastre del mouse
        
        https://community.oracle.com/tech/developers/discussion/2621389/how-can-i-select-multiple-cells-in-tableview-with-javafx-only-by-mouse
        
        startFullDrag();
        */
        LinkedList<Contacto> listaFusionar = new LinkedList<>();
        
        if(nTableView.getSelectionModel().getSelectedIndices().size() >= 2){
            nTableView.getSelectionModel().getSelectedIndices().forEach(i -> {
                System.out.println(i);
                listaFusionar.add(SmartScheduler.gestorC.getListaDuplicados().get(i));
            }); 
            SmartScheduler.gestorC.showContacts(listaFusionar);
        }else{
            
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
        
        
    }
    
    @FXML
    public void exportarButtonAction(ActionEvent event) throws Exception {
        
        //SmartScheduler.gestorA.exportarVcf(SmartScheduler.gestorC.getListaContactos());
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar exportación");
                alert.setHeaderText("Está a punto de exportar sus contactos");
                alert.setContentText("¿Desea continuar?");
                alert.showAndWait();
     
        if(alert.getResult() == ButtonType.OK){
                    
            SmartScheduler.gestorA.exportarVcf(SmartScheduler.gestorC.getListaContactos());
            
            /*
                MOVER A CARGAR
            
            for(Contacto c: SmartScheduler.gestorC.getListaContactos()){
                if(SmartScheduler.gestorDAO.recuperaUnoPorID(String.valueOf(c.getidContacto())) != null){
                    SmartScheduler.gestorDAO.actualizaContacto(c);
                }else{
                    SmartScheduler.gestorDAO.createC(c);
                    //System.out.println("Agregados todos.");
                }
            }
            */
//SmartScheduler.gestorDAO.guardaTodos(lc);
                    
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
    
    @FXML
    public void editarButtonAction(ActionEvent event) throws IOException {
        
        /*INICIALIZAR VENTANA EDICION*/
        
    }
    
    @FXML
    public void agregarButtonAction(ActionEvent event) throws IOException {
        
        /*INICIALIZAR VENTANA EDICION*/
        
    }
    
    @FXML
    public void eliminarButtonAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar eliminación");
                alert.setHeaderText("Está a punto de eliminar el contacto seleccionado");
                alert.setContentText("¿Desea continuar?");
                alert.showAndWait();
                
                if(alert.getResult() == ButtonType.OK){
                    
                    int id = nTableView.getSelectionModel().getSelectedIndex();
                    
                    switch(listaComboBox.getSelectionModel().getSelectedItem()){
                        case "Todos los contactos":
                            muestraTablaDir(SmartScheduler.gestorC.getListaContactos());
                             break;
                        case "Contactos completos":
                            muestraTablaDir(SmartScheduler.gestorC.getListaCompletos());
                             break;
                        case "Contactos incompletos":
                            muestraTablaDir(SmartScheduler.gestorC.getListaIncompletos());
                             break;
                        case "Contactos duplicados":
                            muestraTablaDir(SmartScheduler.gestorC.getListaDuplicados());
                             break;
                        case "Contactos sin foto":
                            muestraTablaDir(SmartScheduler.gestorC.getListaSinFoto());
                             break;
                        case "Contactos con foto":
                        {
                            try {
                                muestraTablaDir(SmartScheduler.gestorDAO.obtieneConFoto());
                            } catch (ExceptionDAO ex) {
                                //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                            break;
                        default:
                            break;
                    }   
                    
                    /* CREAR CONTACTO PARA ELIMINAR DE TODAS LAS LISTAS*/
                    //if(SmartScheduler.gestorC.getListaCompletos().contains())
                    System.out.println("Lo borro pues.");
                    
                }
    }
    
   
        
    @FXML
    public void menuComboBoxAction(ActionEvent event) throws IOException {
       
        switch(menuComboBox.getSelectionModel().getSelectedItem()){
            case "Direcciones":
                switch(listaComboBox.getSelectionModel().getSelectedItem()){
                    case "Todos los contactos":
                        muestraTablaDir(SmartScheduler.gestorC.getListaContactos());
                         break;
                    case "Contactos completos":
                        muestraTablaDir(SmartScheduler.gestorC.getListaCompletos());
                         break;
                    case "Contactos incompletos":
                        muestraTablaDir(SmartScheduler.gestorC.getListaIncompletos());
                         break;
                    case "Contactos duplicados":
                        muestraTablaDir(SmartScheduler.gestorC.getListaDuplicados());
                         break;
                    case "Contactos sin foto":
                        muestraTablaDir(SmartScheduler.gestorC.getListaSinFoto());
                         break;
                    case "Contactos con foto":
                    {
                        try {
                            muestraTablaDir(SmartScheduler.gestorDAO.obtieneConFoto());
                        } catch (ExceptionDAO ex) {
                            //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;
                    default:
                        break;
                }   
                break;
            case "Emails":
                switch(listaComboBox.getSelectionModel().getSelectedItem()){
                    case "Todos los contactos":
                        muestraTablaEmail(SmartScheduler.gestorC.getListaContactos());
                         break;
                    case "Contactos completos":
                        muestraTablaEmail(SmartScheduler.gestorC.getListaCompletos());
                         break;
                    case "Contactos incompletos":
                        muestraTablaEmail(SmartScheduler.gestorC.getListaIncompletos());
                         break;
                    case "Contactos duplicados":
                        muestraTablaEmail(SmartScheduler.gestorC.getListaDuplicados());
                         break;
                    case "Contactos sin foto":
                        muestraTablaEmail(SmartScheduler.gestorC.getListaSinFoto());
                         break;
                    case "Contactos con foto":
                    {
                        try {
                            muestraTablaEmail(SmartScheduler.gestorDAO.obtieneConFoto());
                        } catch (ExceptionDAO ex) {
                            //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;
                    default:
                        break;
                }   
                break;
            case "Telefonos":
                switch(listaComboBox.getSelectionModel().getSelectedItem()){
                    case "Todos los contactos":
                        muestraTablaTel(SmartScheduler.gestorC.getListaContactos());
                         break;
                    case "Contactos completos":
                        muestraTablaTel(SmartScheduler.gestorC.getListaCompletos());
                         break;
                    case "Contactos incompletos":
                        muestraTablaTel(SmartScheduler.gestorC.getListaIncompletos());
                         break;
                    case "Contactos duplicados":
                        muestraTablaTel(SmartScheduler.gestorC.getListaDuplicados());
                         break;
                    case "Contactos sin foto":
                        muestraTablaTel(SmartScheduler.gestorC.getListaSinFoto());
                         break;
                    case "Contactos con foto":
                    {
                        try {
                            muestraTablaTel(SmartScheduler.gestorDAO.obtieneConFoto());
                        } catch (ExceptionDAO ex) {
                            //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                         break;
                    default:
                        break;
                }   
                break;
            default:
                break;
        }
        
    }
    
   
    
    @FXML
    public void listaComboBoxAction(ActionEvent event) throws IOException {
        
        switch(listaComboBox.getSelectionModel().getSelectedItem()){
            case "Todos los contactos":
                muestraTablaN(SmartScheduler.gestorC.getListaContactos());
                 break;
            case "Contactos completos":
                muestraTablaN(SmartScheduler.gestorC.getListaCompletos());
                 break;
            case "Contactos incompletos":
                muestraTablaN(SmartScheduler.gestorC.getListaIncompletos());
                 break;
            case "Contactos duplicados":
                flag = 0;
                muestraTablaN(SmartScheduler.gestorC.getListaDuplicados());
                 break;
            case "Contactos sin foto":
                muestraTablaN(SmartScheduler.gestorC.getListaSinFoto());
                 break;
            case "Contactos con foto":
            {
                try {
                    muestraTablaN(SmartScheduler.gestorDAO.obtieneConFoto());
                } catch (ExceptionDAO ex) {
                    //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                 break;

            default:
                break;
        }
    }
    
    public void inicializaListaBox(){
        
        ArrayList<String> arrayMenu = new ArrayList<>();
        
        arrayMenu.add("Todos los contactos");
        arrayMenu.add("Contactos completos");
        arrayMenu.add("Contactos incompletos");
        arrayMenu.add("Contactos duplicados");
        arrayMenu.add("Contactos sin foto");
        arrayMenu.add("Contactos con foto");
        
        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
        
        listaComboBox.setItems(listaMenu);
        
        listaComboBox.getSelectionModel().selectFirst();

    }
    
    public void inicializaMenuBox(){
        ArrayList<String> arrayMenu = new ArrayList<>();
        
        arrayMenu.add("Telefonos");
        arrayMenu.add("Direcciones");
        arrayMenu.add("Emails");
        
        
        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
        
        menuComboBox.setItems(listaMenu);
        
        menuComboBox.getSelectionModel().selectFirst();
    }
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializaMenuBox();
        inicializaListaBox();
    
        ChangeListener<Number> listener = new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> obs, Number oldSelection, Number newSelection) {
                    if(!newSelection.equals(-1)){
                        if(newSelection != oldSelection){
                            
                            System.out.println("1. Indice nuevo: " + newSelection + " Indice viejo: " + oldSelection);
                            
                            switch(listaComboBox.getSelectionModel().getSelectedItem()){
                                case "Todos los contactos":
                                    menuComboBox.getSelectionModel().selectFirst();
                                    muestraTablaTel(SmartScheduler.gestorC.getListaContactos());
                                    actualizaLabels(SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                        SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                     break;
                                case "Contactos completos":
                                    menuComboBox.getSelectionModel().selectFirst();
                                    muestraTablaTel(SmartScheduler.gestorC.getListaCompletos());
                                    actualizaLabels(SmartScheduler.gestorC.getListaCompletos().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                        SmartScheduler.gestorC.getListaCompletos().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                     break;
                                case "Contactos incompletos":
                                    menuComboBox.getSelectionModel().selectFirst();
                                    muestraTablaTel(SmartScheduler.gestorC.getListaIncompletos());
                                    actualizaLabels(SmartScheduler.gestorC.getListaIncompletos().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                        SmartScheduler.gestorC.getListaIncompletos().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                     break;
                                case "Contactos duplicados":
                                    menuComboBox.getSelectionModel().selectFirst();
                                    muestraTablaTel(SmartScheduler.gestorC.getListaDuplicados());
                                    actualizaLabels(SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                        SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                     break;
                                case "Contactos sin foto":
                                    menuComboBox.getSelectionModel().selectFirst();
                                    muestraTablaTel(SmartScheduler.gestorC.getListaSinFoto());
                                    actualizaLabels(SmartScheduler.gestorC.getListaSinFoto().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                        SmartScheduler.gestorC.getListaSinFoto().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                     break;
                                case "Contactos con foto":
                                    {
                                        try {
                                            menuComboBox.getSelectionModel().selectFirst();
                                            muestraTablaTel(SmartScheduler.gestorDAO.obtieneConFoto());
                                            actualizaLabels(SmartScheduler.gestorDAO.obtieneConFoto().get(nTableView.getSelectionModel().getSelectedIndex()).getFn(),
                                            SmartScheduler.gestorDAO.obtieneConFoto().get(nTableView.getSelectionModel().getSelectedIndex()).getOrg());
                                        } catch (ExceptionDAO ex) {
                                            //Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                     break;
                                default:
                                    break;
                            }
                        }
                    }else if(newSelection.intValue() > nTableView.getItems().size()){
                        System.out.println("2. Indice nuevo: " + newSelection + " Indice viejo: " + oldSelection);
                        nTableView.getSelectionModel().selectFirst();
                    }else{
                        System.out.println("3. Indice nuevo: " + newSelection + " Indice viejo: " + oldSelection);
                        nTableView.getSelectionModel().selectFirst();
                    }
                }
        };
            
            nTableView.getSelectionModel().selectedIndexProperty().addListener(listener);
        
        
        columnReorder(nTableView,nTableColumn,lnTableColumn,nkTableColumn,tTableColumn);
        columnReorder(telefonoTableView,tipoTelColumn,telTelColumn);
        columnReorder(emailTableView,tipoEmailColumn,emEmailColumn);
        columnReorder(direccionTableView,tipoDirColumn,c1DirColumn,c2DirColumn,calleDirColumn,ciudadDirColumn,edoDirColumn,cpDirColumn,paisDirColumn);
        
        muestraTablaN(SmartScheduler.gestorC.getListaContactos());
        
    
    }

}
