package com.sabre.interest.db;

import org.springframework.data.repository.CrudRepository;

import com.sabre.interest.beans.InterestBean;

public interface InterestRepositories extends CrudRepository<InterestBean, Integer>{

}
