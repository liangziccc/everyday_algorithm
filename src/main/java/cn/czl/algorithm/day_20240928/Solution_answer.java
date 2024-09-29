package cn.czl.algorithm.day_20240928;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 017. 最小覆盖子串
 */
class Solution_answer {
    public static void main(String[] args) {

    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        String res = s+t;
        while (right < s.length()) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c)) {
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                if (right - left < res.length()){
                    res = s.substring(left,right);
                }
                char d = s.charAt(left++);
                //1、need中不一定有d，因为上面添加到window时，就只添加了need中包含的char
                if (need.containsKey(d)) {
                    // 移动窗口前的前置判断，先移动会导致valid无法正常--
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // 要包含在if中，因为window中由于添加的时候，只添加了need中包含的，所以必须need包含d，window才有可能get
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return res.equals(s+t) ? "" : res;
    }
}