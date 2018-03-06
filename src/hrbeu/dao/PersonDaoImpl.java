package hrbeu.dao;

import hrbeu.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PersonDaoImpl implements PersonDao{
	public static void main(String[] args) {
		
		PersonDaoImpl cur = new PersonDaoImpl();

		List<Person> persons = cur.selectAllPerson(null, null);
		System.out.println(persons);
	}
	@Override
	public void insertPerson(Person person) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
//	1	PERSON_ID
//	2	CERTIFICATION_TYPE
//	3	CERTIFICATION_ID
//	4	PERSONAL_NAME
//	5	SEX
//	6	BIRTHDAY
//	7	INSTITUTION_ID
//	8	PATIENT_ID
//	9	SOCIAL_SECURITY_ID 自动生成
//	10	COMP_ID
//		String sql = "insert into RENYUANXINX "
//				+ "values(PERSONLIS.nextval,?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?)";
		String sql = "insert into RENYUANXINX "
				+ "values(PERSONLIS.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			Random r = new Random();
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getCertifiType());
			ps.setString(2, person.getCertifiID());
			ps.setString(3, person.getPersonName());
			ps.setString(4, person.getPersonSex());
			ps.setString(5, person.getBirthday());
			ps.setInt(6, person.getInsID());
			ps.setString(7, person.getPatID());
			ps.setInt(8, (r.nextInt(10000)) + 10007);
			ps.setString(9, person.getCompID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}
	@Override
	public List<Person> selectAllPerson(String pID, String pname) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<Person> persons = new ArrayList<Person>();

//		1   PERSON_ID
//		2	CERTIFICATION_TYPE
//		3	CERTIFICATION_ID
//		4	PERSONAL_NAME
//		5	SEX
//		6	BIRTHDAY
//		7	INSTITUTION_ID
//		8	PATIENT_ID
//		9	SOCIAL_SECURITY_ID 自动生成
//		10	COMP_ID
		String sql = "select p.PERSON_ID,  p.CERTIFICATION_TYPE, p.CERTIFICATION_ID, p.PERSONAL_NAME"
				+ ", p.SEX, p.BIRTHDAY, p.INSTITUTION_ID, p.PATIENT_ID,"
				+ "p.SOCIAL_SECURITY_ID, p.COMP_ID "
				+ "from RENYUANXINX p where 1=1 ";
		
		
		if(pID != null && !pID.equals("")){
			sql = sql + " and p.person_id = "+ pID;
		}
		if(pname !=null && !pname.equals("")){
			sql = sql +" and p.personal_name = '"+pname+"'";
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
				int g = rs.getInt(7);
				String h = rs.getString(8);
				int i = rs.getInt(9);
				String j = rs.getString(10);
				
				Person person = new Person(a,b,c,d,e,f,g,h,i,j);
				persons.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return persons;
	}
	@Override
	public void deletePerson(int no) throws Exception {
		System.out.println("into delete " + no);
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete from RENYUANXINX where person_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}
	
	@Override
	public void updatePerson(Person person) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		System.out.println("updata person in impl" + person);
//	1	PERSON_ID
//	2	CERTIFICATION_TYPE
//	3	CERTIFICATION_ID
//	4	PERSONAL_NAME
//	5	SEX
//	6	BIRTHDAY
//	7	INSTITUTION_ID
//	8	PATIENT_ID
//	9	SOCIAL_SECURITY_ID
//	10	COMP_ID
//		String sql = "update RENYUANXINX "
//				+ "set CERTIFICATION_TYPE=?,"
//				+ "CERTIFICATION_ID=?,PERSONAL_NAME=?,SEX=?,"
//				+ "BIRTHDAY=to_date(?,'yyyy-MM-dd'),INSTITUTION_ID=?,"
//				+ "PATIENT_ID=?,SOCIAL_SECURITY_ID=?,COMP_ID=? "
//				+ "where PERSON_ID=?";
		String sql = "update RENYUANXINX "
				+ "set CERTIFICATION_TYPE=?,"
				+ "CERTIFICATION_ID=?,PERSONAL_NAME=?,SEX=?,"
				+ "BIRTHDAY=?,INSTITUTION_ID=?,"
				+ "PATIENT_ID=?,COMP_ID=? "
				+ "where PERSON_ID=?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getCertifiType());
			ps.setString(2, person.getCertifiID());
			ps.setString(3, person.getPersonName());
			ps.setString(4, person.getPersonSex());
			ps.setString(5, person.getBirthday());
			ps.setInt(6, person.getInsID());
			ps.setString(7, person.getPatID());
			ps.setString(8, person.getCompID());
			ps.setInt(9, person.getPersonID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
		
	}
	@Override
	public List<Person> selectPagePerson(String pID, String pname, int page) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		///
		List<Person> persons = new ArrayList<Person>();

		String sql = "select p.PERSON_ID,  p.CERTIFICATION_TYPE, p.CERTIFICATION_ID, p.PERSONAL_NAME"
				+ ", p.SEX, p.BIRTHDAY, p.INSTITUTION_ID, p.PATIENT_ID,"
				+ "p.SOCIAL_SECURITY_ID, p.COMP_ID, rownum rn "
				+ "from RENYUANXINX p where 1=1 ";
		
		if(pID != null && !pID.equals("")){
			sql = sql + " and p.person_id = "+ pID;
		}
		if(pname !=null && !pname.equals("")){
			sql = sql +" and p.personal_name = '"+pname+"'";
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
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				int g = rs.getInt(7);
				String h = rs.getString(8);
				int i = rs.getInt(9);
				String j = rs.getString(10);
				
				Person person = new Person(a,b,c,d,e,f,g,h,i,j);
				persons.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		return persons;
	}
}
