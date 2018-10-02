/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window.java;

import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class Sign_Up_Window {
    Sign_Up_Window(){
        //new account page
    Stage sign_up_page = new Stage();
    sign_up_page.setTitle("Sign Up");
    //new_passwd_page.setFullScreen(true); 

            
    //GridPane Layout 
    GridPane sign_up_pane = new GridPane();
             
    //
    sign_up_pane.setId("sign-up");
    
    //making gridlines visible
    //sign_up_pane.setGridLinesVisible(true); 
                
    //
    sign_up_pane.setAlignment(Pos.CENTER);          
            
    //scenetitle
    Label sign_up_scene_title = new Label();
    sign_up_scene_title.setText("Individual Registration"); 
    sign_up_pane.add(sign_up_scene_title,0,0,4,2);
    
    //css effects for label
    sign_up_scene_title.setId("text");
    
     
       
    //setting gaps between rows and columns of grid 
    sign_up_pane.setHgap(10);
    sign_up_pane.setVgap(10);
        
    //padding of gridpane in scene
    sign_up_pane.setPadding(new Insets(50,50,50,50));
            
    //
    sign_up_pane.centerShapeProperty();
            
    //
    Label acc_details_lbl = new Label("Account Details");
    sign_up_pane.add(acc_details_lbl,0,4,2,1);
    
    //
    Text user_id = new Text("User Id :");
    sign_up_pane.add(user_id,0,6);
    //css effects same as that for text on 1st page 
    user_id.setId("sign-up");  
            
    //
    TextField user_id_tf = new TextField();
    user_id_tf.setPromptText("Enter your user id");
    sign_up_pane.add(user_id_tf,1,6,3,1);
            
    //
    Label user_id_alert = new Label("Between 3 to 10 characters.Only letter, number and underscores are allowed");
    sign_up_pane.add(user_id_alert,1,7,5,1);
            
    //
    Text passwd_txt = new Text("New Password :");
    sign_up_pane.add(passwd_txt,0,9);
    
    //css effects same as that for text on 1st page 
    passwd_txt.setId("sign-up");
             
    //
    PasswordField passwd_pf = new PasswordField();
    passwd_pf.setPromptText("Enter Password");
    sign_up_pane.add(passwd_pf,1,9,3,1);
    //new_passwd_pf.setDisable(true);
    
        
    //
    Label passwd_alert = new Label();
    passwd_alert.setText("Password should contain alphabets,numbers and special characters(@,#,$) and"
            + " should be atleast 8 characters long");
    sign_up_pane.add(passwd_alert,1,10,5,1);
    
    //
    Text confirm_passwd_txt = new Text("Confirm Password :");
    sign_up_pane.add(confirm_passwd_txt,0,12);
    
    //css effects same as that for text on 1st page 
    confirm_passwd_txt.setId("sign-up");
             
    //
    PasswordField confirm_passwd_pf = new PasswordField();
    confirm_passwd_pf.setPromptText("Confirm Password");
    sign_up_pane.add(confirm_passwd_pf,1,12,3,1);
    
    //
    Label personal_details_lbl = new Label("Personal Details");
    sign_up_pane.add(personal_details_lbl,0,14,2,1);
    
    //
    Text f_name_txt = new Text("First Name :");
    sign_up_pane.add(f_name_txt,0,16);
    
    //
    TextField f_name_tf = new TextField();
    f_name_tf.setPromptText("Enter first name");
    sign_up_pane.add(f_name_tf,1,16,3,1);
    
    //
    Text m_name_txt = new Text("Middle Name :");
    sign_up_pane.add(m_name_txt,0,18);
    
    //
    TextField m_name_tf = new TextField();
    m_name_tf.setPromptText("Enter middle name");
    sign_up_pane.add(m_name_tf,1,18,3,1);
    
    //
    Text l_name_txt = new Text("Last Name :");
    sign_up_pane.add(l_name_txt,0,20);
    
    //
    TextField l_name_tf = new TextField();
    l_name_tf.setPromptText("Enter last name");
    sign_up_pane.add(l_name_tf,1,20,3,1);
    
    //
    Text gender_txt = new Text("Gender :");
    sign_up_pane.add(gender_txt,0,22);
    
    //RadioButton for male,female,transgender
    RadioButton male_rbtn = new RadioButton("Male");
    sign_up_pane.add(male_rbtn,1,22);
    
    RadioButton female_rbtn = new RadioButton("Female");
    sign_up_pane.add(female_rbtn,2,22);
    
    RadioButton transgender_rbtn = new RadioButton("Transgender");
    sign_up_pane.add(transgender_rbtn,3,22);
    
    //Toggling Gender RadioButtons
    ToggleGroup gender_tg = new ToggleGroup();
    male_rbtn.setToggleGroup(gender_tg);
    female_rbtn.setToggleGroup(gender_tg);
    transgender_rbtn.setToggleGroup(gender_tg);
    
    //
    Text dob_txt = new Text("Date of Birth :");
    sign_up_pane.add(dob_txt,0,24);
    
    //
    DatePicker dob_dp = new DatePicker();
    sign_up_pane.add(dob_dp,1,24,3,1);
    dob_dp.setEditable(false); 
    //
    Text occupation_txt = new Text("Occupation :");
    sign_up_pane.add(occupation_txt,0,26);
    
    //
    ComboBox occ_cb = new ComboBox();
    occ_cb.getItems().addAll("Government","Public","Private","Professional","SelfEmployed","Student","Others"); 
    sign_up_pane.add(occ_cb,1,26,3,1);
    
    //
    Text country_txt = new Text("Country :");
    sign_up_pane.add(country_txt,0,28);
    
    //
    ComboBox country_cb = new ComboBox();
    country_cb.getItems().addAll("India","Antarcta","Australia","Brazil"); 
    sign_up_pane.add(country_cb,1,28,3,1);
    
    //
    Text email_txt = new Text("Email :");
    sign_up_pane.add(email_txt,0,30);
    
    //
    TextField email_tf = new TextField();
    email_tf.setPromptText("Enter email id");
    sign_up_pane.add(email_tf,1,30,3,1);
    
    //
    Text mobile_no_txt = new Text("Mobile no. :");
    sign_up_pane.add(mobile_no_txt,0,32);
    
    //
    TextField mobile_no_tf = new TextField();
    mobile_no_tf.setPromptText("Enter mobile no.");
    sign_up_pane.add(mobile_no_tf,1,32,3,1);
    
    //
    Text nationality_txt = new Text("Nationality :");
    sign_up_pane.add(nationality_txt,0,34);
    
    //
    ComboBox nationality_cb = new ComboBox();
    nationality_cb.getItems().addAll("India","Antarcta","Australia","Brazil"); 
    sign_up_pane.add(nationality_cb,1,34,3,1);
    
    //Residential address label
    Label res_add_lbl = new Label("Residential Address");
    sign_up_pane.add(res_add_lbl,0,36,3,1);
    
    //flat/door/block no text
    Text flat_txt = new Text("Flat/Door/Block :");
    sign_up_pane.add(flat_txt,0,38);
    
    //
    TextField flat_tf = new TextField();
    flat_tf.setPromptText("flat/door/block");
    sign_up_pane.add(flat_tf,1,38,3,1);
    
    //street/lane text
    Text street_txt = new Text("Street/Lane :");
    sign_up_pane.add(street_txt,0,40);
    
    //
    TextField street_tf = new TextField();
    street_tf.setPromptText("street/lane");
    sign_up_pane.add(street_tf,1,40,3,1);
    
    //area/locality text
    Text area_txt = new Text("Area/Locality :");
    sign_up_pane.add(area_txt,0,42);
    
    //
    TextField area_tf = new TextField();
    area_tf.setPromptText("area/locality");
    sign_up_pane.add(area_tf,1,42,3,1);
    
    //pincode text
    Text pin_txt = new Text("Pincode :");
    sign_up_pane.add(pin_txt,0,44);
    
    //
    TextField pin_tf = new TextField();
    pin_tf.setPromptText("enter pincode");
    sign_up_pane.add(pin_tf,1,44,3,1);
    
    //city/town
    Text city_txt = new Text("City/Town :");
    sign_up_pane.add(city_txt,0,46);
    
    //
    ComboBox city_cb = new ComboBox();
    city_cb.getItems().addAll("Mumbai","New Delhi","Bengaluru","Chennai");
    sign_up_pane.add(city_cb,1,46,3,1);
    
    //

    
    //
    Button submit_btn = new Button("Submit Registration");
    sign_up_pane.add(submit_btn,0,50);
    submit_btn.setOnAction(new EventHandler<ActionEvent>(){
        
        private boolean allFilled(TextField... textFields)
        {
            for(TextField textField : textFields)
            {
                if(textField.getText().trim().isEmpty())
                {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public void handle(ActionEvent e)
        {
            if(allFilled())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all mandatory details");
                alert.show();
            }
            else if(gender_tg.getSelectedToggle()==null || dob_dp.getValue()==null || occ_cb.getValue()==null || country_cb.getValue()==null 
                    || city_cb.getValue()==null || nationality_cb.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incomplete Details"); 
                alert.setContentText("Please fill all mandatory details");
                alert.show();
            }
            else if(!(user_id_tf.getText().length()>2 && user_id_tf.getText().length()<11 && Pattern.matches("[a-zA-Z0-9_]+", user_id_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter User-Id");
                warning.setContentText("User Id should contain 3 to 10 characters and only letter, number and underscores are allowed");
                warning.show();
            }
            else if(passwd_pf.getText().length()<8 && confirm_passwd_pf.getText().length()<8)
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Length of Password should be atleast 8 characters long");
                warning.show();
            }
            else if(!confirm_passwd_pf.getText().equals(passwd_pf.getText()))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Passwords don't match");
                warning.show();
            }   
            else if(!(Pattern.matches("[a-zA-Z0-9@#$]+", passwd_pf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter Password");
                warning.setContentText("Password should contain only alphabets,numbers and"
                        + " special characters(@,#,$)");
                warning.show();
            }
            else if(!(Pattern.matches("[a-zA-Z]", f_name_tf.getText()) || Pattern.matches("[a-zA-Z]", m_name_tf.getText())
                    || Pattern.matches("[a-zA-Z]", l_name_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter Name");
                warning.setContentText("Name field should contain only characters");
                warning.show();
            }
            /*else if(!(email_tf.getText().length()>2 && user_id_tf.getText().length()<11 && Pattern.matches("[a-zA-Z0-9_]+", user_id_tf.getText())))
            {
                Alert warning = new Alert(Alert.AlertType.WARNING,"Re-Enter User-Id");
                warning.setContentText("User Id should contain 3 to 10 characters and only letter, number and underscores are allowed");
                warning.show();
            }*/
            else if(!(mobile_no_tf.getText().length()==10) || Pattern.matches("[0-9]",mobile_no_tf.getText()))
            {
                Alert error =  new Alert(Alert.AlertType.ERROR,"Invalid mobile number");
                error.setContentText("Invalid mobile number");
                error.show();
            }
            else 
            {
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"Confirmation",ButtonType.YES,ButtonType.NO);
                confirmation.setContentText("Confirm Register ?"); 
                confirmation.show();
  
                confirmation.setOnCloseRequest(new EventHandler<DialogEvent>(){
                    @Override
                    public void handle(DialogEvent event) {
                        if(confirmation.getResult()==ButtonType.YES)
                        {   
                            Label registered = new Label("Registered Successfully"); 
                            registered.setId("register"); 
                            sign_up_pane.add(registered,0,53,1,2);
                        }
                        /*else if(confirmation.getResult()==ButtonType.NO)
                        {
                            passwd_pf.setText("");    
                            confirm_passwd_pf.setText(""); 
                        }*/ 
                    }       
                }); 
            }    
        } 

    });
    
    //clear all fields
    Button reset_btn = new Button("Reset");
    sign_up_pane.add(reset_btn,1,50);
    
    reset_btn.setOnAction(new EventHandler<ActionEvent>() {
        
        private void allFilled(TextField... textFields)
        {
            for(TextField textField : textFields)
            {
                textField.clear(); 
            }
        }
        
        @Override
        public void handle(ActionEvent e) {
            allFilled();
        }
    });
    
    //exit forgot password page
    Button exit_btn = new Button("Exit");
    sign_up_pane.add(exit_btn, 3, 50);
    exit_btn.setOnAction(e -> {
        sign_up_page.close();
    });
    
    //
    ScrollPane rootPane = new ScrollPane();
    rootPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    rootPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
    rootPane.setFitToHeight(true);
    rootPane.setFitToWidth(true); 
    rootPane.setContent(sign_up_pane);   
    
    //
    Scene new_passwd_scene = new Scene(rootPane,450,350);
            
    new_passwd_scene.getStylesheets().add(Sign_Up_Window.class.getResource("Sign_Up.css").toExternalForm());
    sign_up_page.setScene(new_passwd_scene);
    
    //setting primaryStage to the size of screen of pc
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    //MinX and MinY are upper left corner of primaryStage
    sign_up_page.setX(primaryScreenBounds.getMinX());
    sign_up_page.setY(primaryScreenBounds.getMinY());
    //setting width of stage to width of screen
    sign_up_page.setWidth(primaryScreenBounds.getWidth());
    //setting height of stage to height of screen
    sign_up_page.setHeight(primaryScreenBounds.getHeight());
        
    sign_up_page.show();
    }

    
}