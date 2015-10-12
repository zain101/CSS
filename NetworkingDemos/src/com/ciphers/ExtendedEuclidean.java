package com.ciphers;

import java.math.BigInteger;

public class ExtendedEuclidean {

	public static BigInteger[] extendedEuclideanI(BigInteger a, BigInteger b){
		BigInteger u= new BigInteger("1"), v=new BigInteger("0"), p=new BigInteger("0"), q=new BigInteger("1");
		BigInteger x=new BigInteger("0"), y=new BigInteger("0"), rem, quo;
		BigInteger r1= new BigInteger(a.toString()), r0 = new BigInteger(b.toString()) ;
		int count=0;
		while(true){
			count++;
			quo = r1.divide(r0);
			rem = r1.remainder(r0);
			//r1 =  quo * r0 + rem;
			if(rem.equals(BigInteger.ZERO) )
				break;
			r1 = r0; 
			r0 = rem;
			x = u.subtract(quo.multiply(p));
			u = p;
			p = x;
			y = v.subtract(quo.multiply(q));
			v=q;
			q=y;
		}
		System.out.println("\nTo find inverse of "+a+"\n MOD\n"+b+"\nIt took "+count+"count");
		//System.out.println(r0+" "+ x +" " +y);
		return new BigInteger[] {r0, x, y};
	}
	
	/*public static void main(String args[]) {
		int a[] = extendedEuclideanI(36163, 1058);
		System.out.println(a[0]+" "+a[1]+" "+ a[2]);
	}*/
}
