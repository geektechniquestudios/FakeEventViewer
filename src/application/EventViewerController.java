package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import itemPopulation.*;

import java.net.URL;
import java.util.ResourceBundle;

import itemPopulation.leftTreeHelper;

public class EventViewerController implements Initializable 
{
	@FXML TreeView<String> leftTreeView;
	@FXML AnchorPane OverviewLabelBox;
	@FXML Label OverviewLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		TreeItem<String> rootItem = new TreeItem<String> ("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        leftTreeView = new TreeView<String> (rootItem); 
		
		
		//leftTreeView = new TreeView<String>();
	}
	
	
}
