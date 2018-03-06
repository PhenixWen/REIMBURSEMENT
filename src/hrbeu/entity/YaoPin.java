package hrbeu.entity;

public class YaoPin {
	private String mediId;
	private String mediName;
	private String feeKind;
	private String chargeRank;
	private double ceilingPri;
	private String hosRank;
	private String factorName;
	private String drugCertificate;
	private String remarks;
	private String useFrequency;
	private String useMethod;
	private String place;
	private Integer dayy;
	private String examine;
	public String getMediId() {
		return mediId;
	}
	public void setMediId(String mediId) {
		this.mediId = mediId;
	}
	public String getMediName() {
		return mediName;
	}
	public void setMediName(String mediName) {
		this.mediName = mediName;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public String getChargeRank() {
		return chargeRank;
	}
	public void setChargeRank(String chargeRank) {
		this.chargeRank = chargeRank;
	}
	public double getCeilingPri() {
		return ceilingPri;
	}
	public void setCeilingPri(double ceilingPri) {
		this.ceilingPri = ceilingPri;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public String getDrugCertificate() {
		return drugCertificate;
	}
	public void setDrugCertificate(String drugCertificate) {
		this.drugCertificate = drugCertificate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUseFrequency() {
		return useFrequency;
	}
	public void setUseFrequency(String useFrequency) {
		this.useFrequency = useFrequency;
	}
	public String getUseMethod() {
		return useMethod;
	}
	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getDayy() {
		return dayy;
	}
	public void setDayy(Integer dayy) {
		this.dayy = dayy;
	}
	public String getExamine() {
		return examine;
	}
	public void setExamine(String examine) {
		this.examine = examine;
	}
	public YaoPin(String mediId, String mediName, String feeKind,
			String chargeRank, double ceilingPri, String hosRank,
			String factorName, String drugCertificate, String remarks,
			String useFrequency, String useMethod, String place, Integer dayy,
			String examine) {
		super();
		this.mediId = mediId;
		this.mediName = mediName;
		this.feeKind = feeKind;
		this.chargeRank = chargeRank;
		this.ceilingPri = ceilingPri;
		this.hosRank = hosRank;
		this.factorName = factorName;
		this.drugCertificate = drugCertificate;
		this.remarks = remarks;
		this.useFrequency = useFrequency;
		this.useMethod = useMethod;
		this.place = place;
		this.dayy = dayy;
		this.examine = examine;
	}
	@Override
	public String toString() {
		return "YaoPin [mediId=" + mediId + ", mediName=" + mediName
				+ ", feeKind=" + feeKind + ", chargeRank=" + chargeRank
				+ ", ceilingPri=" + ceilingPri + ", hosRank=" + hosRank
				+ ", factorName=" + factorName + ", drugCertificate="
				+ drugCertificate + ", remarks=" + remarks + ", useFrequency="
				+ useFrequency + ", useMethod=" + useMethod + ", place="
				+ place + ", dayy=" + dayy + ", examine=" + examine + "]";
	}
	
	
}
