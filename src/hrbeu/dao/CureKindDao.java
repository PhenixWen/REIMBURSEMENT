package hrbeu.dao;



import hrbeu.entity.CureKind;

import java.util.List;

public interface CureKindDao {
	public String queryId(String str);
	public String queryKind(String str);
	public List<CureKind> queryAll();
}
