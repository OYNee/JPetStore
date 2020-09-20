package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.Advertisement;

public interface AdMapper {
	//BannerName필드를 status로 고치기
	//등록 처리(C)
	void insertAd(Advertisement Ad);
	//광고 내리기 처리(D), 광고를 내리면 광고했던 기록이 삭제된다. 남아있어야 하는거 할듯. 테이블이 없으니 일단 내리기 기능 안 만들기로(추후 상의).
	//void deleteAd(String adid);
	//등록된 광고 읽어오기 처리(R)
	List<Advertisement> advertise(String today);
	//추적광고
	List<Advertisement> favAdvertise(@Param("favcategory") String favcategory, @Param("today") String today);

	//mypage에서 광고신청/승인 대기/광고중 표시, itemid로 검색후 status와 endDate를 반환. status가 0이면 승인 대기/ status가 1이고 endDate가 오늘보다 뒤면 광고중, 나머지는 광고신청.
	List<Advertisement> getApprovalList();
	void deleteAdByItemId(String itemId);
}
