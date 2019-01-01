package com.sabre.interest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sabre.interest.beans.InterestBean;
import com.sabre.interest.service.impl.InterestServiceImpl;

@RestController
public class InterestController {
	
	
	  @Autowired private InterestServiceImpl interestService;
	 

	public InterestController() {
		super();
		System.out.println("SampleController constructor-----------------");
	}

	@RequestMapping("/interest/all")
	public List<InterestBean> getAllInterests() {
		return interestService.getAllInterests();
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/interest/add")
	public void getAllInterests(@RequestBody InterestBean interestBean) {
		interestService.addInterest(interestBean);
	}
	
	@RequestMapping("/interest/{id}")
	public InterestBean getAllInterest(@PathVariable Integer id) {
		InterestBean bean = new InterestBean();
		bean.setId(id);
		return interestService.getInterest(bean);
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/interest/update")
	public void updateInterest(@RequestBody InterestBean interestBean) {
		interestService.updateInterest(interestBean);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/interest/{id}")
	public void deleteInterest(@PathVariable Integer id) {
		InterestBean bean = new InterestBean();
		bean.setId(id);
		interestService.deleteInterest(bean);
	}
}
