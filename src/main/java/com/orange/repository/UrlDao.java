package com.orange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.model.DataModel;


@Repository
public interface UrlDao extends JpaRepository<DataModel, Long>   {

public	DataModel findByShorturl(String shorturl);
	
	
}
