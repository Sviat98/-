package sample;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.security.auth.callback.Callback;
import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window;
        window = primaryStage;
        window.setTitle("Lab 1");
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setVgap(10);
        gridpane.setHgap(12);

        Label nameLabel = new Label("Enter text: ");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField textInput1 = new TextField();
        GridPane.setConstraints(textInput1, 1, 1);
        int houseNumber,houseNum;


        //  entered_text1 = textInput1.getText();

        ComboBox<String> comboBox = new ComboBox<>();

        Alert alert = new Alert(AlertType.ERROR);

        Button button = new Button("press!");
        button.setOnAction((ActionEvent e) ->{
            String entered_item = textInput1.getText();


            if (comboBox.getItems().contains(entered_item)){
              alert.setContentText("This Item already exists");
              alert.showAndWait();
            }

            else comboBox.getItems().addAll(entered_item);

        } );

        GridPane.setConstraints(button, 1, 3);


        alert.setContentText("You have selected incorrect option");


        Button button1 = new Button("Press");
        GridPane.setConstraints(button1, 1, 8);

        Button button2 = new Button(" Don't Press");
        GridPane.setConstraints(button2, 2, 8);

        TextField textInput2 = new TextField();

        GridPane.setConstraints(textInput2, 1, 7);

        button1.setOnAction ((ActionEvent e) -> {
            button2.setText(textInput2.getText());

        });

       button2.setOnAction((ActionEvent e) ->{
           String button_first_to_second = button1.getText();
           String button_second_to_first = button2.getText();

           button2.setText(button_first_to_second);
           button1.setText(button_second_to_first);

        });

        TextField textInput3 = new TextField();
        GridPane.setConstraints(textInput3, 1, 11);

        ToggleGroup group = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("1");
        GridPane.setConstraints(radioButton1,0,12);
        radioButton1.setToggleGroup(group);

        RadioButton radioButton2 = new RadioButton("2");
        GridPane.setConstraints(radioButton2,0,13);
        radioButton2.setToggleGroup(group);


        RadioButton radioButton3 = new RadioButton("3");
        GridPane.setConstraints(radioButton3,0,14);
        radioButton3.setToggleGroup(group);

        Button button3 = new Button("Press");
        GridPane.setConstraints(button3, 1, 13);

       // group.getChildren().addAll(radioButton1,radioButton2,radioButton3);
       button3.setOnAction((ActionEvent e) ->{
           if(textInput3.getText().equals(radioButton1.getText()))
               radioButton1.setSelected(true);
           else if (textInput3.getText().equals(radioButton2.getText()))
               radioButton2.setSelected(true);
           else if (textInput3.getText().equals(radioButton3.getText()))
               radioButton3.setSelected(true);


           else alert.showAndWait();


       });

       TextField textInput4 = new TextField();
       GridPane.setConstraints(textInput4, 1, 19);


        CheckBox checkBox1 = new CheckBox("1");
        GridPane.setConstraints(checkBox1, 0, 20);

        CheckBox checkBox2 = new CheckBox("2");
        GridPane.setConstraints(checkBox2, 0, 21);

        CheckBox checkBox3 = new CheckBox("3");
        GridPane.setConstraints(checkBox3, 0, 22);

        Button button4 = new Button("Press");
        GridPane.setConstraints(button4, 1, 22);

        button4.setOnAction((ActionEvent e)->{

            if(checkBox1.getText().equals(textInput4.getText()))
                checkBox1.fire();


            if(checkBox2.getText().equals(textInput4.getText()))
                checkBox2.fire();


            if (checkBox3.getText().equals(textInput4.getText()))
                checkBox3.fire();

            if (!checkBox1.getText().equals(textInput4.getText())) {
              if  (!checkBox2.getText().equals(textInput4.getText())) {
                   if (!checkBox3.getText().equals(textInput4.getText())) {
                        alert.showAndWait();
                    }
                }
            }



        });



        TextField textInput5 = new TextField();
        GridPane.setConstraints(textInput5,1,24);

        TableView <TableData> table = new TableView <TableData>();
        GridPane.setConstraints(table, 1,25);

        TableColumn <TableData,String> first_col = new TableColumn <TableData,String> ("Column A");
        first_col.setCellValueFactory(new PropertyValueFactory<TableData,String>("col_a"));
        first_col.setMinWidth(150);

        TableColumn <TableData,String> second_col = new TableColumn <TableData,String> ("Column B");
        second_col.setCellValueFactory(new PropertyValueFactory<TableData,String>("col_b"));
        second_col.setMinWidth(150);


        table.getColumns().addAll(first_col,second_col);

        ObservableList<TableData> tableRows  = FXCollections.observableArrayList();
        table.setItems(tableRows);


        //String tableText = textInput5.getText();

        Button button5_1 = new Button("Add to col. A");
        GridPane.setConstraints(button5_1,0,27);
        button5_1.setOnAction((ActionEvent e)->{
            String tableText = textInput5.getText();


          TableData newRow = new TableData(tableText,"");
          tableRows.add(newRow);



        });


        Button button5_2 = new Button("From A to B");
        GridPane.setConstraints(button5_2,1,27);
        button5_2.setOnAction((ActionEvent e)->{
            String tableText = textInput5.getText();
           TableData newRow = new TableData("",tableText);
           TableData selectedItem = table.getSelectionModel().getSelectedItem();

            table.getItems().remove(selectedItem);
           table.getItems().add(newRow);

        });

        Button button5_3 = new Button("From B to A");
        GridPane.setConstraints(button5_3,2,27);
        button5_3.setOnAction((ActionEvent e)->{
            String tableText = textInput5.getText();

            TableData newRow = new TableData(tableText,"");
            TableData selectedItem = table.getSelectionModel().getSelectedItem();
            tableRows.add(newRow);
            table.getItems().remove(selectedItem);


        });



        gridpane.getChildren().addAll(nameLabel, textInput1, textInput2, textInput3, button, button1,
                checkBox1, checkBox2, checkBox3, textInput4, button2, button3,button4, comboBox,
                radioButton1,radioButton2, radioButton3,textInput5,button5_1,button5_2,button5_3, table);

        Scene scene = new Scene( gridpane, 500, 1000);
        window.setScene(scene);

        window.show();
    }



   /* @Override
    public void handle(ActionEvent event) {
        if(event.getSource()== button2){

    }
    }
*/

    private boolean isNumber (TextField input, String message) {
    try {
        int age = Integer.parseInt(input.getText());
        System.out.println("The user is " + age + "years old.");
        return true;}

    catch (NumberFormatException e) {
        System.out.println("error!!!");
        return false;
    }
    }

    public static void main(String[] args) { launch(args);
    }

}
