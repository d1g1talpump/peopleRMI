package com.peopleRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.peopleRMI.bo.Person;

public interface PeopleService extends Remote {
	public List<Person> getAllPeople() throws RemoteException;
	public List<Person> getPeopleByName(String name) throws RemoteException;
	public void createDB() throws RemoteException;
	public void createTablePeople() throws RemoteException;
	public void insertPerson(String name) throws RemoteException;
	public void deletePeople(String name) throws RemoteException;
}
