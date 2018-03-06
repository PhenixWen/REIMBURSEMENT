package hrbeu.dao;

import hrbeu.entity.CureKind;
import hrbeu.entity.HosRank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CureKindDaoImpl implements CureKindDao{

	@Override
	public String queryId(String str) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select cure_id from yiliao where cure_kind = '" + str + "'";
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
		String sql = "select cure_kind from yiliao where cure_id = '" + str + "'";
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
//		System.out.println(new CureKindDaoImpl().queryKind("1"));
//	}

	@Override
	public List<CureKind> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from yiliao";
		List<CureKind> list = new ArrayList<CureKind>();
//		System.out.println(sql);
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new CureKind(rs.getString(1), rs.getString(2)));
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
//		CureKindDaoImpl ckdi = new CureKindDaoImpl();
//		List<CureKind> list = ckdi.queryAll();
//		for (CureKind cureKind : list) {
//			System.out.println(cureKind);
//		}
//	}
}
