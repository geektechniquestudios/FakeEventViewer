package application;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WritingController
{
	@FXML private JFXTextField textEntry;
	@FXML private ImageView captchaImage;
	
	private static Stage popupStage;
	
	private int imageCounter = 0;
	
	@FXML private void verifyWasHit()
	{	
		if(textEntry.getText().toCharArray().length != 0)
		{
			imageCounter++;
			textEntry.setText("");
			
			switch(imageCounter)
			{
				case 1:
					Image imageObject = new Image("/imageAssets/writeCaptcha2.png");
					captchaImage.setImage(imageObject);
					break;
					
				case 2:
					Image imageObject2 = new Image("/imageAssets/writeCaptcha3.png");
					captchaImage.setImage(imageObject2);
					break;
					
				case 3:
					Image imageObject3 = new Image("/imageAssets/writeCaptcha4.png");
					captchaImage.setImage(imageObject3);
					break;
					
				case 4:	
					try
					{
						FXMLLoader writingRoot2 = new FXMLLoader(getClass().getResource("writingCaptcha2.fxml"));
						Parent rootParent2 = writingRoot2.load();
						Scene writingScene2 = new Scene(rootParent2);
						
						popupStage.setScene(writingScene2);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					textEntry.requestFocus();

					break;
			}
		}
	}
	
	public static void setPopupStage(Stage someStage)
	{
		popupStage = someStage;
	}
	
}
