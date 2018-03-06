package hrbeu.dao;

import hrbeu.entity.FengDing;
import hrbeu.entity.QiFu;

import java.util.List;

public interface FengDingDao {
	public void add(FengDing f);
	public void delete(int ide);
	public List<FengDing> query(Integer ide, String patientKind);
	public void update(FengDing f);
	public List<FengDing> queryPage(Integer ide, String patientKind, int page);
}
