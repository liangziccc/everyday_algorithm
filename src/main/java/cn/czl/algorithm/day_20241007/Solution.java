package cn.czl.algorithm.day_20241007;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        for(;i<nums1.length;i++){
            arr[i] = nums1[i];
        }
        for(int j = 0;j<nums2.length;j++,i++){
            arr[i] = nums2[j];
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int n = arr.length;
        return n % 2 == 0 ? (double) ( arr[n/2] + arr[n/2 -1] ) / 2  : arr[n/2];
    }
}