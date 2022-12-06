package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.Author;
import com.mmit.model.Category;
import com.mmit.model.DatabaseHandler;
import com.mmit.model.Book;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BookAdd implements Initializable{

	@FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private TextField txt_price;

    @FXML
    private DatePicker txt_publish;

    @FXML
    private TextField txt_title;
    
    @FXML
    private TextField txt_code;

    List<Author> authorList;
    List<Category> categoryList;

    @FXML
    void btn_add_click(ActionEvent event) {
    	try {
    		// get data
        	var code = txt_code.getText();
        	var title = txt_title.getText();
        	var price = Float.parseFloat(txt_price.getText());
        	var publish_date = txt_publish.getValue();
        	
        	
        	// create obj and assign data
        	var book = new Book();
        	book.setCode(Integer.parseInt(code));
        	book.setTitle(title);
        	book.setPrice(price);
        	book.setPublish_date(publish_date);
        	
        	int author_select_index = cbo_author.getSelectionModel().getSelectedIndex();
        	int cat_select_index = cbo_category.getSelectionModel().getSelectedIndex();
        	
        	Author select_author = authorList.get(author_select_index);
        	Category select_category = categoryList.get(cat_select_index);
        	
        	book.setAuthor(select_author);
        	book.setCategory(select_category);
        	book.setCreated_by(Start.loginUser);
        	
        	// save to db
        	DatabaseHandler.saveBook(book);
        	// show message box
        	Start.showAlert(AlertType.INFORMATION, "success");
        	// reset data.
        	reset();
		} catch (Exception e) {
			Start.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Books.fxml");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {

    	System.exit(0);
    }

    @FXML
    void btn_reset_click(ActionEvent event) {

    	reset();
    }

    private void reset() {
    	txt_code.setText(null);
    	txt_title.setText(null);
    	txt_price.setText(null);
    	txt_publish.setValue(null);
    	cbo_author.getSelectionModel().clearSelection();
    	cbo_category.getSelectionModel().clearSelection();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// author list
		 authorList = DatabaseHandler.findAllAuthors();
		
		List<String> nameList = authorList.stream()
									.map(obj -> obj.getName())
									.toList();
		cbo_author.setItems(FXCollections.observableArrayList(nameList));
		
		// category list
		 categoryList = DatabaseHandler.findAllCategories();
		List<String> categoryNames = categoryList.stream()
										.map(obj -> obj.getName())
										.toList();
		cbo_category.setItems(FXCollections.observableArrayList(categoryNames));
		
	}
}
