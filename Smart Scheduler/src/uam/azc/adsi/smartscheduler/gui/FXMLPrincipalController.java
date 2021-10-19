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
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
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
        
        System.out.println("Valor bandera: "+ flag);
        
        nTableView.getSelectionModel().clearSelection();
        
        ArrayList<N> listaN = new ArrayList<N>();
        
            for(int i = 0; i < lc.size(); i++){
                listaN.add(lc.get(i).getN());
            }

            ObservableList<N> observableN = FXCollections.observableArrayList(listaN);

            nTableView.setItems(observableN);
            
            if(flag == 3){
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
    public void fusionarButtonAction(ActionEvent event) throws IOException {
        /*
        Implementar lo siguiente en caso de requerir selección múltiple por arrastre del mouse
        
        https://community.oracle.com/tech/developers/discussion/2621389/how-can-i-select-multiple-cells-in-tableview-with-javafx-only-by-mouse
        
        startFullDrag();
        */
        LinkedList<Contacto> listaFusionar = new LinkedList<>();
        
        if(nTableView.getSelectionModel().getSelectedIndices().size() >= 2){
            nTableView.getSelectionModel().getSelectedIndices().forEach(i -> {
                listaFusionar.add(SmartScheduler.gestorC.getListaDuplicados().get(i));
            }); 
            if(SmartScheduler.gestorC.fusionarContactos(listaFusionar)){
                System.out.println("Contactos fusionados exitosamente.");
                muestraTablaN(SmartScheduler.gestorC.getListaDuplicados());
            }else{
                System.out.println("Contactos no fusionados.");
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Selección de contactos errónea");
                alert.setContentText("Por favor elija 2 o más contactos");
                alert.show();
        }
    }
    
    @FXML
    public void exportarButtonAction(ActionEvent event) throws Exception {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar exportación");
                alert.setHeaderText("Está a punto de exportar sus contactos");
                alert.setContentText("¿Desea continuar?");
                alert.showAndWait();
     
        if(alert.getResult() == ButtonType.OK){
                    
            SmartScheduler.gestorA.exportarVcf(SmartScheduler.gestorC.getListaContactos());
        }
    }
    
    @FXML
    public void editarButtonAction(ActionEvent event) throws IOException {
        
        /* IMPLEMENTAR REGRESO A PRINCIPAL POR CIERRE EN VENTANAEDITAR */
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLEditar.fxml"));
        Parent verParent = loader.load();
        FXMLEditarController editar = loader.getController();
        
        switch(flag){
            case 3:
                Contacto cero = SmartScheduler.gestorC.getListaDuplicados().get(nTableView.getSelectionModel().getSelectedIndex());
                editar.getNomTextField().setText(cero.getN().getN());
                editar.getApTextField().setText(cero.getN().getLn());
                editar.getTitTextField().setText(cero.getN().getT());
                editar.getApodoTextField().setText(cero.getN().getNk());
                editar.getOrgTextField().setText(cero.getOrg());
                
                if(!cero.getTel().isEmpty()){
                    if(telefonoTableView.getSelectionModel().getSelectedIndex() != -1){
                        if(!cero.getTel().get(telefonoTableView.getSelectionModel().getSelectedIndex()).getTelefono().isEmpty()){
                            editar.getTelTextField().setText(cero.getTel().get(telefonoTableView.getSelectionModel().getSelectedIndex()).getTelefono());    
                        }
                        if(!cero.getTel().get(telefonoTableView.getSelectionModel().getSelectedIndex()).getTipo().isEmpty()){
                            editar.getTelBox().getSelectionModel().select(cero.getTel().get(telefonoTableView.getSelectionModel().getSelectedIndex()).getTipo());
                        }else{
                            editar.getTelBox().getSelectionModel().selectFirst();
                        }
                    }else{
                        if(!cero.getTel().getFirst().getTelefono().isEmpty()){
                            editar.getTelTextField().setText(cero.getTel().getFirst().getTelefono());
                        }
                        if(!cero.getTel().getFirst().getTipo().isEmpty()){
                            editar.getTelBox().getSelectionModel().select(cero.getTel().getFirst().getTipo());
                        }else{
                            editar.getTelBox().getSelectionModel().selectFirst();
                        }
                    }
                }
                
                if(!cero.getEmail().isEmpty()){
                    if(emailTableView.getSelectionModel().getSelectedIndex() != -1){
                        if(!cero.getEmail().get(emailTableView.getSelectionModel().getSelectedIndex()).getEmail().isEmpty()){
                            editar.getEmailTextField().setText(cero.getEmail().get(emailTableView.getSelectionModel().getSelectedIndex()).getEmail());    
                        }
                        if(!cero.getEmail().get(emailTableView.getSelectionModel().getSelectedIndex()).getTipo().isEmpty()){
                            editar.getEmailBox().getSelectionModel().select(cero.getEmail().get(emailTableView.getSelectionModel().getSelectedIndex()).getTipo());
                        }else{
                            editar.getEmailBox().getSelectionModel().selectFirst();
                        }
                    }else{
                        if(!cero.getEmail().getFirst().getEmail().isEmpty()){
                            editar.getEmailTextField().setText(cero.getTel().getFirst().getTelefono());
                        }
                        if(!cero.getTel().getFirst().getTipo().isEmpty()){
                            editar.getTelBox().getSelectionModel().select(cero.getTel().getFirst().getTipo());
                        }else{
                            editar.getTelBox().getSelectionModel().selectFirst();
                        }
                    }
                    ////////////////                    
                    editar.getEmailTextField().setText(cero.getEmail().getFirst().getEmail());
                    if(!cero.getEmail().getFirst().getTipo().isEmpty()){
                        editar.getEmailBox().getSelectionModel().select(cero.getEmail().getFirst().getTipo());
                    }else{
                        editar.getEmailBox().getSelectionModel().selectFirst();
                    }
                }
                if(!cero.getAdr().isEmpty()){
                    editar.getCalleTextField().setText(cero.getAdr().getFirst().getCalle());
                    editar.getCiudadTextField().setText(cero.getAdr().getFirst().getCiudad());
                    editar.getEdoTextField().setText(cero.getAdr().getFirst().getEstado());
                    editar.getPaisTextField().setText(cero.getAdr().getFirst().getPais());
                    editar.getCpTextField().setText(cero.getAdr().getFirst().getPais());
                    if(!cero.getAdr().getFirst().getTipo().isEmpty()){
                        editar.getDirBox().getSelectionModel().select(cero.getAdr().getFirst().getTipo());
                    }else{
                        editar.getDirBox().getSelectionModel().selectFirst();
                    }
                }
                break;
              
            case 2:
                Contacto uno = SmartScheduler.gestorC.getListaIncompletos().get(nTableView.getSelectionModel().getSelectedIndex());
                editar.getNomTextField().setText(uno.getN().getN());
                editar.getApTextField().setText(uno.getN().getLn());
                editar.getTitTextField().setText(uno.getN().getT());
                editar.getApodoTextField().setText(uno.getN().getNk());
                editar.getOrgTextField().setText(uno.getOrg());
                
                if(!uno.getTel().isEmpty()){
                    editar.getTelTextField().setText(uno.getTel().getFirst().getTelefono());
                    if(uno.getTel().getFirst().getTipo().isEmpty())
                        editar.getTelBox().getSelectionModel().select(uno.getTel().getFirst().getTipo());
                }
                if(!uno.getEmail().isEmpty()){
                    editar.getEmailTextField().setText(uno.getEmail().getFirst().getEmail());
                    if(uno.getEmail().getFirst().getTipo().isEmpty())
                        editar.getEmailBox().getSelectionModel().select(uno.getEmail().getFirst().getTipo());
                }
                if(!uno.getAdr().isEmpty()){
                    editar.getCalleTextField().setText(uno.getAdr().getFirst().getCalle());
                    editar.getCiudadTextField().setText(uno.getAdr().getFirst().getCiudad());
                    editar.getEdoTextField().setText(uno.getAdr().getFirst().getEstado());
                    editar.getPaisTextField().setText(uno.getAdr().getFirst().getPais());
                    editar.getCpTextField().setText(uno.getAdr().getFirst().getPais());
                    if(uno.getAdr().getFirst().getTipo().isEmpty())
                        editar.getDirBox().getSelectionModel().select(uno.getAdr().getFirst().getTipo());
                }
                
                break;
          
            case 0:
                Contacto dos = SmartScheduler.gestorC.getListaContactos().get(nTableView.getSelectionModel().getSelectedIndex());
                System.out.println(dos.getidContacto());
                editar.getNomTextField().setText(dos.getN().getN());
                editar.getApTextField().setText(dos.getN().getLn());
                editar.getTitTextField().setText(dos.getN().getT());
                editar.getApodoTextField().setText(dos.getN().getNk());
                editar.getOrgTextField().setText(dos.getOrg());
                
                if(!dos.getTel().isEmpty()){
                    editar.getTelTextField().setText(dos.getTel().getFirst().getTelefono());
                    if(dos.getTel().getFirst().getTipo().isEmpty())
                        editar.getTelBox().getSelectionModel().select(dos.getTel().getFirst().getTipo());
                }
                if(!dos.getEmail().isEmpty()){
                    editar.getEmailTextField().setText(dos.getEmail().getFirst().getEmail());
                    if(dos.getEmail().getFirst().getTipo().isEmpty())
                        editar.getEmailBox().getSelectionModel().select(dos.getEmail().getFirst().getTipo());
                }
                if(!dos.getAdr().isEmpty()){
                    editar.getCalleTextField().setText(dos.getAdr().getFirst().getCalle());
                    editar.getCiudadTextField().setText(dos.getAdr().getFirst().getCiudad());
                    editar.getEdoTextField().setText(dos.getAdr().getFirst().getEstado());
                    editar.getPaisTextField().setText(dos.getAdr().getFirst().getPais());
                    editar.getCpTextField().setText(dos.getAdr().getFirst().getPais());
                    if(dos.getAdr().getFirst().getTipo().isEmpty())
                        editar.getDirBox().getSelectionModel().select(dos.getAdr().getFirst().getTipo());
                }
                break;
                
                       
            case 1:
               Contacto tres = SmartScheduler.gestorC.getListaCompletos().get(nTableView.getSelectionModel().getSelectedIndex());
                editar.getNomTextField().setText(tres.getN().getN());
                editar.getApTextField().setText(tres.getN().getLn());
                editar.getTitTextField().setText(tres.getN().getT());
                editar.getApodoTextField().setText(tres.getN().getNk());
                editar.getOrgTextField().setText(tres.getOrg());
                
                if(!tres.getTel().isEmpty()){
                    editar.getTelTextField().setText(tres.getTel().getFirst().getTelefono());
                    if(tres.getTel().getFirst().getTipo().isEmpty())
                        editar.getTelBox().getSelectionModel().select(tres.getTel().getFirst().getTipo());
                }
                if(!tres.getEmail().isEmpty()){
                    editar.getEmailTextField().setText(tres.getEmail().getFirst().getEmail());
                    if(tres.getEmail().getFirst().getTipo().isEmpty())
                        editar.getEmailBox().getSelectionModel().select(tres.getEmail().getFirst().getTipo());
                }
                if(!tres.getAdr().isEmpty()){
                    editar.getCalleTextField().setText(tres.getAdr().getFirst().getCalle());
                    editar.getCiudadTextField().setText(tres.getAdr().getFirst().getCiudad());
                    editar.getEdoTextField().setText(tres.getAdr().getFirst().getEstado());
                    editar.getPaisTextField().setText(tres.getAdr().getFirst().getPais());
                    editar.getCpTextField().setText(tres.getAdr().getFirst().getPais());
                    if(tres.getAdr().getFirst().getTipo().isEmpty())
                        editar.getDirBox().getSelectionModel().select(tres.getAdr().getFirst().getTipo());
                }
                break;
                
            
            case 4:
               Contacto cuatro = SmartScheduler.gestorC.getListaSinFoto().get(nTableView.getSelectionModel().getSelectedIndex());
                editar.getNomTextField().setText(cuatro.getN().getN());
                editar.getApTextField().setText(cuatro.getN().getLn());
                editar.getTitTextField().setText(cuatro.getN().getT());
                editar.getApodoTextField().setText(cuatro.getN().getNk());
                editar.getOrgTextField().setText(cuatro.getOrg());
                
                if(!cuatro.getTel().isEmpty()){
                    editar.getTelTextField().setText(cuatro.getTel().getFirst().getTelefono());
                    if(cuatro.getTel().getFirst().getTipo().isEmpty())
                        editar.getTelBox().getSelectionModel().select(cuatro.getTel().getFirst().getTipo());
                }
                if(!cuatro.getEmail().isEmpty()){
                    editar.getEmailTextField().setText(cuatro.getEmail().getFirst().getEmail());
                    if(cuatro.getEmail().getFirst().getTipo().isEmpty())
                        editar.getEmailBox().getSelectionModel().select(cuatro.getEmail().getFirst().getTipo());
                }
                if(!cuatro.getAdr().isEmpty()){
                    editar.getCalleTextField().setText(cuatro.getAdr().getFirst().getCalle());
                    editar.getCiudadTextField().setText(cuatro.getAdr().getFirst().getCiudad());
                    editar.getEdoTextField().setText(cuatro.getAdr().getFirst().getEstado());
                    editar.getPaisTextField().setText(cuatro.getAdr().getFirst().getPais());
                    editar.getCpTextField().setText(cuatro.getAdr().getFirst().getPais());
                    if(cuatro.getAdr().getFirst().getTipo().isEmpty())
                        editar.getDirBox().getSelectionModel().select(cuatro.getAdr().getFirst().getTipo());
                }
                break;
            case 5:
                Contacto cinco;
                try {
                    
                    cinco = SmartScheduler.gestorDAO.obtieneConFoto().get(nTableView.getSelectionModel().getSelectedIndex());
                    editar.getNomTextField().setText(cinco.getN().getN());
                    editar.getApTextField().setText(cinco.getN().getLn());
                    editar.getTitTextField().setText(cinco.getN().getT());
                    editar.getApodoTextField().setText(cinco.getN().getNk());
                    editar.getOrgTextField().setText(cinco.getOrg());

                    if(!cinco.getTel().isEmpty()){
                        editar.getTelTextField().setText(cinco.getTel().getFirst().getTelefono());
                        if(cinco.getTel().getFirst().getTipo().isEmpty())
                            editar.getTelBox().getSelectionModel().select(cinco.getTel().getFirst().getTipo());
                    }
                    if(!cinco.getEmail().isEmpty()){
                        editar.getEmailTextField().setText(cinco.getEmail().getFirst().getEmail());
                        if(cinco.getEmail().getFirst().getTipo().isEmpty())
                            editar.getEmailBox().getSelectionModel().select(cinco.getEmail().getFirst().getTipo());
                    }
                    if(!cinco.getAdr().isEmpty()){
                        editar.getCalleTextField().setText(cinco.getAdr().getFirst().getCalle());
                        editar.getCiudadTextField().setText(cinco.getAdr().getFirst().getCiudad());
                        editar.getEdoTextField().setText(cinco.getAdr().getFirst().getEstado());
                        editar.getPaisTextField().setText(cinco.getAdr().getFirst().getPais());
                        editar.getCpTextField().setText(cinco.getAdr().getFirst().getPais());
                        if(cinco.getAdr().getFirst().getTipo().isEmpty())
                            editar.getDirBox().getSelectionModel().select(cinco.getAdr().getFirst().getTipo());
                    }
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
        
        
        /*
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLEditar.fxml"));
        Parent verParent = loader.load();
        FXMLEditarController editar = loader.getController();
        
        
        Parent bienvenidaParent = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Scene bienvenidaScene = new Scene(bienvenidaParent);
         
        
        Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ventanaPrincipal.setTitle("Ventana principal."); 
        ventanaPrincipal.setResizable(false);
         
        
        ventanaPrincipal.setScene(bienvenidaScene);
        ventanaPrincipal.centerOnScreen();
        
        ventanaPrincipal.setOnCloseRequest(new EventHandler<WindowEvent>(){
            public void handle(WindowEvent we) {
                System.out.println("Guardando lista de contactos en BD...");
                try{
                    SmartScheduler.gestorDAO.guardaTodos(SmartScheduler.gestorC.getListaContactos());
                }catch(ExceptionDAO ex){
                    Logger.getLogger(FXMLCargarArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        */
        
        Scene verScene = new Scene(verParent);
        
        Stage ventanaPrincipal = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ventanaPrincipal.setTitle("Ventana de edición."); 
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setScene(verScene);
        
        ventanaPrincipal.centerOnScreen();
        ventanaPrincipal.show();
    }
    
    @FXML
    public void agregarButtonAction(ActionEvent event) throws IOException {
        Parent editarParent = FXMLLoader.load(getClass().getResource("FXMLEditar.fxml"));
        Scene editarScene = new Scene(editarParent);
         
        Stage ventanaEdicion = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ventanaEdicion.setTitle("Ventana de nuevo contacto."); 
        ventanaEdicion.setResizable(false);
        ventanaEdicion.setScene(editarScene);
        ventanaEdicion.centerOnScreen();
        ventanaEdicion.show();
        
        ventanaEdicion.setOnCloseRequest(new EventHandler<WindowEvent>(){
            public void handle(WindowEvent we) {
                
                System.out.println("Guardando lista de contactos en BD...");
                try{
                    SmartScheduler.gestorDAO.guardaTodos(SmartScheduler.gestorC.getListaContactos());
                }catch(ExceptionDAO ex){
                    Logger.getLogger(FXMLCargarArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }
    
    @FXML
    public void eliminarButtonAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar eliminación");
                alert.setHeaderText("Está a punto de eliminar el contacto seleccionado");
                alert.setContentText("¿Desea continuar?");
                alert.showAndWait();
                
                if(alert.getResult() == ButtonType.OK){
                    int eliminarId;
                    Contacto c;
                    
                    switch(listaComboBox.getSelectionModel().getSelectedItem()){
                        case "Todos los contactos":
                            eliminarId = nTableView.getSelectionModel().getSelectedIndex();
                            c = SmartScheduler.gestorC.getListaContactos().get(eliminarId);
                            break;
                        case "Contactos completos":
                            eliminarId = nTableView.getSelectionModel().getSelectedIndex();
                            c = SmartScheduler.gestorC.getListaCompletos().get(eliminarId);
                            break;
                        case "Contactos incompletos":
                            eliminarId = nTableView.getSelectionModel().getSelectedIndex();
                            c = SmartScheduler.gestorC.getListaIncompletos().get(eliminarId);
                            break;
                        case "Contactos duplicados":
                            eliminarId = nTableView.getSelectionModel().getSelectedIndex();
                            c = SmartScheduler.gestorC.getListaDuplicados().get(eliminarId);
                            break;
                        case "Contactos sin foto":
                            eliminarId = nTableView.getSelectionModel().getSelectedIndex();
                            c = SmartScheduler.gestorC.getListaSinFoto().get(eliminarId);
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
                fusionarButton.setDisable(true);
                flag = 0;
                muestraTablaN(SmartScheduler.gestorC.getListaContactos());
                 break;
            case "Contactos completos":
                fusionarButton.setDisable(true);
                flag = 1;
                muestraTablaN(SmartScheduler.gestorC.getListaCompletos());
                 break;
            case "Contactos incompletos":
                fusionarButton.setDisable(true);
                flag = 2;
                muestraTablaN(SmartScheduler.gestorC.getListaIncompletos());
                 break;
            case "Contactos duplicados":
                fusionarButton.setDisable(false);
                flag = 3;
                muestraTablaN(SmartScheduler.gestorC.getListaDuplicados());
                 break;
            case "Contactos sin foto":
                fusionarButton.setDisable(true);
                flag = 4;
                muestraTablaN(SmartScheduler.gestorC.getListaSinFoto());
                 break;
            case "Contactos con foto":
                fusionarButton.setDisable(true);
                flag = 5;
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
                            //System.out.println("1. Indice nuevo: " + newSelection + " Indice viejo: " + oldSelection);
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
