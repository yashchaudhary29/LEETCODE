/**
 * Problem: Find All Duplicates In Array
 * 
 * Problem Link:https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 *  Description:
 *  Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
 
 */

package LeetCode;
import java.util.*;

public class FindAllDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=input.nextInt();
        }
        FindAllDuplicates fa=new FindAllDuplicates();
        System.out.println(fa.findDuplicates(arr));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list =new ArrayList<>();
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            if(value>1){
                list.add(key);
            }
        }
        return list;
    }
    
}
