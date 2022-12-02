package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BookSearch {

	@FXML
    private TableColumn<?, ?> col_author;

    @FXML
    private TableColumn<?, ?> col_category;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_price;

    @FXML
    private TableColumn<?, ?> col_publish_date;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableView<?> tbl_books;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_category;

    @FXML
    private TextField txt_title;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {

    	Start.changeScene("view/Books.fxml");
    }

    @FXML
    void btn_logOut_click(ActionEvent event) {

    	System.exit(0);
    }

    @FXML
    void search_click(MouseEvent event) {

    }
}
