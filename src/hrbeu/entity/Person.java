package hrbeu.entity;

public class Person {
	private int personID;
	private String certifiType;
	private String certifiID;
	private String personName;
	private String personSex;
	private String birthday;
	private int insID;
	private String patID;
	private int socialID;
	private String compID;
	
	
	public Person(int personID, String certifiType, String certifiID,
			String personName, String personSex, String birthday, int insID,
			String patID, int socialID, String compID) {
		super();
		this.personID = personID;
		this.certifiType = certifiType;
		this.certifiID = certifiID;
		this.personName = personName;
		this.personSex = personSex;
		this.birthday = birthday;
		this.insID = insID;
		this.patID = patID;
		this.socialID = socialID;
		this.compID = compID;
	}
	public String getCertifiType() {
		return certifiType;
	}
	@Override
	public String toString() {
		return "Person [personID=" + personID + ", certifiType=" + certifiType
				+ ", certifiID=" + certifiID + ", personName=" + personName
				+ ", personSex=" + personSex + ", birthday=" + birthday
				+ ", insID=" + insID + ", patID=" + patID + ", socialID="
				+ socialID + ", compID=" + compID + "]";
	}
	public void setCertifiType(String certifiType) {
		this.certifiType = certifiType;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getCertifiID() {
		return certifiID;
	}
	public void setCertifiID(String certifiID) {
		this.certifiID = certifiID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSex() {
		return personSex;
	}
	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getInsID() {
		return insID;
	}
	public void setInsID(int insID) {
		this.insID = insID;
	}
	public String getPatID() {
		return patID;
	}
	public void setPatID(String patID) {
		this.patID = patID;
	}
	public int getSocialID() {
		return socialID;
	}
	public void setSocialID(int socialID) {
		this.socialID = socialID;
	}
	public String getCompID() {
		return compID;
	}
	public void setCompID(String compID) {
		this.compID = compID;
	}
	
}
