package com.example.lab34;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//controller for hello2 scene
public class Hello2 implements Initializable {
    //initialize variables
    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private Button btload;
    private Connection connextion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadchart();
    }


    //creating method to load data into the table
    private void loadchart() {
        //creating variable that holds our query
        String query = "SELECT * FROM BoxOlimp2012;";
        //class for creating a chart
        XYChart.Series<String, Integer> series=new XYChart.Series<>();
        try{
            //database connection
            connextion=connect();
            //execute query and get data from it
            ResultSet rs= (ResultSet) connextion.createStatement().executeQuery(query);
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(2), rs.getInt(6)));
            }
            //populate chart with data
            barchart.getData().add(series);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //database connection
    public Connection connect() {
        String URL = "jdbc:mysql://localhost:3306/testDB";
        String USER = "root";
        String PASS = "197983hb       ";
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "197983hb");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    //initialize variables
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader2;
    //creating a method to switch from scene1 to scene2
    public void switchToScene2(ActionEvent event) throws IOException {
        //load scene2
        Parent fxmlLoader2 = FXMLLoader.load(Hello2.class.getResource("hello-view.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader2);
        //load css
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        //show scene2 to user
        stage.setScene(scene);
        stage.show();

    }


}
