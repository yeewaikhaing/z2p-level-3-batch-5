package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Author {

	@FXML
    private TableColumn<?, ?> col_birthday;

    @FXML
    private TableColumn<?, ?> col_created_by;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_township;

    @FXML
    private TableView<?> tbl_authors;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_township;

    @FXML
    void btn_add_click(ActionEvent event) {

    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {

    	Start.changeScene("view/Main.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) {

    }

    @FXML
    void btn_edit_click(ActionEvent event) {

    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }
}
