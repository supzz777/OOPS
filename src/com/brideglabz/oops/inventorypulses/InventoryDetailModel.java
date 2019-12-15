package com.brideglabz.oops.inventorypulses;

//POJO class
import java.util.List;

public class InventoryDetailModel 
{
	private List<Wheat> Wheats; 
  
	private List<Pulses> Pulses;
 
	private List<Rice> Rice;
	 
	private int total;

	public int getTotal() { 
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Wheat> getWheats() {
		return Wheats;
	}

	public void setWheats(List<Wheat> wheats) {
		Wheats = wheats;
	}

	public List<Pulses> getPulses() {
		return Pulses;
	}

	public void setPulses(List<Pulses> pulses) {
		Pulses = pulses;
	}

	public List<Rice> getRice() {
		return Rice;
	}

	public void setRice(List<Rice> rice) {
		Rice = rice;
	}

}
