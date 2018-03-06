package hrbeu.dao;

import hrbeu.entity.FeeKind;
import hrbeu.entity.HosRank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeeKindDaoImpl implements FeeKindDao{

	@Override
	public String queryId(String str) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select fee_id from feekind where fee_kind = '" + str + "'";
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
	public String queryRank(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select fee_kind from feekind where fee_id = '" + str + "'";
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
//		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
//		System.out.println(fkdi.queryRank("1001"));
//	}


	@Override
	public List<FeeKind> queryall() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from feekind";
		List<FeeKind> list = new ArrayList<FeeKind>();
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new FeeKind(rs.getString(1), rs.getString(2)));
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
//		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
//		List<FeeKind> list = fkdi.queryall();
//		for (FeeKind feeKind : list) {
//			System.out.println(feeKind);
//		}
//	}
}
