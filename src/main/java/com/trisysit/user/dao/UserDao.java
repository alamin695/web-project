package com.trisysit.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.trisysit.user.model.User;

/**
 * 
 * 
 * @author property of trisysit.com
 *
 */
public class UserDao {
	public static List<User> userList = new ArrayList<User>();

	public UserDao() {
	}

	public void addUser(User user) {
		Random rand = new Random();
		int useID = rand.nextInt(1000);
		user.setId(useID);
		userList.add(user);
	}

	public User selectUser(int id) {
		User userFinal = null;
		for (User user : userList) {
			if (user.getId() == id) {
				userFinal = user;
				break;
			}
		}
		return userFinal;
	}

	public List<User> getUsers() {

		return userList;
	}

	

	public boolean updateUser(User updatedUser) {
		boolean updateStatus = false;
		for (User user : userList) {
			if (user.getId() == updatedUser.getId()) {
				user.setCountry(updatedUser.getCountry());
				user.setEmail(updatedUser.getEmail());
				user.setName(updatedUser.getName());
				user.setStreetline1(updatedUser.getStreetline2());
				user.setStreetline1(updatedUser.getStreetline2());
				user.setCity(updatedUser.getCity());
				user.setPin(updatedUser.getPin());
				user.setState(updatedUser.getState());
				
				
				
				updateStatus = true;
				break;

			}
		}

		return updateStatus;
	}

}
