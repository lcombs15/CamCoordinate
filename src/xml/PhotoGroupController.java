package xml;

import java.net.URI;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PhotoGroupController {
	// Compiler will initialize these from FXML layout
		@FXML
		private ImageView previewThumbnail;
		
		@FXML
		private BorderPane mainArea;
		
		@FXML
		private Text groupTitle;
		
		@FXML
		private ButtonBar groupMenu;
		
		public void setPreviewThumbnail(URI imgPath) {
			this.previewThumbnail.setImage(new Image(imgPath.toString()));
			this.previewThumbnail.setPreserveRatio(true);
			this.previewThumbnail.fitHeightProperty().bind(mainArea.heightProperty().subtract(groupMenu.heightProperty()));
			this.previewThumbnail.fitWidthProperty().bind(mainArea.widthProperty());
			
		}
}
