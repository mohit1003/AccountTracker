package mohit.foundation.banksearch.service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mohit.foundation.banksearch.dao.UsersRepo;
import mohit.foundation.banksearch.model.Users;

@Service
public class UserService {
	@Autowired
	UsersRepo _repo;
	
	public Users register(Users user) {
		user.setAccountNumber(getAccountNumber(100000, 999999));
		Users savedUser = _repo.save(user);
		return savedUser;
	}
	
	public Users login(Users user) {
		Users validatedUser = _repo.findByEmail(user.getEmail());
		if(validatedUser == null) {
			return null;
		}
		return validatedUser;
	}
	public int getAccountNumber(int min, int max) {
	    return (int) Math.floor((Math.random()+ Math.random()) * (max - min + 1)) + min;
	}

}
