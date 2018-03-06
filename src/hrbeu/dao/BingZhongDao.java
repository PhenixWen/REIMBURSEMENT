package hrbeu.dao;

import hrbeu.entity.BingZhong;
import hrbeu.entity.ZhenLiao;

import java.util.List;

public interface BingZhongDao {
	public void add(BingZhong b);
	public void delete(String id)throws Exception;
	public List<BingZhong> query(String diseId, String diseName, String diseKind);
	public void update(BingZhong b);
	public List<BingZhong> queryPage(String diseId, String diseName, String diseKind, int page);
}
