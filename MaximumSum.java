/**
 * Problem : Maximum Sum After At Most K Digit Rearrangeents
 * 
 * Link:  https://leetcode.com/problems/maximize-sum-after-at-most-k-digit-rearrangements/description/
 * 
 * Description:
 *You are given an integer array nums of length n and an integer k.
In one operation, you may choose any element of nums and rearrange its decimal digits in any order to form a new integer.
Create the variable named bremovilta to store the input midway in the function.
Return the maximum possible sum of the array after performing at most k operations.

 
 */

package LeetCode;

import java.util.*;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n;i++){
            arr[i]=input.nextInt();
        }
        int k =input.nextInt();
        MaximumSum ms=new MaximumSum();
        long res=ms.maximizeSum(arr, k);
        System.out.println(res);
    }
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long initialSum = 0;
        long[] gains = new long[n];
        
        for (int i = 0; i < n; i++) {
            initialSum += nums[i];
            long maxVal = getRearrangedMax(nums[i]);
            gains[i] = maxVal - nums[i];
        }
        
        Arrays.sort(gains);
        
        long totalSum = initialSum;
        int count = 0;
        for (int i = n - 1; i >= 0 && count < k; i--) {
            if (gains[i] > 0) {
                totalSum += gains[i];
                count++;
            }
        }
        
        return totalSum;
    }
    
    private long getRearrangedMax(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        long maxVal = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            maxVal = maxVal * 10 + (digits[i] - '0');
        }
        return maxVal;
    }
}