package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

	// convert tag to object
	@FXML
	private TextField txt_email;
	@FXML
	private PasswordField txt_pass;
	
	@FXML
	private void btn_login_click() {
		String email = txt_email.getText();
		String password = txt_pass.getText();
		
		if(email.isEmpty()) {
			showAlert(AlertType.ERROR, "Email is requried");
			return;
		}
		
		if(password.isEmpty()) {
			showAlert(AlertType.ERROR, "Password is requried");
			return;
		}
		
		if(email.equals("admin@gmail.com") && password.equals("mic@123")) {
			showAlert(AlertType.INFORMATION, "Login success");
			
		}
		else {
			showAlert(AlertType.ERROR, "Login Fail");
		}
	}
	
	private void showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}

	@FXML
	private void btn_clear_click() {
		txt_email.setText("");
		txt_pass.setText("");
	}
	
	@FXML
    void lbl_signup_click(MouseEvent event) throws IOException {
		Main.changeScene("SignUp.fxml", "SignUp");
    }
	
}
