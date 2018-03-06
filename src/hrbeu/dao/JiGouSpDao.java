package hrbeu.dao;

import java.util.List;

import hrbeu.entity.JiGouSp;

public interface JiGouSpDao {
	public void insert(JiGouSp a);
	public void delete(int spid);
	public List<JiGouSp> select(int pID, int spID);
	public List<JiGouSp> selectPage(int pID, int spID, int page);
	public void update(JiGouSp a);
	public List<JiGouSp> query(String personId, String compId);
	public void ok(int no);
	public void no(int parseInt);
}
