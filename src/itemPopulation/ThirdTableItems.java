package itemPopulation;

import javafx.beans.property.SimpleStringProperty;

public class ThirdTableItems 
{
	private SimpleStringProperty logName;
	private SimpleStringProperty size;
	private SimpleStringProperty modified2;
	private SimpleStringProperty enabled;
	private SimpleStringProperty retentionPolicy;

	public String getLogName() {
		return logName.get();
	}

	public String getSize() {
		return size.get();
	}

	public String getModified2() {
		return modified2.get();
	}

	public String getEnabled() {
		return enabled.get();
	}

	public String getRetentionPolicy() {
		return retentionPolicy.get();
	}

	public void setLogName(SimpleStringProperty logName) {
		this.logName = logName;
	}

	public void setSize(SimpleStringProperty size) {
		this.size = size;
	}

	public void setmodified2(SimpleStringProperty modified2) {
		this.modified2 = modified2;
	}

	public void setEnabled(SimpleStringProperty enabled) {
		this.enabled = enabled;
	}

	public void setRetentionPolicy(SimpleStringProperty retentionPolicy) {
		this.retentionPolicy = retentionPolicy;
	}

	public ThirdTableItems()
	{
		this.logName = new SimpleStringProperty("N/A");
		this.size = new SimpleStringProperty("N/A");
		this.modified2 = new SimpleStringProperty("N/A");
		this.enabled = new SimpleStringProperty("N/A");
		this.retentionPolicy = new SimpleStringProperty("N/A");
	}
	
	public ThirdTableItems(String logName, String size, String modified2, String enabled)
	{
		this.logName = new SimpleStringProperty(logName);
		this.size = new SimpleStringProperty(size);
		this.modified2 = new SimpleStringProperty(modified2);
		this.enabled = new SimpleStringProperty(enabled);
		this.retentionPolicy = new SimpleStringProperty("Overwrite events as necessary(oldest events first)");
	}
}
