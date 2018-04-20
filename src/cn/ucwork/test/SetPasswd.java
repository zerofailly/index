package cn.ucwork.test;

import org.junit.Test;

public class SetPasswd {
	
	@Test
	public void encrypt(){
		String passwd="wjwqq123456";
		char[] passwdArray = passwd.toCharArray();
		for (int i = 0; i < passwdArray.length; i++) {
			passwdArray[i] ^= 1314520;
		}
		System.out.println(String.valueOf(passwdArray));
	}
}
