package application;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WritingController2 implements Initializable
{
	@FXML private TextField textEntry;
	private static Stage popupStage;
	
	public void indeedWasHit()
	{
		try 
		{
		    Desktop.getDesktop().browse(new URL("https://www.indeed.co.in/jobs?q=literally+anything&l=").toURI());
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
	}
	
	public void setPopupStage(Stage someStage)
	{
		popupStage = someStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//popupStage.setAlwaysOnTop(true);	
	}
}
