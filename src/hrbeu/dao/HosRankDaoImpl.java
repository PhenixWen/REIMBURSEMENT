package hrbeu.dao;

import hrbeu.entity.HosRank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.DDIV;

public class HosRankDaoImpl implements HosRankDao{

	
	@Override
	public String queryRank(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select hos_rank from hosrank where hos_rank_id = '" + str + "'";
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
	public String queryId(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select hos_rank_id from hosrank where hos_rank = '" + str + "'";
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
//		System.out.println(new HosRankDaoImpl().queryId("一级"));
//	}
	@Override
	public List<HosRank> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from hosrank";
		List<HosRank> list = new ArrayList<HosRank>();
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new HosRank(rs.getString(1), rs.getString(2)));
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
//		HosRankDaoImpl hrdi = new HosRankDaoImpl();
//		List<HosRank> list = hrdi.queryAll();
//		for (HosRank hosRank : list) {
//			System.out.println(hosRank);
//		}
//	}
}
