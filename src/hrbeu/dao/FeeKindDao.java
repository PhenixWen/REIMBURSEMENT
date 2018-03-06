package hrbeu.dao;

import hrbeu.entity.FeeKind;

import java.util.List;

public interface FeeKindDao {
	public String queryId(String str);
	public String queryRank(String str);
	public List<FeeKind> queryall();
}
