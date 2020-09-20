package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Mileage;

public interface MileageMapper {
   //20180528 마일리지 메소드
   
   List<Mileage> getMileageListByUsername(String username);
   
   void insertMileageHistory(Mileage mileage);

}
