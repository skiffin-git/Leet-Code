package Apple_Questions_LeetCode.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet <Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            // check if set has char
            if(!set.contains(s.charAt(right))) {
                // update max
                max = Math.max(max, right + 1 - left);
            }else{
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            // update set
            set.add(s.charAt(right));
        }
        return max;
    }
}

