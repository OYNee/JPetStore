package com.example.jpetstore.domain;
//없앨것을 고려.
import java.io.Serializable;

@SuppressWarnings("serial")
public class MySales implements Serializable {
	private String itemid;
	private int unitcost;
	private String adStatus;
	private String status;
	private String isAuction;
	
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public void setUnitcost(int unitcost) {
		this.unitcost = unitcost;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItemid() {
		return itemid;
	}
	public int getUnitcost() {
		return unitcost;
	}
	public String getStatus() {
		return status;
	}
	public String getAdStatus() {
		return adStatus;
	}
	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}
	public String getIsAuction() {
		return isAuction;
	}
	public void setIsAuction(String isAuction) {
		this.isAuction = isAuction;
	}

}
