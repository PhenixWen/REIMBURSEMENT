package hrbeu.dao;

import hrbeu.entity.JiGou;
import hrbeu.entity.ZhenLiao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JiGouDaoImpl implements JiGouDao{

	@Override
	public void add(JiGou j) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into jigou values(?,?,?,?,?,?,?)";
		String hosRankId = new HosRankDaoImpl().queryId(j.getHosRank());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, j.getCompId());
			ps.setString(2, j.getCompName());
			ps.setString(3, hosRankId);
			ps.setString(4, j.getKind());
			ps.setString(5, j.getNam());
			ps.setString(6, j.getTel());
			ps.setString(7, j.getRemarks());
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
		String sql = "delete from jigou where comp_id = '" + id +"'";
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
	public List<JiGou> query(String compId, String compName, String hosRank,
			String kind) {
		// TODO Auto-generated method stub
		List<JiGou> list = new ArrayList<JiGou>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select comp_id, comp_name, hos_rank_id, kind, nam, tel, remarks from jigou where 1 = 1";
		if(compId != null && !compId.isEmpty() && !compId.equals("..."))
			sql += "and comp_id = '" + compId + "'";
		if(compName != null && !compName.isEmpty() && !compName.equals("..."))
			sql += "and comp_name = '" + compName + "'";
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		if(hosRank != null && !hosRank.isEmpty() && !hosRank.equals("..."))
			sql += "and hos_rank_id = '" + hrdi.queryId(hosRank) + "'";
		if(kind != null && !kind.isEmpty() && !kind.equals("..."))
			sql += "and kind = '" + kind + "'";
		//System.out.println(sql);
		ResultSet rs = null;
		//System.out.println(sql);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String hosRank1 = rs.getString(3);
				String kind1 = rs.getString(4);
				String nam = rs.getString(5);
				String tel = rs.getString(6);
				String remarks = rs.getString(7);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new JiGou(id, name, hrdi.queryRank(hosRank1), kind1, nam, tel, remarks));
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
	public void update(JiGou j) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update jigou set comp_name = ?, hos_rank_id = ?, kind = ?, nam = ?, tel = ?, remarks = ? where comp_id = ?";
		String hosRankId = new HosRankDaoImpl().queryId(j.getHosRank());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(7, j.getCompId());
			ps.setString(1, j.getCompName());
			ps.setString(2, hosRankId);
			ps.setString(3, j.getKind());
			ps.setString(4, j.getNam());
			ps.setString(5, j.getTel());
			ps.setString(6, j.getRemarks());
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
//		JiGou j = new JiGou("12", "12", "一级", "12", "12", "12", "12");
//		JiGouDaoImpl jgdi = new JiGouDaoImpl();
//		jgdi.add(j);
//		jgdi.update(j);
//		jgdi.delete("12");
//	}

	@Override
	public List<JiGou> queryPage(String compId, String compName,
			String hosRank, String kind, int page) {
		List<JiGou> list = new ArrayList<JiGou>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select comp_id, comp_name, hos_rank_id, kind, nam, tel, remarks, rownum rn from jigou where 1 = 1";
		if(compId != null && !compId.isEmpty() && !compId.equals("..."))
			sql += "and comp_id = '" + compId + "'";
		if(compName != null && !compName.isEmpty() && !compName.equals("..."))
			sql += "and comp_name = '" + compName + "'";
		HosRankDaoImpl hrdi =  new HosRankDaoImpl();
		if(hosRank != null && !hosRank.isEmpty() && !hosRank.equals("..."))
			sql += "and hos_rank_id = '" + hrdi.queryId(hosRank) + "'";
		if(kind != null && !kind.isEmpty() && !kind.equals("..."))
			sql += "and kind = '" + kind + "'";
		//System.out.println(sql);
		ResultSet rs = null;
		//System.out.println(sql);
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String hosRank1 = rs.getString(3);
				String kind1 = rs.getString(4);
				String nam = rs.getString(5);
				String tel = rs.getString(6);
				String remarks = rs.getString(7);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new JiGou(id, name, hrdi.queryRank(hosRank1), kind1, nam, tel, remarks));
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
