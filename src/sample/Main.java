package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {



    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    Label response;
    public void start(Stage myStage)
    {
        myStage.setTitle("List View Demo");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode,300,300);
        myStage.setScene(scene);
        response = new Label("Select Transport Type");
        ObservableList<String> trasnsportTypes= FXCollections.observableArrayList("Train","Car","Plane","Bicycle","Walking");
        final ListView<String> lvTransport = new ListView<String>(trasnsportTypes);
        lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvTransport.setPrefSize(80,80);
        MultipleSelectionModel<String> lvSelModel =lvTransport.getSelectionModel();
        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String selItems="";
                ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
                for (int i=0;i<selected.size();i++)
                    selItems+="\n      "+selected.get(i);
                response.setText("All Transports Selected : "+selItems);
            }
        });
        rootNode.getChildren().addAll(lvTransport,response);
        myStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
