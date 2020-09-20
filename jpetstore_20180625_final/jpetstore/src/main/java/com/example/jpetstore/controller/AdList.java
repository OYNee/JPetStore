package com.example.jpetstore.controller;
//추후 에러 고쳐서 signon, off에서도 광고하도록 해야 한다.
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.example.jpetstore.domain.Advertisement;
import com.example.jpetstore.service.PetStoreFacade;

public class AdList {
	private List<Advertisement> adList1;
	private List<Advertisement> adList2;
	
	public AdList() {
		inputAdList();
	}

	private PetStoreFacade petStore;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	public List<Advertisement> getAdList1() {
		return adList1;
	}
	public void setAdList1(List<Advertisement> adList1) {
		this.adList1 = adList1;
	}
	public List<Advertisement> getAdList2() {
		return adList2;
	}
	public void setAdList2(List<Advertisement> adList2) {
		this.adList2 = adList2;
	}
	
	public void inputAdList() {
		//1. 광고 품목들 불러오기(status가 2면서 오늘 날짜가 기간 안에 있어야 한다)
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String today = dateFormat.format(c.getTime());
		List<Advertisement> list = new ArrayList<Advertisement>();
		list = this.petStore.advertise(today);
		List<Advertisement> firstAdList = new ArrayList<Advertisement>();
		List<Advertisement> secondAdList = new ArrayList<Advertisement>();
		
		int idx[] = new int[6];
		if(!CollectionUtils.isEmpty(list)) {
			for(int i=0; i<idx.length && i<list.size(); i++) {
				idx[i]=(int)(Math.random()*list.size());
				for(int j=0; j<i; j++) {
					if(i!=0 && idx[i] == idx[j]) {
						i--;
						break;
					}
				}
				System.out.println(idx[i]);
			}
			for(int i=0; i<idx.length && i<list.size(); i++) {
				
				if(i<idx.length/2) {
					firstAdList.add(list.get(idx[i]));
				}
				else {
					secondAdList.add(list.get(idx[i]));
				}
			}
		}
		
		this.adList1 = firstAdList;
		this.adList2 = secondAdList;
		
	}

}
