package hrbeu.entity;

public class BingZhong {
	private String diseId;
	private String diseName;
	private String diseKind;
	private String diseM;
	private String remarks;
	public String getDiseId() {
		return diseId;
	}
	public void setDiseId(String diseId) {
		this.diseId = diseId;
	}
	public String getDiseName() {
		return diseName;
	}
	public void setDiseName(String diseName) {
		this.diseName = diseName;
	}
	public String getDiseKind() {
		return diseKind;
	}
	public void setDiseKind(String diseKind) {
		this.diseKind = diseKind;
	}
	public String getDiseM() {
		return diseM;
	}
	public void setDiseM(String diseM) {
		this.diseM = diseM;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BingZhong(String diseId, String diseName, String diseKind,
			String diseM, String remarks) {
		super();
		this.diseId = diseId;
		this.diseName = diseName;
		this.diseKind = diseKind;
		this.diseM = diseM;
		this.remarks = remarks;
	}
	public BingZhong() {
		super();
	}
	@Override
	public String toString() {
		return "BingZhong [diseId=" + diseId + ", diseName=" + diseName
				+ ", diseKind=" + diseKind + ", diseM=" + diseM + ", remarks="
				+ remarks + "]";
	}
	
}
