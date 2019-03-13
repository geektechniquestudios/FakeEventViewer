package application;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import itemPopulation.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
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
	
	@FXML private Label switchingArrow1;
	@FXML private Label switchingArrow2;
	@FXML private Label switchingArrow3;
	@FXML private Label switchingArrow4;
	@FXML private Label switchingArrowRight;
	
	@FXML private HBox titleHBox1;

	//first table
	@FXML private TableView<FirstTableItems> firstTable;
	
	@FXML private TableColumn<FirstTableItems, String> eventType;
	@FXML private TableColumn<FirstTableItems, String> eventID;
	@FXML private TableColumn<FirstTableItems, String> source;
	@FXML private TableColumn<FirstTableItems, String> log;
	@FXML private TableColumn<FirstTableItems, String> lastHour;
	@FXML private TableColumn<FirstTableItems, String> $24Hours;
	@FXML private TableColumn<FirstTableItems, String> $7Days;
	
	//second table
	@FXML private TableView<SecondTableItems> secondTable;
	
	@FXML private TableColumn<SecondTableItems, String> name;
	@FXML private TableColumn<SecondTableItems, String> description;
	@FXML private TableColumn<SecondTableItems, String> modified;
	@FXML private TableColumn<SecondTableItems, String> created;

	//third table
	@FXML private TableView<ThirdTableItems> thirdTable;
	
	@FXML private TableColumn<ThirdTableItems, String> logName;
	@FXML private TableColumn<ThirdTableItems, String> size;
	@FXML private TableColumn<ThirdTableItems, String> modified2;
	@FXML private TableColumn<ThirdTableItems, String> enabled;
	@FXML private TableColumn<ThirdTableItems, String> retentionPolicy;

    private final Node rootIcon =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon1.png")));//icon for the Left Tree Root
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		

		
		// translate the titledpane arrow and header so that the arrow is displayed to right of the header.

		populateLeftTree();
		getDateTime();
		expandAccordions();
		setToolTips();
		fillTables();	
		rightAlignArrows();
		disableScroll();
	}
	
