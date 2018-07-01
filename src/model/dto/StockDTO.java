package model.dto;

public class StockDTO {
	private String cmpName;
	private String recordDate;
	private String close;
	private String high;
	private String low;
	private String open;
	private String volume;
	
	public StockDTO() {}

	public StockDTO(String cmpName, String recordDate, String close, String high, String low,
			String open, String volume) {
		this.cmpName = cmpName;
		this.recordDate = recordDate;
		this.close = close;
		this.high = high;
		this.low = low;
		this.open = open;
		this.volume = volume;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StockDTO [cmpName=" + cmpName + ", recordDate=" + recordDate + ", close=" + close + ", high=" + high
				+ ", low=" + low + ", open=" + open + ", volume=" + volume + "]";
	}
}