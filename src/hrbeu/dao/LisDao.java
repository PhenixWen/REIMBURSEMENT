package hrbeu.dao;

import hrbeu.entity.Lis;

import java.util.List;

public interface LisDao {

	public void  insert(Lis lis);
	public List<Lis> query(String solveId, String ide, int type);
	public List<Lis> queryall(String solveId);
	public List<Lis> queryPage(String solveId, String ide, int type, int page);
	public int page(String solveId, String ide, int type);
	public void delete(String ide);
	public void update(Lis lis);
}
