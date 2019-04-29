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

/*
 * Designed by Terry Dorsey || geekTechniqueStudios
 * Massive thanks go out to:
 * 
 * 		stackOverflow user Slaw for solving so many of the challenges I had. Some of these problems were very difficult, 
 * 		and I couldn't have made this project without help.
 * 
 * 			Slaw's Account: https://stackoverflow.com/users/6395627/slaw
 * 			Programming problems solved:
 * 				https://stackoverflow.com/questions/55153177/javafx-refer-to-collapsed-and-expanded-accordion-states-in-css
 * 				https://stackoverflow.com/questions/55093764/javafx-how-to-disable-scrollbars-in-tableview
 * 				https://stackoverflow.com/questions/55082933/javafx-how-to-move-drop-down-arrow-in-titledpane-to-be-on-right
 * 				https://stackoverflow.com/questions/54953447/javafx-how-do-i-hide-the-drop-down-arrow-in-a-treeview
 * 				
 * 
 * 		stackOverflow user VGR also helped me solve a major glitch.
 * 			VGR's Account: https://stackoverflow.com/users/1831987/vgr
 * 			Programming problem solved: https://stackoverflow.com/questions/55271334/javafx-tableview-cell-pixelates-imageview-how-do-i-undo-transform
 * 
 * As a disclaimer - These people did not explicitly know what I was working on.
 * However, I feel they deserve credit. 
 */


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
