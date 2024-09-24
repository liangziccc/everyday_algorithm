package cn.czl.algorithm.day_20240924;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 167. 招式拆解 I
 */
class Solution {
    public int dismantlingAction(String arr) {
        int left = 0;
        int right = 0;
        Map<Character,Integer> window = new HashMap<>();
        int res = 0;
        while (right < arr.length()){
            char c = arr.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);

            while (window.get(c) > 1){
                char d = arr.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}