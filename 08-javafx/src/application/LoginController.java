package application;

import java.io.IOException;

import javafx.fxml.FXML;
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
		
		if(email.equals("admin@gmail.com") && password.equals("mic@123")) {
			System.out.println("Authicated User");
		}
		else {
			System.out.println("Authication fail");
		}
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
