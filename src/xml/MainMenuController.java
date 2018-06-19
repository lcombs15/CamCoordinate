package xml;

import java.io.File;

import com.sun.glass.ui.MenuItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
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

		// Print found photos to message area
		for (PhotoGroup g : PhotoGroup.searchDirectory(f.getPath(), false)) {
			for (Photo p : g.getPhotos())
				messageArea.appendText("\n" + p.toString());
		}
	}
}
