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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
		File f = new File("/home/lucas/Desktop/file.txt");
		System.out.println(f.isDirectory());
		System.out.println(f.getPath());

		
		f = f.getParentFile();
		System.out.println(f.isDirectory());
		System.out.println(f.getPath());
	}
	
}
