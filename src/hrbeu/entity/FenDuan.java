package hrbeu.entity;

public class FenDuan {
	private Integer ide;
	private String cureKind;
	private String patientKind;
	private String hosRank;
	private double ceiling;
	private double floor;
	private double ratio;
	public Integer getIde() {
		return ide;
	}
	public void setIde(Integer ide) {
		this.ide = ide;
	}
	public String getCureKind() {
		return cureKind;
	}
	public void setCureKind(String cureKind) {
		this.cureKind = cureKind;
	}
	public String getPatientKind() {
		return patientKind;
	}
	public void setPatientKind(String patientKind) {
		this.patientKind = patientKind;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public double getCeiling() {
		return ceiling;
	}
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	public double getFloor() {
		return floor;
	}
	public void setFloor(double floor) {
		this.floor = floor;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public FenDuan(Integer ide, String cureKind, String patientKind,
			String hosRank, double ceiling, double floor, double ratio) {
		super();
		this.ide = ide;
		this.cureKind = cureKind;
		this.patientKind = patientKind;
		this.hosRank = hosRank;
		this.ceiling = ceiling;
		this.floor = floor;
		this.ratio = ratio;
	}
	public FenDuan() {
		super();
	}
	@Override
	public String toString() {
		return "FenDuan [ide=" + ide + ", cureKind=" + cureKind
				+ ", patientKind=" + patientKind + ", hosRank=" + hosRank
				+ ", ceiling=" + ceiling + ", floor=" + floor + ", ratio="
				+ ratio + "]";
	}
	
}
