import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        MediaManager mediaManager = new MediaManager();

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 5, 10));

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);

        Label label1 = new Label("Digital media management system");
        label1.setStyle("-fx-border-color: #2f60ff; -fx-border-width: 5; -fx-font: 20px Tahoma; -fx-font-weight: bold");
        label1.setPadding(new Insets(10));

        hBox1.getChildren().addAll(label1);
        borderPane.setTop(hBox1);

        borderPane.setCenter(textArea);
        BorderPane.setMargin(textArea, new Insets(5));

        HBox hBox2 = new HBox();
        hBox2.setSpacing(5);
        hBox2.setPadding(new Insets(5));

        Label label2 = new Label("Indtast foldernavn:");
        TextField textField = new TextField();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label2, textField);

        Font font = new Font("Courier New", 15);
        Button button = new Button("Vis filer");
        button.setFont(font);
        button.setPrefSize(150, 40);

        hBox2.getChildren().addAll(vBox, button);
        hBox2.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox2);

        button.setOnAction(e -> {
            if (textField.getText().length() == 0) {
                textArea.setText("Indtast venligst foldernavn.");
            } else {
                ArrayList<String> list = mediaManager.readMediaFolder(textField.getText());
                String saver = "";

                for (String f : list) {
                    saver += f + "\r\n";
                }

                textArea.setText(saver);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Readme editor"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
