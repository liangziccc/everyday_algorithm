package cn.czl.algorithm.day_20240925;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 */
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need  = new HashMap<>();
        Map<Character,Integer> window  = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()){
            char c = s2.charAt(right++);
            window.put(c,window.getOrDefault(c,0)+1);
            if (need.containsKey(c)){
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left++);
                if (need.containsKey(d)){
//                     前置判断 ，窗口左边的是不是多余
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    // 判断完成，更新窗口
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;
    }
}