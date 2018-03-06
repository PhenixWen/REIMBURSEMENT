package hrbeu.dao;


import hrbeu.entity.YaoPinSp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YaoPinSpDaoImpl implements YaoPinSpDao{

	@Override
	public List<YaoPinSp> query(String personId, String mediId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<YaoPinSp> list = new ArrayList<YaoPinSp>();
		String sql = "select STDATE, EDDATE, STATE  "
				+ "  from YAOPINSP where personId = '" + personId + "'" + " and mediId = '" + mediId + "'";
		try {
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String a = rs.getString(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				YaoPinSp ins = new YaoPinSp();
				ins.setStdate(a);
				ins.setEddate(b);
				ins.setState(c);
				list.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
	@Override
	public void insert(YaoPinSp a) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into YAOPINSP "
				+ "values(SP_LIS.nextval,?,?,?,'未通过',?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getPersonID());
			ps.setString(2, a.getMediId());
			ps.setString(3, a.getStdate());
			
			ps.setString(4, a.getPersonName());
			ps.setString(5, a.getEddate());
			///
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public void delete(int spid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "delete from YAOPINSP where SPID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, spid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}

	@Override
	public List<YaoPinSp> select(int pID, int spID) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<YaoPinSp> list = new ArrayList<YaoPinSp>();
		
		String sql = "select p.SPID,  p.PERSONID, "
				+ "p.MEDIID, p.STDATE"
				+ ", p.STATE, p.PERSONNAME, p.EDDATE "
				+ "from YAOPINSP p where 1=1 ";
		
		
		if( pID != -1 ){
			sql = sql + " and p.PERSONID = "+ pID;
		}
		if( spID != -1 ){
			sql = sql + " and p.SPID = "+ spID;
		}
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				int b = rs.getInt(2);
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				String g = rs.getString(7);
				///
				YaoPinSp ins = new YaoPinSp(a,b,c,d,e,f,g);
				list.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public void update(YaoPinSp a) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "update YAOPINSP " 
				+ "set PERSONID=?, MEDIID=?"
				+ ", STDATE=?, PERSONNAME=?, EDDATE=? "
				+ " where SPID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getPersonID());
			ps.setString(2, a.getMediId());
			ps.setString(3, a.getStdate());
			ps.setString(4, a.getPersonName());
			ps.setString(5, a.getEddate());
			ps.setInt(6, a.getSpID());
			///
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public void ok(int no) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "update YAOPINSP set STATE='已通过' where SPID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			///
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<YaoPinSp> selectPage(int pID, int spID, int page) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<YaoPinSp> list = new ArrayList<YaoPinSp>();
		
		String sql = "select p.SPID,  p.PERSONID, "
				+ "p.MEDIID, p.STDATE"
				+ ", p.STATE, p.PERSONNAME, p.EDDATE, rownum rn "
				+ "from YAOPINSP p where 1=1 ";
		
		
		if( pID != -1 ){
			sql = sql + " and p.PERSONID = "+ pID;
		}
		if( spID != -1 ){
			sql = sql + " and p.SPID = "+ spID;
		}
		
		int max = page*5;
		int min = (page-1)*5+1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				int b = rs.getInt(2);
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				String g = rs.getString(7);
				///
				YaoPinSp ins = new YaoPinSp(a,b,c,d,e,f,g);
				list.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
	@Override
	public void no(int no) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "update YAOPINSP set STATE='未通过' where SPID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			///
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}
	
}
