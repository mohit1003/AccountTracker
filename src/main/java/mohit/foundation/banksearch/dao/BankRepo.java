package mohit.foundation.banksearch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mohit.foundation.banksearch.model.SearchModel;

public interface BankRepo extends CrudRepository<SearchModel, Integer> {
	
	@Query(value = "SELECT * FROM transactions t WHERE (:currency is null or t.settlement_currency = :currency) "
			+ "and (:accountFrom is null or t.account_from = :accountFrom) "
			+ "and (:accountTo is null or t.account_to = :accountTo)"
			+ "and (:dateFrom is null and :dateTo is null or t.date between :dateFrom and :dateTo)" , nativeQuery = true)
	public List<SearchModel> getByAllParameters(@Param("currency") String currency, @Param("accountFrom") String string, 
			@Param("accountTo") String string2, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo); 

}
