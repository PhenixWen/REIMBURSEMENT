package hrbeu.dao;

import hrbeu.entity.YaoPin;
import hrbeu.entity.ZhenLiao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZhenLiaoDaoImpl implements ZhenLiaoDao{

	@Override
	public void add(ZhenLiao z) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into ZhenLiao values(?,?,?,?,?,?,?,?,?)";
		String feeId = new FeeKindDaoImpl().queryId(z.getFeeKind());
		String hosRankId = new HosRankDaoImpl().queryId(z.getHosRank());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, z.getProjId());
			ps.setString(2, z.getProjName());
			ps.setString(3, feeId);
			ps.setString(4, z.getChargeRank());
			ps.setString(5, z.getCompany());
			ps.setString(6, z.getManufacturer());
			ps.setString(7, z.getRemarks());
			ps.setString(8, z.getRge());
			ps.setString(9, hosRankId);
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
		String sql = "delete from zhenliao where proj_id = '" + id +"'";
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
	public List<ZhenLiao> query(String projId, String projName) {
		List<ZhenLiao> list = new ArrayList<ZhenLiao>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select proj_id, proj_name, fee_id, charge_rank, company, manufacturer, remarks, rge, hos_rank_id from zhenliao where 1 = 1";
		if(projId != null && !projId.isEmpty() && !projId.equals("..."))
			sql += "and proj_id = '" + projId + "'";
		if(projName != null && !projName.isEmpty() && !projName.equals("..."))
			sql += "and proj_name = '" + projName + "'";
		//System.out.println(sql);
		ResultSet rs = null;
		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
		HosRankDaoImpl hrdi = new HosRankDaoImpl();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String fee = rs.getString(3);
				String rank = rs.getString(4);
				String company = rs.getString(5);
				String manufacturer = rs.getString(6);
				String remarks = rs.getString(7);
				String rge = rs.getString(8);
				String hos = rs.getString(9);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new ZhenLiao(id, name, fkdi.queryRank(fee), rank, company, manufacturer, remarks, rge, hrdi.queryRank(hos)));
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
	public void update(ZhenLiao z) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update zhenliao set proj_name = ?, fee_id = ?, charge_rank = ?, company = ?, manufacturer = ?, remarks = ?, rge = ?, hos_rank_id = ? where proj_id = ?";
		String feeId = new FeeKindDaoImpl().queryId(z.getFeeKind());
		String hosRankId = new HosRankDaoImpl().queryId(z.getHosRank());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(9, z.getProjId());
			ps.setString(1, z.getProjName());
			ps.setString(2, feeId);
			ps.setString(3, z.getChargeRank());
			ps.setString(4, z.getCompany());
			ps.setString(5, z.getManufacturer());
			ps.setString(6, z.getRemarks());
			ps.setString(7, z.getRge());
			ps.setString(8, hosRankId);
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
//		ZhenLiaoDaoImpl zldi = new ZhenLiaoDaoImpl();
//		zldi.update(new ZhenLiao("as1df", "1111111", "甲", "adf", "asfd", "asga", "asfdg", "dsfw", "一级"));
//		zldi.delete("asdf");
//		ZhenLiao z = zldi.query("as1df", null).get(0);
//		System.out.println(z);
//		
//	}

	@Override
	public List<ZhenLiao> queryPage(String projId, String projName, int page) {
		List<ZhenLiao> list = new ArrayList<ZhenLiao>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select proj_id, proj_name, fee_id, charge_rank, company, manufacturer, remarks, rge, hos_rank_id, rownum rn from zhenliao where 1 = 1";
		if(projId != null && !projId.isEmpty() && !projId.equals("..."))
			sql += "and proj_id = '" + projId + "'";
		if(projName != null && !projName.isEmpty() && !projName.equals("..."))
			sql += "and proj_name = '" + projName + "'";
		//System.out.println(sql);
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
		ResultSet rs = null;
		FeeKindDaoImpl fkdi = new FeeKindDaoImpl();
		HosRankDaoImpl hrdi = new HosRankDaoImpl();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				String fee = rs.getString(3);
				String rank = rs.getString(4);
				String company = rs.getString(5);
				String manufacturer = rs.getString(6);
				String remarks = rs.getString(7);
				String rge = rs.getString(8);
				String hos = rs.getString(9);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new ZhenLiao(id, name, fkdi.queryRank(fee), rank, company, manufacturer, remarks, rge, hrdi.queryRank(hos)));
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
//		ZhenLiao y = new ZhenLiao("1001", "跌打草", "甲", "一级", 100.00, "社区医院", "哈药六厂", "G0101", "sdf", "sdf", "sdf", "sss", 100);
//		ZhenLiaoDaoImpl zldi = new ZhenLiaoDaoImpl();
//		List<ZhenLiao> list = zldi.queryPage(null,null, 1);
//		for (ZhenLiao zhenLiao : list) {
//			System.out.println(zhenLiao);
//		}
//		ypdi.update(y);
//		ypdi.delete("1001");
//		ypdi.add(y);
//	}
}
