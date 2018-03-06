package hrbeu.dao;

import hrbeu.entity.HosRank;

import java.util.List;

public interface HosRankDao {
	public String queryId(String str);
	public String queryRank(String str);
	public List<HosRank> queryAll();
}
