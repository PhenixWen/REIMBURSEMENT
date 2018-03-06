package hrbeu.dao;

import hrbeu.entity.LogIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LogInDaoImpl implements LogInDao{

	@Override
	public void insert(LogIn a) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into LOGIN "
				+ "values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getPsw());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}
	
	@Override
	public List<LogIn> selectALL(String name, String psw, boolean must) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<LogIn> list = new ArrayList<LogIn>();
		String sql = "select p.USERNAME, p.PSW "
				+ "from LOGIN p where 1=1 ";
		
		if(must || name != null){
			sql = sql + " and p.USERNAME = "+ "'" + name + "'";
		}
		if(psw != null){
			sql = sql + " and p.PSW = "+ "'" + psw + "'";
		}
		System.out.println(sql);
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String a = rs.getString(1);
				String b = rs.getString(2);
				
				LogIn cur = new LogIn(a,b);
				list.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
	
}
