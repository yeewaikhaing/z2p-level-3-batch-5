package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
	@FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    void btn_cancel_click(ActionEvent event) {

    }

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	
    	Start.changeScene("view/Main.fxml");
    }

}
