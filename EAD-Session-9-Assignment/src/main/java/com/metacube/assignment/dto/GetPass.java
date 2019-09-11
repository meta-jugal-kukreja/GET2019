package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;

/**
 * This class represents a data transfer object for Pass
 * @author Jugal
 * Dated 09/11/20189
 */
public class GetPass {
	
	@NotBlank
	private String currencyType;
	@NotBlank
	private String plan;
	private String finalPrice;
	
	//Getter Setter methods
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

}
