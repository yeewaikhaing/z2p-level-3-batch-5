package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookList {

	@FXML
    private TableColumn<?, ?> col_author;

    @FXML
    private TableColumn<?, ?> col_category;

    @FXML
    private TableColumn<?, ?> col_created_by;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_price;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableView<?> tbl_books;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Books.fxml");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {

    	System.exit(0);
    }
}
