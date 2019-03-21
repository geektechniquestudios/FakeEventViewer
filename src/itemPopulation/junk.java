package itemPopulation;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class junk {

}

public class someTableItems 
{
	private Node imagesRow;
	private SimpleStringProperty description;
	private SimpleStringProperty modified;
	private SimpleStringProperty created;
	
	
	public Node getimagesRow()
	{
		return imagesRow;
	}

	public String getdescription() 
	{
		return description.get();
	}

	public String getmodified() {
		return modified.get();
	}

	public String getcreated() 
	{
		return created.get();
	}

	public void setimagesRow(String pathToImage)
	{
		this.imagesRow = new ImageView(new Image(getClass().getRedescriptionAsStream(pathToImage)));
	}
	
	public void setdescription(SimpleStringProperty description) 
	{
		this.description = description;
	}

	public void setmodified(SimpleStringProperty modified) 
	{
		this.modified = modified;
	}

	public void setcreated(SimpleStringProperty created) 
	{
		this.created = created;
	}

	public someTableItems()
	{
		this.imagesRow =  new ImageView(new Image(getClass().getRedescriptionAsStream("/imageAssets/tableImage1.png")));
		this.description = new SimpleStringProperty("-");
		this.modified = new SimpleStringProperty("-");
		this.created = new SimpleStringProperty("-");
	}
	
	public someTableItems(String pathToImage, String description, String modified, String created)
	{
		this.imagesRow =  new ImageView(new Image(getClass().getRedescriptionAsStream(pathToImage)));
		this.description = new SimpleStringProperty(description);
		this.modified = new SimpleStringProperty(modified);
		this.created = new SimpleStringProperty(created);
	}
}