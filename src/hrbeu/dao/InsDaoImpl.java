package hrbeu.dao;

import hrbeu.entity.Ins;









import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InsDaoImpl implements InsDao{
	
	@Override
	public void insertIns(Ins ins) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into DANWEI "
				+ "values(INSLIS.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ins.getInsName());
			ps.setString(2, ins.getInsType());
			ps.setString(3, ins.getInsAdd());
			ps.setString(4, ins.getInsPost());
			ps.setString(5, ins.getInsTel());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}

	@Override
	public List<Ins> selectAllIns(String insID, String insName, boolean must) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		/*	INSTITUTION_ID
		INSTITUTION_NAME
		INSTITUTION_TYPE
		INSTITUTION_ADDRESS
		INSTITUTION_POSTCODE
		INSTITUTION_TEL*/
		List<Ins> list = new ArrayList<Ins>();
		String sql = "select p.INSTITUTION_ID,  p.INSTITUTION_NAME, "
				+ "p.INSTITUTION_TYPE, p.INSTITUTION_ADDRESS"
				+ ", p.INSTITUTION_POSTCODE, p.INSTITUTION_TEL "
				+ "from DANWEI p where 1=1 ";
		
		
		if(must || (insID != null && !insID.equals(""))){
			sql = sql + " and p.INSTITUTION_ID = "+ insID;
		}
		if(insName != null && !insName.equals("")){
			sql = sql +" and p.INSTITUTION_NAME = '"+insName+"'";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				
				Ins ins = new Ins(a,b,c,d,e,f);
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
	public void deleteIns(int insID) throws Exception {
		System.out.println("into delete Ins" + insID);
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "delete from DANWEI where INSTITUTION_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, insID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}

	@Override
	public void updateIns(Ins ins) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		///
		String sql = "update DANWEI " +
				" set INSTITUTION_NAME=?, "
				+ "INSTITUTION_TYPE=?, INSTITUTION_ADDRESS=?"
				+ ", INSTITUTION_POSTCODE=?, INSTITUTION_TEL=? "
				+ " where  INSTITUTION_ID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ins.getInsName());
			ps.setString(2, ins.getInsType());
			ps.setString(3, ins.getInsAdd());
			ps.setString(4, ins.getInsPost());
			ps.setString(5, ins.getInsTel());
			ps.setInt(6, ins.getInsID());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<Ins> selectPageIns(String insID, String insName, int page) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		/*	INSTITUTION_ID
		INSTITUTION_NAME
		INSTITUTION_TYPE
		INSTITUTION_ADDRESS
		INSTITUTION_POSTCODE
		INSTITUTION_TEL*/
		List<Ins> list = new ArrayList<Ins>();
		String sql = "select p.INSTITUTION_ID,  p.INSTITUTION_NAME, "
				+ "p.INSTITUTION_TYPE, p.INSTITUTION_ADDRESS"
				+ ", p.INSTITUTION_POSTCODE, p.INSTITUTION_TEL, rownum rn "
				+ "from DANWEI p where 1=1 ";
		
		if(insID != null && !insID.equals("")){
			sql = sql + " and p.INSTITUTION_ID = "+ insID;
		}
		if(insName != null && !insName.equals("")){
			sql = sql +" and p.INSTITUTION_NAME = '"+insName+"'";
		}
		///
		int max = page*5;
		int min = (page-1)*5+1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				
				Ins ins = new Ins(a,b,c,d,e,f);
				list.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
	
}
