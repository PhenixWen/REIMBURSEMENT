package hrbeu.entity;

public class LogIn {
	private String name;
	private String psw;
	@Override
	public String toString() {
		return "LogIn [name=" + name + ", psw=" + psw + "]";
	}
	public LogIn(String name, String psw) {
		super();
		this.name = name;
		this.psw = psw;
	}
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
