package com.ciphers;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
	
	public static BigInteger calculateExponent(BigInteger base, BigInteger radix, BigInteger n){
		String str1 = null;
		char str[] = null;
		int count=0;
		str1 =  radix.toString(2);
		str = str1.toCharArray();
		BigInteger z = new BigInteger("1");

		System.out.println("Binary of "+ radix);
		for(char c : str)
			System.out.print(c);
		//System.out.println("\nbase "+ base);
		BigInteger y = new BigInteger(base.toString());
		for(int i =str.length-1; i >=0 ; i--){
		//	System.out.print(">"+str[i]);
			if(str[i] == '1')
				z = z.multiply(y);
				z = z.remainder(n);
				
			y = y.multiply(y);
			y= y.remainder(n);
			count++;
		}
		System.out.println("\nTo perform \n"+base+"\nRAISED TO\n"+radix+ "\nit took "+ count +" multiplication using FFM");
		return z;
	}
	public static void main(String args[]){
		
		//Genrate two lage random primes using Miller-Rabin algo
		Random rnd = new Random();
		rnd.setSeed(1212);
		BigInteger p = BigInteger.probablePrime(1024, rnd); 
		BigInteger q = BigInteger.probablePrime(1024, rnd); 
		
		BigInteger n = p.multiply(q);
		
		BigInteger totientOfn = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		
		BigInteger e = new BigInteger("35537");
		
		BigInteger zz= new BigInteger("88"); //This is message...
		
		BigInteger cipher, plain, t;
		System.out.println("p==>: "+p);
		System.out.println("\nq==>: "+q);
		System.out.println("\nn==>: "+n);
		System.out.println("\ntotient(n)==>: "+totientOfn);
		System.out.println("\ne==>: "+e);
		System.out.println("\n\nOriginal message: "+ zz);
		System.out.println("\n\nAutomated inverse by java: "+ e.modInverse(totientOfn));
		
		BigInteger a[] = ExtendedEuclidean.extendedEuclideanI(e, totientOfn );
		System.out.println("\n\nExtented Euclidean output: "+ a[0]+" "+a[1]+" "+ a[2]);

		cipher = calculateExponent(zz,e, n).remainder(n); //.remainder(new BigInteger(n.toString()));
		System.out.println("\ncipher "+cipher);
		
		BigInteger tmp = a[1];
		t = new BigInteger(tmp.toString());
		t = t.mod(totientOfn);
		
		System.out.println("\nInverse from Extented Euclidean algorithm (d): "+t+"\n");
		//t = BigInteger.ONE;
		//cipher.modPow( e.modInverse(totientOfn), n);
		//t = e.modInverse(totientOfn);
		
		plain = calculateExponent(cipher, t, n).remainder(n); //.remainder(new BigInteger(n.toString()));
		System.out.println("\nplain "+plain);
		
		/*cipher  = calculateExponent("1213743762271", "43914225");
		System.out.println("\nEXpo: "+ cipher.mod(n));*/
		
	}
}
