package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			primaryStage.setTitle("Event Viewer");
			primaryStage.setAlwaysOnTop(true);
			primaryStage.getIcons().add(new Image("/imageAssets/icon.png"));
			//primaryStage.setMaximized(true); // does EV start full screen normally?
			
			FXMLLoader root = new FXMLLoader(getClass().getResource("EventViewer.fxml"));
			Parent rootParent = root.load();
			Scene scene = new Scene(rootParent);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			EventViewerController rootPaneController = (EventViewerController) root.getController();
			rootPaneController.setPrimaryStage(primaryStage);
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
