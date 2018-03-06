package hrbeu.entity;

public class FengDing {
	private Integer ide;
	private String patientKind;
	private double ceiling;
	public Integer getIde() {
		return ide;
	}
	public void setIde(Integer ide) {
		this.ide = ide;
	}
	public String getPatientKind() {
		return patientKind;
	}
	public void setPatientKind(String patientKind) {
		this.patientKind = patientKind;
	}
	public double getCeiling() {
		return ceiling;
	}
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	public FengDing(Integer ide, String patientKind, double ceiling) {
		super();
		this.ide = ide;
		this.patientKind = patientKind;
		this.ceiling = ceiling;
	}
	public FengDing() {
		super();
	}
	@Override
	public String toString() {
		return "FengDing [ide=" + ide + ", patientKind=" + patientKind
				+ ", ceiling=" + ceiling + "]";
	}
	
	
}
