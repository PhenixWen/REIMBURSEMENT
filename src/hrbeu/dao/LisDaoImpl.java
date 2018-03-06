package hrbeu.dao;

import hrbeu.entity.Lis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LisDaoImpl implements LisDao{
public static void main(String[] args) {
	float a = (float)(Math.round(1.238*100)*1.0/100);
	System.out.println(a);
}
	@Override
	public void insert(Lis lis) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into lis values(lis_seq.Nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lis.getMediId());
			ps.setString(2, lis.getProjId());
			ps.setString(3, lis.getServId());
			ps.setFloat(4, lis.getPrice());
			ps.setInt(5, lis.getNum());
			ps.setFloat(6, lis.getSum());
			ps.setString(7, lis.getSolveId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<Lis> query(String _solveId, String _ide, int type){
		List<Lis> liss = new ArrayList<Lis>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(type == 1){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, yaopin.medi_name, yaopin.fee_id, yaopin.hos_rank_id  "
			+ " from lis join yaopin on (lis.medi_id = yaopin.medi_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String mediName = rs.getString(9);
					String feeId = rs.getString(10);
					String hosRankId = rs.getString(11);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					HosRankDaoImpl hosd = new HosRankDaoImpl();
					String feeKind = feed.queryRank(feeId);
					String hosRank = hosd.queryRank(hosRankId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, mediName, feeKind, hosRank, hosRankId);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		if(type == 2){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, zhenliao.proj_name, zhenliao.fee_id, zhenliao.hos_rank_id "
			+ " from lis join zhenliao on (lis.proj_id = zhenliao.proj_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String projName = rs.getString(9);
					String feeId = rs.getString(10);
					String hosRankId = rs.getString(11);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					HosRankDaoImpl hosd = new HosRankDaoImpl();
					String feeKind = feed.queryRank(feeId);
					String hosRank = hosd.queryRank(hosRankId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, projName, feeKind, hosRank, hosRankId);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		if(type == 3){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, fuwu.serv_name, fuwu.fee_id "
			+ " from lis join fuwu on (lis.serv_id = fuwu.serv_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String servName = rs.getString(9);
					String feeId = rs.getString(10);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					String feeKind = feed.queryRank(feeId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, servName, feeKind, null, null);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		return liss;
	}

	@Override
	public void delete(String ide) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from lis where ide = " + ide;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public void update(Lis lis) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update lis "
		+ "set medi_id = ?, proj_id = ?, serv_id = ?, price = ?, num = ?, Sum = ? where ide = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lis.getMediId());
			ps.setString(2, lis.getProjId());
			ps.setString(3, lis.getServId());
			ps.setFloat(4, lis.getPrice());
			ps.setInt(5, lis.getNum());
			ps.setFloat(6, lis.getSum());
			ps.setInt(7, lis.getIde());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<Lis> queryPage(String _solveId, String _ide, int page, int type) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Lis> liss = new ArrayList<Lis>();
		if(type == 1){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, yaopin.medi_name, yaopin.fee_id, yaopin.hos_rank_id, rownum rn "
			+ " from lis join yaopin on (lis.medi_id = yaopin.medi_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			int max=page*5;
			int min=(page-1)*5+1;
			sql = "select e.* from ("+sql+") e where e.rn>="+min+" and e.rn<="+max;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String mediName = rs.getString(9);
					String feeId = rs.getString(10);
					String hosRankId = rs.getString(11);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					HosRankDaoImpl hosd = new HosRankDaoImpl();
					String feeKind = feed.queryRank(feeId);
					String hosRank = hosd.queryRank(hosRankId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, mediName, feeKind, hosRank, hosRankId);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		if(type == 2){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, zhenliao.proj_name, zhenliao.fee_id, zhenliao.hos_rank_id, rownum rn "
			+ " from lis join zhenliao on (lis.proj_id = zhenliao.proj_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			int max=page*5;
			int min=(page-1)*5+1;
			sql = "select e.* from ("+sql+") e where e.rn>="+min+" and e.rn<="+max;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String projName = rs.getString(9);
					String feeId = rs.getString(10);
					String hosRankId = rs.getString(11);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					HosRankDaoImpl hosd = new HosRankDaoImpl();
					String feeKind = feed.queryRank(feeId);
					String hosRank = hosd.queryRank(hosRankId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, projName, feeKind, hosRank, hosRankId);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		if(type == 3){
			String sql = "select lis.ide, lis.medi_id, lis.proj_id, lis.serv_id, lis.price, lis.num, lis.Sum, lis.solve_id, fuwu.serv_name, fuwu.fee_id, rownum rn "
			+ " from lis join fuwu on (lis.serv_id = fuwu.serv_id) where solve_id = '" + _solveId + "'";
			if(_ide != null && _ide != ""){
				sql = sql +" and ide = " + _ide;
			}
			int max=page*5;
			int min=(page-1)*5+1;
			sql = "select e.* from ("+sql+") e where e.rn>="+min+" and e.rn<="+max;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					int ide = rs.getInt(1);
					String mediId = rs.getString(2);
					String projId = rs.getString(3);
					String servId = rs.getString(4);
					float price = rs.getFloat(5);
					int num = rs.getInt(6);
					float Sum = rs.getFloat(7);
					String solveId = rs.getString(8);
					String servName = rs.getString(9);
					String feeId = rs.getString(10);
					FeeKindDaoImpl feed = new FeeKindDaoImpl();
					String feeKind = feed.queryRank(feeId);
					Lis lis = new Lis(ide,mediId,projId,servId,price,num,Sum,solveId, servName, feeKind, null, null);
					liss.add(lis);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return liss;
		}
		return liss;
	}

	@Override
	public int page(String solveId, String ide, int type){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		if(type == 1){
			String sql = "select count(*) from lis join yaopin on (lis.medi_id = yaopin.medi_id) where solve_id = '" + solveId + "'";
			if(ide != null && ide != ""){
				sql = sql +" and ide = " + ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return count;
		}
		if(type == 2){
			String sql = "select count(*) from lis join zhenliao on (lis.proj_id = zhenliao.proj_id) where solve_id = '" + solveId + "'";
			if(ide != null && ide != ""){
				sql = sql +" and ide = " + ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return count;
		}
		if(type == 3){
			String sql = "select count(*) from lis join fuwu on (lis.serv_id = fuwu.serv_id) where solve_id = '" + solveId + "'";
			if(ide != null && ide != ""){
				sql = sql +" and ide = " + ide;
			}
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtil.close(rs, ps, conn);
			}
			return count;
		}
		return count;
	}

	@Override
	public List<Lis> queryall(String solveId) {
		List<Lis> liss1 = query(solveId, null, 1);
		List<Lis> liss2 = query(solveId, null, 2);
		List<Lis> liss3 = query(solveId, null, 3);
		liss1.addAll(liss2);
		liss1.addAll(liss3);
		return liss1;
	}
}
