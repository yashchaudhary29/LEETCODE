/**
 * Problem: Top K Frequent Elements
 * Problem Link: https://leetcode.com/problems/top-k-frequent-elements/description/
 * Description:
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * 
 */

package LeetCode;
import java.util.*;
public class TopKFrequentElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n; i++){
            arr[i]=input.nextInt();
        }
        int k=input.nextInt();
        TopKFrequentElement tf= new TopKFrequentElement();
        int[] ans = tf.topKFrequent(arr, k);
        System.out.println(Arrays.toString(ans));
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for(int key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i=k-1; i >=0; i--) {
            result[i] = pq.poll();
        }        
        return result;
    }
}
