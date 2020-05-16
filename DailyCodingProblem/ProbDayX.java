
/*************************************** 
 *#DAY-X 
 *Problem Statement:
 *
 * 
 * 
 * 
*******************************************/
import java.io.IOException;
import java.util.*;

class ProbDayX {
    public static void solution(int arr[]) {

    }

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
        solution(inArr);
        sc.close();
    }
}