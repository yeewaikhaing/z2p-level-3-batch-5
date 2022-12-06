package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Author implements Initializable{

	@FXML
    private TableColumn<com.mmit.model.Author, LocalDate> col_birthday;

    @FXML
    private TableColumn<com.mmit.model.Author, String> col_created_by;

    @FXML
    private TableColumn<com.mmit.model.Author, Integer> col_id;

    @FXML
    private TableColumn<com.mmit.model.Author, String> col_name;

    @FXML
    private TableColumn<com.mmit.model.Author, String> col_township;

    @FXML
    private TableView<com.mmit.model.Author> tbl_authors;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_township;
    
    com.mmit.model.Author selected_obj = new com.mmit.model.Author();

    @FXML
    void btn_add_click(ActionEvent event) {
    	try {
    		// get data from input
        	var name = txt_name.getText();
        	var birthday = txt_birthday.getValue();
        	var native_town = txt_township.getText();
        	
        	// create new author object
        	var author = new com.mmit.model.Author();
        	author.setBirthday(birthday);
        	author.setName(name);
        	author.setNativeTown(native_town);
        	author.setCreated_by(Start.loginUser);
        	// save to db
        	DatabaseHandler.saveAuthor(author);
        	Start.showAlert(AlertType.INFORMATION, "Success");
        	
        	// clear old data
        	txt_birthday.setValue(null);
        	txt_name.setText(null);
        	txt_name.setText(null);
        	
        	loadAuthors();
        	
		} catch (Exception e) {
			Start.showAlert(AlertType.ERROR	, e.getMessage());
		}
    }

    private void loadAuthors() {
    	List<com.mmit.model.Author> list = DatabaseHandler.findAllAuthors();
		// set data to table
		tbl_authors.setItems(FXCollections.observableArrayList(list));
		
	}

	@FXML
    void btn_back_click(ActionEvent event) throws IOException {

    	Start.changeScene("view/Main.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) {
    	Optional<ButtonType> result = Start.showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
    	if(result.get() == ButtonType.OK) {
    		DatabaseHandler.deleteAuthorById(selected_obj.getId());
    		loadAuthors();
    	}
    }

    @FXML
    void btn_edit_click(ActionEvent event) {
    	try {
    		// change new data
        	selected_obj.setBirthday(txt_birthday.getValue());
        	selected_obj.setName(txt_name.getText());
        	selected_obj.setNativeTown(txt_township.getText());
       
        	// update to db
        	DatabaseHandler.updateAuthor(selected_obj);
        	Start.showAlert(AlertType.INFORMATION, "update success");
        	// reload data
        	loadAuthors();
		} catch (Exception e) {
			Start.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id")); // getId
		col_name.setCellValueFactory(new PropertyValueFactory<>("name")); // getName
		col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("entryBy")); // 
		col_township.setCellValueFactory(new PropertyValueFactory<>("nativeTown"));
		
		loadAuthors();
		
		tbl_authors.getSelectionModel().selectedItemProperty()
			.addListener(
			(obs, old_select, new_select) -> {
				if(new_select != null) {
					selected_obj = tbl_authors.getSelectionModel().getSelectedItem();
					txt_birthday.setValue(selected_obj.getBirthday());
					txt_name.setText(selected_obj.getName());
					txt_township.setText(selected_obj.getNativeTown());
				}
			}
		);
	}
}
