/**
 * Problem : Bulls and Cows
 * problem link : https://leetcode.com/problems/bulls-and-cows/description/
 * Description:
 * You are playing the Bulls and Cows game with your friend.
You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 
 */


import java.util.*;
public class BullandCows{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s1=input.next();
        String s2= input.next();
        BullandCows bc=new BullandCows();
        System.out.println(bc.getHint(s1,s2));
    }
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        HashMap<Character, Integer> map =new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2= guess.charAt(i);
            if(c1==c2){
                bulls++;
            }
            else{
                map.put(c1, map.getOrDefault(c1,0)+1);
            }
        }
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2= guess.charAt(i);
            if(c1==c2){
                continue;
            }
            if(map.containsKey(c2) && map .get(c2)>0){
                cows++;
                map.put(c2, map.get(c2)-1);
            }
        }
        return bulls+"A"+cows+"B";
    }
}
