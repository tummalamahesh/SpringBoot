package com.sabre.interest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabre.interest.beans.InterestBean;
import com.sabre.interest.dao.InterestDao;
import com.sabre.interest.service.InterestService;

@Service
public class InterestServiceImpl implements InterestService{

	@Autowired
	InterestDao interestDao;
	
	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}



	@Override
	public void addInterest(InterestBean interestBean) {
		interestDao.addInterest(interestBean);
		
	}



	@Override
	public List<InterestBean> getAllInterests() {
		return interestDao.getAllInterests();
		
	}



	@Override
	public InterestBean getInterest(InterestBean interestBean) {
		return interestDao.getInterest(interestBean);
	}



	@Override
	public void updateInterest(InterestBean interestBean) {
		interestDao.updateInterest(interestBean);
		
	}



	@Override
	public void deleteInterest(InterestBean interestBean) {
		interestDao.deleteInterest(interestBean);
		
	}
}
