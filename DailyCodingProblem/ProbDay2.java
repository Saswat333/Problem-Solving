
/*************************************** 
 *#DAY-X 
 *Problem Statement:
 *
 Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 * 
 * 
*******************************************/
import java.io.IOException;
import java.util.*;

class ProbDay2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Note: Enter each array element in a new line !!!");
        System.out.println("Array Size:");
        int arrSize = sc.nextInt();
        System.out.println("Input array value:");
        int[] inArr = new int[arrSize];
        // input array value to Integer array
        for (int i = 0; i < arrSize; i++) {
            inArr[i] = Integer.parseInt(sc.next());
        }
        System.out.println("-----------------------------------");
        sc.close();
    }
}