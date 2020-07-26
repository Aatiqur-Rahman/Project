/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAL.ConnectWithDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TakeAttendanceController implements Initializable {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList <Attendance> data  ;

//    private ChoiceBox <String> semester;
//    private ChoiceBox<String> course;
//    private ChoiceBox<String> department;
//    ObservableList <String> semesterlist = FXCollections.observableArrayList("1st","2nd","3rd","4th","5th","6th","7th","8th");
//    ObservableList <String> courselist = FXCollections.observableArrayList("CSE_111","CSE_112","CSE_113","CSE_114","CSE_115","CSE_116");
//    ObservableList <String> departmentlist = FXCollections.observableArrayList("CSE","ECE","BBA");
    @FXML
    private TableView<Attendance> attendance_table;
    @FXML
    private TableColumn<?, ?> c_date;
    @FXML
    private TableColumn<?, ?> c_student_id;
    @FXML
    private TableColumn<?, ?> c_teacher_id;
    @FXML
    private TableColumn<?, ?> c_course_id;
    @FXML
    private TableColumn<?, ?> semester_id;
    @FXML
    private TableColumn<?, ?> dept_name;
    @FXML
    private TableColumn<Attendance, Void> c_status;
    @FXML
    private Button take_attendance_btn;
   
    @FXML
    private Button save_btn;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data=FXCollections.observableArrayList();
        
        try {
            conn = ConnectWithDB.Connector();
            System.out.println(conn);
            setcell();
            loadcell();
            addButton();
        } catch (SQLException ex) {
            Logger.getLogger(TakeAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    private void setcell(){
        c_date.setCellValueFactory(new PropertyValueFactory("date"));
        c_student_id.setCellValueFactory(new PropertyValueFactory("s_id"));
        c_teacher_id.setCellValueFactory(new PropertyValueFactory("t_id"));
        c_course_id.setCellValueFactory(new PropertyValueFactory("c_id"));
        semester_id.setCellValueFactory(new PropertyValueFactory("sem_id"));
        dept_name.setCellValueFactory(new PropertyValueFactory("d_name"));
       
    }
    public void loadcell(){
        data.clear();
        
        try {
            String sql = "select * from Attendance";
            pst = conn.prepareStatement(sql);
            rs= pst.executeQuery();
    
            while(rs.next()){
                System.out.println(rs.getString(2));
                data.add(new Attendance(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TakeAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        attendance_table.setItems(data);
    }
    private void addButton(){
        c_status.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Attendance,Void>,ObservableValue<Void>>() {
            @Override
            public ObservableValue<Void> call(TableColumn.CellDataFeatures<Attendance, Void> param) {
                return null;
            }
        }
        );
        c_status.setCellFactory(
                new Callback<TableColumn<Attendance,Void>,TableCell<Attendance,Void>>() {
            @Override
            public TableCell<Attendance, Void> call(TableColumn<Attendance, Void> param) {
                return new ButtonCell();
                
            }
        }
        );

        
    }

    public class ButtonCell extends TableCell<Attendance, Void> {
        Button bt1;
        Button bt2;
        public ButtonCell() {
            bt1=new Button("present");
            bt2=new Button("Absent");
            bt1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello world \n I am a java developer ");
                }
            });
            bt2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello world \n I am a java developer ");
                    bt2.getStyleClass().add("red");
                }
            });
            
        }
        @Override
        protected void updateItem(Void record, boolean empty) {
            super.updateItem(record, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox pane = new HBox(bt1,bt2);
                            setGraphic(pane);
                            
                        }
        }
        
    }

    
}
