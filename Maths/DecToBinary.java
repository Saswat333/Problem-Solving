/*
Convert binary to decimal
Test case :
- take care of number separated by radix point(integral and fractinal part)
- after binary num from binary array and put back in string with radix point 
- take care of precision point for the fractional part as it may never end when diving by 2
*/
import java.util.*;
import java.util.Arrays;

class DecToBinary{
	public static void main(String[] args)
	{
		double num = 17.25;
		System.out.println("Decimal number: "+num);
		String ans = convertBin(num, 5);
		System.out.println("Binary for "+num+" is : "+ans);
	}
	
	public static String convertBin(double value,Integer precision)
	{
		//precision = precision != null ? precision : 4; // using precision as default param
		int integral = (int) value;
		System.out.println("Integral : "+integral);
		//double integral = integralTemp; // e.g. if value=7.45, integral = 7
		double fractional = value - integral; //fractional = 0.45
		System.out.println("Fractional : "+fractional);
		//PART:1  : INTEGRAL PART
		//for num1 part (before radix point)
		String binary = "";
		while(integral>0){
			int rem = integral % 2;
			binary += ((char)(rem+'0'));
			integral /= 2;
		}

		binary = reverse(binary);
		binary += ('.'); 
		//PART:2	:  FRACTIONAL PART
		// 1. 0.47 * 2 = 0.94, Integral part: 0
		//2. 0.94 * 2 = 1.88, Integral part: 1
		//3. 0.88 * 2 = 1.76, Integral part: 1
		//precision keep tracks of length of the fractional part, its a counter.

		while (precision--  > 0)
		{
			fractional *= 2;
			int fract_int = (int)fractional;
			if(fract_int == 1){
				fractional -=  1;
				binary += (char)(1+'0');
			}
			else{
				binary += (char)(0+'0');
			}
		}

		return binary;
	}
	
	public static String reverse (String input){
		/*StringBuffer*/

		char[] tempArray = input.toCharArray();
		//1,1,0,1
		int left =0, right = tempArray.length-1;
		while(left<right){
			char temp  = tempArray[right];
			tempArray[right] = tempArray[left];
			tempArray[left] = temp;
			left++;
			right--;
		}

		return String.valueOf(tempArray);
	}
	
}