package com.sabre.interest.service;

import java.util.List;

import com.sabre.interest.beans.InterestBean;

public interface InterestService {
	void addInterest(InterestBean interestBean);
	List<InterestBean> getAllInterests();
	InterestBean getInterest(InterestBean interestBean);
	void updateInterest(InterestBean interestBean);
	void deleteInterest(InterestBean interestBean);
	

}
