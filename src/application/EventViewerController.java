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
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import itemPopulation.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import itemPopulation.LeftTreeHelper;


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
	
	@FXML private TableColumn<SecondTableItems, ImageView> name;
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

	//the long list of nodes below are all to make the menu look like event viewer
    private Node selected =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/selected.png")));
    private Node selected1 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/selected1.png")));
    private Node selected2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/selected2.png")));
    private Node selected3 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/selected3.png")));
    private Node selected4 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/selected4.png")));

    private Node notSelected =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/notSelected.png")));
    private Node notSelected1 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/notSelected1.png")));
    private Node notSelected2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/notSelected2.png")));
    private Node notSelected3 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/notSelected3.png")));
    private Node notSelected4 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/notSelected4.png")));
    
    private final Node rootIcon1 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon1.png")));
	private Node rootIcon2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon2.png")));
	private Node rootIcon3 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon3.png")));
	private Node rootIcon4 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon4.png")));
	private Node rootIcon5 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon5.png")));
	private Node adminEventsIcon =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon2a.png")));
	private Node adminEventsIconSelected =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/icon2aSelected.png")));

	
	private Node iconFolder1  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolder1.png")));
	private Node iconFolderSelected1  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolderSelected1.png")));
	
	private Node iconFolder2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolder2.png")));
	private Node iconFolderSelected2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolderSelected2.png")));

	private Node iconFolder3 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolder3.png")));
	private Node iconFolderSelected3 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconFolderSelected3.png")));


	private Node iconPlain1  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconPlain1.png")));
	private Node iconPlainSelected1  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconPlainSelected1.png")));

	private Node iconPlain2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconPlain2.png")));
	private Node iconPlainSelected2 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconPlainSelected2.png")));
	
	private Node iconWarn1   =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn1.png")));
	private Node iconWarnSelected1   =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected1.png")));

	private Node iconWarn2  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn2.png")));
	private Node iconWarnSelected2  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected2.png")));

	private Node iconWarn3  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn3.png")));
	private Node iconWarnSelected3  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected3.png")));

	private Node iconWarn4  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn4.png")));
	private Node iconWarnSelected4  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected4.png")));

	private Node iconWarn5  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn5.png")));
	private Node iconWarnSelected5 = new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected5.png")));
	
	private Node iconWarn6  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn6.png")));
	private Node iconWarnSelected6  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected6.png")));

	private Node iconWarn7  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn7.png")));
	private Node iconWarnSelected7  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected7.png")));
	
	private Node iconWarn8  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn8.png")));
	private Node iconWarnSelected8  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected8.png")));
	
	private Node iconWarn9  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn9.png")));
	private Node iconWarnSelected9 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected9.png")));
    
	private Node iconWarn10  =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarn10.png")));
	private Node iconWarnSelected10 =  new ImageView(new Image(getClass().getResourceAsStream("/imageAssets/iconWarnSelected10.png")));
	
	
    private BorderPane root;
    
    TreeItem<String> rootItem;
    
    ArrayList<TreeItem> treePopulator;
    
    
    
    
    
    
    public void setRoot(BorderPane rootPane)
    {
    	root = rootPane;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{			
		populateLeftTree();
		getDateTime();
		expandAccordions();
		setToolTips();
		fillTables();	
		rightAlignArrows();
		stretchScrollBars();
		pointAllArrowsUp();
		defocusNodes();
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
		rootItem = new TreeItem<String> ("Event Viewer (Local)", selected);
        rootItem.setExpanded(true);          
        
        LeftTreeHelper someLeftTree = new LeftTreeHelper();
        treePopulator = someLeftTree.leftTreeFill();
        
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
		
		firstTable.addEventFilter(ScrollEvent.ANY, Event::consume);//disable scrolling in the first table

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
		itemsToReturn.add(new FirstTableItems("/imageAssets/tableImage1.png", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("/imageAssets/tableImage2.png", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("/imageAssets/tableImage3.png", "0", "0", "0"));
		itemsToReturn.add(new FirstTableItems("/imageAssets/tableImage4.png", firstLowNum, firstMedNum, firstHighNum));
		itemsToReturn.add(new FirstTableItems("/imageAssets/tableImage5.png", secondLowNum, secondMedNum, secondHighNum));

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
		itemsToReturn.add(new ThirdTableItems("Application", "407 MB/20 MB", "3/7/2019 4:03:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Hardware Events", "68 KB/20MB", "2/18/2019 7:32:25 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("IntelAudioServiceLog", "68KB/20MB", "2/24/2019 2:33:23 AM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Internet Explorer", "68KB/100MB", "2/30/2019 9:45:22 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Key Management Service", "68KB/20MB", "2/29/2019 11:42:12 PM", "Enabled"));
		itemsToReturn.add(new ThirdTableItems("Microsoft Office Alerts", "68KB/100MB", "2/22/2019 10:45:58 PM", "Enabled"));
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

	private void stretchScrollBars()//garbage 
	{
		Platform.runLater(() ->
		{
			ScrollBar someScrollBar = (ScrollBar) secondTable.lookup(".scroll-bar:vertical");
			
			//AnchorPane secondTablePane = (AnchorPane) secondTable.lookup(".");
			
	        someScrollBar.setTranslateY(-12);
	        someScrollBar.setScaleY(1.2); 
//	        someScrollBar.setMinHeight();
//	        someScrollBar.setPrefHeight();
//	        someScrollBar.setMaxHeight();
	       
	        
	        ScrollBar anotherScrollBar = (ScrollBar) thirdTable.lookup(".scroll-bar:vertical");
	        anotherScrollBar.setTranslateY(-12);
	        anotherScrollBar.setScaleY(1.11);
		});   
	}
	
	private void pointAllArrowsUp()
	{
		Platform.runLater(() ->
		{
			pointArrowUp(titled1, true);
			pointArrowUp(titled2, true);
			pointArrowUp(titled3, true);
			pointArrowUp(titled4, true);
			pointArrowUp(rightTitled, false);
		});
	}
	
	private void pointArrowUp(TitledPane pane, boolean moveArrowUp)
	{
		Region arrow = (Region) pane.lookup(".arrow");

	    Rotate rotate = new Rotate();
	    rotate.pivotXProperty().bind(arrow.widthProperty().divide(2.0));
	    rotate.pivotYProperty().bind(arrow.heightProperty().divide(2.0));
	    rotate.angleProperty().bind
	    (
	    	Bindings.when(pane.expandedProperty())
	            .then(-180.0)
	            .otherwise(90.0)
	    );

	    arrow.getTransforms().add(rotate);
	    
	    if(moveArrowUp)
	    {
	    	arrow.setTranslateY(-1);
	    }
	    
	    pane.setAnimated(false);
	}
	
	private void defocusNodes()
	{
		
		Platform.runLater(() ->
		{
			titled1.requestFocus();//could use basically any node
		});
	}
	
	/////////////////////////
	//FXML methods below/////
	/////////////////////////
	
	public void treeItemClicked(MouseEvent somethingClicked)//simulates highlight on click, and handles
	{
		//set all graphics back to normal each time a new cell is clicked
		rootItem.setGraphic(notSelected);
		rootItem.getChildren().get(0).setGraphic(notSelected1);
		rootItem.getChildren().get(1).setGraphic(notSelected2);
		rootItem.getChildren().get(2).setGraphic(notSelected3);
		rootItem.getChildren().get(3).setGraphic(notSelected4);
		rootItem.getChildren().get(0).getChildren().get(0).setGraphic(adminEventsIcon);
		rootItem.getChildren().get(1).getChildren().get(0).setGraphic(iconWarn1);
		rootItem.getChildren().get(1).getChildren().get(1).setGraphic(iconWarn2);
		rootItem.getChildren().get(1).getChildren().get(2).setGraphic(iconPlain1);
		rootItem.getChildren().get(1).getChildren().get(3).setGraphic(iconWarn3);
		rootItem.getChildren().get(1).getChildren().get(4).setGraphic(iconPlain2);
		rootItem.getChildren().get(2).getChildren().get(0).setGraphic(iconFolder1);
		rootItem.getChildren().get(2).getChildren().get(1).setGraphic(iconWarn4);
		rootItem.getChildren().get(2).getChildren().get(2).setGraphic(iconWarn5);
		rootItem.getChildren().get(2).getChildren().get(3).setGraphic(iconWarn6);
		rootItem.getChildren().get(2).getChildren().get(4).setGraphic(iconWarn7);
		rootItem.getChildren().get(2).getChildren().get(5).setGraphic(iconFolder2);
		rootItem.getChildren().get(2).getChildren().get(6).setGraphic(iconWarn8);
		rootItem.getChildren().get(2).getChildren().get(7).setGraphic(iconFolder3);
		rootItem.getChildren().get(2).getChildren().get(8).setGraphic(iconWarn9);
		rootItem.getChildren().get(2).getChildren().get(9).setGraphic(iconWarn10);





		TreeItem<String> someItem = leftTreeView.getSelectionModel().getSelectedItem();
		
		try
		{
			switch (someItem.getValue())//set a graphic to appear selected 'on-click' - painfully inelegant
			{
				case "Event Viewer (Local)":
					rootItem.setGraphic(selected);
					break;
					
				case "Custom Views":
					rootItem.getChildren().get(0).setGraphic(selected1);
					break;
					
				case "Windows Logs":
					rootItem.getChildren().get(1).setGraphic(selected2);
					break;
					
				case "Applications and Service Logs":
					rootItem.getChildren().get(2).setGraphic(selected3);
					break;
					
				case "Subscriptions":
					rootItem.getChildren().get(3).setGraphic(selected4);
					break;
				
				case "Administrative Events":
					rootItem.getChildren().get(0).getChildren().get(0).setGraphic(adminEventsIconSelected);
					break;
					
				case "Application":
					rootItem.getChildren().get(1).getChildren().get(0).setGraphic(iconWarnSelected1);
					break;
					
				case "Security":
					rootItem.getChildren().get(1).getChildren().get(1).setGraphic(iconWarnSelected2);
					break;
					
				case "Setup":
					rootItem.getChildren().get(1).getChildren().get(2).setGraphic(iconPlainSelected1);
					break;
					
				case "System":
					rootItem.getChildren().get(1).getChildren().get(3).setGraphic(iconWarnSelected3);
					break;
					
				case "Forwarded Events":
					rootItem.getChildren().get(1).getChildren().get(4).setGraphic(iconPlainSelected2);
					break;
					
				case "AESMService":
					rootItem.getChildren().get(2).getChildren().get(0).setGraphic(iconFolderSelected1);
					break;
					
				case "Hardware Events":
					rootItem.getChildren().get(2).getChildren().get(1).setGraphic(iconWarnSelected4);
					break;
					
				case "IntelAudioServiceLog":
					rootItem.getChildren().get(2).getChildren().get(2).setGraphic(iconWarnSelected5);
					break;
					
				case "Internet Explorer":
					rootItem.getChildren().get(2).getChildren().get(3).setGraphic(iconWarnSelected6);
					break;
					 
				case "Key Management Service":
					rootItem.getChildren().get(2).getChildren().get(4).setGraphic(iconWarnSelected7);
					break;
					
				case "Microsoft":
					rootItem.getChildren().get(2).getChildren().get(5).setGraphic(iconFolderSelected2);
					break;
					
				case "Microsoft Office Alerts":
					rootItem.getChildren().get(2).getChildren().get(6).setGraphic(iconWarnSelected8);
					break;
					
				case "OpenSSH":
					rootItem.getChildren().get(2).getChildren().get(7).setGraphic(iconFolderSelected3);
					break;
					
				case "PreEmptive":
					rootItem.getChildren().get(2).getChildren().get(8).setGraphic(iconWarnSelected9);
					break;

				case "Windows Powershell":
					rootItem.getChildren().get(2).getChildren().get(9).setGraphic(iconWarnSelected10);
					break;
					
				default:
					break;
			}
		}
		catch(Exception e)
		{
			//no use for exception, just handling exception if user hits arrow
		}
		//System.out.println(someItem.getValue());
		
		
	}
}
