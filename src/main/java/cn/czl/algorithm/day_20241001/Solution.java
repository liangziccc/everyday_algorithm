package cn.czl.algorithm.day_20241001;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left_bound = left_bound(nums, target);
        int right_bound = right_bound(nums, target);
        return new int[] { left_bound, right_bound };
    }

    public int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left > nums.length - 1) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || right > nums.length - 1) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }
}