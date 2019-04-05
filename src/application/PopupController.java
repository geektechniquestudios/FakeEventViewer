package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupController
{
	private Stage popupStage;

	@FXML private TextField textEntry;
	
	public void boxTicked()
	{
		try
		{
			FXMLLoader matchingRoot = new FXMLLoader(getClass().getResource("matchingCaptcha.fxml"));
			Parent rootParent = matchingRoot.load();
			Scene matchingScene = new Scene(rootParent);
			
			popupStage.setScene(matchingScene);
			
			MatchingController.setPopupStage(popupStage);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPopupStage(Stage someStage)
	{
		popupStage = someStage;
	}

}
