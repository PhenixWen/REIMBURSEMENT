package hrbeu.entity;

public class Ins {
/*	INSTITUTION_ID
	INSTITUTION_NAME
	INSTITUTION_TYPE
	INSTITUTION_ADDRESS
	INSTITUTION_POSTCODE
	INSTITUTION_TEL*/
	private int insID;
	private String insName;
	private String insType;
	private String insAdd;
	private String insPost;
	private String insTel;
	@Override
	public String toString() {
		return "Ins [insID=" + insID + ", insName=" + insName + ", insType="
				+ insType + ", insAdd=" + insAdd + ", insPost=" + insPost
				+ ", insTel=" + insTel + "]";
	}
	public Ins(int insID, String insName, String insType, String insAdd,
			String insPost, String insTel) {
		super();
		this.insID = insID;
		this.insName = insName;
		this.insType = insType;
		this.insAdd = insAdd;
		this.insPost = insPost;
		this.insTel = insTel;
	}
	public Ins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInsID() {
		return insID;
	}
	public void setInsID(int insID) {
		this.insID = insID;
	}
	public String getInsName() {
		return insName;
	}
	public void setInsName(String insName) {
		this.insName = insName;
	}
	public String getInsType() {
		return insType;
	}
	public void setInsType(String insType) {
		this.insType = insType;
	}
	public String getInsAdd() {
		return insAdd;
	}
	public void setInsAdd(String insAdd) {
		this.insAdd = insAdd;
	}
	public String getInsPost() {
		return insPost;
	}
	public void setInsPost(String insPost) {
		this.insPost = insPost;
	}
	public String getInsTel() {
		return insTel;
	}
	public void setInsTel(String insTel) {
		this.insTel = insTel;
	}
	
}