//	public void disableScroll()
//	{
//		ScrollBar vScrollBar = (ScrollBar) firstTable.lookup(".scroll-bar:vertical");
//		ScrollBar hScrollBar = (ScrollBar) firstTable.lookup(".scroll-bar:horizontal");
//		hScrollBar.setVisible(false);
//		vScrollBar.setVisible(false);
//	}
//	
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
		for(int x = 0; x < dateCharArr.length; x++)// removes "T" time indicator from string
		{
			if(dateCharArr[x] == 'T')
			{
				dateCharArr[x] = ' ';
			}
		}
		String dateString = new String(dateCharArr);
		dateString = dateString.substring(0, 19);// cuts off nonsense at the end of string
		lastRefreshedLabel.setText("Last refreshed: " + dateString);
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
		//first table
		eventType.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("eventType"));
		eventID.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("eventID"));
		source.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("source"));
		log.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("log"));
		lastHour.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("lastHour"));
		$24Hours.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("$24Hours"));
		$7Days.setCellValueFactory(new PropertyValueFactory<FirstTableItems, String>("$7Days"));
		
		lastHour.setStyle( "-fx-alignment: CENTER-RIGHT;");
		$24Hours.setStyle( "-fx-alignment: CENTER-RIGHT;");
		$7Days.setStyle( "-fx-alignment: CENTER-RIGHT;");
		
		firstTable.setItems(getFirstTableItems());
		//firstTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//all columns autosize, might remove
		
		//second table
		name.setCellValueFactory(new PropertyValueFactory<SecondTableItems, String>("name"));
		description.setCellValueFactory(new PropertyValueFactory<SecondTableItems, String>("description"));
		modified.setCellValueFactory(new PropertyValueFactory<SecondTableItems, String>("modified"));
		created.setCellValueFactory(new PropertyValueFactory<SecondTableItems, String>("created"));
		
		secondTable.setItems(getSecondTableItems());
		
		//third table
		logName.setCellValueFactory(new PropertyValueFactory<ThirdTableItems, String>("logName"));
		size.setCellValueFactory(new PropertyValueFactory<ThirdTableItems, String>("size"));
		modified2.setCellValueFactory(new PropertyValueFactory<ThirdTableItems, String>("modified2"));
		enabled.setCellValueFactory(new PropertyValueFactory<ThirdTableItems, String>("enabled"));
		retentionPolicy.setCellValueFactory(new PropertyValueFactory<ThirdTableItems, String>("retentionPolicy"));
		
		thirdTable.setItems(getThirdTableItems());
	}
	
	private ObservableList<FirstTableItems> getFirstTableItems()
	{
		Random randomNumGen = new Random();
		
		int firstLowRand = randomNumGen.nextInt(100);
		String firstLowNum = String.valueOf(firstLowRand);
		
		int secondLowRand = randomNumGen.nextInt(100);
		String secondLowNum = String.valueOf(secondLowRand);
		
		int firstMedRand = randomNumGen.nextInt(1000);
		String firstMedNum = String.valueOf(firstMedRand);
		
		int secondMedRand = randomNumGen.nextInt(1000);
		String secondMedNum = String.valueOf(secondMedRand);
		
		int firstHighRand = randomNumGen.nextInt(10000);
		String firstHighNum = String.valueOf(firstHighRand);
		
		int secondHighRand = randomNumGen.nextInt(10000);
		String secondHighNum = String.valueOf(secondHighRand);
		
		ObservableList<FirstTableItems> itemsToReturn = FXCollections.observableArrayList();
		itemsToReturn.add(new FirstTableItems("Critical", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("Error", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("Warning", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("Information", firstLowNum, firstMedNum, firstHighNum));
		itemsToReturn.add(new FirstTableItems("Audit Success", secondLowNum, secondMedNum, secondHighNum));

		return itemsToReturn;
	}
	
	private ObservableList<SecondTableItems> getSecondTableItems()
	{
		ObservableList<SecondTableItems> itemsToReturn = FXCollections.observableArrayList();
		itemsToReturn.add(new SecondTableItems("Custom Views/Administrative Events","Critical, Error, and Warning events from all administrative logs", "N/A", "N/A"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/Windows PowerShell", "N/A","3/7/2019 11:03:22 PM","2/21/2019 8:29:22 PM"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/PreEmptive", "N/A", "4/7/2019 11:03:29 PM","3/7/2019 1:03:32 AM"));
		itemsToReturn.add(new SecondTableItems("Applications and Serivecs Logs/Microsoft Office Alerts", "N/A", "4/7/2019 7:23:54 PM","4/12/2019 3:32:32 AM"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/Key Management Service", "N/A", "5/7/2019 6:03:12 PM", "3/8/2019 5:13:21 PM"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/Internet Explorer", "N/A", "5/7/2019 6:03:12 PM", "3/9/2019 7:43:34 PM"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/IntelAudioServiceLog","N/A","2/5/2019 2:11:11 AM","9/3/2019 2:22:01 PM"));
		itemsToReturn.add(new SecondTableItems("Applications and Services Logs/Hardware Events","N/A","2/6/2019 3:15:25 AM","9/3/2019 2:22:01 PM"));
		itemsToReturn.add(new SecondTableItems("Windows Logs/Forwarded Events","N/A"," "," "));
		itemsToReturn.add(new SecondTableItems("Windows Logs/System","N/A","2/15/2019 3:17:25 PM","9/18/2019 6:22:01 PM"));

		return itemsToReturn;
	}
	
	private ObservableList<ThirdTableItems> getThirdTableItems()
	{
		ObservableList<ThirdTableItems> itemsToReturn = FXCollections.observableArrayList();
		itemsToReturn.add(new ThirdTableItems("Application", "407 MB/20 MB", "3/7/2019 11:03:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Hardware Events", "68 KB/20MB", "2/18/2019 11:32:25 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("IntelAudioServiceLog", "68KB/20MB", "2/24/2019 11:33:23 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Internet Explorer", "68KB/100MB", "2/30/2019 11:45:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Key Management Service", "68KB/20MB", "2/29/2019 11:42:12 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft Office Alerts", "68KB/100MB", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("PreEmptive","68KB/100MB", "2/22/2019 5:05:32 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Security", "68KB/100MB", "2/12/2019 1:02:33 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("System", "68KB/100MB", "4/20/2019 8:05:32 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Windows PowerShell", "68KB/100KB", "1/12/2019 10:30:52 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("AMSI/Operational", "1.07KB/100KB", "2/24/2019 9:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Forwarded Events", "0 Bytes/20MB", "2/22/2019 11:45:58 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-Client-Licensing/Admin","1.00MB/1.00MB", "2/22/2019 1:05:24 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AAD/Operational", "1.00MB/1.00MB", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-All-User-Install-Agent/Admin", "68KB/1.00MB", "2/12/2019 8:42:18 AM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("AllJoynEvents/Operational", "68KB/1.00MB", "2/24/2019 9:24:51 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AppHost/Admin", "68KB/1.00MB", "3/21/2019 5:52:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-Application", "420B/Az3-lt", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("System Competencies", "68KB/100MB", "4/20/2019 8:05:32 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Windows PowerShell", "68KB/100KB", "1/12/2019 10:30:52 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("AMSI/Operational", "1.07KB/100KB", "2/24/2019 9:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Forwarded Events", "0 Bytes/20MB", "2/22/2019 11:45:58 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-Client-Licensing/Admin","1.00MB/1.00MB", "2/22/2019 1:05:24 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AAD/Operational", "1.00MB/1.00MB", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-All-User-Install-Agent/Admin", "68KB/1.00MB", "2/12/2019 8:42:18 AM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("AllJoynEvents/Operational", "68KB/1.00MB", "2/24/2019 9:24:51 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AppHost/Admin", "68KB/1.00MB", "3/21/2019 5:52:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("System Override", "68KB/100MB", "4/20/2019 8:05:32 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Windows PowerShell", "68KB/100KB", "1/12/2019 10:30:52 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("AMSI/Operational", "1.07KB/100KB", "2/24/2019 9:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Forwarded Events", "0 Bytes/20MB", "2/22/2019 11:45:58 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-Client-Licensing/Admin","1.00MB/1.00MB", "2/22/2019 1:05:24 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AAD/Operational", "1.00MB/1.00MB", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-All-User-Install-Agent/Admin", "68KB/1.00MB", "2/12/2019 8:42:18 AM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("AllJoynEvents/Operational", "68KB/1.00MB", "2/24/2019 9:24:51 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AppHost/Admin", "68KB/1.00MB", "3/21/2019 5:52:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("System Fucntions", "68KB/100MB", "4/20/2019 8:05:32 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Windows PowerShell", "68KB/100KB", "1/12/2019 10:30:52 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("AMSI/Operational", "1.07KB/100KB", "2/24/2019 9:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Forwarded Events", "0 Bytes/20MB", "2/22/2019 11:45:58 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-Client-Licensing/Admin","1.00MB/1.00MB", "2/22/2019 1:05:24 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AAD/Operational", "1.00MB/1.00MB", "2/22/2019 11:45:58 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-All-User-Install-Agent/Admin", "68KB/1.00MB", "2/12/2019 8:42:18 AM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("AllJoynEvents/Operational", "68KB/1.00MB", "2/24/2019 9:24:51 PM", "Disabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft-Windows-AppHost/Admin", "68KB/1.00MB", "3/21/2019 5:52:22 PM", "Enabled"));
		
		return itemsToReturn;
	}
	
	private void rightAlignArrows()
	{
		//must run after init. Explanation complex
        Platform.runLater(() -> 
        {
        	
        accordion1.getPanes().forEach(TitledPaneUtils::putArrowOnRight);
        accordion2.getPanes().forEach(TitledPaneUtils::putArrowOnRight);
        accordion3.getPanes().forEach(TitledPaneUtils::putArrowOnRight);
        accordion4.getPanes().forEach(TitledPaneUtils::putArrowOnRight);
        rightAccordion.getPanes().forEach(TitledPaneUtils::putArrowOnRightLess);
        
        ScrollBar someScrollBar = (ScrollBar) secondTable.lookup(".scroll-bar:vertical");
        someScrollBar.setTranslateY(-12);
        someScrollBar.setScaleY(1.2);
       
        ScrollBar anotherScrollBar = (ScrollBar) thirdTable.lookup(".scroll-bar:vertical");
        anotherScrollBar.setTranslateY(-12);
        anotherScrollBar.setScaleY(1.11);
        }
        );
        
        //below are many failed attempts at moving the arrows tangled together. Keeping because the scrap code might be useful at some point.
        
//		accordion2.getPanes().forEach(TitledPaneUtils::putArrowOnRight);
//		Label collapsableArrow = new Label();
//		switchingArrow1.textProperty().bind(
//		    Bindings.when(titled1.expandedProperty())
//		    	.then("\u25B4").otherwise("\u25BE"));
		
		// HBox.setHgrow(titleHBox1, Priority.ALWAYS);
		
		
		 // Create HBox to hold our Title and Label
//	    HBox arrowAndRegion = new HBox();
//	    HBox regionToGrow = new HBox();
//	    
//	   // collapsableArrow.minWidthProperty().bind(titled1.widthProperty());
//		    
//	    regionToGrow.setMaxWidth(Double.MAX_VALUE);
//	    HBox.setHgrow(regionToGrow, Priority.ALWAYS);
//	    HBox.setHgrow(arrowAndRegion, Priority.ALWAYS);
//	    
//	    arrowAndRegion.getChildren().addAll
//	    (
//	              regionToGrow,
//	              collapsableArrow
//	    );
//	    
//		titled1.setGraphic(arrowAndRegion);
		//titled1.setMaxWidth(Double.MAX_VALUE);
		//titled1.setContentDisplay(ContentDisplay.RIGHT);
		 
		
	}
	
	private void disableScroll()
	{
		firstTable.addEventFilter(ScrollEvent.ANY, Event::consume);
	}
	
	
}
