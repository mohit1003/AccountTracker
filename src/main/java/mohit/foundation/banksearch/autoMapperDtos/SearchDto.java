package mohit.foundation.banksearch.autoMapperDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDto {
	@JsonProperty(value = "accountFrom")
	private int accountFrom;
	@JsonProperty(value = "accountTo")
	private int accountTo;
	
	@JsonProperty(value = "date")
	private String date;
	
	@JsonIgnore
	private String dateFrom;
	
	@JsonIgnore
	private String dateTo;
	@JsonProperty(value = "settlementAmount")
	private double settlementAmount;
	@JsonProperty(value = "settlementCurrency")
	private String settlementCurrency;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(int accountFrom) {
		this.accountFrom = accountFrom;
	}
	public int getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(int accountTo) {
		this.accountTo = accountTo;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public double getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getSettlementCurrency() {
		return settlementCurrency;
	}
	public void setSettlementCurrency(String settlementCurrency) {
		this.settlementCurrency = settlementCurrency;
	}
	
	

}
