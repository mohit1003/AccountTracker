package mohit.foundation.banksearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import mohit.foundation.banksearch.autoMapperDtos.SearchDto;
//import mohit.foundation.banksearch.autoMapperDtos.SearchDto;
import mohit.foundation.banksearch.dao.BankRepo;
import mohit.foundation.banksearch.dao.UsersRepo;
import mohit.foundation.banksearch.helpers.SearchHelper;
import mohit.foundation.banksearch.model.SearchModel;
import mohit.foundation.banksearch.model.Users;

@Service
public class SearchService {
	@Autowired
	BankRepo _repo;
	
	@Autowired
	private UsersRepo _userRepo;
	
	@Autowired
	private ConverterService converterService;
	
	
	
	List<SearchModel> searchModel = new ArrayList<SearchModel>() ;
	SearchHelper searchHelper = new SearchHelper();
	
	public List<Users> getUsers(){
		return (List<Users>) _userRepo.findAll();
	}
	
	
	public List<SearchDto> getSearchResults(SearchModel model) {
		
		try {
			System.out.println(model.getSettlementCurrency());
//				System.out.println(model.getAccountFrom());
				searchModel = _repo.getByAllParameters(model.getSettlementCurrency(), 
						model.getAccountFrom(), model.getAccountTo(), model.getDateFrom(), model.getDateTo());
				
		
			
		}
		catch(BeansException beanEx) {
			System.out.println(beanEx.getMessage());
		}
		catch(DataAccessException dataEx) {
			System.out.println(dataEx.getMessage());
		}
		return searchModel.stream().map(converterService::convertToDto).collect(Collectors.toList());
		
	}
	
	

}
