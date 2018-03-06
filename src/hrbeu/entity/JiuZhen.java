package hrbeu.entity;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.dao.JiGouSpDaoImpl;
import hrbeu.dao.LisDaoImpl;
import hrbeu.dao.PersonDaoImpl;
import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.dao.YaoPinSpDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JiuZhen {
	private String solveId;
	private String personId;
	private String nianfen;
	private String hosRankId;
	private String compId;
	private String cureId;
	private String inDate;
	private String outDate;
	private String diseId;
	private String outReason;
	private String settlement;
	private String compName;
	private String hosRank;
	private String diseName;
	private String diseM;
	private String personName;
	private String certifiId;	
	private String insName;
	private String patientKind;
	private String cureKind;
	private float fd;
	private float qf;
	private float sum;
	private float zf;
	private float zfyl;
	private float bx;
	private float zffd;
	private float bxlj;
	private String zflis;
	private String yllis;
	public String getZflis() {
		return zflis;
	}
	public void setZflis(String zflis) {
		this.zflis = zflis;
	}
	public String getYllis() {
		return yllis;
	}
	public void setYllis(String yllis) {
		this.yllis = yllis;
	}
	public String getSolveId() {
		return solveId;
	}
	public void setSolveId(String solveId) {
		this.solveId = solveId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getNianfen() {
		return nianfen;
	}
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	public String getHosRankId() {
		return hosRankId;
	}
	public void setHosRankId(String hosRankId) {
		this.hosRankId = hosRankId;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getCureId() {
		return cureId;
	}
	public void setCureId(String cureId) {
		this.cureId = cureId;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getDiseId() {
		return diseId;
	}
	public void setDiseId(String diseId) {
		this.diseId = diseId;
	}
	public String getOutReason() {
		return outReason;
	}
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getHosRank() {
		return hosRank;
	}
	public void setHosRank(String hosRank) {
		this.hosRank = hosRank;
	}
	public String getDiseName() {
		return diseName;
	}
	public void setDiseName(String diseName) {
		this.diseName = diseName;
	}
	public String getDiseM() {
		return diseM;
	}
	public void setDiseM(String diseM) {
		this.diseM = diseM;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCertifiId() {
		return certifiId;
	}
	public void setCertifiId(String certifiId) {
		this.certifiId = certifiId;
	}
	public String getInsName() {
		return insName;
	}
	public void setInsName(String insName) {
		this.insName = insName;
	}
	public String getPatientKind() {
		return patientKind;
	}
	public void setPatientKind(String patientKind) {
		this.patientKind = patientKind;
	}
	public String getCureKind() {
		return cureKind;
	}
	public void setCureKind(String cureKind) {
		this.cureKind = cureKind;
	}
	public float getFd() {
		return fd;
	}
	public void setFd(float fd) {
		this.fd = fd;
	}
	public float getQf() {
		return qf;
	}
	public void setQf(float qf) {
		this.qf = qf;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public float getZf() {
		return zf;
	}
	public void setZf(float zf) {
		this.zf = zf;
	}
	public float getZfyl() {
		return zfyl;
	}
	public void setZfyl(float zfyl) {
		this.zfyl = zfyl;
	}
	public float getBx() {
		return bx;
	}
	public void setBx(float bx) {
		this.bx = bx;
	}
	public float getZffd() {
		return zffd;
	}
	public void setZffd(float zffd) {
		this.zffd = zffd;
	}
	public float getBxlj() {
		return bxlj;
	}
	public void setBxlj(float bxlj) {
		this.bxlj = bxlj;
	}
	@Override
	public String toString() {
		return "JiuZhen [solveId=" + solveId + ", personId=" + personId
				+ ", nianfen=" + nianfen + ", hosRankId=" + hosRankId
				+ ", compId=" + compId + ", cureId=" + cureId + ", inDate="
				+ inDate + ", outDate=" + outDate + ", diseId=" + diseId
				+ ", outReason=" + outReason + ", settlement=" + settlement
				+ ", compName=" + compName + ", hosRank=" + hosRank
				+ ", diseName=" + diseName + ", diseM=" + diseM
				+ ", personName=" + personName + ", certifiId=" + certifiId
				+ ", insName=" + insName + ", patientKind=" + patientKind
				+ ", cureKind=" + cureKind + ", fd=" + fd + ", qf=" + qf
				+ ", sum=" + sum + ", zf=" + zf + ", zfyl=" + zfyl + ", bx="
				+ bx + ", zffd=" + zffd + ", bxlj=" + bxlj + "]";
	}
	public JiuZhen(String solveId, String personId, String nianfen,
			String hosRankId, String compId, String cureId, String inDate,
			String outDate, String diseId, String outReason, String settlement,
			String compName, String hosRank, String diseName, String diseM,
			String personName, String certifiId, String insName,
			String patientKind, String cureKind, float fd, float qf, float sum,
			float zf, float zfyl, float bx, float zffd, float bxlj) {
		super();
		this.solveId = solveId;
		this.personId = personId;
		this.nianfen = nianfen;
		this.hosRankId = hosRankId;
		this.compId = compId;
		this.cureId = cureId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.diseId = diseId;
		this.outReason = outReason;
		this.settlement = settlement;
		this.compName = compName;
		this.hosRank = hosRank;
		this.diseName = diseName;
		this.diseM = diseM;
		this.personName = personName;
		this.certifiId = certifiId;
		this.insName = insName;
		this.patientKind = patientKind;
		this.cureKind = cureKind;
		this.fd = fd;
		this.qf = qf;
		this.sum = sum;
		this.zf = zf;
		this.zfyl = zfyl;
		this.bx = bx;
		this.zffd = zffd;
		this.bxlj = bxlj;
	}
	public JiuZhen(String solveId, String personId, String nianfen,
			String hosRankId, String compId, String cureId, String inDate,
			String outDate, String diseId, String outReason, String settlement) {
		super();
		this.solveId = solveId;
		this.personId = personId;
		this.nianfen = nianfen;
		this.hosRankId = hosRankId;
		this.compId = compId;
		this.cureId = cureId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.diseId = diseId;
		this.outReason = outReason;
		this.settlement = settlement;
	}
	public JiuZhen(String solveId, String personId, String nianfen,
			String hosRankId, String compId, String cureId, String inDate,
			String outDate, String diseId, String outReason, String settlement,
			String compName, String hosRank, String diseName, String diseM,
			String personName, String certifiId, String insName,
			String patientKind, String cureKind, float fd, float qf) {
		super();
		this.solveId = solveId;
		this.personId = personId;
		this.nianfen = nianfen;
		this.hosRankId = hosRankId;
		this.compId = compId;
		this.cureId = cureId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.diseId = diseId;
		this.outReason = outReason;
		this.settlement = settlement;
		this.compName = compName;
		this.hosRank = hosRank;
		this.diseName = diseName;
		this.diseM = diseM;
		this.personName = personName;
		this.certifiId = certifiId;
		this.insName = insName;
		this.patientKind = patientKind;
		this.cureKind = cureKind;
		this.fd = fd;
		this.qf = qf;
	}
	public JiuZhen(String solveId, String personId, String nianfen,
			String hosRankId, String compId, String cureId, String inDate,
			String outDate, String diseId, String outReason, String settlement,
			String compName, String hosRank, String diseName, String diseM) {
		super();
		this.solveId = solveId;
		this.personId = personId;
		this.nianfen = nianfen;
		this.hosRankId = hosRankId;
		this.compId = compId;
		this.cureId = cureId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.diseId = diseId;
		this.outReason = outReason;
		this.settlement = settlement;
		this.compName = compName;
		this.hosRank = hosRank;
		this.diseName = diseName;
		this.diseM = diseM;
	}
	public JiuZhen(String solveId, String personId, String nianfen,
			String hosRankId, String compId, String cureId, String inDate,
			String outDate, String diseId, String outReason, String settlement,
			String compName, String hosRank, String diseName, String diseM,
			String personName, String certifiId, String insName,
			String patientKind, String cureKind, float fd, float qf, float sum,
			float zf, float zfyl, float bx, float zffd, float bxlj,
			String zflis, String yllis) {
		super();
		this.solveId = solveId;
		this.personId = personId;
		this.nianfen = nianfen;
		this.hosRankId = hosRankId;
		this.compId = compId;
		this.cureId = cureId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.diseId = diseId;
		this.outReason = outReason;
		this.settlement = settlement;
		this.compName = compName;
		this.hosRank = hosRank;
		this.diseName = diseName;
		this.diseM = diseM;
		this.personName = personName;
		this.certifiId = certifiId;
		this.insName = insName;
		this.patientKind = patientKind;
		this.cureKind = cureKind;
		this.fd = fd;
		this.qf = qf;
		this.sum = sum;
		this.zf = zf;
		this.zfyl = zfyl;
		this.bx = bx;
		this.zffd = zffd;
		this.bxlj = bxlj;
		this.zflis = zflis;
		this.yllis = yllis;
	}
	public void calc(){
		float bxs = 0;
		YaoPinDaoImpl ypd = new YaoPinDaoImpl();
		LisDaoImpl lisd = new LisDaoImpl();
		List<Lis> liss = lisd.queryall(solveId);
		Person person = new PersonDaoImpl().selectAllPerson(personId, null).get(0);
		String person_compId = person.getCompID();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String NOW = sdf.format(d);
		boolean can = false;
		if(person_compId.equals(compId)) can = true;
		else {
			String compName = new JiGouDaoImpl().query(compId, null, null, null).get(0).getCompName();
			List<JiGouSp> sps = new JiGouSpDaoImpl().query(personId, compName);
			for(JiGouSp sp : sps){
				String state = sp.getState();
				String s = sp.getStdate();
				String t = sp.getEddate();
				if(s.compareTo(NOW) <= 0 && NOW.compareTo(t) <= 0 && state != null && state != "" && state.equals("已通过")){
					can = true;
					break;
				}
			}
		}
		zflis = ""; yllis = "";
		sum = zf = zfyl = bx = zffd = 0;
		for(Lis lis : liss) {
			sum += lis.getSum();
			if(diseM.equals("可报销") && can){
				if(lis.getServId() == null || lis.getServId() == ""){
					double cur = 0;
			    	if(lis.getHosRankId().compareTo(hosRankId) < 0) zflis += lis.getName() + " ";
			    	else {
			    		double max = Integer.MAX_VALUE;
			    		String mediId = lis.getMediId(); 
			    		if(mediId != null && mediId != ""){
			    			YaoPin yaopin = ypd.query(mediId, null, null, null).get(0);
							double ceiling = yaopin.getCeilingPri();
							String mediName = yaopin.getMediName();
							if(ceiling > 0) max = ceiling;
			    			String need = yaopin.getExamine();
			    			System.out.println(mediName);
			    			System.out.println(need);
			    			List<YaoPinSp> sps = new YaoPinSpDaoImpl().query(personId, mediName);
			    			System.out.println(sps.size());
			    			boolean ok = false;
			    			for(YaoPinSp sp : sps){
			    				String state = sp.getState();
			    				String s = sp.getStdate();
			    				String t = sp.getEddate();
			    				System.out.println(state);
			    				if(s.compareTo(NOW) <= 0 && NOW.compareTo(t) <= 0 && state != null && state != "" && state.equals("已通过")){
			    					ok = true;
			    					break;
			    				}
			    			}
			    			if(need != null && need != "" && need.equals("需要审批") && !ok){
			    				zflis += lis.getName() + " ";
			    				continue;			    			
			    			}
			    		}
			    		switch (lis.getFeeKind()) {
						case "甲类":
							if(lis.getPrice() > max) cur += max * lis.getNum();
							else cur += lis.getSum();
							break;
						case "乙类":
							if(lis.getPrice() > max){
								cur += max * lis.getNum() * 0.5;
								zfyl += max * lis.getNum() * 0.5 + (lis.getPrice() - max) * lis.getNum();
							}else {
								cur += lis.getSum() * 0.5;
								zfyl += lis.getSum() * 0.5;
							}
							yllis += lis.getName() + " ";
							break;	
			    		case "丙类":
			    			zflis += lis.getName() + " ";
						break;
			    		}
			    	}
			    	bxs += cur;
				}else bxs += lis.getSum();
			}
		}
//		System.out.println(bxs);
//		System.out.println(qf);
//		System.out.println(cureKind);
//		System.out.println(patientKind);
//		System.out.println(hosRank);
	    if(bxs > qf) {
	    	List<FenDuan> fds = new FenDuanDaoImpl().query(null, cureKind, patientKind, hosRank);
		    for(FenDuan lev : fds){
		    	if(bxs >= lev.getFloor() && (bxs <= lev.getCeiling() || (lev.getCeiling() < -0.999999 && lev.getCeiling() > -1.000001))){
					zffd += (bxs - lev.getFloor()) * lev.getRatio();
					bx += (bxs - lev.getFloor()) * (1.0 - lev.getRatio());					
				}
		    	if (bxs > lev.getCeiling() && (lev.getCeiling() > 0)) {
					zffd += (lev.getCeiling() - lev.getFloor()) * lev.getRatio();
					bx += (lev.getCeiling() - lev.getFloor()) * (1.0 - lev.getRatio());
				}
			}
		}
	    float left = fd - bxlj; if(left < 0) left = 0;
	    if(bx >= left) bx = left;
	    zf = sum - bx;
	    bxlj += bx;
	    bx = (float)(Math.round(bx*100)*1.0/100);
	    bxlj = (float)(Math.round(bxlj*100)*1.0/100);
	    zf = (float)(Math.round(zf*100)*1.0/100);
	    zfyl = (float)(Math.round(zfyl*100)*1.0/100);
	    sum = (float)(Math.round(sum*100)*1.0/100);
	    zffd = (float)(Math.round(zffd*100)*1.0/100);
	    fd = (float)(Math.round(fd*100)*1.0/100);
	    qf = (float)(Math.round(qf*100)*1.0/100);
	    if(zflis == "") zflis = "无";
	    if(yllis == "") yllis = "无";
	}
}