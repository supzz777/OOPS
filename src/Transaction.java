

public class Transaction
{
	private String transactionId;
	private String buyer;
	private String seller;
	private int transactionAmount;
	private String dateAndTime; 
	
	
	public String getTransactionId() {
		return transactionId;
	} 
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	} 
	public String getBuyer() {
		return buyer; 
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime)
	{
		this.dateAndTime = dateAndTime;
	}
	@Override
	public String toString() {
		return "Transactionzzzz [transactionId=" + transactionId + ", buyer=" + buyer + ", seller=" + seller
				+ ", transactionAmount=" + transactionAmount + ", dateAndTime=" + dateAndTime + ", getTransactionId()="
				+ getTransactionId() + ", getBuyer()=" + getBuyer() + ", getSeller()=" + getSeller()
				+ ", getTransactionAmount()=" + getTransactionAmount() + ", getDateAndTime()=" + getDateAndTime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
