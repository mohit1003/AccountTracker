package mohit.foundation.banksearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mohit.foundation.banksearch.autoMapperDtos.SearchDto;
import mohit.foundation.banksearch.model.SearchModel;
import mohit.foundation.banksearch.model.Users;
import mohit.foundation.banksearch.service.SearchService;
import mohit.foundation.banksearch.service.UserService;

@RestController
@CrossOrigin(origins = "*")

public class SearchController {
	@Autowired
	SearchService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<Users> users() {
		return service.getUsers();
	}
	
	@PostMapping(path="/results")

	public List<SearchDto> results(@RequestBody SearchModel model) {
		
		return (List<SearchDto>) service.getSearchResults(model);
		
		
	}
	
	@PostMapping("/register")
	
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	
	public Users login(@RequestBody Users user) {
		return userService.login(user);
	}

}
