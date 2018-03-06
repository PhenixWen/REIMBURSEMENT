package hrbeu.dao;

import hrbeu.entity.LogIn;

import java.util.List;

public interface LogInDao {
	public void insert(LogIn a);
	public List<LogIn> selectALL(String name, String psw, boolean must);
}
