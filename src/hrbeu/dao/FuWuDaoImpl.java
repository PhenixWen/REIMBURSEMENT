package hrbeu.dao;

import hrbeu.entity.FuWu;
import hrbeu.entity.ZhenLiao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuWuDaoImpl implements FuWuDao{

	@Override
	public void add(FuWu f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into fuwu values(?,?,?,?,?)";
		String feeId = new FeeKindDaoImpl().queryId(f.getFeeKind());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, f.getServId());
			ps.setString(2, f.getServName());
			ps.setString(3, feeId);
			ps.setString(4, f.getRemarks());
			ps.setString(5, f.getRge());
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
	public void delete(String id) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from fuwu where serv_id = '" + id +"'";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}finally
		{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<FuWu> query(String servId, String servName) {
		List<FuWu> list = new ArrayList<FuWu>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select serv_id, serv_name, fee_id, remarks, rge from fuwu where 1 = 1";
		if(servId != null && !servId.isEmpty() && !servId.equals("..."))
			sql += "and serv_id = '" + servId + "'";
		if(servName != null && !servName.isEmpty() && !servName.equals("..."))
			sql += "and serv_name = '" + servName + "'";
		//System.out.println(sql);
		ResultSet rs = null;
		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
		HosRankDaoImpl hrdi = new HosRankDaoImpl();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String fee = rs.getString(3);
				String remarks = rs.getString(4);
				String rge = rs.getString(5);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new FuWu(id, name, fkdi.queryRank(fee), remarks, rge));
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
	public void update(FuWu f) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update fuwu set serv_name = ?, fee_id = ?, remarks = ?, rge = ? where serv_id = ?";
		String feeId = new FeeKindDaoImpl().queryId(f.getFeeKind());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(5, f.getServId());
			ps.setString(1, f.getServName());
			ps.setString(2, feeId);
			ps.setString(3, f.getRemarks());
			ps.setString(4, f.getRge());
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
//		FuWu f = new FuWu("asdf", "asfd", "甲", "afds", "afd");
//		FuWuDaoImpl fwdi = new FuWuDaoImpl();
//		fwdi.update(f);
//		fwdi.delete("asdf");
//	}

	@Override
	public List<FuWu> queryPage(String servId, String servName, int page) {
		List<FuWu> list = new ArrayList<FuWu>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select serv_id, serv_name, fee_id, remarks, rge, rownum rn from fuwu where 1 = 1";
		if(servId != null && !servId.isEmpty() && !servId.equals("..."))
			sql += "and serv_id = '" + servId + "'";
		if(servName != null && !servName.isEmpty() && !servName.equals("..."))
			sql += "and serv_name = '" + servName + "'";
		//System.out.println(sql);
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		ResultSet rs = null;
		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
		HosRankDaoImpl hrdi = new HosRankDaoImpl();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String fee = rs.getString(3);
				String remarks = rs.getString(4);
				String rge = rs.getString(5);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new FuWu(id, name, fkdi.queryRank(fee), remarks, rge));
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
