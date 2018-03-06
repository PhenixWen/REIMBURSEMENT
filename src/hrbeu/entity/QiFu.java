package hrbeu.entity;

public class QiFu {
	private Integer ide;
	private String cureKind;
	private String patientKind;
	private String hosRank;
	private double std;
	
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

	public double getStd() {
		return std;
	}

	public void setStd(double std) {
		this.std = std;
	}

	public QiFu() {
		super();
	}

	public QiFu(Integer ide, String cureKind, String patientKind,
			String hosRank, double std) {
		super();
		this.ide = ide;
		this.cureKind = cureKind;
		this.patientKind = patientKind;
		this.hosRank = hosRank;
		this.std = std;
	}

	@Override
	public String toString() {
		return "QiFu [ide=" + ide + ", cureKind=" + cureKind + ", patientKind="
				+ patientKind + ", hosRank=" + hosRank + ", std=" + std + "]";
	}
	
	
}
