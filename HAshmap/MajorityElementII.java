/**
 * Problem: Majority Element II
 * link: https://leetcode.com/problems/majority-element-ii/description/
 * Description:
 * Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.
 */

package LeetCode;
import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        MajorityElementII me=new MajorityElementII();
        System.out.println(me.majorityElement(arr));

    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
             map.put(nums[i],map.getOrDefault(nums[i],0)+1);    
        }
        int threshold = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            if (count > threshold) {
                list.add(element);
            }
        }
        return list;
    }
}
