package com.orange;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import com.google.common.hash.Hashing;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

public class Test {
	public static String  RandomString(){
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
	
//	public static void main(String[] args) {
//		
//	String ip = Hashing.murmur3_32().hashString("http://google.com", StandardCharsets.UTF_8).toString();	
//		System.out.println("short = "+ip);
//	
//		Test.RandomString();
//		
//	}
	
	

}
