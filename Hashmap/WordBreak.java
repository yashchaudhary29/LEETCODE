/**
 * Problem: Word Break
 * LeetCode Link: https://leetcode.com/problems/word-break/description/
 * Difficulty: Medium
 * 
 * Description:
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */

import java.util.*;
public class WordBreak{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s=input.next();
        int n=input .nextInt();
        List<String> wordDict =new ArrayList<>();
        for(int i=0; i<n; i++){
            wordDict.add(input.next());
        }
        WordBreak obj=new WordBreak();
        boolean check=obj.wordBreak(s,wordDict);
        System.out.println(check);
        input.close(); 
    }
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordset=new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordset.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
