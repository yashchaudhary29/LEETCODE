package LeetCode;
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