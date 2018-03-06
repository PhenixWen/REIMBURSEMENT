package hrbeu.dao;

import hrbeu.entity.FenDuan;
import hrbeu.entity.JiGou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FenDuanDaoImpl implements FenDuanDao{

	@Override
	public void add(FenDuan f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into fenduan values(fenduan_seq.nextval,?,?,?,?,?,?)";
		String hosRankId = new HosRankDaoImpl().queryId(f.getHosRank());
		String cureKindId = new CureKindDaoImpl().queryId(f.getCureKind());
		String patientKindId = new PatientKindDaoImpl().queryId(f.getPatientKind());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cureKindId);
			ps.setString(2, patientKindId);
			ps.setString(3, hosRankId);
			ps.setDouble(4, f.getCeiling());
			ps.setDouble(5, f.getFloor());
			ps.setDouble(6, f.getRatio());
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
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from fenduan where ide = " + id;
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
	public void update(FenDuan f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update fenduan set cure_id = ?, patient_id = ?, hos_rank_id = ?, ceiling = ?, floor = ?, ratio = ? where ide = ?";
		String hosRankId = new HosRankDaoImpl().queryId(f.getHosRank());
		String cureId = new CureKindDaoImpl().queryId(f.getCureKind());
		String patientId = new PatientKindDaoImpl().queryId(f.getPatientKind());
		
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(7, f.getIde());
			ps.setString(1, cureId);
			ps.setString(2, patientId);
			ps.setString(3, hosRankId);
			ps.setDouble(4, f.getCeiling());
			ps.setDouble(5, f.getFloor());
			ps.setDouble(6, f.getRatio());
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
	public List<FenDuan> query(Integer ide, String cureKind,
			String patientKind, String hosRank) {
		List<FenDuan> list = new ArrayList<FenDuan>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		CureKindDaoImpl ckdi = new CureKindDaoImpl();
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, cure_id, patient_id, hos_rank_id, ceiling, floor, ratio from fenduan where 1 = 1";
		if(ide != null)
			sql += "and ide = " + ide;
		if(cureKind != null && !cureKind.isEmpty() && !cureKind.equals("..."))
			sql += "and cure_id = '" + ckdi.queryId(cureKind) + "'";
		if(patientKind != null && !patientKind.isEmpty() && !patientKind.equals("..."))
			sql += "and patient_id = '" + pkdi.queryId(patientKind) + "'";
		if(hosRank != null && !hosRank.isEmpty() && !hosRank.equals("..."))
			sql += "and hos_rank_id = '" + hrdi.queryId(hosRank) + "'";
		ResultSet rs = null;
		//System.out.println(sql);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String cureKindN = ckdi.queryKind(rs.getString(2));
				String patientKindN = pkdi.queryKind(rs.getString(3));
				String hosRankN = hrdi.queryRank(rs.getString(4));
				double ceiling = rs.getDouble(5);
				double floor = rs.getDouble(6);
				double ratio = rs.getDouble(7);
				//System.out.println(id);
//				System.out.println(rank);
				//System.out.println(cureKind);
				FenDuan f = new FenDuan(id, cureKindN, patientKindN, hosRankN, ceiling, floor, ratio);
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
	public List<FenDuan> queryPage(Integer ide, String cureKind,
			String patientKind, String hosRank, int page) {
		List<FenDuan> list = new ArrayList<FenDuan>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		CureKindDaoImpl ckdi = new CureKindDaoImpl();
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, cure_id, patient_id, hos_rank_id, ceiling, floor, ratio, rownum rn from fenduan where 1 = 1";
		if(ide != null)
			sql += "and ide = " + ide;
		if(cureKind != null && !cureKind.isEmpty() && !cureKind.equals("..."))
			sql += "and cure_id = '" + ckdi.queryId(cureKind) + "'";
		if(patientKind != null && !patientKind.isEmpty() && !patientKind.equals("..."))
			sql += "and patient_id = '" + pkdi.queryId(patientKind) + "'";
		if(hosRank != null && !hosRank.isEmpty() && !hosRank.equals("..."))
			sql += "and hos_rank_id = '" + hrdi.queryId(hosRank) + "'";
		int max = page * 10;
		int min = (page - 1) * 10 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		ResultSet rs = null;
		//System.out.println(sql);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String cureKindN = ckdi.queryKind(rs.getString(2));
				String patientKindN = pkdi.queryKind(rs.getString(3));
				String hosRankN = hrdi.queryRank(rs.getString(4));
				double ceiling = rs.getDouble(5);
				double floor = rs.getDouble(6);
				double ratio = rs.getDouble(7);
				//System.out.println(id);
//				System.out.println(rank);
				//System.out.println(cureKind);
				FenDuan f = new FenDuan(id, cureKindN, patientKindN, hosRankN, ceiling, floor, ratio);
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
