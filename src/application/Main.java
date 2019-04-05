package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
			Platform.setImplicitExit(false);

			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()//makes it impossible to close window without task manager
			{
			    @Override
			    public void handle(WindowEvent event) 
			    {
			        event.consume();
			    }
			});
						
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
