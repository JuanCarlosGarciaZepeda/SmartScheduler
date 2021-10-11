/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.azc.adsi.smartscheduler.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        
        
        
        telefonoTableView.setVisible(true);
        
        telefonoTableView.setItems(a);
        
        
/*        
        
        TableViewSelectionModel<Telefono> selectionModelN = telefonoTableView.getSelectionModel();

        selectionModelN.setSelectionMode(SelectionMode.SINGLE);
        
        ObservableList<Telefono> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
            System.out.println("Selection changed: " + change.getList());
            }
        })*/
        
    /* 
        ProductoDAO pdao = new ProductoDAO();
        
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tablaProductos.setItems(pdao.verProductos());
    */
    }
    
    /*
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
    */
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ArrayList<String> arrayMenu = new ArrayList<>();
        
        arrayMenu.add("Direcciones");
        arrayMenu.add("Emails");
        arrayMenu.add("Telefonos");
        
        ObservableList<String> listaMenu = FXCollections.observableArrayList(arrayMenu);
        
        menuComboBox.setItems(listaMenu);
        
        muestraTablaN();
        
    }    
    
}
