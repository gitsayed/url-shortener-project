package com.orange.interfaces;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.orange.model.DataModel;

public interface UrlService {

	public DataModel saveData(DataModel dataModel, HttpServletRequest req);
	public DataModel getAllDataByShort_url(String short_url);
	public Optional<DataModel> getAllDataById(Long id);
	public void updateDataModel(DataModel dataObj);
	public List<DataModel> renderAllData();
	public Long shortUrlCount();
	
	
	
	
	
	
}
