package itemPopulation;

import javafx.beans.property.SimpleStringProperty;

public class FirstTableItems 
{
	private SimpleStringProperty eventType;
	private SimpleStringProperty eventID;
	private SimpleStringProperty source;
	private SimpleStringProperty log;
	private SimpleStringProperty lastHour;
	private SimpleStringProperty $24Hours;
	private SimpleStringProperty $7Days;
	
	public String getEventType() {
		return eventType.get();
	}

	public String getEventID() {
		return eventID.get();
	}

	public String getSource() {
		return source.get();
	}

	public String getLog() {
		return log.get();
	}

	public String getLastHour() {
		return lastHour.get();
	}

	public String get$24Hours() {
		return $24Hours.get();
	}

	public String get$7Days() {
		return $7Days.get();
	}

	public void setEventType(SimpleStringProperty eventType) {
		this.eventType = eventType;
	}

	public void setEventID(SimpleStringProperty eventID) {
		this.eventID = eventID;
	}

	public void setSource(SimpleStringProperty source) {
		this.source = source;
	}

	public void setLog(SimpleStringProperty log) {
		this.log = log;
	}

	public void setLastHour(SimpleStringProperty lastHour) {
		this.lastHour = lastHour;
	}

	public void set$24Hours(SimpleStringProperty $24Hours) {
		this.$24Hours = $24Hours;
	}

	public void set$7Days(SimpleStringProperty $7Days) {
		this.$7Days = $7Days;
	}

	public FirstTableItems()
	{
		this.eventType = new SimpleStringProperty("-");
		this.eventID = new SimpleStringProperty("-");
		this.source = new SimpleStringProperty("-");
		this.log = new SimpleStringProperty("-");
		this.lastHour = new SimpleStringProperty("-");
		this.$24Hours = new SimpleStringProperty("-");
		this.$7Days = new SimpleStringProperty("-");
	}
	
	public FirstTableItems(String eventType, String lastHour, String $24Hours, String $7Days)
	{
		this.eventType = new SimpleStringProperty(eventType);
		this.eventID = new SimpleStringProperty("-");
		this.source = new SimpleStringProperty("-");
		this.log = new SimpleStringProperty("-");
		this.lastHour = new SimpleStringProperty(lastHour);
		this.$24Hours = new SimpleStringProperty($24Hours);
		this.$7Days = new SimpleStringProperty($7Days);
	}
}
