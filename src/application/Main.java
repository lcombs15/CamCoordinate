package application;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// launch(args);

		// Test directory
		File dir = new File("C:\\Users\\Lucas\\Dropbox\\Camera Uploads\\");

		// List files in directory & sort them by date last modified
		File files[] = dir.listFiles();
		Arrays.sort(files, (a, b) -> {
			return (new Date(a.lastModified())).compareTo(new Date(b.lastModified()));
		});

		Date prev = null;
		int numInGroup = 1;
		// Print everything out
		for (int i = 0; i < files.length; i++) {
			Date current = new Date(files[i].lastModified());

			long diffInMilli = -1, diffInMin = -1;
			if (prev != null) {
				diffInMilli = current.getTime() - prev.getTime();
				diffInMin = (diffInMilli / 1000) / 60;
				if (diffInMin > 15) {
					System.out.println();
					numInGroup = 1;
				} else {
					numInGroup++;
				}
			}

			System.out.println(numInGroup + ".) " + current + " " + diffInMin + "\t" + files[i]);
			prev = current;
		}
	}

}
