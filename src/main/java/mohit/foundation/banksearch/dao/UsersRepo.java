package mohit.foundation.banksearch.dao;

import org.springframework.data.repository.CrudRepository;

import mohit.foundation.banksearch.model.Users;

public interface UsersRepo extends CrudRepository<Users, Integer> {
	public Users findByEmail(String email);

}
