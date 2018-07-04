package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.glass.ui.MenuItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import photos.Photo;
import photos.PhotoGroup;

public class MainMenuController {

	// Compiler will initialize these from FXML layout
	@FXML
	private MenuItem FileCloseMenuItem;
	@FXML
	private TextArea messageArea;
	@FXML
	private VBox photoGroupArea;

	// Need reference passed from Main to access stage
	private Stage stage;

	@FXML
	public void close(ActionEvent e) {
		stage.close();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	public void parseNewDirectory(ActionEvent e) {
		// Prompt user to choose directory
		File f = new DirectoryChooser().showDialog(null).getAbsoluteFile();
		
		ArrayList<PhotoGroup> groups = PhotoGroup.searchDirectory(f.getPath(), false);
		
		// Loop through groups
		for (PhotoGroup g : groups) {
			// Print found photos to message area
			for (Photo p : g.getPhotos())
				messageArea.appendText("\n" + p.toString());			
		}

		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PhotoGroup.fxml"));
				
		try {
			Node n = fxmlLoader.load();
			PhotoGroupController controller = fxmlLoader.getController();
			for(PhotoGroup g: groups) {
				if (g.getPhotos().size() > 5) {
					controller.setPhotoGroup(g);
					break;
				}
			}	
			photoGroupArea.getChildren().add(n);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
	}
}
