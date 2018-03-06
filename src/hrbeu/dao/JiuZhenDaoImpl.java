package hrbeu.dao;

import hrbeu.entity.BingZhong;
import hrbeu.entity.FengDing;
import hrbeu.entity.JiuZhen;
import hrbeu.entity.Person;
import hrbeu.entity.QiFu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JiuZhenDaoImpl implements JiuZhenDao{

	@Override
	public void insert(JiuZhen jiuzhen) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into jiuzhen values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,0,0,0,0,'','')";
		try {
			String personId = jiuzhen.getPersonId();
			ps = conn.prepareStatement(sql);
			ps.setString(1, jiuzhen.getSolveId());
			ps.setString(2, personId);
			ps.setString(3, jiuzhen.getNianfen());
			ps.setString(4, jiuzhen.getHosRankId());
			ps.setString(5, jiuzhen.getCompId());
			ps.setString(6, jiuzhen.getCureId());
			ps.setString(7, jiuzhen.getInDate());
			ps.setString(8, jiuzhen.getOutDate());
			ps.setString(9, jiuzhen.getDiseId());
			ps.setString(10, jiuzhen.getOutReason());
			ps.setString(11, jiuzhen.getSettlement());
			String cureId = jiuzhen.getCureId(), compId = jiuzhen.getCompId();
			String cureKind = new CureKindDaoImpl().queryKind(cureId);
			String compName = new JiGouDaoImpl().query(compId, null, null, null).get(0).getCompName();
			String hosRank = new HosRankDaoImpl().queryRank(jiuzhen.getHosRankId());
			String patientId = new PersonDaoImpl().selectAllPerson(personId, null).get(0).getPatID();
			String patientKind = new PatientKindDaoImpl().queryKind(patientId);
			List<BingZhong> bingzhongs = new BingZhongDaoImpl().query(jiuzhen.getDiseId(), null, null);
			String diseName = bingzhongs.get(0).getDiseName();
			String diseM = bingzhongs.get(0).getDiseM();
		    Person person = new PersonDaoImpl().selectAllPerson(personId, null).get(0);
		    String personName = person.getPersonName();
		    String certifiId = person.getCertifiID();
		    int insId = person.getInsID();
		    String insName = new InsDaoImpl().selectAllIns(String.valueOf(insId), null, false).get(0).getInsName();
		    List<FengDing> fds= new FengDingDaoImpl().query(null, patientKind);
		    float fd;
		    if(fds.size() == 0) fd = 10000;
		    else fd = (float)(fds.get(0).getCeiling());
		    List<QiFu> qfs = new QiFuDaoImpl().query(null, cureKind, patientKind, hosRank);
		    float qf;
		    if(qfs.size() == 0) qf = 1000;
		    else qf = (float)(qfs.get(0).getStd());
			ps.setString(12, compName);
			ps.setString(13, hosRank);
			ps.setString(14, diseName);
			ps.setString(15, diseM);
			ps.setString(16, personName);
			ps.setString(17, certifiId);
			ps.setString(18, insName);
			ps.setString(19, patientKind);
			ps.setString(20, cureKind);
			ps.setFloat(21, fd);
			ps.setFloat(22, qf);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	
	@Override
	public void updateall(JiuZhen jiuzhen) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String solveId = jiuzhen.getSolveId();
		String sql = "update jiuzhen set HOS_RANK_ID = ?, COMP_ID = ? , CURE_ID = ? , IN_DATE = ? , OUT_DATE = ? , DISE_ID = ?"
				+ ", OUT_REASON = ? , COMP_NAME = ? , HOS_RANK = ? , DISE_NAME = ? , DISE_M = ? , PERSON_NAME = ?  "
				+ ", CERTIFI_ID = ? , INS_NAME = ? , PATIENT_KIND = ? , CURE_KIND = ? , FD = ? , QF = ? where solve_Id = '" + solveId + "'";
		try {
			String personId = jiuzhen.getPersonId();
			ps = conn.prepareStatement(sql);
			ps.setString(1, jiuzhen.getHosRankId());
			ps.setString(2, jiuzhen.getCompId());
			ps.setString(3, jiuzhen.getCureId());
			ps.setString(4, jiuzhen.getInDate());
			ps.setString(5, jiuzhen.getOutDate());
			ps.setString(6, jiuzhen.getDiseId());
			ps.setString(7, jiuzhen.getOutReason());
			String cureId = jiuzhen.getCureId(), compId = jiuzhen.getCompId();
			String cureKind = new CureKindDaoImpl().queryKind(cureId);
			String compName = new JiGouDaoImpl().query(compId, null, null, null).get(0).getCompName();
			String hosRank = new HosRankDaoImpl().queryRank(jiuzhen.getHosRankId());
			String patientId = new PersonDaoImpl().selectAllPerson(personId, null).get(0).getPatID();
			String patientKind = new PatientKindDaoImpl().queryKind(patientId);
			List<BingZhong> bingzhongs = new BingZhongDaoImpl().query(jiuzhen.getDiseId(), null, null);
			String diseName = bingzhongs.get(0).getDiseName();
			String diseM = bingzhongs.get(0).getDiseM();
		    Person person = new PersonDaoImpl().selectAllPerson(personId, null).get(0);
		    String personName = person.getPersonName();
		    String certifiId = person.getCertifiID();
		    int insId = person.getInsID();
		    String insName = new InsDaoImpl().selectAllIns(String.valueOf(insId), null, false).get(0).getInsName();
		    List<FengDing> fds= new FengDingDaoImpl().query(null, patientKind);
		    float fd;
		    if(fds.size() == 0) fd = 10000;
		    else fd = (float)(fds.get(0).getCeiling());
		    List<QiFu> qfs = new QiFuDaoImpl().query(null, cureKind, patientKind, hosRank);
		    float qf;
		    if(qfs.size() == 0) qf = 1000;
		    else qf = (float)(qfs.get(0).getStd());
			ps.setString(8, compName);
			ps.setString(9, hosRank);
			ps.setString(10, diseName);
			ps.setString(11, diseM);
			ps.setString(12, personName);
			ps.setString(13, certifiId);
			ps.setString(14, insName);
			ps.setString(15, patientKind);
			ps.setString(16, cureKind);
			ps.setFloat(17, fd);
			ps.setFloat(18, qf);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	
	
	@Override
	public List<JiuZhen> query(String _solveId, String _personId, String _personName, String flag) {
		List<JiuZhen> jiuzhens = new ArrayList<JiuZhen>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select solve_id, person_id, nianfen, hos_rank_id, comp_id, cure_id,"
				+ "in_date, out_date, dise_id, out_reason, settlement, COMP_NAME, HOS_RANK, DISE_NAME, DISE_M, "
				+ "PERSON_NAME, CERTIFI_ID, INS_NAME, PATIENT_KIND, CURE_KIND, FD, QF, SUM, ZF, ZFYL, BX, ZFFD, BXLJ, zflis, yllis "
				+ " from jiuzhen where 1=1 ";
		if(_solveId !=null && !_solveId.equals("")){
			sql = sql +" and solve_Id = '" + _solveId + "'";
		}
		if(_personId !=null && !_personId.equals("")){
			sql = sql +" and person_Id = " + _personId + "";
		}
		if(_personName !=null && !_personName.equals("")){
			sql = sql +" and person_name = '" + _personName + "'";
		}
		if(flag !=null && !flag.equals("")){
			sql = sql +" and settlement = '" + flag + "'";
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String solveId = rs.getString(1);
				String personId = rs.getString(2);
				String nianfen = rs.getString(3);
				String hosRankId = rs.getString(4);
				String compId = rs.getString(5);
				String cureId = rs.getString(6);
				String inDate = rs.getString(7);
				String outDate = rs.getString(8);
				String diseId = rs.getString(9);
				String outReason = rs.getString(10);
				String settlement = rs.getString(11);
				String compName = rs.getString(12);
				String hosRank = rs.getString(13);
				String diseName = rs.getString(14);
				String diseM = rs.getString(15);
				String personName = rs.getString(16);
				String certifiId = rs.getString(17);
				String insName = rs.getString(18);
				String patientKind = rs.getString(19);
				String cureKind = rs.getString(20);
				float fd = rs.getFloat(21);
				float qf = rs.getFloat(22);
				float sum = rs.getFloat(23);
				float zf = rs.getFloat(24);
				float zfyl = rs.getFloat(25);
				float bx = rs.getFloat(26);
				float zffd = rs.getFloat(27);
				float bxlj = rs.getFloat(28);
				String zflis = rs.getString(29);
				String yllis = rs.getString(30);
				JiuZhen jiuzhen = new JiuZhen(solveId, personId, nianfen, hosRankId, compId, cureId, inDate, outDate, diseId, outReason, settlement, compName, hosRank, diseName, diseM,
				personName, certifiId, insName, patientKind, cureKind, fd, qf, sum, zf, zfyl, bx, zffd, bxlj, zflis, yllis);
				jiuzhens.add(jiuzhen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}		
		return jiuzhens;
	}

	@Override
	public void delete(String solveId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from jiuzhen where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<JiuZhen> queryPage(String _solveId, String _personId, String _personName, int page, String flag) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<JiuZhen> jiuzhens = new ArrayList<JiuZhen>();
		String sql = "select solve_id, person_id, nianfen, hos_rank_id, comp_id, cure_id,"
				+ "in_date, out_date, dise_id, out_reason, settlement, COMP_NAME, HOS_RANK, DISE_NAME, DISE_M, "
				+ " PERSON_NAME, CERTIFI_ID, INS_NAME, PATIENT_KIND, CURE_KIND, FD, QF, SUM, ZF, ZFYL, BX, ZFFD, BXLJ, zflis, yllis,"
				+ " rownum rn from jiuzhen where 1=1 ";
		if(_solveId !=null && !_solveId.equals("")){
			sql = sql +" and solve_Id = '" + _solveId + "'";
		}
		if(_personId !=null && !_personId.equals("")){
			sql = sql +" and person_Id = " + _personId + "";
		}
		if(_personName !=null && !_personName.equals("")){
			sql = sql +" and person_name = '" + _personName + "'";
		}
		if(flag !=null && !flag.equals("")){
			sql = sql +" and settlement = '" + flag + "'";
		}
		int max=page*5;
		int min=(page-1)*5+1;
		sql = "select e.* from ("+sql+") e where e.rn>="+min+" and e.rn<="+max;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String solveId = rs.getString(1);
				String personId = rs.getString(2);
				String nianfen = rs.getString(3);
				String hosRankId = rs.getString(4);
				String compId = rs.getString(5);
				String cureId = rs.getString(6);
				String inDate = rs.getString(7);
				String outDate = rs.getString(8);
				String diseId = rs.getString(9);
				String outReason = rs.getString(10);
				String settlement = rs.getString(11);
				String compName = rs.getString(12);
				String hosRank = rs.getString(13);
				String diseName = rs.getString(14);
				String diseM = rs.getString(15);
				String personName = rs.getString(16);
				String certifiId = rs.getString(17);
				String insName = rs.getString(18);
				String patientKind = rs.getString(19);
				String cureKind = rs.getString(20);
				float fd = rs.getFloat(21);
				float qf = rs.getFloat(22);
				float sum = rs.getFloat(23);
				float zf = rs.getFloat(24);
				float zfyl = rs.getFloat(25);
				float bx = rs.getFloat(26);
				float zffd = rs.getFloat(27);
				float bxlj = rs.getFloat(28);
				String zflis = rs.getString(29);
				String yllis = rs.getString(30);
				JiuZhen jiuzhen = new JiuZhen(solveId, personId, nianfen, hosRankId, compId, cureId, inDate, outDate, diseId, outReason, settlement, compName, hosRank, diseName, diseM,
				personName, certifiId, insName, patientKind, cureKind, fd, qf, sum, zf, zfyl, bx, zffd, bxlj, zflis, yllis);
				jiuzhens.add(jiuzhen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return jiuzhens;
	}

	@Override
	public int page(String _solveId, String _personId, String _personName, String flag) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from jiuzhen join renyuanxinx on (jiuzhen.person_id = renyuanxinx.person_id) where 1=1 ";
		if(_solveId !=null && !_solveId.equals("")){
			sql = sql +" and solve_Id = '" + _solveId + "'";
		}
		if(_personId !=null && !_personId.equals("")){
			sql = sql +" and jiuzhen.person_Id = " + _personId + "";
		}
		if(_personName !=null && !_personName.equals("")){
			sql = sql +" and person_name = '" + _personName + "'";
		}
		if(flag !=null && !flag.equals("")){
			sql = sql +" and settlement = '" + flag + "'";
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return count;
	}

	@Override
	public void solve(String solveId, float sum, float zf, float zfyl, float bx, float zffd, float bxlj, String zflis, String yllis) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update jiuzhen "
		+ "set sum = ?, zf = ?, zfyl = ?, bx = ?, zffd = ?, bxlj = ?, zflis = ?, yllis = ? where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, sum);
			ps.setFloat(2, zf);
			ps.setFloat(3, zfyl);
			ps.setFloat(4, bx);
			ps.setFloat(5, zffd);
			ps.setFloat(6, bxlj);
			ps.setString(7, zflis);
			ps.setString(8, yllis);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}	
	}

	@Override
	public void solveflag(String solveId){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select person_id, sum, zf, bx from jiuzhen where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String personId = rs.getString(1);
				float sum = rs.getFloat(2);
				float zf = rs.getFloat(3);
				float bx = rs.getFloat(4);
				new AnnualMoneyDaoImpl().updateAM(personId, 1, sum, bx, zf, 0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		conn = DBUtil.getConnection();
		ps = null;
		rs = null;
		sql = "update jiuzhen set settlement = '已结算' where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}	
	}
	
	@Override
	public void cancelflag(String solveId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select person_id, sum, zf, bx from jiuzhen where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String personId = rs.getString(1);
				float sum = rs.getFloat(2);
				float zf = rs.getFloat(3);
				float bx = rs.getFloat(4);
				new AnnualMoneyDaoImpl().updateAM(personId, -1, -sum, -bx, -zf, 0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		conn = DBUtil.getConnection();
		ps = null;
		rs = null;
		sql = "update jiuzhen set settlement = '未结算' where solve_id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}	
	}

	@Override
	public void update(String solveId) {
		JiuZhen jiuzhen = query(solveId, null, null, null).get(0);
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update jiuzhen set fd = ?, qf = ? where solve_Id = '" + solveId + "'";
		try {
			ps = conn.prepareStatement(sql);
			String personId = jiuzhen.getPersonId();
			String cureId = jiuzhen.getCureId();
			String cureKind = new CureKindDaoImpl().queryKind(cureId);
			String hosRank = new HosRankDaoImpl().queryRank(jiuzhen.getHosRankId());
			String patientId = new PersonDaoImpl().selectAllPerson(personId, null).get(0).getPatID();
			String patientKind = new PatientKindDaoImpl().queryKind(patientId);
			
		    List<FengDing> fds= new FengDingDaoImpl().query(null, patientKind);
		    float fd;
		    if(fds.size() == 0) fd = 10000;
		    else fd = (float)(fds.get(0).getCeiling());
		    List<QiFu> qfs = new QiFuDaoImpl().query(null, cureKind, patientKind, hosRank);
		    float qf;
		    if(qfs.size() == 0) qf = 1000;
		    else qf = (float)(qfs.get(0).getStd());
			ps.setFloat(1, fd);
			ps.setFloat(2, qf);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}
}