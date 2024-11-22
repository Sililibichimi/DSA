package DSA.Hw6_22000123_NguyenDucSi.bai_tap_4;
/*
Given an array arr containing both positive and negative integers,
the task is to compute the length of the largest subarray that has a sum of 0.
 */

import java.util.HashMap;
import java.util.Map;

public class Bai2 {
    int maxLen(int arr[]) {

        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for(int i = 0; i < n; ++i) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                cnt = i - map.get(sum);
                maxLen = Math.max(cnt, maxLen);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
