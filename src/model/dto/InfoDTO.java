package model.dto;

public class InfoDTO {

	private String cmpName;
	private String busName;
	
	public InfoDTO() {}
	
	public InfoDTO(String cmpName, String busName) {
		this.cmpName = cmpName;
		this.busName = busName;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	@Override
	public String toString() {
		return "InfoDTO [cmpName=" + cmpName + ", busName=" + busName + "]";
	}
	
	
}