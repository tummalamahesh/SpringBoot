package com.sabre.interest.dao;

import java.util.List;

import com.sabre.interest.beans.InterestBean;

public interface InterestDao {
	void addInterest(InterestBean interestBean);
	List<InterestBean> getAllInterests();
	InterestBean getInterest(InterestBean interestBean);
	void updateInterest(InterestBean interestBean);
	void deleteInterest(InterestBean interestBean);
}

