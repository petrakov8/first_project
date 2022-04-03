/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jekichoid
 */
public class FXMLController implements Initializable {

   @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<info, String> col_class;

    @FXML
    private TableColumn<info, String> coll_info;
    
    @FXML
    private TableColumn<info, Integer> col_id;

    @FXML
    private TableColumn<info, String> col_kind;

    @FXML
    private TextField filterField;

    @FXML
    private TableView<info> table_info;
    
    ObservableList<info> listM;
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    @FXML
    void Select(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_id.setCellValueFactory(new PropertyValueFactory<info,Integer>("idclass"));
        col_kind.setCellValueFactory(new PropertyValueFactory<info,String>("kindclass"));
        col_class.setCellValueFactory(new PropertyValueFactory<info,String>("nameclass"));
        coll_info.setCellValueFactory(new PropertyValueFactory<info,String>("infoclass"));
        
        listM = DatabaseConnection.getDatainfo();
        table_info.setItems(listM);
        
        FilteredList<info> filteredData = new FilteredList<>(listM, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getKindclass().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (person.getNameclass().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		}); 
        SortedList<info> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(table_info.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table_info.setItems(sortedData);
 
   
    }
}
