package application;

import animations.FadeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MatchingController 
{
	private static Stage popupStage;
	
	@FXML private ImageView image1;
	@FXML private ImageView image2;
	@FXML private ImageView image3;
	@FXML private ImageView image4;
	@FXML private ImageView image5;
	@FXML private ImageView image6;
	@FXML private ImageView image7;
	@FXML private ImageView image8;
	@FXML private ImageView image9;


	public static void setPopupStage(Stage someStage)
	{
		popupStage = someStage;
	}
	
	public void verifyWasHit(ActionEvent action)
	{
		try
		{
			FXMLLoader writingRoot = new FXMLLoader(getClass().getResource("writingCaptcha.fxml"));
			Parent rootParent = writingRoot.load();
			Scene writingScene = new Scene(rootParent);
			
			popupStage.setScene(writingScene);
			WritingController.setPopupStage(popupStage);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	boolean img1Hit = false;
	public void image1WasHit()
	{
		if(img1Hit == false)
		{
			new FadeOut(image1).play();
			img1Hit = true;
		}
	}
	
	boolean img2Hit = false;
	public void image2WasHit()
	{
		if(img2Hit == false)
		{
			new FadeOut(image2).play();
			img2Hit = true;
		}
	}
	
	boolean img3Hit = false;
	public void image3WasHit()
	{
		if(img3Hit == false)
		{
			new FadeOut(image3).play();
			img3Hit = true;
		}
	}
	
	boolean img4Hit = false;
	public void image4WasHit()
	{
		if(img4Hit == false)
		{
			new FadeOut(image4).play();
			img5Hit = true;
		}
	}
	
	boolean img5Hit = false;
	public void image5WasHit()
	{
		if(img5Hit == false)
		{
			new FadeOut(image5).play();
			img5Hit = true;
		}
	}
	
	boolean img6Hit = false;
	public void image6WasHit()
	{
		if(img6Hit == false)
		{
			new FadeOut(image6).play();
			img6Hit = true;
		}
	}
	
	boolean img7Hit = false;
	public void image7WasHit()
	{
		if(img7Hit == false)
		{
			new FadeOut(image7).play();
			img7Hit = true;
		}
	}
	
	boolean img8Hit = false;
	public void image8WasHit()
	{
		if(img8Hit == false)
		{
			new FadeOut(image8).play();
			img8Hit = true;
		}
	}
	
	boolean img9Hit = false;
	public void image9WasHit()
	{
		if(img9Hit == false)
		{
			new FadeOut(image9).play();
			img9Hit = true;
		}
	}
}
