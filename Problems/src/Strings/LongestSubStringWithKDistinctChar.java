/**
 340. Longest Substring with At Most K Distinct Characters

 Given a string, find the length of the longest substring T that contains at most k distinct characters.

	For example, Given s = “eceba” and k = 2,

	T is "ece" which its length is 3. 
 */
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; 
        int right = 0;
        int max = 0;
        
        while (right < s.length()) {
             addToMap(s.charAt(right), map);
             if (map.size() <= k) {
                 max = Math.max(max, right - left + 1);
             }
             right++;
             while (map.size() > k) {
                 removeFromMap(s.charAt(left), map);
                 left++;
             }
        }
        return max;
    }
    void addToMap(char ch, Map<Character, Integer>map) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    
    void removeFromMap(char ch, Map<Character, Integer> map) {
        int count = map.get(ch) - 1;
        if (count == 0) {
            map.remove(ch);
        } else {
            map.put(ch, count);
        }
    }
}
