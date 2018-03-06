package hrbeu.dao;

import hrbeu.entity.PatientKind;

import java.util.List;

public interface PatientKindDao {
	public String queryId(String str);
	public String queryKind(String str);
	public List<PatientKind> queryall();
}
