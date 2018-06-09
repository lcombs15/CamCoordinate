package xml;

import com.sun.glass.ui.MenuItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController {
	@FXML
	private MenuItem FileCloseMenuItem;
	
	private Stage stage;
	
	
	@FXML
    public void closeEventHandler(ActionEvent e) {
        stage.close();
    }
	
	public void setStage(Stage stage) {
        this.stage = stage;
    }
}


