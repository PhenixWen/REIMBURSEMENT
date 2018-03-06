package hrbeu.dao;

import hrbeu.entity.AnnualMoney;

import java.util.List;

public interface AnnualMoneyDao {
	public void insertAM(AnnualMoney am);
	public List<AnnualMoney> selectAllAM(String pID, String pname, String nianfen);
	public List<AnnualMoney> selectPageAM(String pID, String pname, String nianfen, int page);
	public void updateAM(String personID, int times, double money, double baoxiao, double cost, int ztimes);
}
