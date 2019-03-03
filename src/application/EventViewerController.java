package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
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
	@FXML private Accordion accordion1;
	@FXML private TitledPane titled1;
	@FXML private Accordion accordion2;
	@FXML private TitledPane titled2;
	@FXML private Accordion accordion3;
	@FXML private TitledPane titled3;
	@FXML private Accordion accordion4;
	@FXML private TitledPane titled4;
	
    private final Node rootIcon =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon1.png")));

	private ImageView listIcon; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		populateLeftTree();
		getDateTime();
		expandAccordions();
	}
	
	private void populateLeftTree()
	{
		TreeItem<String> rootItem = new TreeItem<String> ("Event Viewer (Local)", rootIcon);
        rootItem.setExpanded(true);          
        
        
        
        leftTreeHelper someLeftTree = new leftTreeHelper();
        ArrayList<TreeItem> treePopulator = someLeftTree.leftTreeFill();
        
        for(TreeItem x : treePopulator)
        {
        	rootItem.getChildren().add(x);
        }
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
		lastRefreshedLabel.setText("Last refreshed: " + y);
	}
	
	public void expandAccordions()
	{
		accordion1.setExpandedPane(titled1);
		accordion2.setExpandedPane(titled2);
		accordion3.setExpandedPane(titled3);
		accordion4.setExpandedPane(titled4);
	}
	
}
