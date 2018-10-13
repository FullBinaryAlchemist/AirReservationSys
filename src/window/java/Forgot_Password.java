/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class Forgot_Password extends Application {
    
    public Button exit_btn, change_pw_btn;
    
    @Override
    public void start(Stage new_passwd_page){
    
    new_passwd_page.setTitle("Forgot Password");
    //new_passwd_page.setFullScreen(true); 

            
    //GridPane Layout 
    GridPane new_passwd_pane = new GridPane();
             
    //
    new_passwd_pane.setId("forgot-pw");
    
    //making gridlines visible
    //new_passwd_pane.setGridLinesVisible(true); 
                
    //
    new_passwd_pane.setAlignment(Pos.CENTER);          
            
    //scenetitle
    Label new_passwd_scene_title = new Label();
    new_passwd_scene_title.setText("Create new Password"); 
    new_passwd_pane.add(new_passwd_scene_title,0,0,3,2);
    
    //css effects for label
    new_passwd_scene_title.setId("text");
    
     
       
    //setting gaps between rows and columns of grid 
    new_passwd_pane.setHgap(10);
    new_passwd_pane.setVgap(10);
        
    //padding of gridpane in scene
    new_passwd_pane.setPadding(new Insets(50,50,50,50));
            
    //
    new_passwd_pane.centerShapeProperty();
            
    //
    Text user_id = new Text("User Id :");
    new_passwd_pane.add(user_id,0,4);
    //css effects same as that for text on 1st page 
    user_id.setId("forgot-pw");  
            
    //
    TextField user_id_tf = new TextField();
    user_id_tf.setPromptText("Enter your user id");
    new_passwd_pane.add(user_id_tf,1,4);
   // user_id_tf.setText(null);
            
    //
    Text new_passwd = new Text("New Password :");
    new_passwd_pane.add(new_passwd,0,6);
    
    //css effects same as that for text on 1st page 
    new_passwd.setId("forgot-pw");
             
    //
    PasswordField new_passwd_pf = new PasswordField();
    new_passwd_pf.setPromptText("Enter new Password");
    new_passwd_pane.add(new_passwd_pf,1,6);
    //new_passwd_pf.setDisable(true);
    
        
    //
    Label passwd_alert = new Label();
    passwd_alert.setText("Password should contain alphabets,numbers and special characters(@,#,$) and"
            + " should be atleast 8 characters long");
    new_passwd_pane.add(passwd_alert,1,7,5,2);
    
    //
    Text confirm_passwd = new Text("Confirm Password :");
    new_passwd_pane.add(confirm_passwd,0,9);
    
    //css effects same as that for text on 1st page 
    confirm_passwd.setId("forgot-pw");
             
    //
    PasswordField confirm_passwd_pf = new PasswordField();
    confirm_passwd_pf.setPromptText("Confirm Password");
    new_passwd_pane.add(confirm_passwd_pf,1,9);
    
    //
    /*EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e)
        {
            if(user_id_tf.getText().isEmpty())
            {    
                Alert enter_id = new Alert(AlertType.INFORMATION);
                enter_id.setTitle("Enter User Id and Password"); 
                enter_id.setContentText("First enter your User Id then Password");
                enter_id.show();
                new_passwd_pf.setText(null);
                confirm_passwd_pf.setText(null);
            }  
        }
    };*/
    //
    //new_passwd_pf.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
    
    //    
    //confirm_passwd_pf.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
 
    
    //
    change_pw_btn = new Button("Change Password");
    new_passwd_pane.add(change_pw_btn,0,13);
    change_pw_btn.setOnAction(new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent e)
        {
            if(user_id_tf.getText().isEmpty() || new_passwd_pf.getText().isEmpty() || confirm_passwd_pf.getText().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all mandatory details");
                alert.show();
            }
            else if(!(Pattern.matches("[a-zA-Z0-9@#$]+", new_passwd_pf.getText())))
            {
                Alert warning = new Alert(AlertType.WARNING,"Re-Enter Password");
                warning.setContentText("Password should contain only alphabets,numbers and"
                        + " special characters(@,#,$)");
                warning.show();
            }
            else if(new_passwd_pf.getText().length()<8 && confirm_passwd_pf.getText().length()<8)
            {
                Alert warning = new Alert(AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Length of Password should be atleast 8 characters long");
                warning.show();
            }
            else if(!confirm_passwd_pf.getText().equals(new_passwd_pf.getText()))
            {
                Alert warning = new Alert(AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Passwords don't match");
                warning.show();
            }
            else 
            {
                Alert confirmation = new Alert(AlertType.CONFIRMATION,"Confirmation",ButtonType.YES,ButtonType.NO);
                confirmation.setContentText("Confirm Change Password ?"); 
                confirmation.show();
  
                confirmation.setOnCloseRequest(new EventHandler<DialogEvent>(){
                    @Override
                    public void handle(DialogEvent event) {
                        if(confirmation.getResult()==ButtonType.YES)
                        {   
                            /*Label passwd_changed = new Label("Password changed Successfully"); 
                            passwd_changed.setId("passwd_changed_label"); 
                            new_passwd_pane.add(passwd_changed,0,13,1,2);*/
                            new_passwd_page.close();
                            Alert passwd_changed = new Alert(Alert.AlertType.INFORMATION);
                            passwd_changed.setTitle("Password Changed");
                            passwd_changed.setContentText("Password Changed Successfully"); 
                            passwd_changed.show();
                        }
                        else if(confirmation.getResult()==ButtonType.NO)
                        {
                            new_passwd_pf.setText("");    
                            confirm_passwd_pf.setText(""); 
                            
                        }
                         
                    }
                      
                       
                   }); 
            }    
        } 
    });
    
    //clear all fields
    Button reset_btn = new Button("Reset");
    new_passwd_pane.add(reset_btn,1,13);
    
    reset_btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            user_id_tf.setText("");
            new_passwd_pf.setText("");
            confirm_passwd_pf.setText("");
        }
    });
    
    //exit forgot password page
    exit_btn = new Button("Exit");
    new_passwd_pane.add(exit_btn, 3, 13);
    exit_btn.setOnAction(e -> {
        new_passwd_page.close();
    });
    
    Scene new_passwd_scene = new Scene(new_passwd_pane,450,350);
            
    new_passwd_scene.getStylesheets().add(Forgot_Password.class.getResource("Forgot_Password.css").toExternalForm());
    new_passwd_page.setScene(new_passwd_scene);
    
    //setting primaryStage to the size of screen of pc
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
          //MinX and MinY are upper left corner of primaryStage
        new_passwd_page.setX(primaryScreenBounds.getMinX());
        new_passwd_page.setY(primaryScreenBounds.getMinY());
          //setting width of stage to width of screen
        new_passwd_page.setWidth(primaryScreenBounds.getWidth());
          //setting height of stage to height of screen
        new_passwd_page.setHeight(primaryScreenBounds.getHeight());
    new_passwd_page.show();
    }
}
