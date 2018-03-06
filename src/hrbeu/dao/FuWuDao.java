package hrbeu.dao;

import hrbeu.entity.FuWu;
import hrbeu.entity.ZhenLiao;

import java.util.List;

public interface FuWuDao {
	public void add(FuWu f);
	public void delete(String id) throws Exception;
	public List<FuWu> query(String servId, String servName);
	public void update(FuWu y);
	public List<FuWu> queryPage(String servId, String servName, int page);
}
