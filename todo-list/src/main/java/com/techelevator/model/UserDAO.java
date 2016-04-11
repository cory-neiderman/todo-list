package com.techelevator.model;

public interface UserDAO {
	
	public User getUserIdByNameAndPassword(String username, String password);
	public boolean checkForUserName(String username);
	public void createNewUser(String username, String password);

}
