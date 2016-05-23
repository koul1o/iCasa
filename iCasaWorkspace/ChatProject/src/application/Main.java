package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane content;
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChatProject/src/application/UiI.fxml"));
			 loader.setRoot(this);
		        loader.setController(this);
		        loader.setClassLoader(getClass().getClassLoader());
		        loader.load();
		    
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
