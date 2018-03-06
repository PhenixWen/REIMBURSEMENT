package hrbeu.dao;

import java.util.List;

import hrbeu.entity.YaoPin;

public interface YaoPinDao {
	public void add(YaoPin y);
	public void delete(String id) throws Exception;
	public List<YaoPin> query(String mediId, String mediName, String factorName, String drugCertificate);
	public void update(YaoPin y);
	public List<YaoPin> queryPage(String mediId, String mediName, String factorName, String drugCertificate, int page);
}
