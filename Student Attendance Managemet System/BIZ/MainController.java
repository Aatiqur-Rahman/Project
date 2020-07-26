/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIZ;

import DAL.ConnectWithDB;
import Main.StructureOfSAMS;
import static com.sun.deploy.util.ReflectionUtil.getClass;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainController implements Initializable {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    @FXML 
    private TextField st_user;
    
    @FXML private PasswordField st_pass;
    @FXML
    private PasswordField admin_pass;
    @FXML
    private TextField admin_user;
    @FXML
    private Label error_label;
    
    
    @FXML
    private void bt (ActionEvent event) throws SQLException, IOException{
//        System.out.println("You clicked login");
//        System.out.println(st_user.getText());
//        System.out.println(st_pass.getText());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = ConnectWithDB.Connector();
            /**
             *
             */
            //showWelcome();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
public static void showWelcome(){ 
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StructureOfSAMS.class.getResource("/UI/welcome.fxml"));
            Parent root =loader.load();
            //Group root = new Group();
            Stage stage = new Stage ();
            Scene scene = new Scene(root,500,500);
            stage.setScene(scene);
            stage.show();
            Login();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
       

}  
public static void showStudentPage(){
    try {
        FXMLLoader loader = new FXMLLoader();
       loader.setLocation(StructureOfSAMS.class.getResource("/UI/Studnet"));
       Parent root ;
            root = loader.load();
            Stage stage = new Stage ();
            Scene scene = new Scene(root,500,500);
            stage.setScene(scene);
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public static void Login(){
            try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StructureOfSAMS.class.getResource("/UI/Login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("welcom.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage ();
            Scene scene = new Scene(root,700,500);
            stage.setScene(scene);
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

}          

    @FXML
    private void Exit_button(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void admin_login(ActionEvent event) {
        String sql ="select admin_username,admin_pass from admin where admin_username=? and  admin_pass=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,admin_user.getText());
            pst.setString(2,admin_pass.getText());
            rs = pst.executeQuery();
            //System.out.println(rs);
            //System.out.println(rs);
            if (rs.next()){
                try {
                    ((Node)event.getSource()).getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/UI/Admin.fxml"));
                    Scene scene = new Scene(root,1200,700);
                    Stage stage = new Stage ();
                    stage.setScene(scene);
                    stage.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                error_label.setText("Username and Password is Incorrect ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}//Initializew
