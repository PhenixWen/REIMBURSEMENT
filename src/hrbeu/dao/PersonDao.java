package hrbeu.dao;

import hrbeu.entity.Person;

import java.util.List;


public interface PersonDao {
	public void insertPerson(Person person);
	public List<Person> selectAllPerson(String pID, String pname);
	public List<Person> selectPagePerson(String pID, String pname, int page);
	public void deletePerson(int pID) throws Exception;
	public void updatePerson(Person person);
}
