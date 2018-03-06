package hrbeu.dao;

import hrbeu.entity.JiGou;
import hrbeu.entity.ZhenLiao;

import java.util.List;

public interface JiGouDao {
	public void add(JiGou j);
	public void delete(String id)throws Exception;
	public List<JiGou> query(String compId, String compName, String hosRank, String kind);
	public void update(JiGou j);
	public List<JiGou> queryPage(String compId, String compName, String hosRank, String kind, int page);
}
