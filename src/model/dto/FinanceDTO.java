package model.dto;

public class FinanceDTO{
	private String cmpName;
	private String revenue;
	private String operatingIncome;
	private String netIncome;
	private String totalAsset;
	private String totalDebt;	
	private String capitalGross;
	private String netProfitRatio;	
	private String capex;	
	private String fcf;	
	private String roe;	
	private String roa;
	private String eps;	
	private String per;	
	private String bps;	
	private String pbr;	
	private String ifrs;	
	private String year;
	
	public FinanceDTO(String cmpName, String revenue, String operatingIncome, String netIncome, String totalAsset, String totalDebt,
			String capitalGross, String netProfitRatio, String capex, String fcf, String roe, String roa, String eps,
			String per, String bps, String pbr, String ifrs, String year) {
		this.cmpName = cmpName;
		this.revenue = revenue;
		this.operatingIncome = operatingIncome;
		this.netIncome = netIncome;
		this.totalAsset = totalAsset;
		this.totalDebt = totalDebt;
		this.capitalGross = capitalGross;
		this.netProfitRatio = netProfitRatio;
		this.capex = capex;
		this.fcf = fcf;
		this.roe = roe;
		this.roa = roa;
		this.eps = eps;
		this.per = per;
		this.bps = bps;
		this.pbr = pbr;
		this.ifrs = ifrs;
		this.year = year;
	}
	
	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getOperatingIncome() {
		return operatingIncome;
	}

	public void setOperatingIncome(String operatingIncome) {
		this.operatingIncome = operatingIncome;
	}

	public String getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(String netIncome) {
		this.netIncome = netIncome;
	}

	public String getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(String totalAsset) {
		this.totalAsset = totalAsset;
	}

	public String getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(String totalDebt) {
		this.totalDebt = totalDebt;
	}

	public String getCapitalGross() {
		return capitalGross;
	}

	public void setCapitalGross(String capitalGross) {
		this.capitalGross = capitalGross;
	}

	public String getNetProfitRatio() {
		return netProfitRatio;
	}

	public void setNetProfitRatio(String netProfitRatio) {
		this.netProfitRatio = netProfitRatio;
	}

	public String getCapex() {
		return capex;
	}

	public void setCapex(String capex) {
		this.capex = capex;
	}

	public String getFcf() {
		return fcf;
	}

	public void setFcf(String fcf) {
		this.fcf = fcf;
	}

	public String getRoe() {
		return roe;
	}

	public void setRoe(String roe) {
		this.roe = roe;
	}

	public String getRoa() {
		return roa;
	}

	public void setRoa(String roa) {
		this.roa = roa;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getBps() {
		return bps;
	}

	public void setBps(String bps) {
		this.bps = bps;
	}

	public String getPbr() {
		return pbr;
	}

	public void setPbr(String pbr) {
		this.pbr = pbr;
	}

	public String getIfrs() {
		return ifrs;
	}

	public void setIfrs(String ifrs) {
		this.ifrs = ifrs;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "FinanceDTO [cmpName=" + cmpName + ", revenue=" + revenue + ", operatingIncome=" + operatingIncome
				+ ", netIncome=" + netIncome + ", totalAsset=" + totalAsset + ", totalDebt=" + totalDebt
				+ ", capitalGross=" + capitalGross + ", netProfitRatio=" + netProfitRatio + ", capex=" + capex
				+ ", fcf=" + fcf + ", roe=" + roe + ", roa=" + roa + ", eps=" + eps + ", per=" + per + ", bps=" + bps
				+ ", pbr=" + pbr + ", ifrs=" + ifrs + ", year=" + year + "]";
	}
	
	
}
