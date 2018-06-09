package application;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import photos.Photo;
import photos.PhotoGroup;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// launch(args);

		/* Find photos testing
		ArrayList<PhotoGroup> groups = PhotoGroup.searchDirectory("/home/lucas/Desktop/photos test/", true);

		for (PhotoGroup pg : groups) {
			ArrayList<Photo> photos = pg.getPhotos();

			if (photos.size() > 100) {
				System.out.println("Group: " + photos.size());
				for (Photo p : photos) {
					System.out.println("\t" + p);
				}
				pg.moveToDir(new File("/home/lucas/Desktop/dest"));
				photos = pg.getPhotos();
				for (Photo p : photos) {
					System.out.println("\t\t" + p);
				}
			}
		}

	*/
		System.exit(0);
	}

}
