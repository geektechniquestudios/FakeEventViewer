package application;

import java.awt.Desktop;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WritingController2
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
	
	public static void setPopupStage(Stage someStage)
	{
		popupStage = someStage;
	}
	
}
