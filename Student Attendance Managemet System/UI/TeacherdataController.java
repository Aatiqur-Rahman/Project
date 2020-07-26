/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAL.ConnectWithDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TeacherdataController implements Initializable {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList<Teacherinfo> data;

    @FXML
    private TableView<Teacherinfo> teacher_table;
    @FXML
    private TableColumn<?, ?> teacher_id;
    @FXML
    private TableColumn<?, ?> teacher_name;
    @FXML
    private TableColumn<?, ?> teacher_mobile;
    @FXML
    private TableColumn<?, ?> teacher_email;
    @FXML
    private TableColumn<?, ?> teacher_username;
    @FXML
    private TableColumn<?, ?> teacher_pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data= FXCollections.observableArrayList();
        try {
            conn = ConnectWithDB.Connector();
            setTableData();
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherdataController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        setTableData();
//        loadData();
       
    } 
    private void setTableData (){
        teacher_id.setCellValueFactory(new PropertyValueFactory("teacher_id"));
        teacher_name.setCellValueFactory(new PropertyValueFactory("teacher_name"));
        teacher_mobile.setCellValueFactory(new PropertyValueFactory("teacher_mobile"));
        teacher_email.setCellValueFactory(new PropertyValueFactory("teacher_email"));
        teacher_pass.setCellValueFactory(new PropertyValueFactory("teacher_pass"));
        
    }
    
    private void loadData(){
        String sql = "SELECT * FROM Teacher;";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                data.add(new Teacherinfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherdataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        teacher_table.setItems(data);
    }
    
}
