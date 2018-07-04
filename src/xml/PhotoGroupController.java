package xml;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import photos.Photo;
import photos.PhotoGroup;

public class PhotoGroupController {
	// Compiler will initialize these from FXML layout		
		@FXML
		private BorderPane controlArea;
		
		@FXML
		private Text groupTitle;
		
		@FXML
		private ButtonBar menu;
		
		@FXML
		private HBox rootHBox;
		
		private PhotoGroup photos;
		
		public void setPhotoGroup(PhotoGroup photos) {
			this.photos = photos;
			
			
			
			for(Photo p: this.photos.getPhotos()) {
				ImageView photoNode;
				photoNode = new ImageView();
				photoNode.setImage(new Image(p.getFile().toURI().toString()));
				photoNode.setPreserveRatio(true);
				photoNode.fitHeightProperty().bind(rootHBox.heightProperty());
				photoNode.fitWidthProperty().bind(rootHBox.widthProperty().multiply(.20));
				rootHBox.getChildren().add(photoNode);
			}
			
			controlArea.prefHeightProperty().bind(rootHBox.heightProperty());
		}
		
}
