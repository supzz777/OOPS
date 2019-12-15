package com.brideglabz.oops.stockmanagement;

import java.util.List;

public class StockModel 
{
	private List<GreenMehendi> GreenMehendiList;
	private List<NupurMehendi> NupurMehendiList;
	private List<LalMehendi> LalMehendiList;
	private List<HeenaMehendi> HeenaMehendiList;
	
	private int totalValueOfAllStock;

	public List<GreenMehendi> getGreenMehendiList() {
		return GreenMehendiList;
	}

	public void setGreenMehendiList(List<GreenMehendi> greenMehendiList) {
		GreenMehendiList = greenMehendiList;
	}

	public List<NupurMehendi> getNupurMehendiList() {
		return NupurMehendiList;
	}

	public void setNupurMehendiList(List<NupurMehendi> nupurMehendiList) {
		NupurMehendiList = nupurMehendiList;
	}

	public List<LalMehendi> getLalMehendiList() {
		return LalMehendiList;
	}
 
	public void setLalMehendiList(List<LalMehendi> lalMehendiList) {
		LalMehendiList = lalMehendiList;
	}

	public List<HeenaMehendi> getHeenaMehendiList() {
		return HeenaMehendiList;
	}

	public void setHeenaMehendiList(List<HeenaMehendi> heenaMehendiList) {
		HeenaMehendiList = heenaMehendiList;
	}

	public int getTotalValueOfAllStock() {
		return totalValueOfAllStock;
	}

	public void setTotalValueOfAllStock(int totalValueOfAllStock) {
		this.totalValueOfAllStock = totalValueOfAllStock;
	}

	

}
