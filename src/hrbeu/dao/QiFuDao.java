package hrbeu.dao;

import hrbeu.entity.FenDuan;
import hrbeu.entity.QiFu;

import java.util.List;

public interface QiFuDao {
	public void add(QiFu q);
	public void delete(int id);
	public List<QiFu> query(Integer ide, String cureKind, String patientKind, String hosRank);
	public void update(QiFu q);
	public List<QiFu> queryPage(Integer ide, String cureKind, String patientKind, String hosRank, int page);
}
