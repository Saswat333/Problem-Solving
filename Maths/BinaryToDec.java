/*
Convert binary to decimal
Test case :
- need to separate both the integral and fractional part
*/

import java.util.*;
import java.util.Arrays;
import java.lang.Math;

class BinaryToDec{
	public static void main(String[] args){
		double num = 10001.0101;
		String ans = BinToDecimal(num);
		System.out.println(ans);
		
	}
	
	public static String BinToDecimal(double num)
	{
		String tempStrVal = Double.toString(num);
		System.out.println(tempStrVal);
		String str1 = tempStrVal.split("\\.")[0];
		String str2 = tempStrVal.split("\\.")[1];
		System.out.println(str1);
		System.out.println(str2);
		int integral = Integer.parseInt(str1);
		int fractional = Integer.parseInt(str2);
		//Part:1	Integral
		int base = 1 ;
		String decimal = "";
		double dec_ans = 0, frac_ans=0;
		while(integral > 0)
		{
			int lastDig = integral % 10;
			integral = integral / 10;
			dec_ans += (double)lastDig * base; // lastDig * 1, lastDig*2
			base *= 2; //1*2 =2, 2*2, 2*2*2
			
		}
		System.out.println("decimal ans integral : "+ dec_ans);
		//decimal = Integer.toString(dec_ans);
		//decimal += '.';
		
		//Part-2 
		// 0.1011 = 1011 , len =4
		int len = str2.length();	
		System.out.println("length fractional : "+ len);
		while(len > 0)
		{
			int lastDig = fractional % 10;
			System.out.println("last digit : "+ lastDig);
			fractional /= 10;
			double power = Math.pow(2,len);
			double val= lastDig*(1/power); //1* 1/(2^2), 0* 1/2^1
			System.out.println("fractional ans inner loop : "+ val);
			frac_ans += val;
			len--;
		}
		System.out.println("fractional ans : "+ frac_ans);
		dec_ans += frac_ans;
		//decimal += Integer.toString();
		System.out.println("fractional : "+ dec_ans);
		return decimal;
	}
}