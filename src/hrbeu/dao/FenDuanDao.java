package hrbeu.dao;

import hrbeu.entity.FenDuan;
import hrbeu.entity.JiGou;

import java.util.List;

public interface FenDuanDao {
	public void add(FenDuan f);
	public void delete(int id);
	public List<FenDuan> query(Integer ide, String cureKind, String patientKind, String hosRank);
	public void update(FenDuan f);
	public List<FenDuan> queryPage(Integer ide, String cureKind, String patientKind, String hosRank, int page);
}
