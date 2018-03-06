package hrbeu.entity;

public class PatientKind {
	private String id;
	private String patientKind;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatientKind() {
		return patientKind;
	}
	public void setPatientKind(String patientKind) {
		this.patientKind = patientKind;
	}
	public PatientKind(String id, String patientKind) {
		super();
		this.id = id;
		this.patientKind = patientKind;
	}
	public PatientKind() {
		super();
	}
	@Override
	public String toString() {
		return "PatientKind [id=" + id + ", patientKind=" + patientKind + "]";
	}
	
}
