package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xml.MainMenuController;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(MainMenuController.class.getResource("MainMenu.fxml"));

			Scene scene = new Scene(fxmlLoader.load());

			final MainMenuController controller = fxmlLoader.getController();
			controller.setStage(primaryStage);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CamCoordinate");
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

		/*
		 * Find photos testing ArrayList<PhotoGroup> groups =
		 * PhotoGroup.searchDirectory("/home/lucas/Desktop/photos test/", true);
		 * 
		 * for (PhotoGroup pg : groups) { ArrayList<Photo> photos = pg.getPhotos();
		 * 
		 * if (photos.size() > 100) { System.out.println("Group: " + photos.size()); for
		 * (Photo p : photos) { System.out.println("\t" + p); } pg.moveToDir(new
		 * File("/home/lucas/Desktop/dest")); photos = pg.getPhotos(); for (Photo p :
		 * photos) { System.out.println("\t\t" + p); } } }
		 * 
		 */
		System.exit(0);
	}

}
