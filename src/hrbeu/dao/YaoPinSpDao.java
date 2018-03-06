package hrbeu.dao;

import hrbeu.entity.YaoPinSp;

import java.util.List;

public interface YaoPinSpDao {
	public void insert(YaoPinSp a);
	public void delete(int spid);
	public List<YaoPinSp> select(int pID, int spID);
	public List<YaoPinSp> selectPage(int pID, int spID, int page);
	public void update(YaoPinSp a);
	public List<YaoPinSp> query(String personId, String compId);
	public void ok(int no);
	public void no(int no);
}
