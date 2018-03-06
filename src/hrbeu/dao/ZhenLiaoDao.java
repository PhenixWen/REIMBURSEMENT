package hrbeu.dao;

import java.util.List;

import hrbeu.entity.ZhenLiao;

public interface ZhenLiaoDao {
	public void add(ZhenLiao y);
	public void delete(String id)  throws Exception;
	public List<ZhenLiao> query(String projId, String projName);
	public void update(ZhenLiao y);
	public List<ZhenLiao> queryPage(String projId, String projName, int page);
}
