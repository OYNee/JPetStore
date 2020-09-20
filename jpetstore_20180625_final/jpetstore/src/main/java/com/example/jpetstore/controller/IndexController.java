package com.example.jpetstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Advertisement;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class IndexController {

	private PetStoreFacade petStore;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	@RequestMapping("/shop/index.do")
	public ModelAndView showAdvertisement() {
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
		ModelAndView m = new ModelAndView("tiles/index");
		m.addObject("firstAdList", firstAdList);
		m.addObject("secondAdList",secondAdList);
		//2. 불러온 품목의 이미지명, itemid, bannertitle을 banner에 담아서 model에 담아 보내기
		return m;
	}
}
