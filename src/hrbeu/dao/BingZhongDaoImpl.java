package hrbeu.dao;

import hrbeu.entity.BingZhong;
import hrbeu.entity.FuWu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BingZhongDaoImpl implements BingZhongDao{

	@Override
	public void add(BingZhong b) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into bingzhong values(?,?,?,?,?)";
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, b.getDiseId());
			ps.setString(2, b.getDiseName());
			ps.setString(3, b.getDiseKind());
			ps.setString(4, b.getDiseM());
			ps.setString(5, b.getRemarks());
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
		String sql = "delete from bingzhong where dise_id = '" + id +"'";
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
	public List<BingZhong> query(String diseId, String diseName, String diseKind) {
		List<BingZhong> list = new ArrayList<BingZhong>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select dise_id, dise_name, dise_kind, dise_m, remarks from bingzhong where 1 = 1";
		if(diseId != null && !diseId.isEmpty() && !diseId.equals("..."))
			sql += "and dise_id = '" + diseId + "'";
		if(diseName != null && !diseName.isEmpty() && !diseName.equals("..."))
			sql += "and dise_name = '" + diseName + "'";
		if(diseKind != null && !diseKind.isEmpty() && !diseKind.equals("..."))
			sql += "and dise_kind = '" + diseKind + "'";
		//System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String kind = rs.getString(3);
				String m = rs.getString(4);
				String remarks = rs.getString(5);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new BingZhong(id, name, kind, m, remarks));
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
	public void update(BingZhong b) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update bingzhong set dise_name = ?, dise_kind = ?, dise_m = ?, remarks = ? where dise_id = ?";
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(5, b.getDiseId());
			ps.setString(1, b.getDiseName());
			ps.setString(2, b.getDiseKind());
			ps.setString(3, b.getDiseM());
			ps.setString(4, b.getRemarks());
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
//		BingZhong b = new BingZhong("asdf", "11111", "甲", "afds", "afd");
//		BingZhongDaoImpl bzdi = new BingZhongDaoImpl();
//		bzdi.add(b);
//		bzdi.update(b);
//		bzdi.delete("asdf");
//	}

	@Override
	public List<BingZhong> queryPage(String diseId, String diseName,
			String diseKind, int page) {
		List<BingZhong> list = new ArrayList<BingZhong>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select dise_id, dise_name, dise_kind, dise_m, remarks, rownum rn from bingzhong where 1 = 1";
		if(diseId != null && !diseId.isEmpty() && !diseId.equals("..."))
			sql += "and dise_id = '" + diseId + "'";
		if(diseName != null && !diseName.isEmpty() && !diseName.equals("..."))
			sql += "and dise_name = '" + diseName + "'";
		if(diseKind != null && !diseKind.isEmpty() && !diseKind.equals("..."))
			sql += "and dise_kind = '" + diseKind + "'";
		//System.out.println(sql);
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String kind = rs.getString(3);
				String m = rs.getString(4);
				String remarks = rs.getString(5);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new BingZhong(id, name, kind, m, remarks));
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
//		BingZhongDaoImpl bzdi = new BingZhongDaoImpl();
//		List<BingZhong> list = bzdi.queryPage("", "", "", 2);
//		for (BingZhong bingZhong : list) {
//			System.out.println(bingZhong);
//		}
//	}
}
