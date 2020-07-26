/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AdminController implements Initializable {
    @FXML
    private ListView <String> addlistview;
    private ObservableList <String> addsublist;
    @FXML
    private ListView<Button> updatelistview;
     private ObservableList <Button> updatesublist;
    @FXML
    private ListView<String> deletelistview;
     private ObservableList <String> deletesublist;
    @FXML
    private TabPane maintab;
    @FXML
    private ListView<String> AllDatalistview;
    private ObservableList <String> alldatasublist;
    @FXML
    private TitledPane alldata;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generateList();
        addDataToList();
        addDataToAlldata();
    }    
    private void generateList(){
        addsublist=FXCollections.observableArrayList();
        addsublist.add ("Add Student");
        addsublist.add ("Add Teacher");
        addsublist.add ("Add ADMIN");
        addlistview.setItems(addsublist); // adding sublist to list 
        // deletesublist 
        deletesublist=FXCollections.observableArrayList();
        deletesublist.add ("Delete Student");
        deletesublist.add ("Delete Teacher");
        deletesublist.add ("Delete Admin");
        deletelistview.setItems(deletesublist);
        // updatesublist
        updatesublist=FXCollections.observableArrayList();
        Button bt = new Button("Update Student");
        updatesublist.add(bt);
        //updatesublist.add("Update Teacher");
        //updatesublist.add("Update Admin");
        updatelistview.setItems(updatesublist);
        
        
        alldatasublist=FXCollections.observableArrayList();
        alldatasublist.add("STUDENT INFO");
        alldatasublist.add("TEACHER INFO");
        alldatasublist.add("ADMIN INFO");
        AllDatalistview.setItems(alldatasublist);
        
    }
    private void addDataToList(){
        addlistview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.
                
                int i = addlistview.getSelectionModel().getSelectedIndex();
                if (i==0){
                    try {
                        Node root1 = FXMLLoader.load(getClass().getResource("/UI/AddStudent.fxml"));
                        Tab tab = new Tab(" Add Student ",root1);
                        maintab.getTabs().add(tab);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (i==1){
                    try {
                        Node root2 = FXMLLoader.load(getClass().getResource("/UI/AddTeacher.fxml"));
                        Tab tab = new Tab("ADD TEACHER",root2);
                        maintab.getTabs().add(tab);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (i==2){
                    try {
                        Node root3 = FXMLLoader.load(getClass().getResource("/UI/AddAdmin.fxml"));
                        Tab tab = new Tab("ADD ADMIN",root3);
                        maintab.getTabs().add(tab);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });   
    }
    
    private void AddDataToUpdate(){
        updatelistview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Button>() {
            @Override
            public void changed(ObservableValue<? extends Button> observable, Button oldValue, Button newValue) {
                int i = updatelistview.getSelectionModel().getSelectedIndex();
                if (i==0){
                    
                }
                if (i==1){
                    
                }
                if (i==2){
                    
                }
            }
        });
        
        
    }
    private void addDataToAlldata(){
        AllDatalistview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int i = AllDatalistview.getSelectionModel().getSelectedIndex();
                if (i==0){
                    try {
                        Node root1 = FXMLLoader.load(getClass().getResource("/UI/studentdata.fxml"));
                        Tab tab = new Tab("Student INFO ",root1);
                        maintab.getTabs().add(tab);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (i==1){
                    try {
                        Node root2 = FXMLLoader.load(getClass().getResource("/UI/Teacherdata.fxml"));
                        Tab tab = new Tab("TEACHER INFO",root2);
                        maintab.getTabs().add(tab);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    @FXML
    private void logout(ActionEvent event) {
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/UI/Login.fxml"));
            Scene scene = new Scene(root,700,500);
            Stage stage = new Stage ();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
// Initialize 