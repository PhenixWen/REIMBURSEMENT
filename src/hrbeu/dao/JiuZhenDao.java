package hrbeu.dao;

import hrbeu.entity.JiuZhen;

import java.util.List;

public interface JiuZhenDao {

	public void insert(JiuZhen jiuzhen);
	public void updateall(JiuZhen jiuzhen);
	public List<JiuZhen> query(String solveId, String personId, String personName, String flag);
	public List<JiuZhen> queryPage(String solveId, String personId, String personName, int page, String flag);
	public int page(String solveId, String personId, String personName, String flag);
	public void delete(String solveId);
	public void solve(String solveId, float sum, float zf, float zfyl, float bx, float zffd, float bxlj, String zflis, String yllis);
	public void solveflag(String solveId);
	public void cancelflag(String solveId);
	public void update(String solveId);
}
