package hrbeu.entity;

public class AnnualMoney {
	private int personID;
	private String personName;
	private String nianfen;
	private int times;
	private double money;
	private double baoxiao;
	private double cost;
	private int ztimes;
	private Person person;
	private String done;
	private double fd;
	public double getFd() {
		return fd;
	}
	public void setFd(double fd) {
		this.fd = fd;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getNianfen() {
		return nianfen;
	}
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getBaoxiao() {
		return baoxiao;
	}
	public void setBaoxiao(double baoxiao) {
		this.baoxiao = baoxiao;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getZtimes() {
		return ztimes;
	}
	public void setZtimes(int ztimes) {
		this.ztimes = ztimes;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "AnnualMoney [personID=" + personID + ", personName="
				+ personName + ", nianfen=" + nianfen + ", times=" + times
				+ ", money=" + money + ", baoxiao=" + baoxiao + ", cost="
				+ cost + ", ztimes=" + ztimes + ", person=" + person + "]";
	}
	public AnnualMoney(int personID, String personName, String nianfen,
			int times, double money, double baoxiao, double cost, int ztimes,
			Person person) {
		super();
		this.personID = personID;
		this.personName = personName;
		this.nianfen = nianfen;
		this.times = times;
		this.money = money;
		this.baoxiao = baoxiao;
		this.cost = cost;
		this.ztimes = ztimes;
		this.person = person;
	}
	public AnnualMoney() {
		super();
	}
	public String getDone() {
		return done;
	}
	public void setDone(String done) {
		this.done = done;
	}
}
