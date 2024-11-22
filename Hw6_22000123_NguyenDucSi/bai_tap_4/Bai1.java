package DSA.Hw6_22000123_NguyenDucSi.bai_tap_4;

/*
Given an array arr[] containing integers and an integer k,
your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k.
It is guaranteed that a valid subarray exists.
 */

import java.util.HashMap;
import java.util.Map;

public class Bai1 {
    public int lenOfLongestSubarr(int[] arr, int k) {
        int n = arr.length;
        int  cnt = 0;
        int cntMax = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for(int i = 0; i < n; ++i) {
            sum += arr[i];
            if(map.containsKey(sum - k)) {
                cnt = i - map.get(sum - k);
                cntMax = Math.max(cnt, cntMax);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return cntMax;
    }
}
