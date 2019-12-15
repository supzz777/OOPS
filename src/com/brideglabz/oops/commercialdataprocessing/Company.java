package com.brideglabz.oops.commercialdataprocessing;

public class Company
{
	private int companyid;
	private String companyname;
	private int companyshares; 
	private int companyshareprice;
	private int companytotalvalue; //companyTotalValue = companyShares * companySharePrice.
	
	public int getCompanyid()
	{
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	
	public int getCompanyshares() {
		return companyshares;
	}
	public void setCompanyshares(int companyshares) {
		this.companyshares = companyshares;
	}
	
	
	public int getCompanyshareprice() {
		return companyshareprice;
	}
	public void setCompanyshareprice(int companyshareprice) {
		this.companyshareprice = companyshareprice;
	}
	
	
	public int getCompanytotalvalue() {
		return companytotalvalue;
	}
	public void setCompanytotalvalue(int companytotalvalue) {
		this.companytotalvalue = companytotalvalue;
	}
	
	
}
