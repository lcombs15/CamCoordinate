import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	public static final String APPLICATION_TITLE = "CamCoordinate";
	
	public static void main(String[] args) {
		System.out.println("File list:");
		File f = new File("C:\\Users\\Lucas\\Dropbox\\Camera Uploads\\");
		
		for(File file: f.listFiles()) {
			System.out.println(file.toString());
		}
		
		Application.launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		
		//Setup Bottom
		Button goButton = new Button("Go");
		root.setBottom(goButton);
		
		//Setup Top
		GridPane gp = new GridPane();
		root.setCenter(gp);
		//gp.prefWidthProperty().bind(root.widthProperty());
		gp.setId("centerGrid");
		
		Button pickSourceButton, pickDestinationButton;
		pickSourceButton = new Button("Pick Source");
		pickDestinationButton = new Button("Pick Destination");
		
		Label sourceLabel = new Label(), destinationLabel = new Label();
		
		gp.add(pickSourceButton, 0, 0);
			pickSourceButton.prefWidthProperty().bind(gp.widthProperty().divide(2));
		gp.add(sourceLabel, 0, 1);
		gp.add(pickDestinationButton, 1, 0);
			pickDestinationButton.prefWidthProperty().bind(gp.widthProperty().divide(2));
		gp.add(destinationLabel, 1, 1);
		
		gp.vgapProperty().bind(gp.heightProperty().multiply(.10));
		
		gp.hgapProperty().bind(gp.widthProperty().multiply(.10));
		gp.setPadding(new Insets(20));
		
		Scene scene = new Scene(root,1000,700);
			
		scene.getStylesheets().add("style.css");
		stage.setTitle(APPLICATION_TITLE);
		stage.setScene(scene);
		stage.show();
	}

}
