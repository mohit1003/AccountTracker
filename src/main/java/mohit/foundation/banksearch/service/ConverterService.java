package mohit.foundation.banksearch.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mohit.foundation.banksearch.autoMapperDtos.SearchDto;
import mohit.foundation.banksearch.model.SearchModel;

@Component
public class ConverterService {
	@Autowired
	private ModelMapper _mapper;
	
	public SearchDto convertToDto(SearchModel model) {
		return _mapper.map(model, SearchDto.class);
	}

}
