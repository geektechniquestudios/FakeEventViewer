package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupController implements Initializable
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
	
	
//	public void verifyWasHit(ActionEvent action)
//	{
//		try
//		{
//			FXMLLoader writingRoot = new FXMLLoader(getClass().getResource("writingCaptcha.fxml"));
//			Parent rootParent = writingRoot.load();
//			Scene writingScene = new Scene(rootParent);
//			
//			popupStage.setScene(writingScene);
//
//		}
//		catch(Exception e)
//		{
//			System.out.println("point of failure");
//			e.printStackTrace();
//		}
//	}

//	public void verifyWasHit2()
//	{
//		try
//		{
//			FXMLLoader writingRoot2 = new FXMLLoader(getClass().getResource("writingCaptcha2.fxml"));
//			Parent rootParent2 = writingRoot2.load();
//			Scene writingScene2 = new Scene(rootParent2);
//			
//			popupStage.setScene(writingScene2);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		textEntry.requestFocus();
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{

	}
}
