package com.example.lab34;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//controller for hello-view scene
public class HelloController extends Hello2 implements Initializable {

//initialize variables
    @FXML
    private Label label;
    @FXML
    private TableView<Boxinfo> table;
    @FXML
    private TableColumn<Boxinfo, Integer> rank;
    @FXML
    private TableColumn<Boxinfo, String> countrycol;
    @FXML
    private TableColumn<Boxinfo, Integer> gold;
    @FXML
    private TableColumn<Boxinfo, Integer> silver;
    @FXML
    private TableColumn<Boxinfo, Integer> bronze;
    @FXML
    private TableColumn<Boxinfo, Integer> medalscol;
    @FXML
    private Button btload;

    //Initialize observable list to hold out database data
    private ObservableList<Boxinfo>data;
    //initialize variable for database connection
    private Connection dc;

    public HelloController() {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //method to load data from mysql database to tableview
    @FXML
    private void loadData(ActionEvent event) {
        try {
            //database connection
            dc = connect();
            //observable list for holding out database data
            data = FXCollections.observableArrayList();
            //getting data from mysql database
            ResultSet rs = dc.createStatement().executeQuery("SELECT * FROM BoxOlimp2012;");
            while (rs.next()) {
                data.add(new Boxinfo(rs.getInt("rating"), rs.getString("country"), rs.getInt("gold"), rs.getInt("silver"), rs.getInt("bronze"), rs.getInt("total")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //
        //populate table with data
        rank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        gold.setCellValueFactory(new PropertyValueFactory<>("gold"));
        silver.setCellValueFactory(new PropertyValueFactory<>("silver"));
        bronze.setCellValueFactory(new PropertyValueFactory<>("medals"));
        medalscol.setCellValueFactory(new PropertyValueFactory<>("medals"));
        table.setItems(null);
        table.setItems(data);
    }

    //initialize variables
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader2;
    //creating a method to switch from scene2 to scene1
    public void switchToScene1(ActionEvent event) throws IOException {
        //load scene1
        Parent fxmlLoader2 = FXMLLoader.load(Hello2.class.getResource("hello2.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader2);
        //load css
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        //show scene1 to user
        stage.setScene(scene);
        stage.show();
    }
}