package hrbeu.dao;

import hrbeu.entity.HosRank;
import hrbeu.entity.PatientKind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientKindDaoImpl implements PatientKindDao{

	@Override
	public String queryId(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select patient_id from yiliaorenyuan where patient_kind = '" + str + "'";
		String ans = null;
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
				ans = rs.getString(1);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return ans;
	}

	@Override
	public String queryKind(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select patient_kind from yiliaorenyuan where patient_id = '" + str + "'";
		String ans = null;
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
				ans = rs.getString(1);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return ans;
	}
//	public static void main(String[] args) {
//		System.out.println(new PatientKindDaoImpl().queryId("学生"));
//	}

	@Override
	public List<PatientKind> queryall() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from yiliaorenyuan";
		List<PatientKind> list = new ArrayList<PatientKind>();
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new PatientKind(rs.getString(1), rs.getString(2)));
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
//	public static void main(String[] args) {
//		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
//		List<PatientKind> list = pkdi.queryall();
//		for (PatientKind patientKind : list) {
//			System.out.println(patientKind);
//		}
//	}
}
