package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
	@FXML private ImageView topIcon;
	@FXML private ImageView topIcon2;
	@FXML private ImageView topIcon3;
	@FXML private ImageView topIcon4;
	@FXML private ImageView topIcon5;
	@FXML private Accordion rightAccordion;
	@FXML private TitledPane rightTitled;
	@FXML private TableColumn eventType;
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
//	@FXML private
	
	
	
    private final Node rootIcon =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon1.png")));

	private ImageView listIcon; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		populateLeftTree();
		getDateTime();
		expandAccordions();
		setToolTips();
		fillTables();
//		Pane connectivityArrow = (Pane) rightTitled.lookup(".arrow");
//	    connectivityArrow.translateXProperty().bind(
//	      rightTitled.widthProperty().subtract(connectivityArrow.widthProperty().multiply(2))
//	    );
//	    Pane connectivityTitle = (Pane) rightTitled.lookup(".header");
//	    connectivityTitle.translateXProperty().bind(
//	      connectivityArrow.widthProperty().negate()
//	    );
//		
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
		y = y.substring(0, 19);
		lastRefreshedLabel.setText("Last refreshed: " + y);
	}
	
	private void expandAccordions()
	{
		accordion1.setExpandedPane(titled1);
		accordion2.setExpandedPane(titled2);
		accordion3.setExpandedPane(titled3);
		accordion4.setExpandedPane(titled4);
		rightAccordion.setExpandedPane(rightTitled);
	}
	
	private void setToolTips()
	{
		Tooltip topIcontip = new Tooltip("Back");
		Tooltip.install(topIcon, topIcontip);
		
		Tooltip topIcontip2 = new Tooltip("Forward");
		Tooltip.install(topIcon2, topIcontip2);
		
		Tooltip topIcontip3 = new Tooltip("Show// Hide Console Tree");
		Tooltip.install(topIcon3, topIcontip3);
		
		Tooltip topIcontip4 = new Tooltip("Help");
		Tooltip.install(topIcon4, topIcontip4);
		
		Tooltip topIcontip5 = new Tooltip("Show// Hide Action Pane");
		Tooltip.install(topIcon5, topIcontip5);
		
	}
	
	private void fillTables()
	{
//		eventType
		
	}
}
