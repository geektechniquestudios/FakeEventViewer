package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import itemPopulation.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import itemPopulation.leftTreeHelper;

public class EventViewerController implements Initializable 
{
	@FXML private TreeView<String> leftTreeView;
	@FXML private AnchorPane overviewLabelBox;
	@FXML private Label overviewLabel;
	@FXML private Label lastRefreshedLabel;
	
	private ImageView listIcon; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		populateLeftTree();
		getDateTime();
		iconsToLeftTree();
	}
	
	private void populateLeftTree()
	{
		TreeItem<String> rootItem = new TreeItem<String> ("Event Viewer (Local)");
        rootItem.setExpanded(true);          
        
        leftTreeHelper someLeftTree = new leftTreeHelper();
        ArrayList<TreeItem> treePopulator = someLeftTree.getProducts();
        
        for(TreeItem x : treePopulator)
        {
        	rootItem.getChildren().add(x);
        }
        
//        Image someImage = new Image(getClass().getResourceAsStream("/imageAssets/icon.png"));
        
//        listIcon.setImage(someImage);
        
 //       rootItem.setGraphic(someImage);
        
        
        leftTreeView.setRoot(rootItem);
	}
	
	private void getDateTime()
	{
 		String dateToConvert = LocalDateTime.now().toString();
		char[] dateCharArr = dateToConvert.toCharArray();
		for(int x = 0; x < dateCharArr.length; x++)
		{
			if(dateCharArr[x] == 'T')
			{
				dateCharArr[x] = ' ';
			}
			
		}
		String y = new String(dateCharArr);
		lastRefreshedLabel.setText(lastRefreshedLabel.getText() + y);
	}
	
	private void iconsToLeftTree()
	{
		
	}
}
