/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIZ;

import Main.StructureOfSAMS;
import static com.sun.deploy.util.ReflectionUtil.getClass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    /**
     *
     */
    //showWelcome();
        
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
            Scene scene = new Scene(root,500,500);
            stage.setScene(scene);
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

}          
    
}//Initializew
