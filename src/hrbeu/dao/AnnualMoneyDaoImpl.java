package hrbeu.dao;

import hrbeu.entity.AnnualMoney;
//import hrbeu.entity.Lis;
import hrbeu.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnualMoneyDaoImpl implements AnnualMoneyDao{

	@Override
	public void insertAM(AnnualMoney am) {
		System.out.println("create AM");
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int curval = 0;
		String sql = "select max(PERSON_ID) from RENYUANXINX";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				curval = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		///
		sql = "insert into LEIJIFEIYONG "
				+ "values(?,2017,0,0,0,0,0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curval);			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}
	
	@Override
	public List<AnnualMoney> selectAllAM(String pID, String pname,
			String nianfen) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AnnualMoney> list = new ArrayList<AnnualMoney>();
		///
/*		PERSON_ID
//		NIANFEN
//		ANNUAL_TIMES
//		ANNUAL_MONEY
//		ANNUAL_BAOXIAO
//		ANNUAL_COST
*/		String sql = "select a.PERSON_ID,  "
				+ " b.PERSONAL_NAME , a.ANNUAL_TIMES, "
		+ "a.ANNUAL_MONEY, a.ANNUAL_BAOXIAO"
		+ ", a.ANNUAL_COST, a.NIANFEN, a.ZTIMES, b.CERTIFICATION_TYPE, b.CERTIFICATION_ID, b.SEX, b.BIRTHDAY, b.INSTITUTION_ID, b.PATIENT_ID, b.SOCIAL_SECURITY_ID, b.COMP_ID"
		+ " from leijifeiyong a, renyuanxinx b where a.PERSON_ID = b.PERSON_ID ";
		///
		if(pID != null && !pID.equals("")){
			sql = sql + " and a.PERSON_ID = "+ pID;
		}
		if(pname != null && !pname.equals("")){
			sql = sql +" and b.PERSONAL_NAME = '"+pname+"'";
		}
		if(nianfen != null && !nianfen.equals("")){
			sql = sql +" and a.NIANFEN = '"+nianfen+"'";
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				String b = rs.getString(2);
				int c = rs.getInt(3);
				double d = rs.getDouble(4);
				double e = rs.getDouble(5);
				double f = rs.getDouble(6);
				String g = rs.getString(7);
				int h = rs.getInt(8);
				String i = rs.getString(9);
				String j = rs.getString(10);
				String k = rs.getString(11);
				String l = rs.getString(12);
				int m = rs.getInt(13);
				String n = rs.getString(14);
				int o = rs.getInt(15);
				String p = rs.getString(16);
				Person person = new Person(a,i,j,b,k,l,m,n,o,p);
				AnnualMoney ins = new AnnualMoney(a,b,g,c,d,e,f,h,person);
				list.add(ins);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public void updateAM(String personID, int times, double money, double baoxiao, double cost, int ztimes) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		AnnualMoney am0 = selectAllAM(personID, null, null).get(0);
		String sql = "update leijifeiyong "
		+ "set ANNUAL_TIMES = ?, ANNUAL_MONEY = ?, ANNUAL_BAOXIAO = ?, ANNUAL_COST = ?, ZTIMES = ? where PERSON_ID = ? and NIANFEN = '2017'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, times + am0.getTimes());
			ps.setDouble(2, money + am0.getMoney());
			ps.setDouble(3, baoxiao + am0.getBaoxiao());
			ps.setDouble(4, cost + am0.getCost());
			ps.setInt(5, ztimes + am0.getZtimes());
			ps.setString(6, personID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}		
	}

	@Override
	public List<AnnualMoney> selectPageAM(String pID, String pname,
			String nianfen, int page) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AnnualMoney> list = new ArrayList<AnnualMoney>();
		///
/*		PERSON_ID
//		NIANFEN
//		ANNUAL_TIMES
//		ANNUAL_MONEY
//		ANNUAL_BAOXIAO
//		ANNUAL_COST
*/		String sql = "select a.PERSON_ID,  "
				+ " b.PERSONAL_NAME , a.ANNUAL_TIMES, "
		+ "a.ANNUAL_MONEY, a.ANNUAL_BAOXIAO"
		+ ", a.ANNUAL_COST, a.NIANFEN, a.ZTIMES, b.CERTIFICATION_TYPE, b.CERTIFICATION_ID, b.SEX, b.BIRTHDAY, "
		+ "b.INSTITUTION_ID, b.PATIENT_ID, b.SOCIAL_SECURITY_ID, b.COMP_ID, rownum rn"
		+ " from leijifeiyong a, renyuanxinx b where a.PERSON_ID = b.PERSON_ID ";
		///
		if(pID != null && !pID.equals("")){
			sql = sql + " and a.PERSON_ID = "+ pID;
		}
		if(pname != null && !pname.equals("")){
			sql = sql +" and b.PERSONAL_NAME = '"+pname+"'";
		}
		if(nianfen != null && !nianfen.equals("")){
			sql = sql +" and a.NIANFEN = '"+nianfen+"'";
		}
		
		int max = page*5;
		int min = (page-1)*5+1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int a = rs.getInt(1);
				String b = rs.getString(2);
				int c = rs.getInt(3);
				double d = rs.getDouble(4);
				double e = rs.getDouble(5);
				double f = rs.getDouble(6);
				String g = rs.getString(7);
				int h = rs.getInt(8);
				String i = rs.getString(9);
				String j = rs.getString(10);
				String k = rs.getString(11);
				String l = rs.getString(12);
				int m = rs.getInt(13);
				String n = rs.getString(14);
				int o = rs.getInt(15);
				String p = rs.getString(16);
				Person person = new Person(a,i,j,b,k,l,m,n,o,p);
				AnnualMoney ins = new AnnualMoney(a,b,g,c,d,e,f,h,person);
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
