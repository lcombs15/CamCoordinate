package application;

import java.util.ArrayList;

import Photos.Photo;
import Photos.PhotoGroup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../Home.fxml")));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CamCoordinate");
			primaryStage.show();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
		
		ArrayList<PhotoGroup> groups = PhotoGroup.searchDirectory("/home/lucas/Dropbox/Camera Uploads/", true);
		
		for(PhotoGroup pg: groups) {
			System.out.println("Group: ");
			ArrayList<Photo> photos = pg.getPhotos();
			for(Photo p: photos) {
				System.out.println("\t" + p);
			}
		}
		
		System.exit(0);
	}
	
}
