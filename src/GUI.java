import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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

        Label labelOverskrift = new Label("Digital media management system");
        labelOverskrift.setStyle("-fx-border-color: #ff241c; -fx-border-width: 5; -fx-font: 20px Tahoma; -fx-font-weight: bold");
        labelOverskrift.setPadding(new Insets(10));

        hBox1.getChildren().addAll(labelOverskrift);
        borderPane.setTop(hBox1);

        borderPane.setCenter(textArea);
        BorderPane.setMargin(textArea, new Insets(5));

        HBox hBox2 = new HBox();
        hBox2.setSpacing(5);
        hBox2.setPadding(new Insets(5));

        Label labelVisFilnavne = new Label("Vis folderindhold");
        TextField textFieldVisFilnavne = new TextField("Indtast foldernavn");
        Button buttonFilnavne = new Button("Vis filnavne");
        Label blank = new Label();

        Label labelVisFil = new Label("Vis video eller billede");
        TextField textFieldVisFil = new TextField("Indtast filnavn");
        Button buttonVisFil = new Button("Vis mediefil");

        VBox vBoxRight = new VBox();
        vBoxRight.getChildren().addAll(labelVisFilnavne, textFieldVisFilnavne, buttonFilnavne, blank, labelVisFil, textFieldVisFil, buttonVisFil);
        borderPane.setRight(vBoxRight);

        // Buttons - Right

        buttonFilnavne.setOnAction(e -> {
            if (textFieldVisFilnavne.getText().length() == 0) {
                textArea.setText("Indtast venligst foldernavn.");
            } else {
                ArrayList<String> list = mediaManager.readMediaFolder(textFieldVisFilnavne.getText());
                String saver = "";

                for (String f : list) {
                    saver += f + "\r\n";
                }

                textArea.setText(saver);
            }
        });

        buttonVisFil.setOnAction(e -> {
            Stage stage = new Stage();
            String filtype = textFieldVisFil.getText().substring(textFieldVisFil.getText().lastIndexOf('.') + 1);
            StackPane pane = new StackPane();

            if (filtype.equals("mp4") || filtype.equals("m4v") || filtype.equals("mov")) {
                pane.getChildren().clear();
                Media media = new Media(getClass().getResource(textFieldVisFil.getText()).toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                MediaView mediaView = new MediaView(mediaPlayer);
                mediaView.setManaged(false);
//                mediaView.fitWidthProperty().bind(stage.widthProperty());
//                mediaView.fitHeightProperty().bind(stage.heightProperty());
                pane.getChildren().add(mediaView);
            }

            if (filtype.equals("jpg") || filtype.equals("png") || filtype.equals("gif")) {
                pane.getChildren().clear();
                Image image = new Image(getClass().getResourceAsStream(textFieldVisFil.getText()));
                ImageView imageView = new ImageView(image);
                pane.getChildren().add(imageView);
            }

            Scene scene = new Scene(pane);
            stage.setTitle("Media"); // Set the stage title
            stage.setScene(scene); // Place the scene in the stage
            stage.show(); // Display the stage
        });

        // Left node
        ScrollPane scrollPaneLeft = new ScrollPane();
        scrollPaneLeft.setPadding(new Insets(0, 5, 0, 5));
        scrollPaneLeft.setPrefWidth(200);
        VBox vBoxLeft = new VBox();

        Label labelOpretVideo = new Label("Opret video");
        TextField textFieldOpretVideo1 = new TextField("Indtast filtype");
        TextField textFieldOpretVideo2 = new TextField("Indtast længde");
        TextField textFieldOpretVideo3 = new TextField("Indtast opløsning");
        TextField textFieldOpretVideo4 = new TextField("Indtast fotograf");
        Button buttonOpretVideo = new Button("Opret video");

        Label labelOpretBillede = new Label("Opret billede");
        TextField textFieldOpretBillede1 = new TextField("Indtast filtype");
        TextField textFieldOpretBillede2 = new TextField("Indtast bredde i pixels");
        TextField textFieldOpretBillede3 = new TextField("Indtast højde i pixels");
        TextField textFieldOpretBillede4 = new TextField("Indtast fotograf");
        Button buttonOpretBillede = new Button("Opret billede");

        Label labelOpretArtikel = new Label("Opret artikel");
        TextField textFieldOpretArtikel1 = new TextField("Indtast forfatter");
        TextField textFieldOpretArtikel2 = new TextField("Indtast artikeltekst");
        TextField textFieldOpretArtikel3 = new TextField("Indtast tilhørende billede");
        Button buttonOpretArtikel = new Button("Opret artikel");

        Label labelRetVideo = new Label("Ret video");
        TextField textFieldRetVideo1 = new TextField("Indtast video-ID");
        ComboBox<String> comboBoxRetVideo = new ComboBox<>();
        comboBoxRetVideo.getItems().addAll("Filtype", "Laengde", "Oploesning", "Fotograf");
        comboBoxRetVideo.setValue("Filtype");
        comboBoxRetVideo.setEditable(false);
        comboBoxRetVideo.setPrefWidth(150);
        TextField textFieldRetVideo2 = new TextField("Indtast ny værdi");
        Button buttonRetVideo = new Button("Ret video");

        Label labelRetBillede = new Label("Ret billede");
        TextField textFieldRetBillede1 = new TextField("Indtast billede-ID");
        ComboBox<String> comboBoxRetBillede = new ComboBox<>();
        comboBoxRetBillede.getItems().addAll("Filtype", "Bredde_i_pixels", "Hoejde_i_pixels", "Fotograf");
        comboBoxRetBillede.setValue("Filtype");
        comboBoxRetBillede.setEditable(false);
        comboBoxRetBillede.setPrefWidth(150);
        TextField textFieldRetBillede2 = new TextField("Indtast ny værdi");
        Button buttonRetBillede = new Button("Ret billede");

        Label labelRetArtikel = new Label("Ret artikel");
        TextField textFieldRetArtikel1 = new TextField("Indtast artikel-ID");
        ComboBox<String> comboBoxRetArtikel = new ComboBox<>();
        comboBoxRetArtikel.getItems().addAll("Forfatter", "Artikeltekst", "Tilhoerende_billede");
        comboBoxRetArtikel.setValue("Forfatter");
        comboBoxRetArtikel.setEditable(false);
        comboBoxRetArtikel.setPrefWidth(150);
        TextField textFieldRetArtikel2 = new TextField("Indtast ny værdi");
        Button buttonRetArtikel = new Button("Ret artikel");

        Label labelSletVideo = new Label("Slet video");
        TextField textFieldSletVideo = new TextField("Indtast video-ID");
        Button buttonSletVideo = new Button("Slet video");

        Label labelSletBillede = new Label("Slet billede");
        TextField textFieldSletBillede = new TextField("Indtast billede-ID");
        Button buttonSletBillede = new Button("Slet billede");

        Label labelSletArtikel = new Label("Slet artikel");
        TextField textFieldSletArtikel = new TextField("Indtast artikel-ID");
        Button buttonSletArtikel = new Button("Slet artikel");

        Label blank1 = new Label();
        Label blank2 = new Label();
        Label blank3 = new Label();
        Label blank4 = new Label();
        Label blank5 = new Label();
        Label blank6 = new Label();
        Label blank7 = new Label();
        Label blank8 = new Label();

        vBoxLeft.getChildren().addAll(labelOpretVideo, textFieldOpretVideo1, textFieldOpretVideo2, textFieldOpretVideo3, textFieldOpretVideo4, buttonOpretVideo, blank1, labelOpretBillede, textFieldOpretBillede1, textFieldOpretBillede2, textFieldOpretBillede3,
                textFieldOpretBillede4, buttonOpretBillede, blank2, labelOpretArtikel, textFieldOpretArtikel1, textFieldOpretArtikel2, textFieldOpretArtikel3, buttonOpretArtikel, blank3, labelRetVideo, textFieldRetVideo1, comboBoxRetVideo, textFieldRetVideo2,
                buttonRetVideo, blank4, labelRetBillede, textFieldRetBillede1, comboBoxRetBillede, textFieldRetBillede2, buttonRetBillede, blank5, labelRetArtikel, textFieldRetArtikel1, comboBoxRetArtikel, textFieldRetArtikel2, buttonRetArtikel, blank6, labelSletVideo,
                textFieldSletVideo, buttonSletVideo, blank7, labelSletBillede, textFieldSletBillede, buttonSletBillede, blank8, labelSletArtikel, textFieldSletArtikel, buttonSletArtikel);

        scrollPaneLeft.setContent(vBoxLeft);
        borderPane.setLeft(scrollPaneLeft);

        // Buttons - Left

        buttonOpretVideo.setOnAction(e -> {
            Video video = new Video(textFieldOpretVideo1.getText(), textFieldOpretVideo2.getText(), textFieldOpretVideo3.getText(), textFieldOpretVideo4.getText());
            mediaManager.database(video);
            textArea.setText("Video oprettet.");
        });

        buttonOpretBillede.setOnAction(e -> {
            Billede billede = new Billede(textFieldOpretBillede1.getText(), Integer.parseInt(textFieldOpretBillede2.getText()), Integer.parseInt(textFieldOpretBillede3.getText()), textFieldOpretBillede4.getText());
            mediaManager.database(billede);
            textArea.setText("Billede oprettet.");
        });

        buttonOpretArtikel.setOnAction(e -> {
            Artikel artikel = new Artikel(textFieldOpretArtikel1.getText(), textFieldOpretArtikel1.getText(), textFieldOpretArtikel1.getText());
            mediaManager.database(artikel);
            textArea.setText("Artikel oprettet.");
        });

        buttonOpretVideo.setOnAction(e -> {
            Video video = new Video(textFieldOpretVideo1.getText(), textFieldOpretVideo2.getText(), textFieldOpretVideo3.getText(), textFieldOpretVideo4.getText());
            mediaManager.database(video);
            textArea.setText("Video oprettet.");
        });

        buttonRetVideo.setOnAction(e -> {
            mediaManager.rettelse(Integer.parseInt(textFieldRetVideo1.getText()), "Video", comboBoxRetVideo.getValue(), textFieldRetVideo2.getText());
            textArea.setText("Video rettet.");
        });

        buttonRetBillede.setOnAction(e -> {
            mediaManager.rettelse(Integer.parseInt(textFieldRetBillede1.getText()), "Billede", comboBoxRetBillede.getValue(), textFieldRetBillede2.getText());
            textArea.setText("Billede rettet.");
        });

        buttonRetArtikel.setOnAction(e -> {
            mediaManager.rettelse(Integer.parseInt(textFieldRetArtikel1.getText()), "Artikel", comboBoxRetArtikel.getValue(), textFieldRetArtikel2.getText());
            textArea.setText("Artikel rettet.");
        });

        buttonSletVideo.setOnAction(e -> {
            mediaManager.slet(Integer.parseInt(textFieldSletVideo.getText()), "Video");
            textArea.setText("Video slettet.");
        });

        buttonSletBillede.setOnAction(e -> {
            mediaManager.slet(Integer.parseInt(textFieldSletBillede.getText()), "Billede");
            textArea.setText("Billede slettet.");
        });

        buttonSletArtikel.setOnAction(e -> {
            mediaManager.slet(Integer.parseInt(textFieldSletArtikel.getText()), "Artikel");
            textArea.setText("Artikel slettet.");
        });

        // Right node


        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 1000, 500);
        primaryStage.setTitle("Digital media management system"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
