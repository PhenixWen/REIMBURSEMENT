package hrbeu.dao;

import java.util.List;

import hrbeu.entity.Ins;


public interface InsDao {
	public void insertIns(Ins ins);
	public List<Ins> selectAllIns(String insID, String insName, boolean must);
	public List<Ins> selectPageIns(String insID, String insName, int page);
	public void deleteIns(int insID) throws Exception;
	public void updateIns(Ins ins);
}
