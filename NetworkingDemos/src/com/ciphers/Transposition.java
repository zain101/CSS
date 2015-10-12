package com.ciphers;

import java.util.ArrayList;
import java.util.Arrays;

public class Transposition {
	private static int height = 3;
	private static Integer  keys[]  = {6, 3, 2, 4, 1, 5};
	
	
	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Transposition.height = height;
	}

	public static ArrayList<ArrayList<Character>> routeMatrixArrange(char[] tmp){
		ArrayList<ArrayList<Character>> mat = new ArrayList<ArrayList<Character>>();
		int i;
		int k =0;
		for(i=0; i<getHeight(); i++){
			mat.add(new ArrayList<Character>());
		}
		for(int j=0; j<tmp.length; j++){
			for ( i =0; i< 3; i++){
				if(tmp[k] == ' '){
					mat.get(i).add('#');
					k++;
				}
				else{
					mat.get(i).add(tmp[k++]);
				}
			}
			if(k >= tmp.length){
				break;
			}
		}
		return mat;
	} 
	
	public static StringBuffer SpiralTopLeftClockwise(ArrayList<ArrayList<Character>> mat){
		int r = 3;
		int c = mat.get(0).size();
		int k=0;
		int l=0;
		int i=0;
		StringBuffer cipherText = new StringBuffer() ;
		while(k < r && l < c){
			for (i = l; i < c; i++){
				cipherText.append(mat.get(k).get(i));
			}
			k++;
			for (i = k; i < r; ++i){
				cipherText.append(mat.get(i).get(c-1));
			}
			c--;

			if ( k < r){
				for (i = c-1; i >= l; --i){
					cipherText.append(mat.get(r-1).get(i));
				}
			}
			r--;

			if (l < c){
				for (i = r-1; i >= k; --i){
					cipherText.append(mat.get(i).get(l));
				}
				l++;    

			}
		}
		
		return cipherText;
	}
	
	public static ArrayList<ArrayList<Character>> spiralTopLeftClockwiseArrange(char tmp[], ArrayList<ArrayList<Character>> mat){
		
		int r = 3;
		int c = mat.get(0).size();
		int k=0;
		int l=0;
		int i=0;
		int z=0;
		//mat.clear();
		for(i=0; i<getHeight(); i++){
			//mat.add(new ArrayList<Character>());
			
		}
		
		while(k < r && l < c){
			for (i = l; i < c; i++){
				//cipherText.append(mat.get(k).get(i));
				mat.get(k).remove(i);
				mat.get(k).add(i, tmp[z++]);
			}
			k++;
			for (i = k; i < r; ++i){
				//cipherText.append(mat.get(i).get(c-1));
				mat.get(i).remove(c-1);
				mat.get(i).add(c-1, tmp[z++]);
			}
			c--;

			if ( k < r){
				for (i = c-1; i >= l; --i){
					//cipherText.append(mat.get(r-1).get(i));
					mat.get(r-1).remove(i);
					mat.get(r-1).add(i, tmp[z++]);
				}
			}
			r--;

			if (l < c){
				for (i = r-1; i >= k; --i){
					//cipherText.append(mat.get(i).get(l));
					mat.get(i).remove(l);
					mat.get(i).add(l, tmp[z++]);
				}
				l++;    

			}
		}
		
		return mat;
		

	}
	
	
	public  static StringBuffer getRouteMatrix(ArrayList<ArrayList<Character>> mat, char tmp[]){
		int i;
		int k =0;
		StringBuffer plain = new StringBuffer();
		/*for (ArrayList<Character> c : mat) {
			
			System.out.println(c);
		}*/
		for(int j=0; j<mat.get(0).size(); j++){
			for ( i =0; i< 3; i++){
					//mat.get(i).add(tmp[k++]);
						
					plain.append(mat.get(i).get(j));
			}
			if(k >= tmp.length){
				break;
			}
		}
		return plain;
	}
	
	
	public static ArrayList<ArrayList<Character>> ColumnarMatrixArrange(char tmp[]){
		ArrayList<ArrayList<Character>> mat = new ArrayList<ArrayList<Character>>();
		int i, j;
		int k =0;
		for(i = 0; true  ; i++){
			mat.add(new ArrayList<Character>());
			for(j = 0; j<keys.length; j++){
				if(tmp[k] == ' '){
					mat.get(i).add(j, '#');
					k++;
				}
				else{
					mat.get(i).add(j, tmp[k++]);
				}
			}
			if(k == tmp.length){
				break;
			}
		}
//		for (ArrayList<Character> arrayList : mat) {
//			System.out.println(arrayList);
//		}
		return mat;
	}
	
	public static String getColumnarCipher(ArrayList<ArrayList<Character>> mat){
		StringBuffer cipher = new StringBuffer();
		int row = mat.size();
		int col  = keys.length;
		int key[] = new int[col];
		int k=0;

		for (int i = 1; i<=col && k<col; i++) {
			key[k++] = Arrays.asList(keys).indexOf(i);
		}
		
//		for( int i: key )
//			System.out.println(i);
		int i =0;
		
		while(true){
			for(int j=0; j<col-1; j++){
				//System.out.println(j+ " "+ i+" "+ key[i]);
				cipher.append(mat.get(j).get(key[i]));
			}
			i++;
			if(i > key.length-1)
				break;
		}
		return cipher.toString().trim();
		
	}
	
	public static StringBuffer RouteEcryption(String plainText){
		char[] tmp = plainText.toCharArray();

		ArrayList<ArrayList<Character>> mat = routeMatrixArrange(tmp);
		
		StringBuffer cipherText = new StringBuffer() ;
		cipherText = SpiralTopLeftClockwise(mat);

		return cipherText;
	}
	
	public static String RouteDecryption(String cipher){
		StringBuffer plain = new StringBuffer();
		char[] tmp = cipher.toCharArray();
		
		ArrayList<ArrayList<Character>> mat = routeMatrixArrange(tmp) ;
		mat = spiralTopLeftClockwiseArrange(tmp, mat);
		plain = getRouteMatrix(mat, tmp);
		
		return plain.toString().replace('#', ' ');
	}
	
	public static String ColumnarEncryption(String plainText){
		char[] tmp = plainText.toCharArray();
		String cipher;
		ArrayList<ArrayList<Character>> mat  = ColumnarMatrixArrange(tmp) ;
		cipher = getColumnarCipher(mat);
		return cipher;
	}
	
	
	
	public static String ColumnarDecryption(String cipherText){
		char[] tmp = cipherText.toCharArray();
		StringBuffer plain;
		
		ArrayList<ArrayList<Character>> mat = ColumnarMatrixArrange(tmp);
		plain = genMatrixInsertCol(mat, tmp);
		return plain.toString();
	}
	
	
	public static StringBuffer genMatrixInsertCol(ArrayList<ArrayList<Character>> mat, char[] tmp){
		StringBuffer plain = new StringBuffer();
		int row = mat.size();
		int col  = keys.length;
		int key[] = new int[col];
		int k=0;
		System.out.println("rows: "+row+ "cols: "+col);
		
		for (int i = 1; i<=col && k<col; i++) {
			key[k++] = Arrays.asList(keys).indexOf(i);
		}
	
		/*for (ArrayList<Character> arrayList : mat) {
			System.out.println(arrayList);
		}*/
		
		/*System.out.println();
		for(int i : key)
			System.out.print("  "+i);
		System.out.println();*/
		
		k=0;
		int i =0;
		
		while(true){
			for(int j=0; j<row; j++){
		//		System.out.println(j+" "+key[i]+" "+mat.get(j).get(key[i]));
				mat.get(j).remove(key[i]);
				mat.get(j).add(key[i], tmp[k++]);
		//		System.out.println(j+" "+key[i]+" "+mat.get(j).get(key[i]));
			}
			i++;
			if(i > key.length-1)
				break;
		}
		

		/*for (ArrayList<Character> arrayList : mat) {
			System.out.println(arrayList);
		}*/
		
	for(i=0; i<row; i++){
			for(int j = 0; j<col; j++){
				//System.out.print(" "+ mat.get(i).get(j));
				plain.append(mat.get(i).get(j));
			}
			//System.out.println();
		}
	
		k=0;
		
		
		return plain;
	}
}

