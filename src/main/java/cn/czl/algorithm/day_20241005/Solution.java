package cn.czl.algorithm.day_20241005;

/**
 * LCR 172. 统计目标成绩的出现次数
 */
class Solution {
    public int countTarget(int[] scores, int target) {
        int leftBound = left_bound(scores, target);
        if (leftBound == -1) {
            return 0;
        }
        int res = 0;
        for (int i = leftBound; i < scores.length; i++) {
            if (scores[i] == target) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private int left_bound(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] == target) {
                right = mid - 1;
            } else if (scores[mid] > target) {
                right = mid - 1;
            } else if (scores[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left > scores.length -1){
            return -1;
        }
        return scores[left] == target ? left : -1;
    }
}