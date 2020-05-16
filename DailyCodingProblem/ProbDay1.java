
/************************************************************************** 
 *#DAY-1 
 *Problem Statement:
 * Given a list of numbers and a number k, return whether any two       numbers from the list add up to k.
 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 * 
 * Here, the problem can have multiple scenario:
 * 1. We may have to return 0-if no such pair exist or 1-if such pair exist
 * 2. We may have to return the pair such forms value k
 *      - We may have only one value to return
 *      - Wr may have multiple value to return
*********************************************************************/
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class ProbDay1 {
    // Solution Method
    public static boolean hasPairOfNumber(int arr[], int k) {
        int low = 0, high = arr.length - 1;
        Arrays.sort(arr);
        while (low < high) {
            if (arr[low] + arr[high] == k)
                return true;
            else if (arr[low] + arr[high] < k)
                low++;
            else
                high--;
        }
        return false;
    }

    // Driver Class
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Note: Enter each array element in a new line !!!");
        System.out.println("Array Size:");
        int arrSize = sc.nextInt();
        System.out.println("Value of k:");
        int k = sc.nextInt();
        System.out.println("Input array value:");
        // String s = sc.nextLine();
        // String[] ar = s.split(" ");
        int[] inArr = new int[arrSize];
        // input array value to Integer array
        // int[] inputArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            inArr[i] = Integer.parseInt(sc.next());
        }
        System.out.println("-----------------------------------");
        boolean ans = hasPairOfNumber(inArr, k);
        System.out.println("Array size = " + arrSize);
        System.out.println("Value of k = " + k);
        System.out.println("Array value (sorted) = ");
        for (int j = 0; j < arrSize; j++) {
            System.out.print(inArr[j] + " ");
        }
        System.out.println("");
        if (ans)
            System.out.println("Pair exist !!");
        else
            System.out.println("Pair don't exist !!");
        sc.close();
    }
}