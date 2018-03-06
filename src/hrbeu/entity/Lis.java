package hrbeu.entity;

public class Lis {
	private int ide;
	private String mediId;
	private String projId;
	private String servId;
	private float price;
	private int num;
	private float sum;
	private String solveId;
	private String name;
	private String feeKind;
	private String hosRank;
	private String hosRankId;
	private String examine;
	public int getIde() {
		return ide;
	}
	public void setIde(int ide) {
		this.ide = ide;
	}
	public String getMediId() {
		return mediId;
	}
	public void setMediId(String mediId) {
		this.mediId = mediId;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getServId() {
		return servId;
	}
	public void setServId(String servId) {
		this.servId = servId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getSolveId() {
		return solveId;
	}
	public void setSolveId(String solveId) {
		this.solveId = solveId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public String getHosRankId() {
		return hosRankId;
	}
	public void setHosRankId(String hosRankId) {
		this.hosRankId = hosRankId;
	}
	@Override
	public String toString() {
		return "Lis [ide=" + ide + ", mediId=" + mediId + ", projId=" + projId
				+ ", servId=" + servId + ", price=" + price + ", num=" + num
				+ ", sum=" + sum + ", solveId=" + solveId + ", name=" + name
				+ ", feeKind=" + feeKind + ", hosRank=" + hosRank
				+ ", hosRankId=" + hosRankId + "]";
	}
	public Lis(int ide, String mediId, String projId, String servId,
			float price, int num, float sum, String solveId, String name,
			String feeKind, String hosRank, String hosRankId) {
		super();
		this.ide = ide;
		this.mediId = mediId;
		this.projId = projId;
		this.servId = servId;
		this.price = price;
		this.num = num;
		this.sum = sum;
		this.solveId = solveId;
		this.name = name;
		this.feeKind = feeKind;
		this.hosRank = hosRank;
		this.hosRankId = hosRankId;
	}
	public Lis() {
		super();
	}
	public String getExamine() {
		return examine;
	}
	public void setExamine(String examine) {
		this.examine = examine;
	}
}
