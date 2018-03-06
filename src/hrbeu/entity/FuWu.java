package hrbeu.entity;

public class FuWu {
	private String servId;
	private String servName;
	private String feeKind;
	private String remarks;
	private String rge;
	public String getServId() {
		return servId;
	}
	public void setServId(String servId) {
		this.servId = servId;
	}
	public String getServName() {
		return servName;
	}
	public void setServName(String servName) {
		this.servName = servName;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
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
	public FuWu(String servId, String servName, String feeKind, String remarks,
			String rge) {
		super();
		this.servId = servId;
		this.servName = servName;
		this.feeKind = feeKind;
		this.remarks = remarks;
		this.rge = rge;
	}
	public FuWu() {
		super();
	}
	@Override
	public String toString() {
		return "FuWu [servId=" + servId + ", servName=" + servName
				+ ", feeKind=" + feeKind + ", remarks=" + remarks + ", rge="
				+ rge + "]";
	}
	
}
