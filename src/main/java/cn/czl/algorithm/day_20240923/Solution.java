package cn.czl.algorithm.day_20240923;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串 | 力扣 | LeetCode |
 */
class Solution {
    public static void main(String[] args) {
        int i = new Solution().lengthOfLongestSubstring("aab");

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character,Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            res = Math.max(res,window.size());
        }
        return res;
    }

   /* public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        List<Character> window = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            while (window.contains(c)) {
                window.remove(0);
            }
            res = Math.max(res, window.size());
            window.add(c);
        }
        return res;
    }*/
}