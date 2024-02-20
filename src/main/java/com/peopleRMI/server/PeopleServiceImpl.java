package com.peopleRMI.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.peopleRMI.PeopleService;
import com.peopleRMI.bo.Person;
import com.peopleRMI.dal.SelectData;
import com.peopleRMI.dal.Connect;
import com.peopleRMI.dal.CreateTable;
import com.peopleRMI.dal.DeleteData;
import com.peopleRMI.dal.InsertData;

public class PeopleServiceImpl extends UnicastRemoteObject implements PeopleService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public PeopleServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public List<Person> getAllPeople() throws RemoteException {
		return SelectData.selectAll();
	}

	@Override
	public List<Person> getPeopleByName(String name) throws RemoteException {
		return SelectData.selectbyName(name);
	}

	@Override
	public void createDB() throws RemoteException {
		Connect.getInstance().getConnection();
	}

	@Override
	public void createTablePeople() throws RemoteException {
		CreateTable.createTablePeople();		
	}

	@Override
	public void insertPerson(String name) throws RemoteException {		
		InsertData.insertPerson(name);
	}

	@Override
	public void deletePeople(String name) throws RemoteException {
		DeleteData.deletePeopleByName(name);
		
	}	
}
