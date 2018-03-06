package hrbeu.entity;

public class FeeKind {
	private String id;
	private String feeKind;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public FeeKind(String id, String feeKind) {
		super();
		this.id = id;
		this.feeKind = feeKind;
	}
	public FeeKind() {
		super();
	}
	@Override
	public String toString() {
		return "FeeKind [id=" + id + ", feeKind=" + feeKind + "]";
	}
	
}
