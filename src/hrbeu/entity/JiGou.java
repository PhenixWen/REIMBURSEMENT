package hrbeu.entity;

public class JiGou {
	private String compId;
	private String compName;
	private String hosRank;
	private String kind;
	private String nam;
	private String tel;
	private String remarks;
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public JiGou(String compId, String compName, String hosRank, String kind,
			String nam, String tel, String remarks) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.hosRank = hosRank;
		this.kind = kind;
		this.nam = nam;
		this.tel = tel;
		this.remarks = remarks;
	}
	public JiGou() {
		super();
	}
	@Override
	public String toString() {
		return "JiGou [compId=" + compId + ", compName=" + compName
				+ ", hosRank=" + hosRank + ", kind=" + kind + ", nam=" + nam
				+ ", tel=" + tel + ", remarks=" + remarks + "]";
	}
	
}
