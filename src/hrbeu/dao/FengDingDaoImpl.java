package hrbeu.dao;

import hrbeu.entity.FenDuan;
import hrbeu.entity.FengDing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FengDingDaoImpl implements FengDingDao{

	@Override
	public void add(FengDing f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into fengding values(?,?, fengding_seq.nextval)";
		//System.out.println(sql);
		String patientKindId = new PatientKindDaoImpl().queryId(f.getPatientKind());
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, patientKindId);
			ps.setDouble(2, f.getCeiling());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public void delete(int ide) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
//		System.out.println(patientKind);
		String sql = "delete from fengding where ide = " + ide;
		try
		{
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<FengDing> query(Integer idee, String patientKind) {
		List<FengDing> list = new ArrayList<FengDing>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, patient_id, ceiling from fengding where 1 = 1";
		if(patientKind != null && !patientKind.isEmpty() && !patientKind.equals("..."))
			sql += "and patient_id = '" + pkdi.queryId(patientKind) + "'";
		if(idee != null)
			sql += "and ide = " + idee;
		ResultSet rs = null;
		//System.out.println(sql);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int ide = rs.getInt(1);
				String patientKindN = pkdi.queryKind(rs.getString(2));
				double ceiling = rs.getDouble(3);
				FengDing f = new FengDing(ide, patientKindN, ceiling);
				list.add(f);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public void update(FengDing f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update fengding set ceiling = ? where patient_id = ?";
		String patientId = new PatientKindDaoImpl().queryId(f.getPatientKind());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(2, patientId);
			ps.setDouble(1, f.getCeiling());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(null, ps, conn);
		}
	}
//	public static void main(String[] args) {
//		FengDing f = new FengDing("学生", 30.0);
//		FengDingDaoImpl fddi = new FengDingDaoImpl();
//		fddi.add(f);
//		fddi.delete("学生");
//		fddi.update(f);
//		List<FengDing> list = new ArrayList<FengDing>();
//		list = fddi.query("学生");
//		System.out.println(list.get(0));
//	}

	@Override
	public List<FengDing> queryPage(Integer idee, String patientKind, int page) {
		List<FengDing> list = new ArrayList<FengDing>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, patient_id, ceiling, rownum rn from fengding where 1 = 1";
		if(patientKind != null && !patientKind.isEmpty() && !patientKind.equals("..."))
			sql += "and patient_id = '" + pkdi.queryId(patientKind) + "'";
		if(idee != null)
			sql += "and ide = " + idee;
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		ResultSet rs = null;
		//System.out.println(sql);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int ide = rs.getInt(1);
				String patientKindN = pkdi.queryKind(rs.getString(2));
				double ceiling = rs.getDouble(3);
				FengDing f = new FengDing(ide, patientKindN, ceiling);
				list.add(f);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
}
