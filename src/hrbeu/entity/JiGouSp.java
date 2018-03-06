package hrbeu.entity;

public class JiGouSp {
	private int spID;
	private int personID;
	private String compID;
	private String stdate;
	private String state;
	private String personName;
	private String eddate;
	public JiGouSp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	


	public JiGouSp(int spID, int personID, String compID, String stdate,
			String state, String personName, String eddate) {
		super();
		this.spID = spID;
		this.personID = personID;
		this.compID = compID;
		this.stdate = stdate;
		this.state = state;
		this.personName = personName;
		this.eddate = eddate;
	}

	public String getEddate() {
		return eddate;
	}

	public void setEddate(String eddate) {
		this.eddate = eddate;
	}

	@Override
	public String toString() {
		return "JiGouSp [spID=" + spID + ", personID=" + personID + ", compID="
				+ compID + ", stdate=" + stdate + ", state=" + state
				+ ", personName=" + personName + ", eddate=" + eddate + "]";
	}

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
	public String getCompID() {
		return compID;
	}
	public void setCompID(String compID) {
		this.compID = compID;
	}
	public String getStdate() {
		return stdate;
	}
	public void setStdate(String stdate) {
		this.stdate = stdate;
	}
	
	
}
