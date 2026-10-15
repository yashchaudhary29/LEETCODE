package LeetCode;
import java.util.*;
class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int n=input.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=input.nextInt();
        }
        if (nums == null || nums.length == 0) {
            System.out.println(0);
            
        }
        else{
            Arrays.sort(nums);

            int longestStreak = 1;
            int currentStreak = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else { 
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
            System.out.println(Math.max(longestStreak, currentStreak));
        }
        input.close();

    }
}