package hrbeu.dao;

import hrbeu.entity.JiGouSp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JiGouSpDaoImpl implements JiGouSpDao {

	@Override
	public List<JiGouSp> query(String personId, String compId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<JiGouSp> list = new ArrayList<JiGouSp>();
		String sql = "select STDATE, EDDATE, STATE "
				+ " from JIGOUSP where personId = '" + personId + "'" + " and compId = '" + compId + "'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String a = rs.getString(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				JiGouSp ins = new JiGouSp();
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
	public void insert(JiGouSp a) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into JIGOUSP "
				+ "values(SP_LIS.nextval,?,?,?,'未通过',?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getPersonID());
			ps.setString(2, a.getCompID());
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
		System.out.println("into delete jigousp" + spid);
		///
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "delete from JIGOUSP where SPID = ?";
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
	public List<JiGouSp> select(int pID, int spID) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<JiGouSp> list = new ArrayList<JiGouSp>();
		
		String sql = "select p.SPID,  p.PERSONID, "
				+ "p.COMPID, p.STDATE"
				+ ", p.STATE, p.PERSONNAME, p.EDDATE "
				+ "from JIGOUSP p where 1=1 ";
		
		
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
				JiGouSp ins = new JiGouSp(a,b,c,d,e,f,g);
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
	public void update(JiGouSp a) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		System.out.println(a);
		///
		String sql = "update JIGOUSP " 
				+ "set PERSONID=?, COMPID=?"
				+ ", STDATE=?, PERSONNAME=?, EDDATE=?"
				+ " where SPID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getPersonID());
			ps.setString(2, a.getCompID());
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
		String sql = "update JIGOUSP set STATE='已通过' where SPID=?";
		
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
	public List<JiGouSp> selectPage(int pID, int spID, int page) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<JiGouSp> list = new ArrayList<JiGouSp>();
		
		String sql = "select p.SPID,  p.PERSONID, "
				+ "p.COMPID, p.STDATE"
				+ ", p.STATE, p.PERSONNAME, p.EDDATE, rownum rn "
				+ "from JIGOUSP p where 1=1 ";
		
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
				JiGouSp ins = new JiGouSp(a,b,c,d,e,f,g);
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
		String sql = "update JIGOUSP set STATE='未通过' where SPID=?";
		
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
