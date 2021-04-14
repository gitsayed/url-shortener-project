package com.orange.controller;

import java.net.InetAddress;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.orange.interfaces.UrlService;
import com.orange.model.DataModel;
import eu.bitwalker.useragentutils.UserAgent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UrlController {
	@Autowired
	UrlService urlService;

@PostMapping(value = "/postlongurl")
public ResponseEntity<DataModel> getLongUrl(@RequestBody DataModel dataModel,
		HttpServletRequest req) throws Exception {
   if(dataModel.getLongurl()==null ||dataModel.getLongurl().isEmpty()) {
					throw new Exception("bad request");
	} else {			
	dataModel = urlService.saveData(dataModel, req);
	System.out.println(dataModel);}
	return new ResponseEntity<>(dataModel, HttpStatus.OK);
}




	@GetMapping(value = "/shorturlserver/{shl}")
	public ResponseEntity<DataModel> getDatamodelByShortUrl(
			@PathVariable("shl") String shorturl) throws Exception {
		
		if (shorturl.length() == 6) {
			DataModel dataObj = urlService.getAllDataByShort_url(shorturl);
			if (dataObj == null) {
				throw new Exception("data is not found for url : /" + shorturl);
			}else {return new ResponseEntity<>(dataObj, HttpStatus.OK) ;}

		} else {
			throw new Exception("URL : /" + shorturl + " is not valid.");
		}
	}

	@GetMapping(value = "/getrecordbyid/{id}")
	public ResponseEntity<Optional<DataModel>> getDatamodelById(
			@PathVariable("id") Long id) throws Exception {
		
		if (id!=null) {
			Optional<DataModel> dataObj = urlService.getAllDataById(id);
			if (dataObj == null) {
				throw new Exception("data is not found for id : /" + id);
			}else {return new ResponseEntity<>(dataObj, HttpStatus.OK) ;}

		} else {
			throw new Exception("ID : " + id + " is not valid.");
		}
	}

	@GetMapping(value = "/golongurl/{srl}")
	public void getUserInfoByShortUrl(
			@PathVariable("srl") String srl,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		InetAddress ip= InetAddress.getLocalHost();
		String devicename=ip.getHostName();
		String ipaddress=ip.getHostAddress();
		UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
		String osname = userAgent.getOperatingSystem().getName();
		String browsername=userAgent.getBrowser().getName()+" - v"+ userAgent.getBrowserVersion(); 		
		
		DataModel dataObj=null;
		if (srl.length() == 6) {
			 dataObj = urlService.getAllDataByShort_url(srl);
			if (dataObj == null) {
				throw new Exception("data is not found for url : /" + srl);
			}else {
				dataObj.setDevicename(devicename);
				dataObj.setIpaddress(ipaddress);
				dataObj.setOsname(osname);
				dataObj.setBrowsername(browsername);
				urlService.updateDataModel(dataObj);
				String rd_url=dataObj.getLongurl()+"?arg1="+dataObj.getParameters()[0]+"&arg2="+dataObj.getParameters()[1];
				res.setHeader("Location", rd_url);
				res.setStatus(302);
//				return rd_url; 
			}
		} else {
			throw new Exception("URL : /" + srl + " is not valid.");
		}
	}	

	@GetMapping(value="/renderalldata")
	public ResponseEntity<List<DataModel>> renderAllData(){
		List<DataModel> dataList= urlService.renderAllData();
		
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
	
	@GetMapping(value="/shorturlcount")
	public ResponseEntity<String > renderTotalCount(){
		Long count=urlService.shortUrlCount();
		String url_count="short_url_count : "+count;
		return new ResponseEntity<>(url_count, HttpStatus.OK);
	}
	
}
