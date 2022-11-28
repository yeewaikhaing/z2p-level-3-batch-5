package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SignUpController implements Initializable{

	@FXML
    private ComboBox<String> cbo_city;

    @FXML
    private CheckBox chk_java;

    @FXML
    private CheckBox chk_nodejs;

    @FXML
    private CheckBox chk_php;

    @FXML
    private ToggleGroup gender_group;

    @FXML
    private TextArea textarea_address;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_salary;

    @FXML
    void btn_reset_click(ActionEvent event) {

    }

    @FXML
    void btn_signup_click(ActionEvent event) {

    }

    @FXML
    void lbl_login_click(MouseEvent event) throws IOException {
    	Main.changeScene("Login.fxml", "Login");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		List<String> cities = List.of("Yangon", "Mandalay", "Pyay", "Bago");
		
		cbo_city.setItems(FXCollections.observableArrayList(cities));
		
	}
}
