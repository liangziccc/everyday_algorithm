package cn.czl.algorithm.day_20240929;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
class Solution_76 {
    public static void main(String[] args) {

    }
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right =0;
        int valid = 0;
        String res  = s+t;
        while (right < s.length()){
            char c = s.charAt(right++);
            window.put(c,window.getOrDefault(c,0)+1);
            // 这里的need是用来判断是否需要valid++ 的前置条件，如果都不在need中，后面不需要判断
            //if (need.containsKey(c)){
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            //}
            while (valid == need.size()){
                if (right - left < res.length()){
                    res = s.substring(left,right);
                }
                char d = s.charAt(left++);

              //  if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                //}
            }
        }
        return res.equals(s+t) ? "" : res;
    }
}