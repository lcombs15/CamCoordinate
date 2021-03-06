package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout.Alignment;

import com.sun.glass.ui.MenuItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
	private GridPane gridArea;

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

		PhotoGroupController controller = new PhotoGroupController();
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("PhotoGroup.fxml"));
		fxmlLoader.setController(controller);

		try {
			Node n = fxmlLoader.load();			
			gridArea.add(n,0,0);
			
			// Allow node to re-size automatically
			GridPane.setHgrow(n, Priority.ALWAYS);
			GridPane.setVgrow(n, Priority.ALWAYS);
			
			// Align center
			GridPane.setHalignment(n, HPos.LEFT);
			GridPane.setValignment(n, VPos.TOP);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<PhotoGroup> groups = PhotoGroup.searchDirectory(f.getPath(), false);
		
		// Loop through groups
		for (PhotoGroup g : groups) {
			// Print found photos to message area
			for (Photo p : g.getPhotos())
				messageArea.appendText("\n" + p.toString());			
		}
		
		controller.setPreviewThumbnail(groups.get(0).getPhotos().get(0).getFile().toURI());
	}
}
