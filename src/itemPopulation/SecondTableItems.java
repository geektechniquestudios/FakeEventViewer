package itemPopulation;

import javafx.beans.property.SimpleStringProperty;

public class SecondTableItems 
{
	private SimpleStringProperty name;
	private SimpleStringProperty description;
	private SimpleStringProperty modified;
	private SimpleStringProperty created;


	public String getName() {
		return name.get();
	}

	public String getDescription() {
		return description.get();
	}

	public String getModified() {
		return modified.get();
	}

	public String getCreated() {
		return created.get();
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public void setDescription(SimpleStringProperty description) {
		this.description = description;
	}

	public void setModified(SimpleStringProperty modified) {
		this.modified = modified;
	}

	public void setCreated(SimpleStringProperty created) {
		this.created = created;
	}

	public SecondTableItems()
	{
		this.name = new SimpleStringProperty("N/A");
		this.description = new SimpleStringProperty("N/A");
		this.modified = new SimpleStringProperty("N/A");
		this.created = new SimpleStringProperty("N/A");
	}
	
	public SecondTableItems(String name, String description, String modified, String created)
	{
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.modified = new SimpleStringProperty(modified);
		this.created = new SimpleStringProperty(created);
	}
}
