package hrbeu.entity;

public class HosRank {
	private String id;
	private String hosRank;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public HosRank(String id, String hosRank) {
		super();
		this.id = id;
		this.hosRank = hosRank;
	}
	public HosRank() {
		super();
	}
	@Override
	public String toString() {
		return "HosRank [id=" + id + ", hosRank=" + hosRank + "]";
	}
	
}
