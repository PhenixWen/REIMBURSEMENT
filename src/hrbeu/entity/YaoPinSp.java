package hrbeu.entity;

public class YaoPinSp {
	private int spID;
	private int personID;
	private String mediId;
	private String stdate;
	private String state;
	private String personName;
	private String eddate;
	public int getSpID() {
		return spID;
	}
	public void setSpID(int spID) {
		this.spID = spID;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getMediId() {
		return mediId;
	}
	public void setMediId(String mediId) {
		this.mediId = mediId;
	}
	public String getStdate() {
		return stdate;
	}
	public void setStdate(String stdate) {
		this.stdate = stdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
	public YaoPinSp(int spID, int personID, String mediId, String stdate,
			String state, String personName, String eddate) {
		super();
		this.spID = spID;
		this.personID = personID;
		this.mediId = mediId;
		this.stdate = stdate;
		this.state = state;
		this.personName = personName;
		this.eddate = eddate;
	}
	@Override
	public String toString() {
		return "YaoPinSp [spID=" + spID + ", personID=" + personID
				+ ", mediId=" + mediId + ", stdate=" + stdate + ", state="
				+ state + ", personName=" + personName + ", eddate=" + eddate
				+ "]";
	}
	public String getEddate() {
		return eddate;
	}
	public void setEddate(String eddate) {
		this.eddate = eddate;
	}
	public YaoPinSp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
