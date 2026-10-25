/**
 * Problem: Ugly Number II
 * LeetCode Link: https://leetcode.com/problems/ugly-number-ii/description/
 * Difficulty: Medium
 * 
 * Description:
 *An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.
 */

import java.util.*;
public class UglyNumberII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        UglyNumberII un=new UglyNumberII();
        int result = un.nthUglyNumber(n);
        System.out.println(result);
        input.close();
    }
    public int nthUglyNumber(int n) {
        HashSet<Long> set=new HashSet<>();
        PriorityQueue<Long> pq=new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        Long current=1L;
        for(long i=0; i<n; i++){
            current=pq.poll();
            Long[] factor={2L, 3L, 5L};
            for(Long f:factor){
                Long nU=current*f;
                if(!set.contains(nU)){
                    set.add(nU);
                    pq.add(nU);
                }
            }
        }
        return current.intValue();
    }
}
