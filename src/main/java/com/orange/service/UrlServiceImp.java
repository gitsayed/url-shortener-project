package com.orange.service;

import java.net.InetAddress;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.interfaces.UrlService;
import com.orange.model.DataModel;
import com.orange.repository.UrlDao;
import eu.bitwalker.useragentutils.UserAgent;



@Service
public class UrlServiceImp implements UrlService {
@Autowired
UrlDao urlDao;
	
	@Override
	public DataModel saveData(DataModel dataModel, HttpServletRequest req) {
		
		try{ 
			String[] param=dataModel.getParameters();
			InetAddress ip= InetAddress.getLocalHost();
		String devicename=ip.getHostName();
		String ipaddress=ip.getHostAddress();
		UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
		String osname = userAgent.getOperatingSystem().getName();
		String browsername=userAgent.getBrowser().getName()+" - v"+ userAgent.getBrowserVersion(); 		
		String short_url=getRandomString();
		while(short_url.equals(urlDao.findByShorturl(short_url))){
			short_url=getRandomString();
		}
		if (param==null) {
			param[0]=null;
			param[1]=null;
		}
		dataModel.setOsname(osname);
		dataModel.setBrowsername(browsername);
		dataModel.setDevicename(devicename);
		dataModel.setIpaddress(ipaddress);
		dataModel.setShorturl(short_url);
		dataModel.setParameters(param);
		
		}catch(Exception e) {
			System.out.println("Exception = "+e);
			
		}
	urlDao.save(dataModel);
	return urlDao.findByShorturl(dataModel.getShorturl());
		
	}

	@Override
	public DataModel getAllDataByShort_url(String short_url) {
		return urlDao.findByShorturl(short_url);
	}
	
	public String  getRandomString(){
		String characters="ABCDEFGHIJKLMNSOPTQRSTUVWXYZ";
		String randomString="";
		int length=6;
		Random rand=new Random();
	    char[] text=new char[length];
	
	for(int i=0; i<length;i++) {
		text[i]=characters.charAt(rand.nextInt(characters.length()));
	}
	
	for(int j=0; j<text.length; j++) {
		randomString +=text[j];
	}
		System.out.println("random = "+randomString);
		
		return randomString;
	}

	@Override
	public Optional<DataModel> getAllDataById(Long id) {
		// TODO Auto-generated method stub
		return  urlDao.findById(id);
	}

	@Override
	public void updateDataModel(DataModel dataObj) {
		urlDao.save(dataObj);
		
	}

	@Override
	public List<DataModel> renderAllData() {
		return urlDao.findAll();
	}

	@Override
	public Long shortUrlCount() {
		
		return urlDao.count();
	}



	

}
