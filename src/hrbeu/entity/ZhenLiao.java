package hrbeu.entity;

public class ZhenLiao {
	private String projId;
	private String projName;
	private String feeKind;
	private String chargeRank;
	private String company;
	private String manufacturer;
	private String remarks;
	private String rge;
	private String hosRank;
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public String getChargeRank() {
		return chargeRank;
	}
	public void setChargeRank(String chargeRank) {
		this.chargeRank = chargeRank;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRge() {
		return rge;
	}
	public void setRge(String rge) {
		this.rge = rge;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public ZhenLiao(String projId, String projName, String feeKind,
			String chargeRank, String company, String manufacturer,
			String remarks, String rge, String hosRank) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.feeKind = feeKind;
		this.chargeRank = chargeRank;
		this.company = company;
		this.manufacturer = manufacturer;
		this.remarks = remarks;
		this.rge = rge;
		this.hosRank = hosRank;
	}
	public ZhenLiao() {
		super();
	}
	@Override
	public String toString() {
		return "ZhenLiao [projId=" + projId + ", projName=" + projName
				+ ", feeKind=" + feeKind + ", chargeRank=" + chargeRank
				+ ", company=" + company + ", manufacturer=" + manufacturer
				+ ", remarks=" + remarks + ", rge=" + rge + ", hosRank="
				+ hosRank + "]";
	}
	
}
