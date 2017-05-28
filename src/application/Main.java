package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    private AnchorPane rootLayout;
    private Stage primaryStage;

    public ObservableList<Customer> customerData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        try {




            customerData.add(new Customer("45", "2017"));
            customerData.add(new Customer("45", "2016"));
            customerData.add(new Customer("225", "2012"));
            customerData.add(new Customer("85", "2017"));
            customerData.add(new Customer("85", "2015"));
            customerData.add(new Customer("85", "2011"));
            customerData.add(new Customer("451", "2017"));

            customerData.add(new Customer("45", "2016"));
            customerData.add(new Customer("450", "2017"));
            customerData.add(new Customer("450", "2012"));
            customerData.add(new Customer("450", "2014"));
            customerData.add(new Customer("10", "2014"));
            customerData.add(new Customer("30", "2014"));
            customerData.add(new Customer("50", "2015"));
            customerData.add(new Customer("60", "2014"));
            customerData.add(new Customer("450", "2014"));
            customerData.add(new Customer("450", "2014"));
            customerData.add(new Customer("999", "2016"));
            customerData.add(new Customer("999", "2015"));






            this.primaryStage = primaryStage;


            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("TableView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);

            TableViewController controller = loader.getController();
            controller.setMain(this);

            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
