package hrbeu.dao;

import hrbeu.entity.FenDuan;
import hrbeu.entity.QiFu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QiFuDaoImpl implements QiFuDao{

	@Override
	public void add(QiFu q) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into qifu values(qifu_seq.nextval,?,?,?,?)";
		String hosRankId = new HosRankDaoImpl().queryId(q.getHosRank());
		String cureKindId = new CureKindDaoImpl().queryId(q.getCureKind());
		String patientKindId = new PatientKindDaoImpl().queryId(q.getPatientKind());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cureKindId);
			ps.setString(2, patientKindId);
			ps.setString(3, hosRankId);
			ps.setDouble(4, q.getStd());
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
		String sql = "delete from qifu where ide = " + id;
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
	public List<QiFu> query(Integer ide, String cureKind, String patientKind,
			String hosRank) {
		List<QiFu> list = new ArrayList<QiFu>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		CureKindDaoImpl ckdi = new CureKindDaoImpl();
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, cure_id, patient_id, hos_rank_id, std from qifu where 1 = 1";
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
				double std = rs.getDouble(5);
				//System.out.println(id);
//				System.out.println(rank);
				//System.out.println(cureKind);
				QiFu q = new QiFu(id, cureKindN, patientKindN, hosRankN, std);
				list.add(q);
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
	public void update(QiFu q) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update qifu set cure_id = ?, patient_id = ?, hos_rank_id = ?, std = ? where ide = ?";
		String hosRankId = new HosRankDaoImpl().queryId(q.getHosRank());
		String cureId = new CureKindDaoImpl().queryId(q.getCureKind());
		String patientId = new PatientKindDaoImpl().queryId(q.getPatientKind());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(5, q.getIde());
			ps.setString(1, cureId);
			ps.setString(2, patientId);
			ps.setString(3, hosRankId);
			ps.setDouble(4, q.getStd());
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
//		QiFu q = new QiFu(3, "二类", "公务员", "二级", 10.0);
//		QiFuDaoImpl qfdi = new QiFuDaoImpl();
//		qfdi.add(q);
//		qfdi.delete(2);
//		qfdi.update(q);
//		
//	}

	@Override
	public List<QiFu> queryPage(Integer ide, String cureKind,
			String patientKind, String hosRank, int page) {
		List<QiFu> list = new ArrayList<QiFu>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		CureKindDaoImpl ckdi = new CureKindDaoImpl();
		PatientKindDaoImpl pkdi = new PatientKindDaoImpl();
		String sql = "select ide, cure_id, patient_id, hos_rank_id, std, rownum rn from qifu where 1 = 1";
		if(ide != null)
			sql += "and ide = " + ide;
		if(cureKind != null && !cureKind.isEmpty() && !cureKind.equals("..."))
			sql += "and cure_id = '" + ckdi.queryId(cureKind) + "'";
		if(patientKind != null && !patientKind.isEmpty() && !patientKind.equals("..."))
			sql += "and patient_id = '" + pkdi.queryId(patientKind) + "'";
		if(hosRank != null && !hosRank.isEmpty() && !hosRank.equals("..."))
			sql += "and hos_rank_id = '" + hrdi.queryId(hosRank) + "'";
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
				int id = rs.getInt(1);
				String cureKindN = ckdi.queryKind(rs.getString(2));
				String patientKindN = pkdi.queryKind(rs.getString(3));
				String hosRankN = hrdi.queryRank(rs.getString(4));
				double std = rs.getDouble(5);
				//System.out.println(id);
//				System.out.println(rank);
				//System.out.println(cureKind);
				QiFu q = new QiFu(id, cureKindN, patientKindN, hosRankN, std);
				list.add(q);
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
