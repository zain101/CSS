package com.ciphers;


public class Substitution {
	private static int KEY = 3;
		
	public static int getKEY() {
		return KEY;
	}

	public void setKEY(int kEY) {
		KEY = kEY;
	}
	
	public static StringBuffer ceaserEncrypt(String plainText){
		StringBuffer cipherText = new StringBuffer();
		char buff[] = plainText.toCharArray();	
		for (int i=0; i< buff.length; i++) {
			int ch = (int) buff[i];
			
			if(ch == 32){
				buff[i] = '#'; 
			}
			else if(ch >= 65 && ch<91 ){
				ch = ((ch+ getKEY()) % 91);
				buff[i] = (char) ( ch < 65 ? ch+ 65: ch);
			}
			else if(ch >=97 && ch<123 ){
				ch = (ch + getKEY()) % 123;
				buff[i] = (char) ( ch < 65 ? ch+ 97: ch);
			}
		}
		
		for (char b : buff) {
			cipherText.append(b);
		}
		return cipherText;
	}

	public static StringBuffer ceaserDeacrypt(String cipher){
		StringBuffer plain = new StringBuffer();
		char buff[] = cipher.toCharArray();	
		for (int i=0; i< buff.length; i++) {
			int ch = (int) buff[i];
			
			if(ch == 35){
				buff[i] = ' '; 
			}
			else if(ch >= 65 && ch<91 ){
				ch = ((ch - getKEY()) % 91);
				buff[i] = (char) ( ch < 65 ? ch+ 26: ch);
			}
			else if(ch >=97 && ch<123 ){
				ch = (ch  -  getKEY()) % 123;
				buff[i] = (char) ( ch < 97 ? ch+ 26: ch);
			}
		}
		
		for (char b : buff) {
			plain.append(b);
		}
		return plain;
	}
}
