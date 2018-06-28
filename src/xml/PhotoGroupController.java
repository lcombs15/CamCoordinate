package xml;

import java.net.URI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PhotoGroupController {
	// Compiler will initialize these from FXML layout
		@FXML
		private ImageView previewThumbnail;
		
		@FXML
		private BorderPane mainArea;
		
		public void setPreviewThumbnail(URI imgPath) {
			this.previewThumbnail.setImage(new Image(imgPath.toString()));
			this.previewThumbnail.fitWidthProperty().bind(mainArea.widthProperty());
			this.previewThumbnail.fitHeightProperty().bind(mainArea.heightProperty());
			
			this.previewThumbnail.setPreserveRatio(true);
		}
}
