/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAL.ConnectWithDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddTeacherController implements Initializable {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    @FXML
    private TextField teacher_id;
    @FXML
    private TextField teacher_usename;
    @FXML
    private TextField teacher_mobile;
    @FXML
    private TextField teacher_email;
    @FXML
    private TextField teacher_name;
    @FXML
    private PasswordField teacher_pass;
    @FXML
    private Button teacher_add_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           conn=ConnectWithDB.Connector();
        } catch (SQLException ex) {
            Logger.getLogger(AddTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void teacher_add_button_clicked(ActionEvent event) {
        String sql = "insert into Teacher (Teacher_id,Teacher_Name,Mobile,Email,Password) values (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,teacher_id.getText());
            pst.setString(2,teacher_name.getText());
            pst.setString(3,teacher_mobile.getText());
            pst.setString(4,teacher_email.getText());
            pst.setString(5,teacher_pass.getText());
            // Showing data to console
//            System.out.println(teacher_id.getText());
//            System.out.println(teacher_name.getText());
            pst.executeUpdate();
            //if (j==1){System.out.println("Hello world !! ");}
            //System.out.println(pst.executeUpdate());
//            if (j==1){
//                System.out.println("Hello world !! ");
//                   
//                try {
//                    Parent root = FXMLLoader.load(getClass().getResource("/UI/alert_add_data.fxml"));
//                     Scene scene = new Scene(root,400,200);
//                    Stage stage = new Stage();
//                    stage.setScene(scene);
//                    stage.initStyle(StageStyle.UNDECORATED);  
//                    stage.show();
//                } catch (IOException ex) {
//                    Logger.getLogger(AddTeacherController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                  
//       
//            }
        } catch (SQLException ex) {
            Logger.getLogger(AddTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
