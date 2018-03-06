package hrbeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hrbeu.entity.YaoPin;

public class YaoPinDaoImpl implements YaoPinDao{
	@Override
	public void add(YaoPin y) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into YaoPin values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String feeId = new FeeKindDaoImpl().queryId(y.getFeeKind());
		String hosRankId = new HosRankDaoImpl().queryId(y.getHosRank());
		//String sql = "insert into yaopin values('1000', '板蓝根', '1000', '一级', 100.00, '1000', 'ss', 'ss', 'sss', 'sss', 'ssf', '2312',100)";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, y.getMediId());
			ps.setString(2, y.getMediName());
			ps.setString(3, feeId);
			ps.setString(4, y.getChargeRank());
			ps.setDouble(5, y.getCeilingPri());
			ps.setString(6, hosRankId);
			ps.setString(7, y.getFactorName());
			ps.setString(8, y.getDrugCertificate());
			ps.setString(9, y.getRemarks());
			ps.setString(10, y.getUseFrequency());
			ps.setString(11, y.getUseMethod());
			ps.setString(12, y.getPlace());
			if(y.getDayy() != null)
				ps.setInt(13, y.getDayy());
			else
				ps.setString(13, "");
			ps.setString(14, y.getExamine());
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
		String sql = "delete from yaopin where medi_id = '" + id + "'";
		//System.out.println(sql);
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
	public List<YaoPin> query(String mediId, String mediName, String factorName,
			String drugCertificate) {
		List<YaoPin> list = new ArrayList<YaoPin>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select medi_id, medi_name, fee_id, charge_rank, ceiling_pri, hos_rank_id, factor_name, drug_certificate, remarks, use_frequency, use_method, place, dayy, examine from yaopin where 1 = 1";
		if(mediId != null && !mediId.isEmpty() && !mediId.equals("..."))
			sql += "and medi_id = '" + mediId + "'";
		if(mediName != null && !mediName.isEmpty() && !mediName.equals("..."))
			sql += "and medi_name = '" + mediName + "'";
		if(factorName != null && !factorName.isEmpty() && !factorName.equals("..."))
			sql += "and factor_name = '" + factorName + "'";
		if(drugCertificate != null && !drugCertificate.isEmpty() && !drugCertificate.equals("..."))
			sql += "and drug_certificate = '" + drugCertificate + "'";
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
				double ceiling = rs.getDouble(5);
				String hos = rs.getString(6);
				String factor = rs.getString(7);
				String drug = rs.getString(8);
				String remark = rs.getString(9);
				String frequency = rs.getString(10);
				String method = rs.getString(11);
				String pla = rs.getString(12);
				int day = rs.getInt(13);
				String examine  = rs.getString(14);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new YaoPin(id, name, fkdi.queryRank(fee), rank, ceiling, hrdi.queryRank(hos), factor, drug, remark, frequency, method, pla, day, examine));
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
	public void update(YaoPin y) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update yaopin set medi_name = ?, fee_id = ?, charge_rank = ?, ceiling_pri = ?, hos_rank_id = ?, factor_name = ?, drug_certificate = ?, remarks = ?, use_frequency = ?, use_method = ?, place = ?, dayy = ?, examine = ? where medi_id = ?";
		String feeId = new FeeKindDaoImpl().queryId(y.getFeeKind());
		String hosRankId = new HosRankDaoImpl().queryId(y.getHosRank());
//		String sql = "update yaopin set medi_name = ?, fee_id = ? where medi_id = ?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(14, y.getMediId());
			ps.setString(1, y.getMediName());
			ps.setString(2, feeId);
			ps.setString(3, y.getChargeRank());
			ps.setDouble(4, y.getCeilingPri());
			ps.setString(5, hosRankId);
			ps.setString(6, y.getFactorName());
			ps.setString(7, y.getDrugCertificate());
			ps.setString(8, y.getRemarks());
			ps.setString(9, y.getUseFrequency());
			ps.setString(10, y.getUseMethod());
			ps.setString(11, y.getPlace());
			ps.setInt(12, y.getDayy());	
			ps.setString(13, y.getExamine());
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
	public List<YaoPin> queryPage(String mediId, String mediName,
			String factorName, String drugCertificate, int page) {
		List<YaoPin> list = new ArrayList<YaoPin>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "select medi_id, medi_name, fee_id, charge_rank, ceiling_pri, hos_rank_id, factor_name, drug_certificate, remarks, use_frequency, use_method, place, dayy, examine, rownum rn from yaopin where 1 = 1";
		if(mediId != null && !mediId.isEmpty() && !mediId.equals("..."))
			sql += "and medi_id = '" + mediId + "'";
		if(mediName != null && !mediName.isEmpty() && !mediName.equals("..."))
			sql += "and medi_name = '" + mediName + "'";
		if(factorName != null && !factorName.isEmpty() && !factorName.equals("..."))
			sql += "and factor_name = '" + factorName + "'";
		if(drugCertificate != null && !drugCertificate.isEmpty() && !drugCertificate.equals("..."))
			sql += "and drug_certificate = '" + drugCertificate + "'";
		//System.out.println(sql);
		int max = page * 5;
		int min = (page - 1) * 5 + 1;
		sql = "select e.* from (" + sql + ") e where e.rn >= " + min + " and e.rn <= " + max;
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
				double ceiling = rs.getDouble(5);
				String hos = rs.getString(6);
				String factor = rs.getString(7);
				String drug = rs.getString(8);
				String remark = rs.getString(9);
				String frequency = rs.getString(10);
				String method = rs.getString(11);
				String pla = rs.getString(12);
				int day = rs.getInt(13);
				String examine  = rs.getString(14);
				//System.out.println(id);
//				System.out.println(rank);
				list.add(new YaoPin(id, name, fkdi.queryRank(fee), rank, ceiling, hrdi.queryRank(hos), factor, drug, remark, frequency, method, pla, day, examine));
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
//		YaoPin y = new YaoPin("1001", "跌打草", "甲", "一级", 100.00, "社区医院", "哈药六厂", "G0101", "sdf", "sdf", "sdf", "sss", 100);
//		YaoPinDaoImpl ypdi = new YaoPinDaoImpl();
//		List<YaoPin> list = ypdi.queryPage(null,null,null,null, 1);
//		for (YaoPin yaoPin : list) {
//			System.out.println(yaoPin);
//		}
//		ypdi.update(y);
//		ypdi.delete("1001");
//		ypdi.add(y);
//	}
}
