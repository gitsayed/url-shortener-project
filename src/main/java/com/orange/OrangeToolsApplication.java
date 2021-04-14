package com.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrangeToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeToolsApplication.class, args);
		String s="System Started:name = OrangeTools/MyOffer360";
		//System.out.println("print = "+s.substring(0, 6));
		System.out.println(s);
	}

}
