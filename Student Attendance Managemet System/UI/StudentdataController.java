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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class StudentdataController implements Initializable {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList <Student> data;

    @FXML
    private TableView<Student> student;
    @FXML
    private TableColumn<?, ?> st_id;
    @FXML
    private TableColumn<?, ?> st_name;
    @FXML
    private TableColumn<?, ?> st_father_name;
    @FXML
    private TableColumn<?, ?> st_dob;
    @FXML
    private TableColumn<?, ?> st_sex;
    @FXML
    private TableColumn<?, ?> st_email;
    @FXML
    private TableColumn<?, ?> st_mobile;
    @FXML
    private TableColumn<?, ?> st_semester;
    @FXML
    private TableColumn<?, ?> st_dept;
    @FXML
    private TableColumn<?, ?> st_user;
    @FXML
    private TableColumn<?, ?> st_pass;
    @FXML
    private TextField st_serach_field;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       data = FXCollections.observableArrayList();
        try {
            // TODO
            conn = ConnectWithDB.Connector();
            setCellValue ();
            loaddata();
        } catch (SQLException ex) {
            Logger.getLogger(StudentdataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void st_search(ActionEvent event) {
    }
    private void setCellValue () {
        st_id.setCellValueFactory(new PropertyValueFactory("ID"));
        st_name.setCellValueFactory(new PropertyValueFactory("Name"));
        st_father_name.setCellValueFactory(new PropertyValueFactory("Father_name"));
        st_dob.setCellValueFactory(new PropertyValueFactory("DOB"));
        st_sex.setCellValueFactory(new PropertyValueFactory("Sex"));
        st_email.setCellValueFactory(new PropertyValueFactory("Email"));
        st_mobile.setCellValueFactory(new PropertyValueFactory("Mobile"));
        st_semester.setCellValueFactory(new PropertyValueFactory("Semester"));
        st_dept.setCellValueFactory(new PropertyValueFactory("Dept"));
        st_user.setCellValueFactory(new PropertyValueFactory("User"));
        st_pass.setCellValueFactory(new PropertyValueFactory("Pass"));
    }
    private void loaddata(){
        String sql = "select * from Student";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
               data.add(new Student(rs.getString(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getString(7),
                       rs.getString(8),
                       rs.getString(9),
                       rs.getString(10),
                       rs.getString(11)
               ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentdataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        student.setItems(data);
        
    }
    
}
