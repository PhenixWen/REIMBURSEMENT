package hrbeu.entity;

public class CureKind {
	private String id;
	private String cureKind;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCureKind() {
		return cureKind;
	}
	public void setCureKind(String cureKind) {
		this.cureKind = cureKind;
	}
	public CureKind(String id, String cureKind) {
		super();
		this.id = id;
		this.cureKind = cureKind;
	}
	public CureKind() {
		super();
	}
	@Override
	public String toString() {
		return "CureKind [id=" + id + ", cureKind=" + cureKind + "]";
	}
	
}
